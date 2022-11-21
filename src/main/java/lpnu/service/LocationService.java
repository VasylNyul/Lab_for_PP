package lpnu.service;

import lpnu.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> getAllLocations();
    List<LocationDTO> getActiveLocation();
    LocationDTO create(LocationDTO locationDTO);
    LocationDTO findById(Long id);
    LocationDTO update(LocationDTO locationDTO);
    void delete(Long id);
}

