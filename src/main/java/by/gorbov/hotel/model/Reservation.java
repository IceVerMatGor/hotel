package by.gorbov.hotel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation extends AbstractEntity{

    @ManyToOne
    private Client client;

    @ManyToOne
    private Room room;

    private Date startDate;

    private Date endDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
