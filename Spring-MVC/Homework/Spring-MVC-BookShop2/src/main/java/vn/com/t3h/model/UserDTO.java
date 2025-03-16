package vn.com.t3h.model;

public class UserDTO {
    private long id;
    private String userName;
    private String password;
    private String fullName;
    private String role_name;
    private String address;
    private String identityNumber;


    public UserDTO() {
    }

    public UserDTO(long id, String userName, String password, String fullName, String role_name, String address, String identityNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.role_name = role_name;
        this.address = address;
        this.identityNumber = identityNumber;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }


}
