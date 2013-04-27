/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

import br.com.mackenzie.caixaeletronico.log.Log;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.util.ConstantsUtil;

/**
 *
 * @author Vinicius
 */
public class SacarValor {
    protected SacarValor(){}
    
    public boolean sacar(Conta conta, float valor){
        conta.setSaldo(conta.getSaldo()-valor);
        
        if (conta.getSaldo()<0){
            System.err.println("### Seu saldo esta negativo! ###");
        }
        
        Log.gravarTransacao(conta, ConstantsUtil.LOG_MENSAGEM_SAQUE+valor);
        
        return true;
    }
}
