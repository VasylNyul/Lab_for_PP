package lpnu.entity.enums;

import java.util.ResourceBundle;

public enum City {
    LVIV(0, "Lviv"), 
    KYIV(1, "Kyiv");

    private final int code;
    private final String city;

    City(final int code, final String city) {
        this.code = code;
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public City valueOf(final int code) {
        switch (code) {
            case 0:
                return City.LVIV;
            case 1:
                return City.KYIV;
            default:
                final ResourceBundle resourceBundle = ResourceBundle.getBundle("model_messages");
                throw new RuntimeException(resourceBundle.getString("city.notfound"));
        }
    }
}
