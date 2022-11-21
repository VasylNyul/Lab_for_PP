package lpnu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MealDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Positive(message="Price has to be greater than 0")
    private Integer price;
    @NotNull
    @Positive
    private Integer grams;

    public MealDTO(final Long id, final String name, final Integer price, final Integer grams) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.grams = grams;
    }

    public MealDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }
}
