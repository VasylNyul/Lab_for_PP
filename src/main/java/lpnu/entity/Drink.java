package lpnu.entity;

public class Drink {

    private Long id;
    private String name;

    private int price;

    private int milliliters;

    public Drink() {
    }

    public Drink(final Long id, final String name, final int price, final int milliliters) {
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }

}