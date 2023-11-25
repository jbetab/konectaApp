package com.example.konectaAPI.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidad {
    public boolean buscarCoincidencia(String expresionRegular, String cadenaTexto){
        Pattern patron=Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(cadenaTexto);
        if(coincidencia.matches()){
            System.out.println("Tenemos coincidencia");
            return true;

        }else{
            System.out.println("no tenemos coincidencia");
            return false;
        }

    }
}
