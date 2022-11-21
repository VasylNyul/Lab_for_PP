package lpnu.service.impl;

import lpnu.dto.LocationDTO;
import lpnu.entity.Location;
import lpnu.entity.enums.Status;
import lpnu.exception.ServiceException;
import lpnu.mapper.LocationMapper;
import lpnu.repository.LocationRepository;
import lpnu.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationRepository.getAllLocations().stream()
                        .map(LocationMapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> getActiveLocation() {
        return getAllLocations().stream()
                .filter(e -> e.getStatus().equals(Status.ACTIVE))
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO create(final LocationDTO locationDTO) {
        final Location location = LocationMapper.toEntity(locationDTO);
        location.setStatus(Status.ACTIVE);

        locationRepository.save(location);

        return LocationMapper.toDTO(location);
    }

    @Override
    public LocationDTO findById(final Long id) {
        return LocationMapper.toDTO(locationRepository.findById(id));
    }

    @Override
    public LocationDTO update(final LocationDTO locationDTO) {
        if (locationDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Location location = LocationMapper.toEntity(locationDTO);

        locationRepository.update(location);

        return LocationMapper.toDTO(location);
    }

    @Override
    public void delete(final Long id) {
        locationRepository.delete(id);

    }
}
