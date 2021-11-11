package by.gorbov.hotel.facade;

import by.gorbov.hotel.dto.*;

import java.util.List;

public interface ApplicationFacade {
    //Admin methods
    void saveAdmin(AdminDto dto);

    void updateAdmin(AdminDto newDto);

    void deleteAdmin(Long id);

    AdminDto getByIdAdmin(Long id);

    List<AdminDto> getAllAdmin();

    List<AdminDto> getAllAdminSortedBy(String name);

    //Bill methods
    void saveBill(BillDto dto);

    void updateBill(BillDto newDto);

    void deleteBill(Long id);

    BillDto getByIdBill(Long id);

    List<BillDto> getAllBill();

    List<BillDto> getAllBillSortedBy(String name);

    //Employee methods
    void saveEmployee(EmployeeDto dto);

    void updateEmployee(EmployeeDto newDto);

    void deleteEmployee(Long id);

    EmployeeDto getByIdEmployee(Long id);

    List<EmployeeDto> getAllEmployee();

    List<EmployeeDto> getAllEmployeeSortedBy(String name);

    //Hotel methods
    void saveHotel(HotelDto dto);

    void updateHotel(HotelDto newDto);

    void deleteHotel(Long id);

    HotelDto getByIdHotel(Long id);

    List<HotelDto> getAllHotel();

    List<HotelDto> getAllHotelSortedBy(String name);

    //Request methods
    void saveRequest(RequestDto dto);

    void updateRequest(RequestDto newDto);

    void deleteRequest(Long id);

    RequestDto getByIdRequest(Long id);

    List<RequestDto> getAllRequest();

    List<RequestDto> getAllRequestSortedBy(String name);

    //Reservation methods
    void saveReservation(ReservationDto dto);

    void updateReservation(ReservationDto newDto);

    void deleteReservation(Long id);

    ReservationDto getByIdReservation(Long id);

    List<ReservationDto> getAllReservation();

    List<ReservationDto> getAllReservationSortedBy(String name);

    //Room methods
    void saveRoom(RoomDto dto);

    void updateRoom(RoomDto newDto);

    void deleteRoom(Long id);

    RoomDto getByIdRoom(Long id);

    List<RoomDto> getAllRoom();

    List<RoomDto> getAllRoomSortedBy(String name);

    //Client methods
    void saveClient(ClientDto dto);

    void updateClient(ClientDto newDto);

    void deleteClient(Long id);

    ClientDto getByIdClient(Long id);

    List<ClientDto> getAllClient();

    List<ClientDto> getAllClientSortedBy(String name);
}
