package collection.task;

import collection.task.text.FormatedText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Start {


    public static void main(String[] args) {

        String[] str = readFile();
        FormatedText text = new FormatedText();
        text.addWordInText(str);
        System.out.println("----------\nОтсортированный текс + статистика:");
        System.out.println(text);
        System.out.println("----------\nБольшее количество повторений:");
        System.out.println(text.getMaxCountInTextWord());
        System.out.println("----------\nКоличество слов в тексте:");
        System.out.println(text.getCountWordInText());

    }

    public static String[] readFile(){
        StringBuilder stringBuffer = new StringBuilder();
        System.out.println("Файл: ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/example.txt"));
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i<line.length();i++){
                    if (Character.isAlphabetic(line.charAt(i))||((line.charAt(i)==' ')&&((line.charAt(i+1)!=' '))))
                        stringBuffer.append(line.charAt(i));
                }
                stringBuffer.append(" ");
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла...");
        }
        String str = new String(stringBuffer);
        return str.split(" ");
    }

}
