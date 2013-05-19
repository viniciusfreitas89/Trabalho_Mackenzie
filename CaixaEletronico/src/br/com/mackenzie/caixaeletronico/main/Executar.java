/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.controller.ContasController;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.util.Util;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 71306552
 */
public class Executar {
    
    
    public static void funcoesMenuInicar(String opcao){
        if (Util.isInteger(opcao)){
            if (opcao.equals("0")){
                System.exit(0);
            }else if (opcao.equals("2")){
                realizarDeposito('1');
            }else if (opcao.equals("3")){
                realizarDeposito('2');
            }
        }
    }
    
    public static void funcoesMenuTransacoes(String opcao, Conta conta){
       if (Util.isInteger(opcao)){
           if (opcao.equals("0")){
               System.exit(0);
           }else if (opcao.equals("1")){
               realizarSaque(conta);
           }else if (opcao.equals("2")){
               realizarTransferencia(conta);
           }else if (opcao.equals("3")){
               exibirExtrato(conta);
           }
       }
   }
    
   private static void realizarDeposito(char tipo) {
        ContasController controller = new ContasController();
        Scanner ler = new Scanner(System.in);
        
        String str = "";
        
        System.out.print(" -> Digite o número da conta: ");
        str = ler.nextLine();
        
        if (Util.isLong(str)){
            long contaDestino = Long.parseLong(str);
            Conta conta = controller.validarConta(contaDestino);

            if (conta!=null){
                System.out.print(" -> Digite o valor: R$ ");
                str = ler.nextLine();
                str = str.replace(",", ".");
                
                if (Util.isFloat(str)){
                    float valor = Float.parseFloat(str);
                    
                    controller.depositarValor(conta, valor, tipo);
                    System.err.println("Depósito realizado com súcesso!\n\n");
                }
            }else{
                System.err.println("Este número de conta não existe!\n\n");
            }
        }else{
            System.err.println("Número da conta inválido!\n\n");
        }
   }
   
   private static void realizarSaque(Conta conta){
        ContasController controller = new ContasController();
        Scanner ler = new Scanner(System.in);
        
        String str = "";
        
        System.out.print(" -> Digite o valor: R$ ");
        str = ler.nextLine();
        str = str.replace(",", ".");

        if (Util.isFloat(str)){
            float valor = Float.parseFloat(str);
                    
            if (controller.sacarValor(conta, valor)){
                System.err.println("Saque realizado com súcesso!\n\n");
            }else{
                System.err.println("### Saque não realizado. Seu saldo esta negativo! ###");
            }
        }
   }
   
   private static void realizarTransferencia(Conta contaOrigem) {
        ContasController controller = new ContasController();
        Scanner ler = new Scanner(System.in);
        
        String str = "";
        
        System.out.print(" -> Digite o número da conta de destino: ");
        str = ler.nextLine();
        
        if (Util.isLong(str)){
            long numeroConta = Long.parseLong(str);
            Conta contaDestino = controller.validarConta(numeroConta);

            if (contaDestino!=null){
                System.out.print(" -> Digite o valor: R$ ");
                str = ler.nextLine();
                str = str.replace(",", ".");
                
                if (Util.isFloat(str)){
                    float valor = Float.parseFloat(str);
                    
                    if (controller.transferirValor(contaOrigem, valor, contaDestino)){
                        System.err.println("Transferência realizada com súcesso!\n\n");
                    }
                }
            }else{
                System.err.println("Este número de conta não existe!\n\n");
            }
        }else{
            System.err.println("Número da conta inválido!\n\n");
        }
   }
   
   private static void exibirExtrato(Conta conta){
       ContasController controller = new ContasController();
       Object extrato = controller.consultarExtrato(conta, null, null);
       if (extrato!=null && extrato instanceof String ){
        System.err.println(extrato.toString());
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Executar.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
   }
    
}
