package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Hello world!
 *
 */
public class App {

    public static final int HH = 0;
    public static void main(String[] args) {

    }


    private static void en(final List<Map<String,String>> mm, final String[] hea,final String[] date){
        Map<String,String> row = new HashMap<>(hea.length);
        for (int i = 0; i < hea.length; i++) {
            row.put(hea[i],date[i] );
            
        }
        mm.add(row);
    }

}