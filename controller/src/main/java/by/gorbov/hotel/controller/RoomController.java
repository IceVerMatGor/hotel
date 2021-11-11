package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.RoomDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final ApplicationFacade applicationFacade;

    public RoomController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    private RoomDto getRoomById(@PathVariable Long id) {
        return applicationFacade.getByIdRoom(id);
    }

    @GetMapping("/all")
    private List<RoomDto> getAllRooms(){
        return applicationFacade.getAllRoom();
    }
}
