package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enums.Status;


public class User {

    private Long id;
    private String name;
    private String email;
    private String codeForAuth;
    private Status status;
    private int coffeeBean;
    public User() {
    }

    public User(final Long id, final String name, final String email, final String codeForAuth, final Status status, final int coffeeBean) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeForAuth = codeForAuth;
        this.status = status;
        this.coffeeBean = coffeeBean;
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
