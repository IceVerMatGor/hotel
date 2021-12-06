package by.gorbov.hotel.service.impl;


import by.gorbov.hotel.dao.api.BillDao;
import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.dto.RequestDto;

import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ReservationServiceTest {


    private static final RoomDao roomDao = mock(RoomDao.class);
    private static final ReservationMapper reservationMapper = mock(ReservationMapper.class);
    private static final RequestMapper requestMapper = mock(RequestMapper.class);
    private static final ReservationDao reservationDao = mock(ReservationDao.class);
    private static final RequestDao requestDao = mock(RequestDao.class);
    private static final BillDao billDao = mock(BillDao.class);

    @InjectMocks
    ReservationServiceImpl reservationService;

    @BeforeAll
    public static void setup() {

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Room room = new Room();
            room.setId((long) i + 1);
            room.setPlace(i + 1);
            room.setRoomClass(RoomClass.TWO_STAR);
            room.setPrice((i + 1) * 1000);
            List<Reservation> reservations = new ArrayList<>();
            Reservation reservation = new Reservation();
            reservation.setStartDate(new GregorianCalendar(2001, Calendar.NOVEMBER, 12).getTime());
            reservation.setEndDate(new GregorianCalendar(2002, Calendar.NOVEMBER, 12).getTime());
            reservation.setRoom(room);
            reservations.add(reservation);
            reservations.add(reservation);

            room.setReservations(reservations);
            rooms.add(room);
        }

        when(roomDao.getAll()).thenReturn(rooms);
        when(requestMapper.toEntity(any())).thenReturn(new Request());
    }


    @Test
    public void findRoomTest() {
        RequestDto request = new RequestDto();
        request.setRoomClass(RoomClass.TWO_STAR.name());
        request.setStatus(RequestStatus.NOT_VIEWED.name());
        request.setPlace(2);
        request.setStartDate(new GregorianCalendar(2003, Calendar.NOVEMBER, 12).getTime());
        request.setEndDate(new GregorianCalendar(2004, Calendar.NOVEMBER, 12).getTime());

        Optional<Room> room = reservationService.findRoom(request);
        room.ifPresent(value -> Assert.isTrue(2L == value.getId(), "select wrong room"));
    }

    @Test
    public void addReservationNoSuitableRoomTest() {
        RequestDto request = new RequestDto();
        request.setRoomClass(RoomClass.TWO_STAR.name());
        request.setStatus(RequestStatus.NOT_VIEWED.name());
        request.setPlace(1);
        request.setStartDate(new GregorianCalendar(2001, Calendar.DECEMBER, 12).getTime());
        request.setEndDate(new GregorianCalendar(2002, Calendar.DECEMBER, 12).getTime());
        reservationService.addReservation(request);
        Assert.isTrue(Objects.equals(request.getStatus(), RequestStatus.NO_SUITABLE_ROOM.name()));
        //Assertions.assertThrows(NullPointerException.class, () -> reservationService.findRoom(request));
    }

    @Test
    public void addReservationTest() {
        RequestDto request = new RequestDto();
        request.setId(1L);
        request.setClientId(1L);
        request.setRoomClass(RoomClass.TWO_STAR.name());
        request.setStatus(RequestStatus.NOT_VIEWED.name());
        request.setPlace(1);
        request.setStartDate(new GregorianCalendar(2003, Calendar.NOVEMBER, 12).getTime());
        request.setEndDate(new GregorianCalendar(2004, Calendar.NOVEMBER, 12).getTime());


        reservationService.addReservation(request);
        Assert.isTrue(Objects.equals(request.getStatus(), RequestStatus.BOOKED.name()), "request status not changed");
    }
}
