package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.facade.ApplicationFacade;
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
    public ClientDto getClientById(@PathVariable Long id) {
        return applicationFacade.getByIdClient(id);
    }

    @GetMapping("/all")
    public List<ClientDto> getAllClients() {
        return applicationFacade.getAllClient();
    }

    @PostMapping("/save")
    public void createClient(@RequestBody ClientDto client) {

        applicationFacade.saveClient(client);
    }

    @PostMapping("/update")
    public void updateClient(@RequestBody ClientDto client) {
        applicationFacade.updateClient(client);
    }

    @PostMapping("{id}/delete")
    public void deleteClient(@PathVariable Long id) {
        applicationFacade.deleteClient(id);
    }

//    @PostMapping("/{id}/create/request")
//    public void createRequest(@PathVariable Long id, RequestDto request) {
//        applicationFacade.getByIdClient(id).setId(request.getId());
//
//    }
}
