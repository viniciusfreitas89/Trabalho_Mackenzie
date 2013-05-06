/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Vinicius
 */
public class Historico {
    private String descricao;
    private Date date;
    private Float valor;

    public Historico(String descricao, Date date, Float valor){
        this.descricao = descricao;
        this.date = date;
        this.valor = valor;
    }
    
    public String toString(){
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(ptBR);
        
        return  adicionarEspacos(this.descricao, 50)
                 + adicionarEspacos(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date), 30)
                 + (valor!=null ?  formatter.format(valor) : "");
    }
    
    public String adicionarEspacos(String str, int qtdeCaracteres){
        for (int i = str.length(); i < qtdeCaracteres; i++){
            str += " ";
        }
        return str;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
