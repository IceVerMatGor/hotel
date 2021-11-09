package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl extends AbstractDao<Reservation> implements ReservationDao {
    @Override
    protected Class<Reservation> getEntityClass() {
        return Reservation.class;
    }
}
