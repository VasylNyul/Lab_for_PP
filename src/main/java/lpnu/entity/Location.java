package lpnu.entity;

import lpnu.entity.enums.Address;
import lpnu.entity.enums.City;
import lpnu.entity.enums.Status;

public class Location {
    private Long id;
    private City city;
    private Address address;
    private Status status;

    public Location() {
    }

    public Location(final Long id, final City city, final Address address, final Status status) {
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

    public City getCity() {
        return city;
    }

    public void setCity(final City  city) {
        this.city = city;
    }

    public Address getAddress() {
        return Address.valueOf(city, address.getCode());
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
