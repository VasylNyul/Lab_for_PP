package lpnu.mapper;

import lpnu.dto.MealDTO;
import lpnu.entity.Meal;

public class MealMapper {

    public static MealDTO toDTO(final Meal meal){
        final MealDTO mealDTO = new MealDTO();


        mealDTO.setId(meal.getId());
        mealDTO.setName(meal.getName());
        mealDTO.setPrice(meal.getPrice());
        mealDTO.setGrams(meal.getGrams());

        return mealDTO;
    }

    public static Meal toEntity(final MealDTO mealDTO){
        final Meal meal = new Meal();

        meal.setId(mealDTO.getId());
        meal.setName(mealDTO.getName());
        meal.setPrice(mealDTO.getPrice());
        meal.setGrams(mealDTO.getGrams());

        return meal;
    }
}