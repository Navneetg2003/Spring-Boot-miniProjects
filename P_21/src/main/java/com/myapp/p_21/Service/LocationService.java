package com.myapp.p_21.Service;


import com.myapp.p_21.Entity.Location;
import com.myapp.p_21.Repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findLocationsWithinDistance(Point point, double distance) {
        return locationRepository.findLocationsWithinDistance(point, distance);
    }
}
