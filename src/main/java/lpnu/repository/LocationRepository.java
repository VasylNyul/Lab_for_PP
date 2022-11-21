package lpnu.repository;

import lpnu.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LocationRepository {
    private List<Location> locations = new ArrayList<>();
    private long id = 0L;

    public List<Location> getAllLocations() {
        return new ArrayList<>(locations);
    }

    public Location save(final Location location){
        ++id;
        location.setId(id);

        locations.add(location);

        return location;
    }

    public Location findById(final Long id) {
        return locations.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Location not found by id: " + id));

    }

    public Location update(final Location location) {
        final Location saved = findById(location.getId());

        saved.setCity(saved.getCity());
        saved.setAddress(saved.getAddress());
        saved.setStatus(saved.getStatus());

        return saved;
    }

    public void delete(final Long id) {
        locations = locations.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

}
