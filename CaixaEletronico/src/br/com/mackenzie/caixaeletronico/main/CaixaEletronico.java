/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.log.Log;
import br.com.mackenzie.caixaeletronico.model.conta.*;
import br.com.mackenzie.caixaeletronico.model.transacao.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.mackenzie.caixaeletronico.hardware.*;
import br.com.mackenzie.caixaeletronico.util.BaseDados;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
    public static void main(String[] args) {
        try {
            Cliente cli = new Cliente();
            cli.setNome("Maria");
            cli.setDocumento("123456");
            Conta con = new Conta(123456, null);
            Cartao c = new Cartao(con, "123456");
        } catch (Exception ex) {
            Logger.getLogger(CaixaEletronico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //AL - ler teclado ----
	Scanner ler = new Scanner(System.in);
	int teclado;
	System.out.printf("Informe o número do cartão:\n");
	teclado = ler.nextInt();
        
        try {
            Cartao c = new Cartao(12345);
            c.setSenha("adc");
            Cartao c2 = new Cartao(22222);
            c2.setSenha("xyz");
            
            Conta conta = new Conta(123456, new Cliente());
            conta.setCartao(c);
            conta.setSaldo(100);
            Conta conta2 = new Conta(654321, new Cliente());
            conta2.setCartao(c2);           
                       
         
           Cartao cartao = new Cartao(teclado);
           
           //LeitoraCartao l = new LeitoraCartao();
          
          LeitoraCartao.lerCartao(cartao);
           
        //-----
            
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
