package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ApplicationFacade applicationFacade;

    public ClientController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdClient(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return  ResponseEntity.ok(applicationFacade.getAllClient());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createClient(@RequestBody ClientDto client) {
        applicationFacade.saveClient(client);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateClient(@RequestBody ClientDto client) {
        applicationFacade.updateClient(client);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        applicationFacade.deleteClient(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/{id}/create/request")
    public ResponseEntity<Void> createRequest(@PathVariable Long id,@RequestBody RequestDto request) {
        applicationFacade.addRequest(id,request);
        return ResponseEntity.ok().build();
    }
}
