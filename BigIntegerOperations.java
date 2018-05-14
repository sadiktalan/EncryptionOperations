import java.math.BigInteger;
import java.security.SecureRandom;

class BigIntegerOperations {
    private static final int bitLength = 1024;

    static BigInteger randomPrimeBigInteger() {
        final  SecureRandom random = new SecureRandom();
        return BigInteger.probablePrime(bitLength/2, random);
    }
    static BigInteger modPow(BigInteger number1, BigInteger exponent, BigInteger modulus) {
        return number1.modPow(exponent,modulus);
    }


}
