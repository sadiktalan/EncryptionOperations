import java.math.BigInteger;


public class DiffieHelman {

    private enum SharedKey{
        BIG_INTEGER;
        public BigInteger getKeyP() {
            return BigIntegerOperations.randomPrimeBigInteger();
        }
        public BigInteger getKeyG() {
            return BigIntegerOperations.randomPrimeBigInteger();
        }
    }

    private static SharedKey sharedKey = SharedKey.BIG_INTEGER;

    private static BigInteger p = sharedKey.getKeyP();
    private static BigInteger g = sharedKey.getKeyG();

    public BigInteger calculateDHSharedKey(BigInteger value) {
        return BigIntegerOperations.modPow(value,p,g);
    }
    public BigInteger calculateDHSecretKey(BigInteger sharedKey,BigInteger privateKey) {
        return BigIntegerOperations.modPow(sharedKey,privateKey,g);
    }

}
