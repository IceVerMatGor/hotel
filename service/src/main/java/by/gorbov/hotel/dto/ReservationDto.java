package by.gorbov.hotel.dto;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

public class ReservationDto extends AbstractDto{


    private Long clientId;

    private Long roomId;

    private Date startDate;

    private Date endDate;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
