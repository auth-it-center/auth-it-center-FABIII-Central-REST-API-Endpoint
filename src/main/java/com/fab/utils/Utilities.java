package com.fab.utils;

import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static Map<Character, String> GREEK_TO_GREEKLISH = populateGreeklish();

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

    public static String transliterate(String input){

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(GREEK_TO_GREEKLISH.getOrDefault(c, c+""));
        }
        return sb.toString();
    }
     
}