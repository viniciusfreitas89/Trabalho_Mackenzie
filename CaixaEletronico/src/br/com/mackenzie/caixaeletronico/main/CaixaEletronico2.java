/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.model.transacao2.*;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TransacaoFactory t = new TransacaoFactory();
            SacarValor objSacar = (SacarValor) t.criarTransacao(TransacaoEnum.SAQUE);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
