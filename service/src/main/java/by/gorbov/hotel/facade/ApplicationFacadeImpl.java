package by.gorbov.hotel.facade;

import by.gorbov.hotel.dto.*;
import by.gorbov.hotel.service.api.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFacadeImpl implements ApplicationFacade {

    private final AdminService adminService;
    private final BillService billService;
    private final EmployeeService employeeService;
    private final RequestService requestService;
    private final ReservationService reservationService;
    private final RoomService roomService;
    private final ClientService clientService;
    private final HotelService hotelService;

    public ApplicationFacadeImpl(AdminService adminService, BillService billService, EmployeeService employeeService, RequestService requestService, ReservationService reservationService, RoomService roomService, ClientService clientService, HotelService hotelService) {
        this.adminService = adminService;
        this.billService = billService;
        this.employeeService = employeeService;
        this.requestService = requestService;
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.clientService = clientService;
        this.hotelService = hotelService;
    }


    @Override
    public void saveAdmin(AdminDto dto) {
        adminService.save(dto);
    }

    @Override
    public void updateAdmin(AdminDto newDto) {
        adminService.update(newDto);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminService.delete(id);
    }

    @Override
    public AdminDto getByIdAdmin(Long id) {
        return adminService.getById(id);
    }

    @Override
    public List<AdminDto> getAllAdmin() {
        return adminService.getAll();
    }

    @Override
    public List<AdminDto> getAllAdminSortedBy(String name) {
        return null;
    }

    @Override
    public void saveBill(BillDto dto) {
        billService.save(dto);
    }

    @Override
    public void updateBill(BillDto newDto) {
        billService.update(newDto);
    }

    @Override
    public void deleteBill(Long id) {
        billService.delete(id);
    }

    @Override
    public BillDto getByIdBill(Long id) {
        return billService.getById(id);
    }

    @Override
    public List<BillDto> getAllBill() {
        return billService.getAll();
    }

    @Override
    public List<BillDto> getAllBillSortedBy(String name) {
        return null;
    }

    @Override
    public void saveEmployee(EmployeeDto dto) {
        employeeService.save(dto);
    }

    @Override
    public void updateEmployee(EmployeeDto newDto) {
        employeeService.update(newDto);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeService.delete(id);
    }

    @Override
    public EmployeeDto getByIdEmployee(Long id) {
        return employeeService.getById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAll();
    }

    @Override
    public List<EmployeeDto> getAllEmployeeSortedBy(String name) {
        return null;
    }

    @Override
    public void saveHotel(HotelDto dto) {
        hotelService.save(dto);
    }

    @Override
    public void updateHotel(HotelDto newDto) {
        hotelService.update(newDto);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelService.delete(id);
    }

    @Override
    public HotelDto getByIdHotel(Long id) {
        return hotelService.getById(id);
    }

    @Override
    public List<HotelDto> getAllHotel() {
        return hotelService.getAll();
    }

    @Override
    public List<HotelDto> getAllHotelSortedBy(String name) {
        return null;
    }

    @Override
    public void saveRequest(RequestDto dto) {
        requestService.save(dto);
    }

    @Override
    public void updateRequest(RequestDto newDto) {
        requestService.update(newDto);
    }

    @Override
    public void deleteRequest(Long id) {
        requestService.delete(id);
    }

    @Override
    public RequestDto getByIdRequest(Long id) {
        return requestService.getById(id);
    }

    @Override
    public List<RequestDto> getAllRequest() {
        return requestService.getAll();
    }

    @Override
    public List<RequestDto> getAllRequestSortedBy(String name) {
        return null;
    }

    @Override
    public void saveReservation(ReservationDto dto) {
        reservationService.save(dto);
    }

    @Override
    public void updateReservation(ReservationDto newDto) {
        reservationService.update(newDto);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationService.delete(id);
    }

    @Override
    public ReservationDto getByIdReservation(Long id) {
        return reservationService.getById(id);
    }

    @Override
    public List<ReservationDto> getAllReservation() {
        return reservationService.getAll();
    }

    @Override
    public List<ReservationDto> getAllReservationSortedBy(String name) {
        return null;
    }

    @Override
    public void saveRoom(RoomDto dto) {
        roomService.save(dto);
    }

    @Override
    public void updateRoom(RoomDto newDto) {
        roomService.update(newDto);
    }

    @Override
    public void deleteRoom(Long id) {
        roomService.delete(id);
    }

    @Override
    public RoomDto getByIdRoom(Long id) {
        return roomService.getById(id);
    }

    @Override
    public List<RoomDto> getAllRoom() {
        return roomService.getAll();
    }

    @Override
    public List<RoomDto> getAllRoomSortedBy(String name) {
        return null;
    }

    @Override
    public void saveClient(ClientDto dto) {
        clientService.save(dto);
    }

    @Override
    public void updateClient(ClientDto newDto) {
        clientService.update(newDto);
    }

    @Override
    public void deleteClient(Long id) {
        clientService.delete(id);
    }

    @Override
    public ClientDto getByIdClient(Long id) {
        return clientService.getById(id);
    }

    @Override
    public List<ClientDto> getAllClient() {
        return clientService.getAll();
    }

    @Override
    public List<ClientDto> getAllClientSortedBy(String name) {
        return null;
    }
}
