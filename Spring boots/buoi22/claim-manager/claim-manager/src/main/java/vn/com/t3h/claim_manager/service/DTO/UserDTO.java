package vn.com.t3h.claim_manager.service.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
    private String code;
    private String username;
    private String fullName;
    private LocalDateTime createdDate;
    private String address;

    public UserDTO(String code, String username,  String fullName, LocalDateTime createdDate, String address) {
        this.code = code;
        this.username = username;
        this.fullName = fullName;
        this.createdDate = createdDate;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createdDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}