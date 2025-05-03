package vn.com.t3h.claim_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.claim_manager.entity.RoleEntity;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.UserMapper;
import vn.com.t3h.claim_manager.repository.RoleRepository;
import vn.com.t3h.claim_manager.repository.UserRepository;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseResponse;
import vn.com.t3h.claim_manager.service.DTO.respond.Response;
import vn.com.t3h.claim_manager.service.FileService;
import vn.com.t3h.claim_manager.service.UserService;
import vn.com.t3h.claim_manager.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import vn.com.t3h.claim_manager.utils.SessionUtils;

@Service
public class UserServiceImpl implements UserService {

  @Value("${application.root.folder}")
  private String rootFolderUpload;
  @Value("${application.root.folder.image}")
  private String rootFolderImageUpload;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FileService fileService;

  /**
   1.	convert dữ liệu filed stringBase64Avatar từ StringBase64 trong userDto về lại file image
   2.	lưu file image vào folder của ổ cứng local tại path D:\T3h\LJava2411\github\LJava2411\LJava2411\spring-boot\file-upload\image
   3.	Lưu lại đường dẫn của ảnh
   4.	Convert toàn bộ dữ liệu dạng userDto sang dạng UserEntity để lưu vào database
   •	lưu ý
   o	set đường dẫn đã lưu vảnh vào thuộc tính pathAvatar của object UserEntity
   o	mặc định luôn gán quyền Role Admin cho user
   5.	Sau khi đã hoàn chỉnh thông tin UserEntity -> lưu UserEntity vào database
   6.	Trả về toàn UserDto để thông báo cho font-end đã tạo user thành công
   */

  @Override
  public Response<UserDTO> saveUser(UserDTO userDto) {
    // Lưu lại đường dẫn của ảnh
    String pathFileAvatar = saveImageAvatar(userDto);

    // Chuyển đổi sang UserEntity
    UserEntity userEntity = userMapper.toEntity(userDto);
    userEntity.setCode(Constant.CODE_START + UUID.randomUUID().toString());
    userEntity.setCreatedDate(LocalDateTime.now());
    userEntity.setLastModifiedDate(LocalDateTime.now());
    userEntity.setPathAvatar(pathFileAvatar);
    setRole(userEntity);

    try {
      // Lưu vào DB
      userEntity = userRepository.save(userEntity);
    } catch (ObjectOptimisticLockingFailureException e) {
      // Xử lý lỗi
      throw new RuntimeException("Đã có sự thay đổi trong dữ liệu. Vui lòng thử lại.", e);
    }

    // Chuyển đổi lại sang UserDTO
    userDto = userMapper.toDto(userEntity);
    Response<UserDTO> response = new Response<>();
    response.setCode(HttpStatus.OK.value());
    response.setMessage(HttpStatus.OK.name());
    response.setData(userDto);
    return response;
  }

  @Override
  public BaseResponse<List<UserDTO>> findAll(String code, LocalDate fromDate, LocalDate toDate,
      String phone, Pageable pageable) {
    if (StringUtils.isEmpty(code)) {
      code = null;
    }
    if (StringUtils.isEmpty(fromDate)) {
      fromDate = null;
    }
    if (StringUtils.isEmpty(toDate)) {
      toDate = null;
    }
    if (StringUtils.isEmpty(phone)) {
      phone = null;
    }
    Page<UserEntity> userEntities = userRepository.findByCondition(code, fromDate, toDate, phone,
        pageable);
    List<UserDTO> userDTO = new ArrayList<>();
    userDTO = userEntities.map(entity -> userMapper.toDto(entity)).stream().toList();
    BaseResponse<List<UserDTO>> response = new BaseResponse<>();
    response.setCode(HttpStatus.OK.value());
    response.setMessage("success");
    response.setData(userDTO);
    response.setPageIndex(pageable.getPageNumber());
    response.setPageSize(pageable.getPageSize());
    response.setTotalPage(userEntities.getTotalPages());
    response.setTotalElement(userEntities.getTotalElements());
    return response;


  }

  @Override
  public Response<UserDTO> getDetailUser(Long id) {
    UserEntity userEntity = userRepository.findById(id).orElse(null);
//        Kieu neu ko ton tai id nay thi se tra ra null
    if (userEntity == null) {
      Response<UserDTO> response = new Response<>(HttpStatus.BAD_REQUEST.value(), "user not found",
          null);
      return response;

    }
    UserDTO userDTO = userMapper.toDto(userEntity);
//    String fileBase64 = fileService.getBase64FromPath(userEntity.getPathAvatar());
//    userDTO.setStringBase64Avatar(fileBase64);
    Response<UserDTO> response = new Response<>(HttpStatus.OK.value(), HttpStatus.OK.name(),
        userDTO);

    return response;
  }

  @Override
  public Response<UserDTO> getCurrentUser() {
    // Get user login
    UserDetails userDetails = SessionUtils.getUserPrinciple();
    System.out.println("current user login: " + userDetails.getUsername());
    UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());
    UserDTO userDTO = userMapper.toDto(userEntity);
    Response<UserDTO> userDTOResponse = new Response<>(HttpStatus.OK.value(),"Susscess",userDTO);
    return userDTOResponse;
  }


  private void setRole(UserEntity userEntity) {
    RoleEntity roleEntity = roleRepository.findByCodeAndDeletedIsFalse(Constant.ROLE_ADMIN_CODE);
    Set<RoleEntity> roleEntities = new HashSet<>();
    roleEntities.add(roleEntity);
    userEntity.setRoles(roleEntities);
  }

  //    1.	convert dữ liệu filed stringBase64Avatar từ StringBase64 trong userDto về lại file image
  public String saveImageAvatar(UserDTO userDTO) {

    if (StringUtils.isEmpty(userDTO.getStringBase64Avatar())) {
      return "";
    }
    String[] partsBase64 = userDTO.getStringBase64Avatar().split(",");
    // get mime type image
    String mimeType = partsBase64[0];
    // lấy phần dữ liệu image base64
    String dataImage = partsBase64[1];
    byte[] decodedByte = Base64.getDecoder().decode(dataImage);
    // xác định đuôi của file
    String fileExtension = "";
    if (mimeType.contains("image/jpeg")) {
      fileExtension = ".jpg";
    } else if (mimeType.contains("image/png")) {
      fileExtension = ".png";
    }

    //      2.	lưu file image vào folder của ổ cứng local tại path D:\T3h\LJava2411\github\LJava2411\LJava2411\spring-boot\file-upload\image
    // lưu file image vào folder ổ cứng
//        String rootFolderImage = "D:\\T3h\\LJava2411\\github\\LJava2411\\LJava2411\\spring-boot\\file-upload\\image\\";
    String rootFolderImage = rootFolderUpload + rootFolderImageUpload;
    String fileName = "avatar_" + userDTO.getUsername() + fileExtension;
    String finalPathAvatar = rootFolderImage + fileName;

    // Kiểm tra xem có thư mục đó chưa
    File rootFolderData = new File(rootFolderImage);
    if (!rootFolderData.exists()) { // nếu chưa có -> tạo folder
      rootFolderData.mkdir();
    }

    // lưu file
    try (FileOutputStream fos = new FileOutputStream(new File(finalPathAvatar))) {
      fos.write(decodedByte);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      System.out.println("Save file success " + finalPathAvatar);
    }
    return finalPathAvatar;
  }
}
