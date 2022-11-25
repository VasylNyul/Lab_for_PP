package lpnu.dto;

import lpnu.entity.enums.Status;

import javax.validation.constraints.NotNull;

public class LocationDTO {
    private Long id;
    @NotNull
    private  String city;
    @NotNull
    private String address;
    private Status status;

    public LocationDTO() {
    }

    public LocationDTO(final Long id, final String city, final String address, final Status status) {
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

    public void setCity(final String city) {
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
