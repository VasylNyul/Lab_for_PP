package lpnu.mapper;

import lpnu.dto.LocationDTO;
import lpnu.entity.Location;

public class LocationMapper {
    public static LocationDTO toDTO(final Location location){
        final LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(location.getId());
        locationDTO.setCity(location.getCity());
        locationDTO.setAddress(location.getAddress());
        locationDTO.setStatus(location.getStatus());

        return locationDTO;
    }

    public static Location toEntity(final LocationDTO locationDTO){
        final Location location = new Location();

        location.setId(locationDTO.getId());
        location.setCity(locationDTO.getCity());
        location.setAddress(locationDTO.getAddress());
        location.setStatus(locationDTO.getStatus());

        return location;
    }
}
