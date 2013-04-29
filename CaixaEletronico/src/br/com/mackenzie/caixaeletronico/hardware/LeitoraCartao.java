/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.hardware;
import br.com.mackenzie.caixaeletronico.model.conta.*;
import java.util.ArrayList;
/**
 *
 * @author Antonio
 */
public class LeitoraCartao {
    
    public static void lerCartao(Cartao c, ArrayList<Conta> minhasContas){
        int numAtual = c.getNumeroCartao();
        for(int i=0; i < minhasContas.size(); i++){
            int numCartao = minhasContas.get(i).getCartao().getNumeroCartao(); 
            if(numAtual == numCartao ){
               System.out.println("cartão válido("+ numAtual +")");
               break;
            }else{
                if(i == minhasContas.size()){
                System.out.println("cartão inválido("+ numAtual +")");
                }
            }
            
       }
        
    }   

}
