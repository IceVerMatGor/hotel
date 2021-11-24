package by.gorbov.hotel.dto;

import java.util.List;

public class ClientDto extends AbstractDto{
    private String email;
    private String name;
    private List<BillDto> bills;
    private List<ReservationDto> reservations;
    private List<RequestDto> requests;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BillDto> getBills() {
        return bills;
    }

    public void setBills(List<BillDto> bills) {
        this.bills = bills;
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public List<RequestDto> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDto> requests) {
        this.requests = requests;
    }
}
