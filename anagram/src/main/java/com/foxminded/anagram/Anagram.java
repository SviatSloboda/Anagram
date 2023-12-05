package com.foxminded.anagram;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(getAnagram("abcd efgh"));
    }

    static String reverseLetters(String value) {
        if(value == null) throw new IllegalArgumentException("Null is not allowed!");

        char[] valueCharArray = value.toCharArray();

        int leftPivot = 0;
        int rightPivot = valueCharArray.length - 1;

        while (leftPivot < rightPivot) {
            if (!Character.isAlphabetic(valueCharArray[leftPivot])) {
                leftPivot++;
            } else if (!Character.isAlphabetic(valueCharArray[rightPivot])) {
                rightPivot--;
            } else {
                char temp = valueCharArray[leftPivot];
                valueCharArray[leftPivot] = valueCharArray[rightPivot];
                valueCharArray[rightPivot] = temp;
                leftPivot++;
                rightPivot--;
            }
        }

        return new String(valueCharArray);
    }

    public static String getAnagram(String value) {
        if(value == null) throw new IllegalArgumentException("Null is not allowed!");

        StringBuilder result = new StringBuilder();
        String[] words = value.split("(?<=\\s)|(?=\\s)");

        for (String word : words) {
            result.append(reverseLetters(word));
        }

        return result.toString();
    }
}