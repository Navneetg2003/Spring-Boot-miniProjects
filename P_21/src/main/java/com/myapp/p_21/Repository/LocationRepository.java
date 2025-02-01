package com.myapp.p_21.Repository;

import com.myapp.p_21.Entity.Location;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE FUNCTION('ST_DWithin', l.location, :point, :distance) = true")
    List<Location> findLocationsWithinDistance(@Param("point") Point point, @Param("distance") double distance);

}
