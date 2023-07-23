public class CaesarCipher {
    // isEncrypt = true: зашифрование,
    // isEncrypt = false: расшифрование
    // key - числовой ключ сдвига
    public static String caesarCipher(String text, boolean isEncrypt, int key) {
        StringBuilder result = new StringBuilder();
        int n = text.length();
        key = key % 33; // Для обработки больших ключей

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);

            // Если символ - буква русского алфавита, выполняем шифрование/расшифрование
            if (Character.isLetter(ch) && isRussianLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'А' : 'а';
                ch = (char) (base + ((isEncrypt ? (ch - base + key) : (ch - base - key) + 33) % 33));
            }

            result.append(ch);
        }

        return result.toString();
    }

    // Проверка, является ли символ русской буквой
    private static boolean isRussianLetter(char ch) {
        return (ch >= 'А' && ch <= 'я') || ch == 'Ё' || ch == 'ё';
    }

    public static void main(String[] args) {
        String originalText = "Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифрования и числовым ключом";
        int key = 5;

        // Зашифрование
        String encryptedText = caesarCipher(originalText, true, key);
        System.out.println("Зашифрованный текст: " + encryptedText);

        // Расшифрование (используем тот же ключ, но с отрицательным знаком)
        String decryptedText = caesarCipher(encryptedText, false, key);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }
}

