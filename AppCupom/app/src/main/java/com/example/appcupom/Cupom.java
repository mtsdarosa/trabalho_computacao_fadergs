package com.example.appcupom;

import java.util.Date;

public class Cupom {
    private int id;
    private String codigoCupom;
    private String dataValidade;
    private float valorDesconto;

    public Cupom(){}

    public Cupom(String codigoCupom, String dataValidade, float valorDesconto){
        setCodigoCupom(codigoCupom);
        setDataValidade(dataValidade);
        setValorDesconto(valorDesconto);
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public String toString() {
        return id + " - " + codigoCupom + " | " + dataValidade + " | " + valorDesconto;
    }
}
