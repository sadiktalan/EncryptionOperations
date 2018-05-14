import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Person p = new Person("Alice");
    static Person p2 = new Person("Bob");
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please Select the operation :");
        System.out.println("1-Symmetric operation");
        System.out.println("2-Asymmetric operation");

        int number  = Integer.parseInt(s.nextLine());
        if(number == 1) {
            System.out.println(p.getName() +"'s Diffie Hellman Keys :");
            System.out.println("Diffie Hellman Secret Key :\n" + p.getDiffieHelmanSecretKey());
            System.out.println("Diffie Hellman Shared Key :\n" + p.getDiffieHelmanSharedKey());
            System.out.println("-----------");
            System.out.println(p2.getName() +"'s Diffie Hellman Keys :");
            System.out.println("Diffie Hellman Secret Key :\n" + p2.getDiffieHelmanSecretKey());
            System.out.println("Diffie Hellman Shared Key :\n" + p2.getDiffieHelmanSharedKey());
            System.out.println("-----------");
            System.out.println("They both get the following key : ");
            System.out.println(p.getCommonSecretKey(p2.getDiffieHelmanSharedKey()));
            System.out.println("-----------");
            afterDH();
        }
        if(number == 2){
            System.out.println("Choose the asymmetric operation");
            System.out.println("1-RSA");
            System.out.println("2-ElGamal");
            int no = Integer.parseInt(s.nextLine());
            if(no==1) {
                System.out.println("Encryption & Decryption");

                    System.out.println(p.getName()+"'s Public Key :");
                    System.out.println(p.getRSApublicKey());
                    System.out.println("Enter the BigInteger: ");
                    System.out.println(p.encryptRSA(new BigInteger(s.nextLine())));

                    System.out.println("Decrypting with "+ p.getName() +"'s private Key");
                    System.out.println("Enter the encrypted Big Integer :");
                    BigInteger bigInteger = s.nextBigInteger();
                    System.out.println("Decrypted result is :");
                    System.out.println(p.decryptRSA(bigInteger));

            }
            if(no == 2) {
                System.out.println("Encryption & Decryption");
                System.out.println("El Gamal methods added on ElGamal.java class. However it couldnt added as menu operation.");
            }
        }
    }

    private static void afterDH(){
        System.out.println("Encryption");
        System.out.println(p.getName() + " :");
        System.out.println("Enter the password :");
        String str = s.nextLine();
        p.setSymmetricKey(str);
        System.out.println("Enter the message :");
        String message = s.nextLine();
        System.out.println("Encrypted message is :");
        String enc = p.encryptAES(message);
        System.out.println(enc);

        System.out.println("Decryption");
        System.out.println(p2.getName() + " :");
        System.out.println("Enter the password :");
        str = s.nextLine();
        p.setSymmetricKey(str);
        System.out.println("Enter encrypted message :");
        str  = s.nextLine();
        System.out.println("Decrypted message is :");
        System.out.println(p.decryptAES(str));
    }

}
