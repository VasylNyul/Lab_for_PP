package lpnu.repository;

import lpnu.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private Long drinkId = 0L;
    private Long mealId = 0L;

    public List<Order> getAllOrders(){
        return new ArrayList<>(orders);
    }

    public Order saveDrink(final Order drink){
        ++drinkId;
        drink.setId(drinkId.longValue());

        orders.add(drink);

        return drink;
    };

    public Order saveMeal(final Order meal){
        ++mealId;
        meal.setId(mealId.longValue());

        orders.add(meal);

        return meal;
    };

    public Order findById(final Long id){
        return orders.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found by id: " + id));
    }

    public void delete(final Long id){
        orders = orders.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Order update(final Order drink){
        final Order saved = findById(drink.getId());

        saved.setUser(drink.getUser());
        saved.setOrderDetails(drink.getOrderDetails());
        saved.setOrderStatus(drink.getOrderStatus());
        saved.setOrderDateTime(drink.getOrderDateTime());

        return saved;
    }

    public Order updateMeal(final Order meal){
        final Order saved = findById(meal.getId());

        saved.setUser(meal.getUser());
        saved.setOrderDetails(meal.getOrderDetails());
        saved.setOrderStatus(meal.getOrderStatus());
        saved.setOrderDateTime(meal.getOrderDateTime());

        return saved;
    }
}
