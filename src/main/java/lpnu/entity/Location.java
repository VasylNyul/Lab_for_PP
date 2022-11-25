package lpnu.entity;

import lpnu.entity.enums.Status;

public class Location {
    private Long id;
    private String city;
    private String address;
    private Status status;

    public Location() {
    }

    public Location(final Long id, final String city, final String address, final Status status) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String  city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
