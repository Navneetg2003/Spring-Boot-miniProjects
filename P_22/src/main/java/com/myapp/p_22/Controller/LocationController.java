package com.myapp.p_22.Controller;

import com.myapp.p_22.DTO.LocationRequest;
import com.myapp.p_22.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/add")
    public ResponseEntity<String> saveLocation(@RequestBody LocationRequest locationRequest) {
        try {
            locationService.saveLocation(
                    locationRequest.getName(),
                    locationRequest.getLatitude(),
                    locationRequest.getLongitude(),
                    locationRequest.getCategory()
            );

            return ResponseEntity.ok("Location saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving location: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        try {
            locationService.deleteLocationById(id);
            return ResponseEntity.ok("City with ID " + id + " deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting city: " + e.getMessage());
        }
    }
}
