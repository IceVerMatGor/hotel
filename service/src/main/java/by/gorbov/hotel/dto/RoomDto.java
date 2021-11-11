package by.gorbov.hotel.dto;

import java.util.List;

public class RoomDto extends AbstractDto{

    private List<Long> reservationsId;
    private Long hotelId;
    private Integer places;
    private Integer price;
    private String roomClass;
}
