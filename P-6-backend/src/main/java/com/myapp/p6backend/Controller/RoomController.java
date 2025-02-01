package com.myapp.p6backend.Controller;

import com.myapp.p6backend.Entity.Message;
import com.myapp.p6backend.Entity.Room;
import com.myapp.p6backend.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        try {
            Room room = roomService.createRoom(roomId);
            return ResponseEntity.status(HttpStatus.CREATED).body(room);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        try {
            Room room = roomService.joinRoom(roomId);
            return ResponseEntity.ok(room);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        try {
            List<Message> messages = roomService.getMessages(roomId, page, size);
            return ResponseEntity.ok(messages);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
