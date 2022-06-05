package ua.com.alevel.persistence.entity.user;

import lombok.Data;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.util.RoleType;

import javax.persistence.*;

@Data
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

    public User() {
        super();
        this.enabled = true;
    }

}
