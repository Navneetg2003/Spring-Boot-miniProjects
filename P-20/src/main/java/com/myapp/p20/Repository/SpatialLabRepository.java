package com.myapp.p20.Repository;

import com.myapp.p20.entity.SpatialLab;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpatialLabRepository extends JpaRepository<SpatialLab, Long> {
    @Query("Select s from SpatialLab s where intersect(s.polygon,:filter)=true")
    List<SpatialLab> findItemsIntersects(@Param("filter") Geometry filter);
}
