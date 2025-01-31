package com.myapp.mapproject.Service;


import com.myapp.mapproject.Model.City;
import com.myapp.mapproject.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public void save(City city) {
        cityRepository.save(city);
    }
}
