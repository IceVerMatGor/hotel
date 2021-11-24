package by.gorbov.hotel.service.impl;


import by.gorbov.hotel.dao.api.BillDao;
import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.dto.RequestDto;

import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.Request;
import by.gorbov.hotel.model.Reservation;
import by.gorbov.hotel.model.Room;

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
            room.setPlaces(i + 1);
            room.setRoomClass(i + 1 + "-star");
            room.setPrice((i + 1) * 1000);
            List<Reservation> reservations = new ArrayList<>();
            Reservation reservation = new Reservation();
            reservation.setStartDate(new Date(2001, 10, 12));
            reservation.setEndDate(new Date(2002, 10, 12));
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
        request.setRoomClass("2-star");
        request.setStatus("no");
        request.setPlaces(1);
        request.setStartDate(new Date(2003, 12, 12));
        request.setEndDate(new Date(2004, 12, 12));

        Room room = reservationService.findRoom(request);
        Assert.isTrue(2L == room.getId(), "select wrong room");
    }

    @Test
    public void findRoomFailTest() {
        RequestDto request = new RequestDto();
        request.setRoomClass("2-star");
        request.setStatus("no");
        request.setPlaces(1);
        request.setStartDate(new Date(2001, 12, 12));
        request.setEndDate(new Date(2002, 12, 12));

        Assertions.assertThrows(NullPointerException.class, () -> reservationService.findRoom(request));
    }

    @Test
    public void addReservationTest() {
        RequestDto request = new RequestDto();
        request.setId(1L);
        request.setClientId(1L);
        request.setRoomClass("2-star");
        request.setStatus("no");
        request.setPlaces(1);
        request.setStartDate(new Date(2003, 12, 12));
        request.setEndDate(new Date(2004, 12, 12));


        reservationService.addReservation(request);
        Assert.isTrue(Objects.equals(request.getStatus(), "ok"), "request status not changed");
    }
}
