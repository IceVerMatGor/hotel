package by.gorbov.hotel.dto;

import java.util.List;

public class ClientDto extends AbstractDto{
    private String email;
    private String name;
    private List<Long> billsId;
    private List<Long> reservationsId;
    private List<Long> requestsId;

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

    public List<Long> getBillsId() {
        return billsId;
    }

    public void setBillsId(List<Long> billsId) {
        this.billsId = billsId;
    }

    public List<Long> getReservationsId() {
        return reservationsId;
    }

    public void setReservationsId(List<Long> reservationsId) {
        this.reservationsId = reservationsId;
    }

    public List<Long> getRequestsId() {
        return requestsId;
    }

    public void setRequestsId(List<Long> requestsId) {
        this.requestsId = requestsId;
    }
}
