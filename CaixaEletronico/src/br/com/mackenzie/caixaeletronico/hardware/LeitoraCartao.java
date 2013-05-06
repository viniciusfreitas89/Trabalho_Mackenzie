/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.hardware;
import br.com.mackenzie.caixaeletronico.model.conta.*;
import br.com.mackenzie.caixaeletronico.util.BaseDados;
/**
 *
 * @author Antonio
 */
public class LeitoraCartao {
    
    public static int lerCartao(Cartao c){
        return BaseDados.cartaoExiste(c);
    }   

}
