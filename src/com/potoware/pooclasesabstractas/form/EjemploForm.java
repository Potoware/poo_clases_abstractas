package com.potoware.pooclasesabstractas.form;

import com.potoware.pooclasesabstractas.form.elementos.*;
import com.potoware.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        lenguaje.addOpcion(java)
        .addOpcion(new Opcion("2","Javascript"))
        .addOpcion(new Opcion("3","Jquery"))
        .addOpcion(new Opcion("4","PHP"))
        .addOpcion(new Opcion("5","PowerQuery").setSelected(true));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value='"+this.valor+"'>";
            }
        };
        saludar.setValor("Hola estoy saludando :v");
        username.setValor("apotosimo");
        password.setValor("a12345");
        email.setValor("apotosimo@potoware.com");
        edad.setValor("23");
        experiencia.setValor("...mas de 10 años de experiencia");

        List<ElementoForm> elementos = Arrays.asList(username, password, edad, email, experiencia, lenguaje,saludar);

        for(ElementoForm e:elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

    }
}
