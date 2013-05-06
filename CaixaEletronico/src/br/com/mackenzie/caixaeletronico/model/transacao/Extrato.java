/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.model.conta.Historico;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
 public class Extrato {
    protected Extrato(){}
    
    public void consultarExtrato(Conta conta, Date dtInicio, Date dtFim){
        System.out.println("### Extrato Bancário:");
        for (Historico historico : conta.getListaHistorico()){
            System.out.println(historico);
        }
    }
}
