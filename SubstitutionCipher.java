import java.util.Scanner;
public class SubstitutionCipher {
    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public static String encrypt(String plainText){
        plainText=plainText.toUpperCase();
        StringBuilder cipherText=new StringBuilder();
        for(int i=0;i<plainText.length();i++){
            char c=plainText.charAt(i);
            if(Character.isLetter(c)){
                int index=ALPHABET.indexOf(c);
                char encryptedChar=KEY.charAt(index);
                cipherText.append(encryptedChar);
            }else{
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }
    public static String decrypt(String cipherText){
        cipherText=cipherText.toUpperCase();
        StringBuilder plainText=new StringBuilder();
        for(int i=0;i<cipherText.length();i++){
            char c=cipherText.charAt(i);
            if(Character.isLetter(c)){
                int index=KEY.indexOf(c);
                char decryptedChar=ALPHABET.charAt(index);
                plainText.append(decryptedChar);
            }else{
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("---Substitution_Cipher---");
        System.out.println("ALPHABET:"+ALPHABET);
        System.out.println("Key:"+KEY);
        System.out.print("\nEnter the text: ");
        String plain=sc.nextLine();
        String encrypted=encrypt(plain);
        System.out.println("Encrypted Text:"+encrypted);
        String decypted=decrypt(encrypted);
        System.out.println("Decrpted Text:"+decypted);
        sc.close();




      }

}
