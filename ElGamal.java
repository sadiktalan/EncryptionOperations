
import java.math.BigInteger;

class ElGamal {
    private static final BigInteger prime = BigIntegerOperations.randomPrimeBigInteger();
    private static final BigInteger generator = new BigInteger("2");

    BigInteger createSharedKey(BigInteger privateKey){
            return BigIntegerOperations.modPow(generator,privateKey,prime);
    }

    BigInteger getChangedKey(BigInteger privateKey, BigInteger sharedKey){
        return BigIntegerOperations.modPow(sharedKey,privateKey,prime);
    }

    BigInteger newPrivateKey(){
        return BigIntegerOperations.randomPrimeBigInteger();
    }

    public static BigInteger getPrime() {
        return prime;
    }

    public static BigInteger getGenerator() {
        return generator;
    }
}
