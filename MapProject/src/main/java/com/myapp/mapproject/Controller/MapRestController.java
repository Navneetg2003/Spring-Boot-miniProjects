package com.myapp.mapproject.Controller;

import com.myapp.mapproject.Model.City;
import com.myapp.mapproject.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MapRestController {

    @Autowired
    private CityService cityService;
    @PostMapping("/addcity")
    public City saveCity(@RequestBody City city) {
        cityService.save(city);  // Save the city object to the database
        return city;  // Return the saved city object, including its generated ID
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.getAll();
    }
}