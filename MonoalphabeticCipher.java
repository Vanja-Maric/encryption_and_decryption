import java.util.HashMap;
import java.util.Map;

/**
 * The MonoalphabeticCipher class represents a monoalphabetic cipher algorithm
 * for encrypting and decrypting text.
 * It uses a key mapping to substitute characters in the text.
 */
public class MonoalphabeticCipher {
  /**
   * Encrypts the given sentence using a monoalphabetic cipher with the specified
   * key.
   *
   * @param sentence the sentence to encrypt
   * @param key      the key mapping used for substitution
   * @return the encrypted ciphertext
   */
  public String encrypt(String sentence, Map<Character, Character> key) {
    StringBuilder result = new StringBuilder();
    for (char character : sentence.toCharArray()) {
      if (Character.isLetter(character)) {
        char mappedChar = Character.isUpperCase(character)
            ? Character.toUpperCase(key.get(Character.toLowerCase(character)))
            : key.get(character);
        result.append(mappedChar);
      } else {
        result.append(character);
      }
    }
    return result.toString();
  }

  /**
   * Decrypts the given ciphertext using a monoalphabetic cipher with the
   * specified key.
   *
   * @param ciphertext the ciphertext to decrypt
   * @param key        the key mapping used for substitution
   * @return the decrypted plaintext
   */
  public String decrypt(String sentence, Map<Character, Character> key) {
    Map<Character, Character> reverseKey = new HashMap<>();
    for (Map.Entry<Character, Character> entry : key.entrySet()) {
      reverseKey.put(entry.getValue(), entry.getKey());
    }

    StringBuilder result = new StringBuilder();
    for (char character : sentence.toCharArray()) {
      if (Character.isLetter(character)) {
        char mappedChar = Character.isUpperCase(character)
            ? Character.toUpperCase(reverseKey.get(Character.toLowerCase(character)))
            : reverseKey.get(character);
        result.append(mappedChar);
      } else {
        result.append(character);
      }
    }
    return result.toString();
  }

  /**
   * Generates a random key mapping for the monoalphabetic cipher.
   *
   * @return the generated key mapping
   */
  public Map<Character, Character> generateKey() {
    Map<Character, Character> key = new HashMap<>();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] alphabetToShuffle = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    for (int i = 0; i < alphabetToShuffle.length; i++) {
      int randomIndex = (int) (Math.random() * alphabetToShuffle.length);
      char temp = alphabetToShuffle[i];
      alphabetToShuffle[i] = alphabetToShuffle[randomIndex];
      alphabetToShuffle[randomIndex] = temp;
    }
    for (int i = 0; i < alphabet.length; i++) {
      key.put(alphabet[i], alphabetToShuffle[i]);
    }
    return key;
  }
}
