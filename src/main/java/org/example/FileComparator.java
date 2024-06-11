package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileComparator {
    public static void main(String[] args) {
        String filePath1 = "file1.txt";
        String filePath2 = "file2.txt";

        FileInputStream fis1 = null;
        FileInputStream fis2 = null;

        try {
            fis1 = new FileInputStream(filePath1);
            fis2 = new FileInputStream(filePath2);

            int char1, char2;
            int position = 0;

            while (true) {
                char1 = fis1.read();
                char2 = fis2.read();

                if (char1 == -1 && char2 == -1) {
                    System.out.println("Файлы идентичны.");
                    break;
                }

                if (char1 != char2) {
                    System.out.println("Файлы различаются на позиции " + position + ".");
                    break;
                }

                position++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (fis1 != null) fis1.close();
                if (fis2 != null) fis2.close();
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии файла: " + e.getMessage());
            }
        }
    }
}
