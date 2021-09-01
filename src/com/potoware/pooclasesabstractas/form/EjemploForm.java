package com.potoware.pooclasesabstractas.form;

import com.potoware.pooclasesabstractas.form.elementos.ElementoForm;
import com.potoware.pooclasesabstractas.form.elementos.InputForm;
import com.potoware.pooclasesabstractas.form.elementos.SelectForm;
import com.potoware.pooclasesabstractas.form.elementos.TextAreaForm;
import com.potoware.pooclasesabstractas.form.elementos.select.Opcion;

public class EjemploForm{

    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email","email");
        InputForm edad = new InputForm("edad", "number");

        TextAreaForm experiencia = new TextAreaForm("exp",5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion();
        java = new Opcion("1","Java");
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2","Javascript"));
        lenguaje.addOpcion(new Opcion("3","Jquery"));
        lenguaje.addOpcion(new Opcion("4","PHP"));
        lenguaje.addOpcion(new Opcion("5","PowerQuery"));

        username.setValor("apotosimo");
        password.setValor("a12345");
        email.setValor("apotosimo@potoware.com");
        edad.setValor("23");
        java.setSelected(true);


    }
}
