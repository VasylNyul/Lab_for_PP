package lpnu.service.impl;

import lpnu.dto.MealDTO;
import lpnu.entity.Meal;
import lpnu.exception.ServiceException;
import lpnu.repository.MealRepository;
import lpnu.service.MealService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class MealServiceImplTest {
    @Test
    public void test_getMealById_mealExist() throws Exception {
        final MealRepository mealRepository = Mockito.mock(MealRepository.class);
        final MealService mealService = new MealServiceImpl(mealRepository);

        final Meal meal = new Meal(1l, "WEB CAPPUCCINO", 49, 270);

        when(mealRepository.findById(1l)).thenReturn(meal);


        final MealDTO mealDTO = mealService.findById(1l);

        assertNotNull(mealDTO);
        assertEquals(1l, (long) mealDTO.getId());
        assertEquals(meal.getName(), mealDTO.getName());
    }

    @Test
    public void test_getMealById_mealNotExist() throws Exception {
        final MealRepository mealRepository = Mockito.mock(MealRepository.class);

        final MealService mealService = new MealServiceImpl(mealRepository);

        when(mealRepository.findById(1l)).thenThrow(new ServiceException(400, "some exception"));


        try {
            final MealDTO mealDTO = mealService.findById(1l);
            fail();
        } catch (final ServiceException e) {

        }
    }

}