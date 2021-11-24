package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    private final ApplicationFacade applicationFacade;

    public RequestController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDto> getRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdRequest(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestDto>> getAllRequests() {
        return ResponseEntity.ok(applicationFacade.getAllRequest());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createRequest(@RequestBody RequestDto request) {
        applicationFacade.saveRequest(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> updateRequest(@RequestBody RequestDto request) {
        applicationFacade.updateRequest(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        applicationFacade.deleteRequest(id);
        return ResponseEntity.ok().build();
    }
}
