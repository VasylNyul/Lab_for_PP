package lpnu.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DrinkDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Positive(message="Price has to be greater than 0")
    private Integer price;
    @NotNull
    @Positive
    private Integer milliliters;

    public DrinkDTO(final Long id, final String name, final Integer price, final Integer milliliters) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.milliliters = milliliters;
    }

    public DrinkDTO() {
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

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public Integer getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(final Integer milliliters) {
        this.milliliters = milliliters;
    }
}