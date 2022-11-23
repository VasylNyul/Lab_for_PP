package lpnu.entity;

public class Drink {

    private Long id;
    private String name;

    private Integer price;

    private Integer milliliters;

    public Drink() {
    }

    public Drink(final Long id, final String name, final Integer price, final Integer milliliters) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.milliliters = milliliters;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public int getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(final Integer milliliters) {
        this.milliliters = milliliters;
    }

}