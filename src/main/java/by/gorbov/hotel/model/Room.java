package by.gorbov.hotel.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Room extends AbstractEntity {

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @ManyToOne
    private Hotel hotel;

    private Integer places;
    private Integer price;
    private String roomClass;
}
