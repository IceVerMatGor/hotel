package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ApplicationFacade applicationFacade;

    public ReservationController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdReservation(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(applicationFacade.getAllReservation());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationDto reservation) {
        applicationFacade.saveReservation(reservation);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        applicationFacade.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateReservation(@RequestBody ReservationDto reservation) {
        applicationFacade.updateReservation(reservation);
        return ResponseEntity.ok().build();
    }
}
