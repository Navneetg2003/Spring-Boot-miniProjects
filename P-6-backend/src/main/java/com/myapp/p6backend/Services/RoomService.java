package com.myapp.p6backend.Services;

import com.myapp.p6backend.Entity.Message;
import com.myapp.p6backend.Entity.Room;
import com.myapp.p6backend.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(String roomId) {
        if (roomRepository.findByRoomId(roomId) != null) {
            throw new IllegalArgumentException("Room already exists");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    public Room joinRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }
        return room;
    }

    public List<Message> getMessages(String roomId, int page, int size) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }

        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        return messages.subList(start, end);
    }
}
