package lpnu.entity;

public class Meal {

    private Long id;
    private String name;

    private Integer price;

    private Integer grams;

    public Meal() {
    }

    public Meal(final Long id, final String name, final Integer price, final Integer grams) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.grams = grams;
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
