package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        client.setEmail("attempt@email.rofl");
        client.setName("attempt1");
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        client.setRequestsId(list);

//        RequestDto request = new RequestDto();
//        request.setId(1L);
//        request.setPlaces(8);
//        RequestDto request2 = new RequestDto();
//        request2.setId(2L);
//        request2.setPlaces(12);
//        applicationFacade.saveRequest(request);
//        applicationFacade.saveRequest(request2);
        applicationFacade.saveClient(client);
    }

    @PostMapping("/update")
    public void updateClient(ClientDto client) {
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
