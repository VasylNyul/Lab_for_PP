package lpnu.entity.enums;

import java.util.ResourceBundle;

public enum Address {
    SVOBODY(0, "Svobody Av"),
    POROKHOVA(1, "Porokhova St"),
    VALOVA(2, "Valova St"),
    PIDDUBOM(3, "Pid Dubom St"),
    YAROSLAVIVVAL(4, "Yaroslaviv Val St"),
    IHORIVSKA(5, "Ihorivska St");

    private final int code;
    private final String address;

    Address(final int code, final String address) {
        this.code = code;
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public static Address valueOf(final City city, final int code) {
        switch (code) {
            case 0:
                if (city.getCode() == 0) {
                    return Address.SVOBODY;
                } else {
                    throw new RuntimeException("Address not found");
                }
            case 1:
                if (city.getCode() == 0) {
                    return Address.POROKHOVA;
                } else {
                    throw new RuntimeException("Address not found");
                }
            case 2:
                if (city.getCode() == 0) {
                    return Address.VALOVA;
                } else {
                    throw new RuntimeException("Address not found");
                }
            case 3:
                if (city.getCode() == 0) {
                    return Address.PIDDUBOM;
                } else {
                    throw new RuntimeException("Address not found");
                }
            case 4:
                if (city.getCode() == 1) {
                    return Address.YAROSLAVIVVAL;
                } else {
                    throw new RuntimeException("Address not found");
                }
            case 5:
                if (city.getCode() == 1) {
                    return Address.IHORIVSKA;
                } else {
                    throw new RuntimeException("Address not found");
                }
            default:
                final ResourceBundle resourceBundle = ResourceBundle.getBundle("model_messages");
                throw new RuntimeException(resourceBundle.getString("address.notfound"));
        }
    }
}

