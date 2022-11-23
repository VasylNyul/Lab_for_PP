package lpnu.service.impl;

import lpnu.dto.DrinkDTO;
import lpnu.entity.Drink;
import lpnu.exception.ServiceException;
import lpnu.repository.DrinkRepository;
import lpnu.service.DrinkService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class DrinkServiceImplTest {
    @Test
    public void test_getDrinkById_drinkExist() throws Exception {
        final DrinkRepository drinkRepository = Mockito.mock(DrinkRepository.class);
        final DrinkService drinkService = new DrinkServiceImpl(drinkRepository);

        final Drink drink = new Drink(11l, "Candy", 49, 20);

        when(drinkRepository.findById(11l)).thenReturn(drink);


        final DrinkDTO drinkDTO = drinkService.findById(11l);

        assertNotNull(drinkDTO);
        assertEquals(11l, (long) drinkDTO.getId());
        assertEquals(drink.getName(), drinkDTO.getName());
    }

    @Test
    public void test_getDrinkById_drinkNotExist() throws Exception {
        final DrinkRepository drinkRepository = Mockito.mock(DrinkRepository.class);
        final DrinkService drinkService = new DrinkServiceImpl(drinkRepository);

        when(drinkRepository.findById(11l)).thenThrow(new ServiceException(400, "some exception"));

        try {
            final DrinkDTO drinkDTO = drinkService.findById(11l);
            fail();
        } catch (final ServiceException e) {

        }
    }
}