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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }
}
