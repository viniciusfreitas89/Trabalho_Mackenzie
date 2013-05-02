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
    
    public static void lerCartao(Cartao c){
        int index = BaseDados.cartaoExiste(c);
        
        if (index > -1){
            System.out.println("cartão válido("+ c.getNumeroCartao() +")");
        }else{
            System.out.println("cartão inválido("+ c.getNumeroCartao() +")");
        }
    }   

}
