package com.myapp.p20;

import com.myapp.p20.Repository.SpatialLabRepository;
import com.myapp.p20.entity.SpatialLab;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ugeojson.builder.UltimateGeoJSONBuilder;
import org.ugeojson.model.GeoJSONObjectDto;
import org.ugeojson.model.geometry.GeometryDto;
import org.ugeojson.model.geometry.PointDto;
import org.ugeojson.model.geometry.PolygonDto;
import org.ugeojson.parser.UltimateGeoJSONParser;
import org.ugeojson.parser.util.JtsUGeojsonConversionUtil;

@SpringBootTest
class P20ApplicationTests {

    @Autowired
    private SpatialLabRepository spatialLabRepository;

    @Test
    void contextLoads() {
        SpatialLab spatialLab = spatialLabRepository.findById(1L).get();
        Point point=spatialLab.getPoint();
        Polygon polygon = spatialLab.getPolygon();

        JtsUGeojsonConversionUtil jtsUGeojsonConversionUtil=new JtsUGeojsonConversionUtil();
        PointDto pointDto=jtsUGeojsonConversionUtil.toPointDto(point);
        PolygonDto polygonDto=jtsUGeojsonConversionUtil.toPolygonDto(polygon);
        GeometryDto geometryDto=jtsUGeojsonConversionUtil.toGeometryDto(spatialLab.getGeometryCollection());

        String pointJson= UltimateGeoJSONBuilder.getInstance().toGeoJSON(pointDto);
        String polygonJson= UltimateGeoJSONBuilder.getInstance().toGeoJSON(polygonDto);

        System.out.println(pointJson);
        System.out.println("-------------");
        System.out.println(polygonJson);

        GeoJSONObjectDto parse= UltimateGeoJSONParser.getInstance().parse(polygonJson);
        Geometry geometry=jtsUGeojsonConversionUtil.toJtsGeometry((GeometryDto)parse);

        System.out.println(geometry);
    }

}
