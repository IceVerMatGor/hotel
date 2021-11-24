package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.EmployeeDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ApplicationFacade applicationFacade;

    public EmployeeController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdEmployee(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(applicationFacade.getAllEmployee());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeDto employee) {
        applicationFacade.saveEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeDto employee) {
        applicationFacade.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        applicationFacade.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
