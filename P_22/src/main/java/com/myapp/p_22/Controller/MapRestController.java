package com.myapp.p_22.Controller;

import com.myapp.p_22.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class MapRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<LocationDTO> getLocations() {
        return locationService.getAllLocations().stream()
                .map(location -> new LocationDTO(
                        location.getName(),
                        location.getGeometry().getY(), // Latitude
                        location.getGeometry().getX(), // Longitude
                        location.getCategory() // Category
                ))
                .collect(Collectors.toList());
    }

//    @GetMapping("/lines")
//    public List<Map<String, Object>> getLines() {
//        return locationService.getLinesBetweenDistantPoints();
//    }
//
//    @GetMapping("/polygons")
//    public List<Map<String, Object>> getPolygons() {
//        return locationService.getPolygonsForClusters();
//    }

    // DTO class to structure the response
    public static class LocationDTO {
            private String name;
            private double latitude;
            private double longitude;
            private String category; // Added category

            public LocationDTO(String name, double latitude, double longitude, String category) {
                this.name = name;
                this.latitude = latitude;
                this.longitude = longitude;
                this.category = category;
            }

            // Getters
            public String getName() {
                return name;
            }

            public double getLatitude() {
                return latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public String getCategory() {
                return category;
            }
        }
}
