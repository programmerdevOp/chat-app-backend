package com.sumit.chat_app_backend.controllers;

import com.sumit.chat_app_backend.entities.Room;
import com.sumit.chat_app_backend.repositories.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        //Room room
        // check if id is already present by this id or not
//        if(roomRepository.findByRoomId(room.getId()) != null){
//            return ResponseEntity.badRequest().body("Room already exists by this Id");
//        }

//        if(roomRepository.findByRoomId(roomId) != null){
//            return ResponseEntity.badRequest().body("Room already exists by this Id: "+ roomId);
//        }
//
//        Room room = new Room();
//        room.setRoomId(roomId);
//        Room savedRoom = roomRepository.save(room);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);

        if(roomRepository.findByRoomId(roomId) != null){
            return ResponseEntity.badRequest().body("Room already exist with this Id");
        }

        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomRepository.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }


    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
       Room room = roomRepository.findByRoomId(roomId);

       if(room == null){
           return ResponseEntity.badRequest()
                   .body("Room Not Found :( ");
       }

       return ResponseEntity.ok(room);
    }
}
