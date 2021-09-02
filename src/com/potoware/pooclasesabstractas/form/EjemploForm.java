package com.potoware.pooclasesabstractas.form;

import com.potoware.pooclasesabstractas.form.elementos.*;
import com.potoware.pooclasesabstractas.form.elementos.select.Opcion;
import com.potoware.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm{

    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email","email");
        email.addValidador(new EmailValidador()).addValidador(new NoNulo());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());
        TextAreaForm experiencia = new TextAreaForm("exp",5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNulo());
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
        password.setValor("1234578");
        email.setValor("apotosimopotoware.com");
        edad.setValor("l");
        experiencia.setValor("...mas de 10 años de experiencia");

        List<ElementoForm> elementos = Arrays.asList(username, password, edad, email, experiencia, lenguaje,saludar);

        for(ElementoForm e:elementos) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
            elementos.forEach(f ->{
                if (!f.esValido()) {
                    f.getErrores().forEach(System.out::println);
                }
                });


    }
}
