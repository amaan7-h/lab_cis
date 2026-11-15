import java.util.*;
public class columnarTransposition {

    static int[]getkey(String keyKey){
       String k=keyKey.toUpperCase();
        int n=k.length();
        int[]key=new int[n];
        Integer[]idx=new Integer[n];
        for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(a,b)->k.charAt(a)!=k.charAt(b)?k.charAt(a)-k.charAt(b):a-b);
        for(int r=0;r<n;r++)key[idx[r]]=r+1;
        return key;

   
        }
        static String encrypt(String pt,int[]key){
            int c=key.length,r=(int)Math.ceil((double)pt.length()/c);
            char[][]g=new char[r][c];
            for(int i=0;i<r*c;i++)g[i/c][i%c]=i<pt.length()?pt.charAt(i):'_';
            StringBuilder sb=new StringBuilder();
            for(int k=1;k<=c;k++)
                for(int j=0;j<c;j++)if(key[j]==k)
                  for(int i=0;i<r;i++)
                   sb.append(g[i][j]);
                return sb.toString();
             }

         static String decrypt(String ct,int[]key){
                int c=key.length,r=ct.length()/c;
                char[][]g=new char[r][c];
                int p=0;
                for(int k=1;k<=c;k++)
                    for(int j=0;j<c;j++)if (key[j]==k)
                       for(int i=0;i<r;i++)g[i][j]=ct.charAt(p++);
            StringBuilder sb=new StringBuilder();
            for(char[]row:g)for(char ch:row)sb.append(ch);
            return sb.toString();
             }

             static String doubleEncrypt(String pt,int[]key){
             return  encrypt(encrypt(pt,key),key);
            }
             static String doubleDecrypt(String ct,int[]key){
                return decrypt(decrypt(ct,key),key);
             }
             public static void main(String []args){
                Scanner sc=new Scanner(System.in);
                System.out.print(" plain text:");
                String msg=sc.nextLine().replace(" ","");
                System.out.print("key");
                String sKey=sc.next();
                int[] Key =getkey(sKey);
                System.out.println("\nNumeric Key:"+Arrays.toString(Key));

                String singleEnc=encrypt(msg,Key);
                System.out.println("\n---Single Transposition--");
                System.out.println("Encrypted:"+singleEnc);
                System.out.println("Decrypted:"+decrypt(singleEnc,Key));

                String doubleEnc=doubleEncrypt(msg,Key);
                System.out.println("\n---Double Transposition--");
                System.out.println("Encrypted:"+doubleEnc);
                System.out.println("Decrypted:"+doubleDecrypt(singleEnc,Key));

        }
}