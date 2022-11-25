package lpnu.repository;

import lpnu.entity.Drink;
import lpnu.entity.Location;
import lpnu.entity.enums.Status;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LocationRepository {
    private List<Location> locations = new ArrayList<>();
    private long id = 1;

    public List<Location> getAllLocations() {
        return new ArrayList<>(locations);
    }

    public List<Location> getActiveLocations() {
        return locations.stream()
                .filter(e -> e.getStatus().equals(Status.ACTIVE))
                .collect(Collectors.toList());
    }

    public void save(final Location location){
        location.setId(id);
        ++id;
        locations.add(location);
//        ++id;
//        location.setId(id);
//
//        locations.add(location);
//
//        return location;
    }

    public Location findById(final Long id) {
        return locations.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "user with id " + id + " not found"));
    }

    public Location update(final Location location) {
        final Location saved = findById(location.getId());

        saved.setCity(saved.getCity());
        saved.setAddress(saved.getAddress());
        saved.setStatus(saved.getStatus());

        return saved;
    }

    public void delete(final Long id) {
        for (final Location location : locations) {
            if (location.getId().equals(id)) {
                locations.remove(location);
                break;
            }
        }
    }

}
