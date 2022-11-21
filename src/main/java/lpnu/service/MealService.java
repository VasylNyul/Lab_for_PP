package lpnu.service;

import lpnu.dto.MealDTO;

import java.util.List;
public interface MealService {
    List<MealDTO> getAllMeals();
    MealDTO create(MealDTO mealDTO);
    MealDTO findById(Long id);
    MealDTO update(MealDTO mealDTO);

    void delete(Long id);
}