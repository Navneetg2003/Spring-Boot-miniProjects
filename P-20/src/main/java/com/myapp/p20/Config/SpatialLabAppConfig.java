package com.myapp.p20.Config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.myapp.p20.Custom.CustomUGeojsonDeserializer;
import com.myapp.p20.Custom.CustomUGeojsonSerializer;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpatialLabAppConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Geometry.class, new CustomUGeojsonSerializer());
        simpleModule.addDeserializer(Polygon.class, new CustomUGeojsonDeserializer<>());
        simpleModule.addDeserializer(LineString.class, new CustomUGeojsonDeserializer<>());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
}
