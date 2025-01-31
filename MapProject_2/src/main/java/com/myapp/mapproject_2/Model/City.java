//package com.myapp.mapproject_2.Model;
//
//import jakarta.persistence.*;
//import org.locationtech.jts.geom.*;
//
//@Entity
//@Table(name = "city")
//public class City {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "spatial_seq_gen")
//    @SequenceGenerator(name = "spatial_seq_gen",sequenceName = "spatial_seq",allocationSize = 1)
//    private Long id;
//
//    @Column(name = "point")
//    private Point point;
//
//    @Column(name = "multipoint")
//    private MultiPoint multipoint;
//
//    @Column(name = "linestring")
//    private LineString linestring;
//
//    @Column(name = "multilinestring")
//    private MultiLineString multilinestring;
//
//    @Column(name = "polygon")
//    private Polygon polygon;
//
//    @Column(name = "multipolygon")
//    private MultiPolygon multipolygon;
//
//    @Column(name = "geocollection")
//    private GeometryCollection geometryCollection;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Point getPoint() {
//        return point;
//    }
//
//    public void setPoint(Point point) {
//        this.point = point;
//    }
//
//    public MultiPoint getMultipoint() {
//        return multipoint;
//    }
//
//    public void setMultipoint(MultiPoint multipoint) {
//        this.multipoint = multipoint;
//    }
//
//    public LineString getLinestring() {
//        return linestring;
//    }
//
//    public void setLinestring(LineString linestring) {
//        this.linestring = linestring;
//    }
//
//    public MultiLineString getMultilinestring() {
//        return multilinestring;
//    }
//
//    public void setMultilinestring(MultiLineString multilinestring) {
//        this.multilinestring = multilinestring;
//    }
//
//    public Polygon getPolygon() {
//        return polygon;
//    }
//
//    public void setPolygon(Polygon polygon) {
//        this.polygon = polygon;
//    }
//
//    public MultiPolygon getMultipolygon() {
//        return multipolygon;
//    }
//
//    public void setMultipolygon(MultiPolygon multipolygon) {
//        this.multipolygon = multipolygon;
//    }
//
//    public GeometryCollection getGeometryCollection() {
//        return geometryCollection;
//    }
//
//    public void setGeometryCollection(GeometryCollection geometryCollection) {
//        this.geometryCollection = geometryCollection;
//    }
//}
