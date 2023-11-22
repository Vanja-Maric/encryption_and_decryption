import java.util.Map;

public class Main {
  public static void main(String[] args) {
    CaesarCipher cipherCaesar = new CaesarCipher();
    System.out.println("Caesar Cipher");
    String encryptedCaesar = cipherCaesar.encrypt("Original text: Hello, World!", 3);
    System.out.println("Encrypted by Caesar: " + encryptedCaesar);
    System.out.println("Decrypted by Caesar: " + cipherCaesar.decrypt("encrypted", 3));
    System.out.println();

    System.out.println("Monalfabethic Cipher");
    MonoalphabeticCipher monoalphabeticCipher = new MonoalphabeticCipher();
    Map<Character, Character> key = monoalphabeticCipher.generateKey();
    String enc = monoalphabeticCipher.encrypt("Original text: Hello, World again!", key);
    String dec = monoalphabeticCipher.decrypt(enc, key);
    System.out.println("Encrypted monalfabethic: " + enc);
    System.out.println("Decrypted monalfabethic: " + dec);
    System.out.println();

    System.out.println("Transposition Cipher");
    String plaintext = "Hello, World again and again!";
    int keyT = 3;
    TranspositionCipher cipherT = new TranspositionCipher();
    String encryptedText = cipherT.encrypt(plaintext, keyT);
    String decryptedText = cipherT.decrypt(encryptedText, keyT);

    System.out.println("Original text: " + plaintext);
    System.out.println("Encrypted text transposition: " + encryptedText);
    System.out.println("Decrypted text transposition: " + decryptedText);
  }
}