package Lesson8;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        // №1

        String text = "What a nice summer day!";
        char chr = 'a';

        int end = findSymbolOccurance(text,chr);
        System.out.println("Задание №1: ");
        System.out.println("Символ '" + chr + "' встречается в тексте " + end + " раз(а)");


        // №2

        System.out.println("Задание №2: ");
        System.out.println(findWordPosition("Hello, Java World", "World"));


        // №3
        System.out.println("Задание №3: ");

        stringReverse("developer");


        // №4
        System.out.println(isPalindrome("ERE"));





    }



    //  Задание №1


    public static int findSymbolOccurance(String word, char symbol) {

        int count = 0;

        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }



    //Задание №2


    public static int findWordPosition(String source, String target) {

        return source.indexOf(target);
    }



    // Задание #3


    public static void stringReverse(String text){
        StringBuilder texts = new StringBuilder(text);
        texts.reverse();
        System.out.println(texts.toString());
    }



    // Звдача №4


    public static boolean isPalindrome(String text) {

        text = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder build = new StringBuilder(text);
        return build.reverse().toString().equals(text);



    }

}
