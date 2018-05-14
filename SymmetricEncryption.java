
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

enum SymmetricEncryption {
        AES;
    private static SecretKeySpec adjustKey(String myKey){
        try {
            MessageDigest sha;
            SecretKeySpec secretKey;
            byte[] key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            return secretKey;
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    String encrypt(String plainText, String pass)
    {
        SecretKeySpec secretKey = adjustKey(pass);
        if(!isNull(secretKey)){
            try{
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
            }catch (Exception e){
               return "adjusting key is failed!";
            }
        }
        return "failed to encrypt";
    }

    String decrypt(String cypherText, String pass) {
        SecretKeySpec secretKey = adjustKey(pass);
        if(!isNull(secretKey)) {
            try{
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return new String(cipher.doFinal(Base64.getDecoder().decode(cypherText)));
            }catch (Exception e){
                e.printStackTrace();
                return "failed to decrypt";
            }
        }
        return "failed to adjustKey";
    }
     private static  <E> boolean isNull(E value) {
        return value.equals(null);
    }
}
