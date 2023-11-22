import java.util.Map;

public class Main {
  public static void main(String[] args) {
    CaesarCipher cipher = new CaesarCipher();
    String encrypted = cipher.encrypt("Hello, World!", 3);
    System.out.println("Encrypted: " + encrypted);
    System.out.println("Decrypted: " + cipher.decrypt("encrypted", 3));
    MonoalphabeticCipher monoalphabeticCipher = new MonoalphabeticCipher();
    Map<Character, Character> key = monoalphabeticCipher.generateKey();
    String enc = monoalphabeticCipher.encrypt("Hello, World again!", key);
    String dec = monoalphabeticCipher.decrypt(enc, key);
    System.out.println("Encrypted: " + enc);
    System.out.println("Decrypted: " + dec);
  }
}