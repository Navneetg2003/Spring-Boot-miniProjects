package com.myapp.mapproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MapController {

    @GetMapping("/map1")
    public String map() {
        return "Map";
    }

    @GetMapping("/map2")
    public String map2() {
        return "Map2";
    }

}