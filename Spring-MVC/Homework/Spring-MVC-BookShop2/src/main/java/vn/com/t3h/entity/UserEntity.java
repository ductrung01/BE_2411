package vn.com.t3h.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IdentityCardEntity identityCardEntity;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<RoleEntity> roles;
    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonBackReference // Ngăn chặn việc lặp lại thông qua quan hệ
    public IdentityCardEntity getIdentityCardEntity() {
        return identityCardEntity;
    }

    @JsonBackReference // Ngăn chặn việc lặp lại thông qua quan hệ
    public Set<RoleEntity> getRoles() {
        return roles;
    }

}
