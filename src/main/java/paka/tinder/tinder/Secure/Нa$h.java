package paka.tinder.tinder.Secure;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public class Нa$h {//If everything will blow UP, pick up your items, documents and run into a forest
//(or delete first russian letter in name)
    private static final SecureRandom Rand = new SecureRandom();
    private static final  int ITERATIONS = 1000-7;
    private static final  int KEY_LENGTH = 64*8;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    public static String genSalt(int length){
        byte[] salt =  new byte[length];
        Rand.nextBytes(salt);

        StringBuilder cursed_salt = new StringBuilder();
        for (byte b : salt) {
            cursed_salt.append((char) (b + 256));
        }
        return cursed_salt.toString();
    }
    public static String HaShIt(String password, String cursed_salt){
        char[] pass = password.toCharArray();
        byte[] salt = new byte[cursed_salt.length()];
        for (int i=0; i<cursed_salt.length();++i) {
            salt[i]=(byte)(cursed_salt.charAt(i)-256);
        }

        PBEKeySpec spec = new PBEKeySpec(pass, salt, ITERATIONS, KEY_LENGTH);

        Arrays.fill(pass,Character.MIN_VALUE);
        String retur;
        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            StringBuilder result = new StringBuilder();
            for (byte b : securePassword) {
                result.append((char) (b + 256));
            }
            retur = result.toString();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println(e);
            System.out.println(e.getStackTrace());
            retur = "";
        } finally {
            spec.clearPassword();
        }
        return retur;
    }
    public static boolean verifyPassword(String pass, String hash, String salt){
        String hashed_pass = HaShIt(pass,salt);

        return hashed_pass.equals(hash);
    }
}
