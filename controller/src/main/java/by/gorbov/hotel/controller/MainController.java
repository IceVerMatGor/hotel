package by.gorbov.hotel.controller;

import by.gorbov.hotel.facade.ApplicationFacade;
import by.gorbov.hotel.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class MainController {

    private final ApplicationFacade applicationFacade;

    public MainController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }


    @GetMapping("/findFirst")
    public Reservation hello() {
        Reservation reservation = new Reservation();
        Date date = new Date();
        reservation.setEndDate(date);

//        for (long i = 0; i < 60; i++) {
//            Bill bill = new Bill();
//            bill.setId(i);
//            bill.setPrice((int) i);
//            client.getBills().add(bill);
//        }
        return reservation;
    }


}
