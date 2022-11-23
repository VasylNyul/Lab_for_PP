package lpnu.repository;

import lpnu.annotation.NotEmptyList;
import lpnu.entity.Drink;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DrinkRepository {
    private final List<Drink> drinks = new ArrayList<>();
    private long id = 1;

    @NotEmptyList
    public List<Drink> getAllDrinks() {
        return new ArrayList<>(drinks);
    }

    public void delete(final Long id) {
        for (final Drink drink : drinks) {
            if (drink.getId().equals(id)) {
                drinks.remove(drink);
                break;
            }
        }
    }

    public Drink update(final Drink drink) {
        final Drink savedDrink = findById(drink.getId());

        savedDrink.setName(drink.getName());
        savedDrink.setPrice(drink.getPrice());
        savedDrink.setMilliliters(drink.getMilliliters());

        return savedDrink;
    }

    public void saveDrink(final Drink drink) {
        drink.setId(id);
        ++id;
        drinks.add(drink);
    }

    public Drink findById(final Long id) {
        return drinks.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "drink with id " + id + " not found"));
    }
}