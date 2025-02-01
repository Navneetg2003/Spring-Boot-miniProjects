package com.myapp.p20.Controller;


import com.myapp.p20.Repository.SpatialLabRepository;
import com.myapp.p20.entity.SpatialLab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spatial")
public class SpatialLabController {

    @Autowired
    private SpatialLabRepository spatialLabRepository;

    @GetMapping("/{id}")
    public SpatialLab getSpatialLab(@PathVariable Long id) {
        return spatialLabRepository.findById(id).get();
    }

    @PostMapping("/add")
    public List<SpatialLab> getIntersects(@RequestBody SpatialLab spatialLab) {
        return spatialLabRepository.findItemsIntersects(spatialLab.getPolygon());
    }
}
