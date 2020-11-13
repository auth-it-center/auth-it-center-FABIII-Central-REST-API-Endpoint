package com.fab.utils;

import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static Map<Character, String> GREEK_TO_GREEKLISH = populateGreeklish();

    public static Map<Character, String> LATVIAN_TO_ENGLISH = populateLatvianEnglish();

    private static Map<Character, String> populateGreeklish() {
        Map<Character, String> map = new HashMap<>(50);

        // Capital
        map.put('Α', "A");
        map.put('Β', "V");
        map.put('Γ', "G");
        map.put('Δ', "D");
        map.put('Ε', "E");
        map.put('Ζ', "Z");
        map.put('Η', "I");
        map.put('Θ', "Th");
        map.put('Ι', "I");
        map.put('Κ', "K");
        map.put('Λ', "L");
        map.put('Μ', "M");
        map.put('Ν', "N");
        map.put('Ξ', "X");
        map.put('Ο', "O");
        map.put('Π', "P");
        map.put('Ρ', "R");
        map.put('Σ', "S");
        map.put('Τ', "T");
        map.put('Υ', "Y");
        map.put('Φ', "F");
        map.put('Χ', "Ch");
        map.put('Ψ', "Ps");
        map.put('Ω', "O");
        // 
        map.put('Ά',"A");
        map.put('Έ',"E");
        map.put('Ή',"I");
        map.put('Ί',"I");
        map.put('Ό',"O");
        map.put('Ύ',"Y");
        map.put('Ώ',"O");
        //
        map.put('Ϊ',"Ι");
        map.put('Ϋ',"Υ");
        
        // Small
        map.put('α', "a");
        map.put('β', "v");
        map.put('γ', "g");
        map.put('δ', "d");
        map.put('ε', "e");
        map.put('ζ', "z");
        map.put('η', "i");
        map.put('θ', "th");
        map.put('ι', "i");
        map.put('κ', "k");
        map.put('λ', "l");
        map.put('μ', "m");
        map.put('ν', "n");
        map.put('ξ', "x");
        map.put('ο', "o");
        map.put('π', "p");
        map.put('ρ', "r");
        map.put('σ', "s");
        map.put('ς', "s");
        map.put('τ', "t");
        map.put('υ', "y");
        map.put('φ', "f");
        map.put('χ', "ch");
        map.put('ψ', "ps");
        map.put('ω', "o");
        //
        map.put('ά',"a");
        map.put('έ',"e");
        map.put('ή',"i");
        map.put('ί',"i");
        map.put('ό',"o");
        map.put('ύ',"y");
        map.put('ώ',"o");
        //
        map.put('ϊ',"i");
        map.put('ϋ',"y");
        map.put('ΐ',"i");
        map.put('ΰ',"y");
        return map;    
    }

    private static Map<Character, String> populateLatvianEnglish() {
        Map<Character, String> map = new HashMap<>(50);

        // Capital
        map.put('A', "A");
        map.put('Ā', "A");
        map.put('B', "B");
        map.put('C', "C");
        map.put('Č', "C");
        map.put('D', "D");
        map.put('E', "E");
        map.put('Ē', "E");
        map.put('F', "F");
        map.put('G', "G");
        map.put('Ģ', "G");
        map.put('H', "H");
        map.put('I', "I");
        map.put('Ī', "I");
        map.put('J', "J");
        map.put('K', "K");
        map.put('Ķ', "K");
        map.put('L', "L");
        map.put('Ļ', "L");
        map.put('M', "M");
        map.put('N', "N");
        map.put('Ņ', "N");
        map.put('O', "O");
        map.put('P', "P");
        map.put('R', "R");
        map.put('S', "S");
        map.put('Š', "S");
        map.put('T', "T");
        map.put('U', "U");
        map.put('Ū', "U");
        map.put('V', "V");
        map.put('Z', "Z");
        map.put('Ž', "Z");

        //Lower case
        map.put('a', "a");
        map.put('ā', "a");
        map.put('b', "b");
        map.put('c', "c");
        map.put('č', "c");
        map.put('d', "d");
        map.put('e', "e");
        map.put('ē', "e");
        map.put('f', "f");
        map.put('g', "g");
        map.put('ģ', "g");
        map.put('h', "h");
        map.put('i', "i");
        map.put('ī', "i");
        map.put('j', "j");
        map.put('k', "k");
        map.put('ķ', "k");
        map.put('l', "l");
        map.put('ļ', "l");
        map.put('m', "m");
        map.put('n', "n");
        map.put('ņ', "n");
        map.put('o', "o");
        map.put('p', "p");
        map.put('r', "r");
        map.put('s', "s");
        map.put('š', "s");
        map.put('t', "t");
        map.put('u', "u");
        map.put('ū', "u");
        map.put('v', "v");
        map.put('z', "z");
        map.put('ž', "z");

        return map;
    }

    public static String transliterate(String input, String lang){

        StringBuilder sb = new StringBuilder();

        if (lang.equals("el")) { // TODO use static variables
            for (char c : input.toCharArray()) {
                sb.append(GREEK_TO_GREEKLISH.getOrDefault(c, c + ""));
            }
        } else if (lang.equals("lv")) { // TODO use static variables
            for (char c : input.toCharArray()) {
                sb.append(LATVIAN_TO_ENGLISH.getOrDefault(c, c + ""));
            }
        }

        return sb.toString();
    }
     
}