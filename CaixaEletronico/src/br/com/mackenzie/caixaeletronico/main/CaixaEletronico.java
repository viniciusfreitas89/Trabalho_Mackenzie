/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.model.transacao.*;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
    public static void main(String[] args) {
        SacarValor objSacar = TransacaoFactory.criarSacarValor();
        objSacar.sacar();
    }
}
