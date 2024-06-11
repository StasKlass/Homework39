package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
        String filePath = "input.txt";

        Map<Character, Integer> characterCountMap = new HashMap<>();

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            int character;
            while ((character = fileInputStream.read()) != -1) {
                char ch = (char) character;
                characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                System.out.println("Символ: '" + entry.getKey() + "' Количество: " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
        }
    }
}
