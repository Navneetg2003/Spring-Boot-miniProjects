package com.myapp.p_22.Repository;

import com.myapp.p_22.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {



    @Query(value = "SELECT id, name, category, ST_AsGeoJSON(geometry) AS geojson FROM locations WHERE id = :id", nativeQuery = true)
    Map<String, Object> findLocationAsGeoJson(Long id);

    @Query(value = "SELECT id, name, category, ST_AsGeoJSON(geometry) AS geojson FROM locations", nativeQuery = true)
    List<Map<String, Object>> findAllLocationsWithCategory();
}


//    @Query(value = """
//        WITH points AS (
//            SELECT
//                p1.id AS point1_id,
//                p2.id AS point2_id,
//                ST_Distance(p1.geometry::geography, p2.geometry::geography) AS distance_km,
//                ST_MakeLine(p1.geometry, p2.geometry) AS line
//            FROM locations p1, locations p2
//            WHERE p1.id != p2.id
//        )
//        SELECT point1_id, point2_id, ST_AsGeoJSON(line) AS geojson
//        FROM points
//        WHERE distance_km < 500000;
//    """, nativeQuery = true)
//    List<Map<String, Object>> findLinesBetweenPoints();
//
//    @Query(value = """
//     WITH pairs AS (
//            SELECT
//                p1.id AS point1_id,
//                p2.id AS point2_id,
//                ST_MakeLine(p1.geometry, p2.geometry) AS line
//            FROM locations p1, locations p2
//            WHERE p1.id < p2.id
//              AND ST_Distance(p1.geometry::geography, p2.geometry::geography) <= 500000
//        ),
//        polygons AS (
//            SELECT
//                ST_Union(line) AS polygon
//            FROM pairs
//        )
//        SELECT ST_AsGeoJSON(polygon) AS geojson
//        FROM polygons;
//        """, nativeQuery = true)
//    List<Map<String, Object>> findPolygonsForClusters();


