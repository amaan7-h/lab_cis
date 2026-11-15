import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    public static void main(String []args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("enter 16 char key:");
        String Key=sc.nextLine();
        System.out.print("enter text:");
        String plain=sc.nextLine();

        SecretKeySpec secKey=new SecretKeySpec(Key.getBytes(),"AES");
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secKey);
        String encrypted=Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes()));
    
        cipher.init(Cipher.DECRYPT_MODE,secKey);
        byte[]decoded=Base64.getDecoder().decode(encrypted);
        String decrypted=new String(cipher.doFinal(decoded));
        System.out.println("\nEncrypted:"+encrypted);
        System.out.println("\nDecrypted:"+decrypted);
        sc.close();


    }
    
}
