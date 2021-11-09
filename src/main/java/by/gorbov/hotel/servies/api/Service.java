package by.gorbov.hotel.servies.api;

import by.gorbov.hotel.dto.AbstractDto;

import java.util.List;

public interface Service<Dto extends AbstractDto> {
    void save(Dto dto);

    void update(Dto newDto);

    void delete(Long id);

    Dto getById(Long id);

    List<Dto> getAll();

    List<Dto> getAllSortedBy(String name);
}
