package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.HotelDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import by.gorbov.hotel.model.Room;
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
    public HotelDto getHotelById(@PathVariable Long id) {
        return applicationFacade.getByIdHotel(id);
    }

    @GetMapping("/all")
    public List<HotelDto> getAllHotels() {
        return applicationFacade.getAllHotel();
    }

//    @GetMapping("/{id}/rooms")
//    public List<Room> getAllRoomInHotel(@PathVariable Long id) {
//        return applicationFacade.getByIdHotel(id).getRooms();
//    }

    @PostMapping("/save")
    public void saveHotel(@RequestBody HotelDto hotel) {
        applicationFacade.saveHotel(hotel);
    }
}
