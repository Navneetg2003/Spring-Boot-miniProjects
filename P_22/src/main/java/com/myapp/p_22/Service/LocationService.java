package com.myapp.p_22.Service;

import com.myapp.p_22.Model.Location;
import com.myapp.p_22.Repository.LocationRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public void saveLocation(String name, double latitude, double longitude, String category) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));
        point.setSRID(4326);

        Location location = new Location();
        location.setName(name);
        location.setGeometry(point);
        location.setCategory(category != null && !category.isEmpty() ? category : "Location"); // Set category or default to "Location"

        locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void deleteLocationById(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
        } else {
            throw new RuntimeException("City with ID " + id + " not found");
        }
    }
}

//    public List<Map<String, Object>> getLinesBetweenDistantPoints() {
//        return locationRepository.findLinesBetweenPoints();
//    }
//
//    public List<Map<String, Object>> getPolygonsForClusters() {
//        return locationRepository.findPolygonsForClusters();
//    }
