/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.model.transacao.*;
import br.com.mackenzie.caixaeletronico.model.transacao2.TransacaoEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SacarValor objSacar = TransacaoFactory.getSacarValorInstance();
        
        try {
            br.com.mackenzie.caixaeletronico.model.transacao2.TransacaoFactory t = 
                    new br.com.mackenzie.caixaeletronico.model.transacao2.TransacaoFactory();
            t.criarTransacao(TransacaoEnum.SAQUE);
        } catch (Exception ex) {
            Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
