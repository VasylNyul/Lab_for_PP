package lpnu.resource;

import lpnu.dto.MealDTO;
import lpnu.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class MealResource {
    @Autowired
    private MealService mealService;

    @GetMapping("/meals")
    public List<MealDTO> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/meal/{id}")
    public MealDTO findById(@PathVariable final Long id) {
        return mealService.findById(id);
    }

    @PostMapping("/meal")
    public MealDTO createMeal(@RequestBody @Validated final MealDTO mealDTO) {
        return mealService.create(mealDTO);
    }

    @PutMapping("/meal")
    public MealDTO updateMeal(@RequestBody final MealDTO mealDTO) {
        return mealService.update(mealDTO);
    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        mealService.delete(id);
        return ResponseEntity.ok().build();
    }

}

