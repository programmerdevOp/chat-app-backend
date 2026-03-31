package com.sumit.chat_app_backend.repositories;

import com.sumit.chat_app_backend.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    // get room  by roomId;
    Boolean findByRoomId(String roomId);
}
