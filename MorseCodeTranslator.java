import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeTranslator {
    private static final char[] textChars = {
        'A', 'B', 'C', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ', '.', ',', '?', '!', ':', ';', '-', '/', '(', ')', '"', '@', '='
    };

    private static final String[] morseCodes = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "/", ".-.-.-", "--..--", "..--..", "-.-.--", "---...", "-.-.-.", "-....-", "-..-.", "-.--.", "-.--.-", ".-..-.", ".--.-.", "-...-"
    };

    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            for (int i = 0; i < textChars.length; i++) {
                if (textChars[i] == c) {
                    morse.append(morseCodes[i]).append(" ");
                    break;
                }
            }
        }
        return morse.toString().trim();
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] morseArray = morse.split(" ");
        for (String morseChar : morseArray) {
            for (int i = 0; i < morseCodes.length; i++) {
                if (morseCodes[i].equals(morseChar)) {
                    text.append(textChars[i]);
                    break;
                }
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueTranslating = true;

        while (continueTranslating) {
        	System.out.println("MORSE CODE TRANSLATOR");
        	System.out.println("Developed By Keshav Subash");
            System.out.println("Enter '1' to convert text to Morse code, '2' to convert Morse code to text, or '3' to read from a file:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("Enter the text to convert to Morse code:");
                String text = scanner.nextLine();
                System.out.println("Morse Code: " + textToMorse(text));
            } else if (choice == 2) {
                System.out.println("Enter the Morse code to convert to text (use space to separate Morse characters):");
                String morse = scanner.nextLine();
                System.out.println("Text: " + morseToText(morse));
            } else if (choice == 3) {
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try (Scanner fileScanner = new Scanner(new File(filePath))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Original: " + line);
                        System.out.println("Morse Code: " + textToMorse(line));
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + filePath);
                }
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println("Do you want to translate more? (y/n)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                continueTranslating = false;
            }
        }

    }
}
