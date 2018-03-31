/**
 * Created by ribake on 08/03/2018.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int discard;

    // remove uncommon characters from both strings, adding 1 to result for each removed character

    // remove extraneous common characters from both strings, adding 1 to result for each removed character

    public static int numberNeeded(String first, String second) {

        String commonChars_first = removeUncommonCharactersFromLeft(first, second);
        String commonChars_second = removeUncommonCharactersFromLeft(second, commonChars_first);

        reduceToAnangram(commonChars_first, commonChars_second);

        return discard;
    }

    // remove characters in left string that are not in right string and returns the common substring
    private static String removeUncommonCharactersFromLeft(String a, String b){
        char[] a_chars = a.toCharArray();

        StringBuilder common = new StringBuilder();
        StringBuilder uncommon = new StringBuilder();

        for (int i=0; i<a_chars.length; i++){
            if (b.contains(String.valueOf(a_chars[i]))){
                common.append(a_chars[i]);
            } else {
                uncommon.append(a_chars[i]);
                discard++;
            }
        }
        return common.toString();
    }

    // Makes an anagram of a and b having the same characters, but not necessarily equal numbers
    // of corresponding characters.
    private static void reduceToAnangram(String a, String b){
        // create a hashmap of each character in string and its total count
        char[] charsa = a.toCharArray();
        HashMap<Character,Integer> charsCounta = new HashMap<Character, Integer>();

        for (int i=0; i<charsa.length; i++){
            char current = charsa[i];
            if(charsCounta.keySet().contains(current)){
                charsCounta.put(current, charsCounta.get(current)+ 1);
            } else {
                charsCounta.put(current, 1);
            }
        }

        char[] charsb = b.toCharArray();
        HashMap<Character,Integer> charsCountb = new HashMap<Character, Integer>();

        for (int i=0; i<charsb.length; i++){
            char current = charsb[i];
            if(charsCountb.keySet().contains(current)){
                charsCountb.put(current, charsCountb.get(current)+ 1);
            } else {
                charsCountb.put(current, 1);
            }
        }

        // compare the totals of each character in both maps
        for(Character c:charsCounta.keySet()){
            discard += Math.abs(charsCounta.get(c) - charsCountb.get(c));
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

/*
import java.util.Scanner;
A MORE ELEGANT SOLUTION
public class Solution {
    public static int numberNeeded(String first, String second) {
        // represents each small letter of the alphabet
        int[] lettercounts = new int[26];

        // get the total occurrence of each character in first string
        for(char c : first.toCharArray()){
            lettercounts[c-'a']++;
        }

        // subtract the total occurrence of each character in second string
        for(char c : second.toCharArray()){
            lettercounts[c-'a']--;
        }

        // the absolute difference of each character's occurrence is what we need
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
*/