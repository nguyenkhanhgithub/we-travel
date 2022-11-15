package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r  FROM Room r where r.accommodationId.accommodationId = :accommodationId")
    List<Room> getListRoomByAccommodationId(Long accommodationId);
}
