import java.math.BigInteger;

public class Person {
    private DiffieHelman dh = new DiffieHelman();
    private RSA rsa = new RSA();
    private ElGamal elGamal = new ElGamal();
    private String name;
    private final BigInteger RSAprivateKey;
    private final BigInteger RSApublicKey;
    private final BigInteger ElGamalSecretKey;
    private final BigInteger ElGamalSharedKey;
    private final BigInteger diffieHelmanSharedKey;
    private final BigInteger diffieHelmanSecretKey;
    private String symmetricKey;
    private SymmetricEncryption aes = SymmetricEncryption.AES;

    Person(String name2) {
        name = name2;
        RSAprivateKey = rsa.getPrivateKey();
        RSApublicKey = rsa.getPublicKey();
        ElGamalSecretKey = elGamal.newPrivateKey();
        ElGamalSharedKey = elGamal.createSharedKey(ElGamalSecretKey);
        diffieHelmanSecretKey = BigIntegerOperations.randomPrimeBigInteger();
        diffieHelmanSharedKey = dh.calculateDHSharedKey(diffieHelmanSecretKey);
    }

    void setSymmetricKey(String key){
        symmetricKey = key;
    }
    public void printInfo(){
        System.out.println(name + " :");
        System.out.println("RSA Private Key : ");
        System.out.println(RSAprivateKey);
        System.out.println("RSA Public Key :");
        System.out.println(RSApublicKey);
        System.out.println("El Gamal Secret Key:");
        System.out.println(ElGamalSecretKey);
        System.out.println("El Gamal Shared Key :");
        System.out.println(ElGamalSharedKey);
        System.out.println("El Gamal Change Key :");
        System.out.println(calculateElGamalKey());
        System.out.println("Diffie Helmann Secret Key :");
        System.out.println(diffieHelmanSecretKey);
        System.out.println("Diffie Helmann Shared Key :");
        System.out.println(diffieHelmanSharedKey);
    }

    private BigInteger calculateElGamalKey(){
        return elGamal.getChangedKey(ElGamalSecretKey,ElGamalSharedKey);
    }
    BigInteger encryptRSA(BigInteger plainText){
        return rsa.encrypt(plainText);
    }

    BigInteger decryptRSA(BigInteger cyperText){
        return rsa.decrypt(cyperText);
    }
    public BigInteger DecElGamalKey(){
        return elGamal.getChangedKey(ElGamalSecretKey,ElGamalSharedKey);
    }
    String encryptAES(String message) {
        return aes.encrypt(message,symmetricKey);
    }
    String decryptAES(String encText){
        return aes.decrypt(encText,symmetricKey);
    }
    BigInteger getDiffieHelmanSharedKey(){
        return diffieHelmanSharedKey;
    }
    BigInteger getCommonSecretKey(BigInteger opponentSharedKey){
        return dh.calculateDHSecretKey(opponentSharedKey,diffieHelmanSecretKey);
    }

    String getName() {
        return name;
    }

    public BigInteger getRSAprivateKey() {
        return RSAprivateKey;
    }

    BigInteger getRSApublicKey() {
        return RSApublicKey;
    }

    public BigInteger getElGamalSecretKey() {
        return ElGamalSecretKey;
    }

    public BigInteger getElGamalSharedKey() {
        return ElGamalSharedKey;
    }

    public BigInteger getDiffieHelmanSecretKey() {
        return diffieHelmanSecretKey;
    }

    public String getSymmetricKey() {
        return symmetricKey;
    }

}
