/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.model.transacao.SacarValor;
import br.com.mackenzie.caixaeletronico.model.transacao.TransacaoFactory;

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
        objSacar.sacar();
    }
}
