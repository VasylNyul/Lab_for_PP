package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {
    private Long drinkID;
    private String drinkName;
    private Long mealID;
    private String mealName;
    private int amount;
}
