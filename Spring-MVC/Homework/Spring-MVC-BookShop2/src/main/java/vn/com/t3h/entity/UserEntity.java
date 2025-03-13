package vn.com.t3h.entity;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonManagedReference
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonManagedReference
    public IdentityCardEntity getIdentityCardEntity() {
        return identityCardEntity;
    }

    @JsonManagedReference
    public Set<RoleEntity> getRoles() {
        return roles;
    }

}
