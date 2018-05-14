import java.math.BigInteger;

class RSA {
    private final static BigInteger one = BigInteger.ONE;

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    RSA() {
        BigInteger p = BigIntegerOperations.randomPrimeBigInteger();
        BigInteger q = BigIntegerOperations.randomPrimeBigInteger();
        modulus    = p.multiply(q);
        publicKey  = createPublicKey();
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        privateKey = publicKey.modInverse(phi);
    }

    BigInteger encrypt(BigInteger message) {
        return BigIntegerOperations.modPow(message,publicKey, modulus);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return BigIntegerOperations.modPow(encrypted,privateKey, modulus);
    }

    private BigInteger createPublicKey(){
        BigInteger bigInteger;
            bigInteger = BigIntegerOperations.randomPrimeBigInteger();
        return bigInteger;
    }

    BigInteger getPrivateKey() {
        return privateKey;
    }

    BigInteger getPublicKey() {
        return publicKey;
    }

}

