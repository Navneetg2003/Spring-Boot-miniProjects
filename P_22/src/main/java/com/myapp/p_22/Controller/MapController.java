package com.myapp.p_22.Controller;


import com.myapp.p_22.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/map")
    public String map() {
        return "Map";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
}
