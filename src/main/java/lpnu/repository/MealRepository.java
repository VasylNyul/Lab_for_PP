package lpnu.repository;

import lpnu.annotation.NotEmptyList;
import lpnu.entity.Meal;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepository {
    private final List<Meal> meals = new ArrayList<>();
    private long id = 1;

    @NotEmptyList
    public List<Meal> getAllMeals() {
        return new ArrayList<>(meals);
    }

    public void delete(final Long id) {
        for (final Meal meal : meals) {
            if (meal.getId().equals(id)) {
                meals.remove(meal);
                break;
            }
        }
    }

    public Meal update(final Meal meal) {
        final Meal savedMeal = findById(meal.getId());

        savedMeal.setName(meal.getName());
        savedMeal.setPrice(meal.getPrice());
        savedMeal.setGrams(meal.getGrams());

        return savedMeal;
    }

    public void saveMeal(final Meal meal) {
        meal.setId(id);
        ++id;
        meals.add(meal);
    }

    public Meal findById(final Long id) {
        return meals.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "meal with id " + id + " not found"));
    }
}