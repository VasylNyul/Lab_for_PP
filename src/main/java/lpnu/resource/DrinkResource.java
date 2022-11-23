package lpnu.resource;

import lpnu.dto.DrinkDTO;
import lpnu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class DrinkResource {
    @Autowired
    private DrinkService drinkService;

    @GetMapping("/drinks")
    public List<DrinkDTO> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @GetMapping("/drink/{id}")
    public DrinkDTO findById(@PathVariable final Long id) {
        return drinkService.findById(id);
    }

    @PostMapping("/drink")
    public DrinkDTO createDrink(@RequestBody @Validated final DrinkDTO drinkDTO) {
        return drinkService.create(drinkDTO);
    }

    @PutMapping("/drink")
    public DrinkDTO updateDrink(@RequestBody final DrinkDTO drinkDTO) {
        return drinkService.update(drinkDTO);
    }

    @DeleteMapping("/drink/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        drinkService.delete(id);
        return ResponseEntity.ok().build();
    }

}

