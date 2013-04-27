/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.log.Log;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.model.transacao.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
    public static void main(String[] args) {
        try {
            Conta conta = new Conta("123456");
            conta.setSaldo(100);
            
            Log.limparLog(conta);
            
            TransacaoFactory.criarDepositarValor().depositar(conta, 100);
            TransacaoFactory.criarSacarValor().sacar(conta, 100);
            TransacaoFactory.criarSacarValor().sacar(conta, 800);
            
            Log.exibirLog(conta);
        } catch (Exception ex) {
            Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
