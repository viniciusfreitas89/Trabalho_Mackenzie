/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

import br.com.mackenzie.caixaeletronico.log.Log;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.model.conta.Historico;
import br.com.mackenzie.caixaeletronico.util.ConstantsUtil;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
 public class DepositarValor {
    protected DepositarValor(){}
    
    public boolean depositar(Conta conta, float valor){
        conta.setSaldo(conta.getSaldo()+valor);
        
        conta.getListaHistorico().add(new Historico("Depósito", new Date(), valor));
        Log.gravarTransacao(conta, ConstantsUtil.LOG_MENSAGEM_DEPOSITO+valor);
        
        return true;
    }
}
