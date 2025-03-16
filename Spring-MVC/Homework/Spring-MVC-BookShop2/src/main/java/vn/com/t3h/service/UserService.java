package vn.com.t3h.service;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.model.UserDTO;

import java.util.List;
public interface UserService {
    List<UserDTO> getAllUser();
    public List<UserDTO> searchUserByName(String userName, String fullName , String identityNumber);
    public UserDTO addUser(UserDTO userDTO);
    UserDTO findByID(Long id);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
