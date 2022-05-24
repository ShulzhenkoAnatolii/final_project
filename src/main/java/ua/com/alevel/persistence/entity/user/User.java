package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.util.RoleType;
import ua.com.alevel.persistence.entity.util.SexType;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex_type", nullable = false)
    private SexType sexType;

    public User() {
        super();
        this.enabled = true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }
}
