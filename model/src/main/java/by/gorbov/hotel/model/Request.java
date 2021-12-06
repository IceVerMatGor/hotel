package by.gorbov.hotel.model;

import javax.persistence.*;
import java.util.Date;

import static by.gorbov.hotel.model.RequestStatus.NOT_VIEWED;

@Entity
public class Request extends AbstractEntity{

    @ManyToOne
    private Client client;
    private Integer place;
    private RoomClass roomClass;
    private RequestStatus status = NOT_VIEWED;
    private Date startDate;
    private Date endDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
