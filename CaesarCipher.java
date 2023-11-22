/**
 * The CaesarCipher class represents a Caesar cipher algorithm for encrypting
 * and decrypting text.
 * It uses a specified key to shift the characters in the text.
 */
public class CaesarCipher {

  /**
   * Encrypts the given plaintext using a Caesar cipher with the specified key.
   *
   * @param plaintext the plaintext to encrypt
   * @param key       the key to use for shifting the characters
   * @return the encrypted ciphertext
   */
  public String encrypt(String text, int key) {
    StringBuilder result = new StringBuilder();
    for (char character : text.toCharArray()) {
      if (Character.isLetter(character)) {
        char base = Character.isLowerCase(character) ? 'a' : 'A';
        int offset = (character - base + key) % 26;
        result.append((char) (base + offset));
      } else {
        result.append(character);
      }
    }
    return result.toString();
  }

  /**
   * Decrypts the given ciphertext using a Caesar cipher with the specified key.
   *
   * @param ciphertext the ciphertext to decrypt
   * @param key        the key to use for shifting the characters
   * @return the decrypted plaintext
   */
  public String decrypt(String text, int shift) {
    return encrypt(text, 26 - shift);
  }
}
