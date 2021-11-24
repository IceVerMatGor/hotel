package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.HotelDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import by.gorbov.hotel.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final ApplicationFacade applicationFacade;

    public HotelController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdHotel(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(applicationFacade.getAllHotel());
    }

//    @GetMapping("/{id}/rooms")
//    public List<Room> getAllRoomInHotel(@PathVariable Long id) {
//        return applicationFacade.getByIdHotel(id).getRooms();
//    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveHotel(@RequestBody HotelDto hotel) {
        applicationFacade.saveHotel(hotel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        applicationFacade.deleteHotel(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateHotel(@RequestBody HotelDto hotel) {
        applicationFacade.updateHotel(hotel);
        return ResponseEntity.ok().build();
    }
}
