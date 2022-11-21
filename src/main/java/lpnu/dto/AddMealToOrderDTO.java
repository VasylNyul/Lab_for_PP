package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMealToOrderDTO {
    @Positive
    @NotNull
    private Long orderId;
    @Positive
    @NotNull
    private Long mealId;
    @Positive
    private int amount;
}
