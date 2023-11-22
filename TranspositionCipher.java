/**
 * The TranspositionCipher class represents a transposition cipher algorithm for
 * encrypting and decrypting text.
 * It uses a specified number of columns to rearrange the characters in the
 * text.
 */
public class TranspositionCipher {
  /**
   * Encrypts the given plaintext using a transposition cipher with the specified
   * number of columns.
   *
   * @param plaintext the plaintext to encrypt
   * @param columns   the number of columns to use in the transposition cipher
   * @return the encrypted ciphertext
   */
  public String encrypt(String plaintext, int columns) {
    int length = plaintext.length();
    int rows = (int) Math.ceil((double) length / columns);
    char[][] grid = new char[rows][columns];

    int index = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (index < length) {
          grid[i][j] = plaintext.charAt(index);
          index++;
        } else {
          grid[i][j] = ' '; // Padding with spaces if necessary
        }
      }
    }

    StringBuilder encryptedText = new StringBuilder();
    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows; i++) {
        encryptedText.append(grid[i][j]);
      }
    }

    return encryptedText.toString();
  }

  /**
   * Decrypts the given ciphertext using a transposition cipher with the specified
   * number of columns.
   *
   * @param ciphertext the ciphertext to decrypt
   * @param columns    the number of columns used in the transposition cipher
   * @return the decrypted plaintext
   */
  public String decrypt(String ciphertext, int columns) {
    int length = ciphertext.length();
    int rows = (int) Math.ceil((double) length / columns);
    char[][] grid = new char[rows][columns];

    int index = 0;
    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows; i++) {
        grid[i][j] = ciphertext.charAt(index);
        index++;
      }
    }

    StringBuilder decryptedText = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        decryptedText.append(grid[i][j]);
      }
    }

    return decryptedText.toString();
  }
}
