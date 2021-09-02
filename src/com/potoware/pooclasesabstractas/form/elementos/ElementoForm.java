package com.potoware.pooclasesabstractas.form.elementos;

import com.potoware.pooclasesabstractas.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    public ElementoForm(List<Validador> validadores) {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    private List<Validador>validadores;
    private List<String>errores;

    public ElementoForm() {
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    public List<String> getErrores() {
        return errores;
    }

    public boolean esValido(){
        for(Validador v: validadores){
            if(!v.esValido(valor)){
                this.errores.add(v.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();

}
