package vn.edu.t3h.bookstore.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {
    //   Ở trang này mình phải tạo ra 1 hàm mã hóa và 1 hàm giải thuật
    public static final String ALGORITHM = "AES";//AGLOEITHM la Giai thuat
    public static SecretKey secretKey; // KHAI BÁO BIẾN KHOÓA BÍ MẬT
static{
    String secretKeyString = "mySuperSecretKey1234567890123456";
    byte[] secretKeyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);
    secretKey = new SecretKeySpec(secretKeyBytes, ALGORITHM);

}
// Tạo ra 1 hàm để mã hóa
    public static String encryptPassword(String password){
        try{
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //Cipher chịu trách nhiệm cho việc thực hiện các thuật toán mã hóa và giải mã.
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[ ] encryptBytes = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptBytes);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
                BadPaddingException e){
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
}
