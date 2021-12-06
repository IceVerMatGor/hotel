package by.gorbov.hotel.dto;

import java.util.List;

public class RoomDto extends AbstractDto{

    private List<ReservationDto> reservations;
    private Long hotelId;
    private Integer place;
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

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
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
