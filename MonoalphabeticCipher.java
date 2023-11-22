import java.util.HashMap;
import java.util.Map;

public class MonoalphabeticCipher {

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
