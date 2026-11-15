import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class DESWithUserKey {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plainText = sc.nextLine();
        System.out.print("Enter the key(must be 8 chars e.g.12345678): ");
        String keyInput = sc.nextLine();

        DESKeySpec desKeySpec=new DESKeySpec(keyInput.getBytes());
        SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DES");
        SecretKey secretKey=secretKeyFactory.generateSecret(desKeySpec);

        Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] encryptedBytes=cipher.doFinal(plainText.getBytes());
        String encryptedText=Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted:"+encryptedText);

        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[]decryptedBytes=cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText=new String(decryptedBytes);
        System.out.println("Decrypted:"+decryptedText);

    }
    
}
