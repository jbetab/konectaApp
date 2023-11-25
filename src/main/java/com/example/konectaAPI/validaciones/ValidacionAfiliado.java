package com.example.konectaAPI.validaciones;


import com.example.konectaAPI.Utilidades.Utilidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionAfiliado {
    Utilidad utilidad=new Utilidad();

    public ValidacionAfiliado() {
    }
    public Boolean validarId(Integer id) throws Exception{
        if(id < 0){
            throw new Exception("");
        }String expresionRegular="^[1-9][0-9]*$";
        if(!this.utilidad.buscarCoincidencia(expresionRegular, String.valueOf(id))){
            throw new Exception("revise el formato ingresado");
        }
        return true;
    }
    public Boolean validarNombres(String nombre) throws Exception {
        //longitud sea menos a 3 y mayor a 40
        if (nombre.length() < 3 || nombre.length() > 40) {
            throw new Exception("el nombre debe tener entre 3 y 40 caracteres");

        }
        //el formato del nombre tiene numeros o caracteres especiales
        String expresionRegular = "^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular, nombre)) {
            throw new Exception("el nombre no cumple los parametros");


            // busco la coincidencia entre la expresion regular y mi string

        /*Pattern patron=Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(nombre);
        if(coincidencia.matches()){
            System.out.println("Tenemos coincidencia");
            return true;

        }else{
            System.out.println("no tenemos coincidencia");
            return false;
        }
    //return true;*/
        }
        return true;
    }

    public Boolean validarApeliidos(String apellidos)throws Exception{
        if(apellidos.length()<10 || apellidos.length()>50){
            throw new Exception("los empleados no cumplen " + "con el minimo o maximo de caracteres");
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (! this.utilidad.buscarCoincidencia(expresionRegular, apellidos)){
            throw new Exception("el apellido no cumple los parametros");




        /*Pattern patron=Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(apellidos);
        if(coincidencia.matches()){
            System.out.println("Tenemos coincidencia");
            return true;

        }else{
            System.out.println("no tenemos coincidencia");
            return false;*/
        }
        return true;



    }
    public Boolean validarDocumento(String documento) throws Exception{
        if(documento.length()<7 || documento.length()>10){
            throw new Exception("documento con longitud invalida");

        }

        String expresionRegular="^[0-9]+$";
        if(!this.utilidad.buscarCoincidencia(expresionRegular,documento)){
            throw new Exception("revise el formato ingresado");


        }
        return true;

    }
   /*public  Boolean ValidarFechaNacimiento(){

   }*/

    public Boolean ValidarCiudad(Integer ciudad) throws  Exception{
        if (ciudad.longValue()>0 || ciudad.longValue()<1123){
            throw new Exception("ciudad con longitud invalida");

        }
        String expresionRegular="^[0-9]+$";
        if(!this.utilidad.buscarCoincidencia(expresionRegular, String.valueOf(ciudad))){

            throw new Exception("ciudad con longitud invalida");
        }
        return true;
    }
    public Boolean validarDepartamento(Integer departamento) throws Exception{
        if (departamento.longValue()>0 || departamento.longValue()<32){
            throw new Exception("departamento con longitud invalida");
        }
        String espresionRegular="^[0-9]+$";
        if (!this.utilidad.buscarCoincidencia(espresionRegular, String.valueOf(departamento))){
            throw new Exception("Revise el formato ingresado");
        }
        return true;
    }
    public Boolean validarCorreoElectronico(String correoElectronico) throws Exception{
        if(correoElectronico.length()<50){
            throw new Exception("no cumplen " + "con el minimo o maximo de caracteres");
        }

        String espresionRegular="^[A-Za-z0-9+_.-]+@(.+)$";
        if(!this.utilidad.buscarCoincidencia(espresionRegular,correoElectronico)){
            throw new Exception("por favor, revise el formato");
        }

        return true;
    }

    public Boolean validarTelefono(String telefono) throws Exception{
        //int telefono=Integer.parseInt(telefono);
        if(telefono.length()<10){
            throw new Exception("Documento con longitud invalida");
        }
        String expresionRegular="^[0-9]+$";
        Pattern pattern= Pattern.compile((telefono));
        Matcher matcher= pattern.matcher(telefono);

        return matcher.matches();
    }
}
