package com.myapp.p6backend.Controller;


import com.myapp.p6backend.Entity.Message;
import com.myapp.p6backend.Entity.Room;
import com.myapp.p6backend.Repository.RoomRepository;
import com.myapp.p6backend.payload.MessageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:5173")
public class ChatController {
    private RoomRepository roomRepository;
    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @MessageMapping("/sendmsg/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ){
        Room room = roomRepository.findByRoomId(roomId);
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room!=null){
            room.getMessages().add(message);
            roomRepository.save(room);
        }else{
            throw new RuntimeException("Room not found");
        }

        return message;
    }
}
