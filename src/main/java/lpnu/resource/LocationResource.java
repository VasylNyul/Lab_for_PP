package lpnu.resource;

import lpnu.dto.LocationDTO;
import lpnu.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationResource {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDTO findById(@PathVariable final Long id) {
        return locationService.findById(id);
    }

    @PostMapping
    public LocationDTO createItem(@RequestBody @Validated final LocationDTO locationDTO) {
        return locationService.create(locationDTO);
    }

    @PutMapping
    public LocationDTO updateItem(@RequestBody @Validated final LocationDTO locationDTO) {
        return locationService.update(locationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        locationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public List<LocationDTO> getActiveLocation() {
        return locationService.getActiveLocation();
    }
}
