package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.ClientDao;
import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.ClientMapper;
import by.gorbov.hotel.model.Client;
import by.gorbov.hotel.service.api.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends AbstractService<Client, ClientDao, ClientDto, ClientMapper> implements ClientService {

    private final ClientDao clientDao;
    private final RequestDao requestDao;
    private final ReservationDao reservationDao;

    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientDao clientDao, RequestDao requestDao, ReservationDao reservationDao, ClientMapper clientMapper) {
        this.clientDao = clientDao;
        this.requestDao = requestDao;
        this.reservationDao = reservationDao;
        this.clientMapper = clientMapper;
    }

    @Override
    protected ClientDao getDefaultDao() {
        return clientDao;
    }

    @Override
    protected ClientMapper getDefaultMapper() {
        return clientMapper;
    }

    @Override
    public void addReservation(Long clientId, Long reservationId) {
        clientDao.getById(clientId).getReservations().add(reservationDao.getById(reservationId));
    }

}
