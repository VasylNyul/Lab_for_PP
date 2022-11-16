package lpnu.entity;

import lpnu.entity.enums.UserRole;
import lpnu.entity.enums.Status;

public class User {

    private Long id;
    private String name;
    private String phone;
    private UserRole role;
    private Status status;

    public User() {
    }

    public User(final Long id, final String name, final String phone, final UserRole role, final Status status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.status = status;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(final UserRole role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
