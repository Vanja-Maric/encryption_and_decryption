public class CaesarCipher {

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

  public String decrypt(String text, int shift) {
    return encrypt(text, 26 - shift);
  }
}
