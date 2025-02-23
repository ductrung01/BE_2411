package vn.edu.t3h.homeworkservlet1.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class PasswordUntils {
     private static final String ALGORITHM = "AES";
     private static SecretKey secretKey;
     static {
          String secretKeyString = "mySuperSecretKey1234567890123456";//Chuỗi đại diện cho mã bí mật
          byte[] secretKeyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);// tạo ra mang secretKeyBytes để lưu caái su chuyen doi cua  chuoi secretKeyString  sang dạng Byte dc mã hóa là utf_8
          secretKey = new SecretKeySpec(secretKeyBytes, ALGORITHM);// Biến secretKey khởi tạo ở trên sẽ lưu đối tựng mảng secretKeyBytes kia , va ALGORITHm kia la dai dien cho thuat toan minh su dung
     }
     public static String encryptPassword(String password) { // hàm mã hóa password
          try{
               Cipher cipher = Cipher.getInstance(ALGORITHM);// đối tượng chứa thuật toans mình suwr dung
               cipher.init(Cipher.ENCRYPT_MODE,secretKey);// thiet lap che do hoat dọng cho cipher ,ở đây là chee độ mã hóa
               byte[ ] encryptBytes = cipher.doFinal(password.getBytes()); // tạo ra mảng encryptBytes kieu Byte de chuyen doi  password người dung nhap sang daạng byte
               return Base64.getEncoder().encodeToString(encryptBytes); // dòng mã này là tra ve caái mang dc chưa du lieudda ma hoa sang dang base64
          } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {

               throw new RuntimeException(e);
          }
     }
     public static String decryptPassword(String password) {//hàm giải mã password
          try{
               Cipher cipher = Cipher.getInstance(ALGORITHM);
               cipher.init(Cipher.DECRYPT_MODE,secretKey);
               byte[ ] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(password));
               return new String (decryptBytes, StandardCharsets.UTF_8);
          } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {

               throw new RuntimeException(e);
          }
     }

     public static void main(String[] args) {
          System.out.println(encryptPassword("admin"));
          System.out.println(encryptPassword("user"));
     }
}
