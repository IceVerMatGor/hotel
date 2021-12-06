package by.gorbov.hotel.controller;

import by.gorbov.hotel.dto.BillDto;
import by.gorbov.hotel.facade.ApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final ApplicationFacade applicationFacade;

    public BillController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDto> getBillById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationFacade.getByIdBill(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BillDto>> getAllBills() {
        return ResponseEntity.ok(applicationFacade.getAllBill());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createBill(@RequestBody BillDto bill) {
        applicationFacade.saveBill(bill);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateBill(@RequestBody BillDto bill) {
        applicationFacade.updateBill(bill);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        applicationFacade.deleteBill(id);
        return ResponseEntity.ok().build();
    }
}
