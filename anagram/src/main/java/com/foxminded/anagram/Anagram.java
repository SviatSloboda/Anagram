package com.foxminded.anagram;

public class Anagram 
{
	
	public static void main(String[] args) {
		System.out.println(anagram("abcd efgh"));
	}
	
	public static String reverseOneString(String value) {
        char[] arr = value.toCharArray();

        int leftPivot = 0;
        int rightPivot = arr.length - 1;

        while (leftPivot < rightPivot) {
            if (!Character.isAlphabetic(arr[leftPivot])) {
                leftPivot++;
            } else if (!Character.isAlphabetic(arr[rightPivot])) {
                rightPivot--;
            } else {
                char temp = arr[leftPivot];
                arr[leftPivot] = arr[rightPivot];
                arr[rightPivot] = temp;
                leftPivot++;
                rightPivot--;
            }
        }
        return new String(arr);
    }
	
    public static String anagram(String value) {
        StringBuilder result = new StringBuilder();
        for(String i: value.split(" ")) {
            result.append(reverseOneString(i)).append(" ");
        }
        return result.toString().trim();
    }
}
