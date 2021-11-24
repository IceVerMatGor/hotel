package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.AdminDto;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ApplicationFacade applicationFacade;

    public AdminController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdAdmin(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return ResponseEntity.ok(applicationFacade.getAllAdmin());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createAdmin(@RequestBody AdminDto admin) {
        applicationFacade.saveAdmin(admin);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> updateAdmin(@RequestBody AdminDto admin) {
        applicationFacade.updateAdmin(admin);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        applicationFacade.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/create/reservation")
    public ResponseEntity<Void> createReservation(@RequestBody RequestDto request){
        applicationFacade.addReservation(request);
        return ResponseEntity.ok().build();
    }
}
