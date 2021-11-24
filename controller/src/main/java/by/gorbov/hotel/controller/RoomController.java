package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.RoomDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final ApplicationFacade applicationFacade;

    public RoomController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdRoom(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        return ResponseEntity.ok(applicationFacade.getAllRoom());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveRoom(@RequestBody RoomDto room) {
        applicationFacade.saveRoom(room);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        applicationFacade.deleteRoom(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateRoom(@RequestBody RoomDto room) {
        applicationFacade.updateRoom(room);
        return ResponseEntity.ok().build();
    }

}
