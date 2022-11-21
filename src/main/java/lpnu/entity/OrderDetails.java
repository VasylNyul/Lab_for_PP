package lpnu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    //item;
    private Drink drink;
    private Meal meal;
    private int amount;
}
