package lpnu.mapper;

import lpnu.dto.DrinkDTO;
import lpnu.entity.Drink;

public class DrinkMapper {

    public static DrinkDTO toDTO(final Drink drink) {
        final DrinkDTO drinkDTO = new DrinkDTO();


        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setPrice(drink.getPrice());
        drinkDTO.setMilliliters(drink.getMilliliters());

        return drinkDTO;
    }

    public static Drink toEntity(final DrinkDTO drinkDTO) {
        final Drink drink = new Drink();

        drink.setId(drinkDTO.getId());
        drink.setName(drinkDTO.getName());
        drink.setPrice(drinkDTO.getPrice());
        drink.setMilliliters(drinkDTO.getMilliliters());

        return drink;
    }
}