package dsa.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class atomsOfMolecules {
    public static void solution(){
        String s = "H2(SO4)2";
        HashMap<String, Integer> map = new LinkedHashMap<>();
        String lastKey = "";
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lastKey += String.valueOf(c);
            } else if (Character.isDigit(c)) {
                if (map.containsKey(lastKey)) map.put(lastKey, map.get(lastKey) + Character.getNumericValue(c));
                else map.put(lastKey, Character.getNumericValue(c));
                lastKey = "";
            } else {
                if (lastKey.length() > 0) {
                    if (map.containsKey(lastKey)) map.put(lastKey, map.get(lastKey) + 1);
                    else map.put(lastKey, 1);
                }
                lastKey = String.valueOf(c);
            }
        }

        if (lastKey.length() > 0) {
            if (map.containsKey(lastKey)) map.put(lastKey, map.get(lastKey) + 1);
            else map.put(lastKey, 1);
        }

        System.out.println(map);
    }
}
