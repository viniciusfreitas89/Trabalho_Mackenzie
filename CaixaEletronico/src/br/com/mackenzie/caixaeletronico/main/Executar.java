/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.util.Util;


/**
 *
 * @author 71306552
 */
public class Executar {
    public static void funcoesMenuInicar(String opcao){
        if (Util.isInteger(opcao)){
            if (opcao.equals("0")){
                System.exit(0);
            }
        }
    }
    
    public static void funcoesMenuTransacoes(String opcao){
       if (Util.isInteger(opcao)){
           if (opcao.equals("0")){
               System.exit(0);
           }
       }
   }
    
    
}
