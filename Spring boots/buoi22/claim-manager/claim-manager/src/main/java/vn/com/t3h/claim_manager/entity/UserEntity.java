package vn.com.t3h.claim_manager.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String code;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String pathAvatar;
    @Version // Thêm dòng này
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
/*
* FetchType.EAGER:Khi lay ra 1 user entity tu database thif orm se tu  dong
 lay ra het tat ca cac role cuar user entity vao dua vao vaofetch = FetchType.EAGER
=> Tức là khi lấy ra 1 UserEntity từ database thì orm sẽ tự động lấy ra hết tất cả các role của
UserEntity và đưa vào roles luôn

* fetch = FetchType.LAZY thì ngược lại
=> khi lấy ra 1 UserEntity từ database thì orm sẽ KHÔNG lấy ra hết tất cả các role của
UserEntity và đưa vào roles luôn , và nếu muốn lấy ra danh sách role của UserEntity
sẽ phải tự thực hiện các query khác . Nếu mà cố tình thực hiện trên query này
    private Set<RoleEntity> roles = new HashSet<>();
thì sẽ báo lỗi

* *
* */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPathAvatar() {
        return pathAvatar;
    }

    public void setPathAvatar(String pathAvatar) {
        this.pathAvatar = pathAvatar;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
