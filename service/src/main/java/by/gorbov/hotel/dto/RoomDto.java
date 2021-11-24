package by.gorbov.hotel.dto;

import java.util.List;

public class RoomDto extends AbstractDto{

    private List<ReservationDto> reservations;
    private Long hotelId;
    private Integer places;
    private Integer price;
    private String roomClass;

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservationsId(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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
