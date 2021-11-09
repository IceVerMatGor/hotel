package by.gorbov.hotel.controller;

import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final ApplicationFacade applicationFacade;

    public HotelController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

//    @GetMapping("/{id}")
//    public Hotel getHotelById(@PathVariable Long id) {
//        return applicationFacade.getByIdHotel(id);
//    }
//
//    @GetMapping("/all")
//    public List<Hotel> getAllHotels() {
//        return applicationFacade.getAllHotel();
//    }
//
//    @GetMapping("/{id}/rooms")
//    public List<Room> getAllRoomInHotel(@PathVariable Long id) {
//        return applicationFacade.getByIdHotel(id).getRooms();
//    }
//
//    @PostMapping
//    public void createHotel() {
//        Hotel hotel = new Hotel();
//        applicationFacade.saveHotel(hotel);
//    }
}
