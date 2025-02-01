package com.myapp.p6backend.Repository;

import com.myapp.p6backend.Entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    Room findByRoomId(String roomId);
}
