package lpnu.mapper;

import lpnu.dto.OrderDetailsDTO;
import lpnu.entity.OrderDetails;
//import lpnu.repository.ItemRepository;
import lpnu.repository.DrinkRepository;
import lpnu.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {

    @Autowired
    private DrinkRepository drinkRepository;
    private MealRepository mealRepository;

    public OrderDetails toEntity(final OrderDetailsDTO orderDetailsDTO){
        final OrderDetails orderDetails = new OrderDetails();

        orderDetails.setDrink(drinkRepository.findById(orderDetailsDTO.getDrinkID()));
       // orderDetails.setMeal(drinkRepository.findById(orderDetailsDTO.getMealID()));

        orderDetails.setAmount(orderDetailsDTO.getAmount());

        return orderDetails;
    }

    public OrderDetailsDTO toDTO(final OrderDetails orderDetails){
        final OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setDrinkID(orderDetails.getDrink().getId());
        orderDetailsDTO.setDrinkName(orderDetails.getDrink().getName());
        orderDetailsDTO.setMealID(orderDetails.getMeal().getId());
        orderDetailsDTO.setMealName(orderDetails.getMeal().getName());
        orderDetailsDTO.setAmount(orderDetails.getAmount());

        return orderDetailsDTO;
    }
}
