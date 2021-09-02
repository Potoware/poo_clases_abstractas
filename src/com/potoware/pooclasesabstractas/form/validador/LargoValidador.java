package com.potoware.pooclasesabstractas.form.validador;

public class LargoValidador extends Validador{

    protected String mensaje = "el campo debe tener un minimo %d caracteres y maximo %d caracteres";
    private int min=0;
    private int max= Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return this.mensaje;
    }

    @Override
    public boolean esValido(String valor) {
       this.mensaje = String.format(this.mensaje,this.max,this.max);

       if (valor == null){
           return true;
       }
        if(valor.length() <= min && valor.length() > max){
            return true;
        }
        else {
            return false;
        }
    }
}
