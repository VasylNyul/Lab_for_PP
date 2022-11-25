package lpnu.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lpnu.entity.enums.Status;

public class UserDTO {

    private Long id;
    @NotNull
    private String name;
    @Email
    private String email;
    private String codeForAuth;
    private Status status;
    private int coffeeBean;

    public UserDTO(final Long id, final String name, final String email, final Status status, final int coffeeBean) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.coffeeBean = coffeeBean;
    }

    public UserDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCodeForAuth() {
        return codeForAuth;
    }

    public void setCodeForAuth(final String codeForAuth) {
        this.codeForAuth = codeForAuth;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public int getCoffeeBean() {
        return coffeeBean;
    }

    public void setCoffeeBean(final int coffeeBean) {
        this.coffeeBean = coffeeBean;
    }
}
