package lpnu.service.impl;

import lpnu.dto.LocationDTO;
import lpnu.entity.Location;
import lpnu.entity.enums.Status;
import lpnu.repository.LocationRepository;
import lpnu.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
class LocationServiceImplTest {
    private static final LocationRepository locationRepository = Mockito.mock(LocationRepository.class);
    private static final LocationService locationService = new LocationServiceImpl(locationRepository);
    private static final long ID = 1L;
    private static final long ID1 = 3L;

    @Test
    void getAllLocations() {
        final Location location = new Location(ID, "Lviv", "Svobody Av", Status.ACTIVE);

        final Location location1 = new Location(ID1, "Kyiv", "Yaroslaviv Val St", Status.ACTIVE);

        final List<Location> locations = new ArrayList<>();

        locations.add(location);
        locations.add(location1);

        Mockito.when(locationRepository.getAllLocations()).thenReturn(locations);

        final List<LocationDTO> result = locationService.getAllLocations();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void findByIdLocationTest() throws Exception {
        final Location location = new Location(ID, "Lviv", "Svobody Av", Status.ACTIVE);

        when(locationRepository.findById(ID)).thenReturn(location);

        final LocationDTO locationDTO = locationService.findById(ID);

        assertNotNull(locationDTO);
        assertEquals(ID, (long) locationDTO.getId());
        assertEquals(location.getAddress(), locationDTO.getAddress());
    }

    @Test
    void delete() {
        final Location location = new Location(ID, "Lviv", "Svobody Av", Status.ACTIVE);

        locationService.delete(ID);

        Mockito.verify(locationRepository).delete(ID);
    }
}
