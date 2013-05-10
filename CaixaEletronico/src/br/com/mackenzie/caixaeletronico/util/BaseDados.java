/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.util;

import br.com.mackenzie.caixaeletronico.model.conta.Cartao;
import br.com.mackenzie.caixaeletronico.model.conta.Cliente;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class BaseDados {
    private static List<Cliente> clientes;
    private static List<Conta> contas;
    private static List<Cartao> cartoes;
    
    static{
        clientes = new ArrayList<Cliente>();
        contas = new ArrayList<Conta>();
        cartoes = new ArrayList<Cartao>();
        
        criarContas();
    }
    
    private static void criarContas() {
        try {
            Cartao card;
            Conta conta;
            Cliente c;
            
            c = new Cliente();
            c.setNome("Joaquim");
            c.setDocumento("123456");
            clientes.add(c);
            conta = new Conta(123456, c);
            card = new Cartao(conta, "123456");
            cartoes.add(card);
            conta.setCartao(card);
            contas.add(conta);
            
            c = new Cliente();
            c.setNome("Maria");
            c.setDocumento("789123");
            clientes.add(c);
            conta = new Conta(789123, c);
            card = new Cartao(conta, "123456");
            cartoes.add(card);
            conta.setCartao(card);
            contas.add(conta);
            
            c = new Cliente();
            c.setNome("João");
            c.setDocumento("55s88ddd");
            clientes.add(c);
            conta = new Conta(445589, c);
            card = new Cartao(conta, "123456");
            cartoes.add(card);
            conta.setCartao(card);
            contas.add(conta);
            
            c = new Cliente();
            c.setNome("Benedita");
            c.setDocumento("asacs5445");
            clientes.add(c);
            conta = new Conta(778551, c);
            card = new Cartao(conta, "123456");
            cartoes.add(card);
            conta.setCartao(card);
            contas.add(conta);
            
            c = new Cliente();
            c.setNome("Joana");
            c.setDocumento("18asa8sa8");
            clientes.add(c);
            conta = new Conta(4852668, c);
            card = new Cartao(conta, "123456");
            cartoes.add(card);
            conta.setCartao(card);
            contas.add(conta);
            
        } catch (Exception ex) {
            Logger.getLogger(BaseDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * Retorna -1 caso não exista,
     * Se existir retorna a posição do elemento na lista
     */
    public static int cartaoExiste(Cartao cartao){
        return cartoes.indexOf(cartao);
    }
    
    public static boolean cartaoSenhaConfere(Cartao c, String senha){
        int index = cartaoExiste(c);
        if (index > -1){
            if (c.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    /*
     * Retorna -1 caso não exista,
     * Se existir retorna a posição do elemento na lista
     */
    public static int contaExiste(Conta conta){
        return contas.indexOf(conta);
    }
    
    /*
     * Retorna -1 caso não exista,
     * Se existir retorna a posição do elemento na lista
     */
    public static int clienteExiste(Cliente cliente){
        return clientes.indexOf(cliente);
    }
    
    public static void listarCartoes(){
        for (Cartao elem : cartoes){
            System.out.println("Nº do Cartão: "+elem);
        }
    }
    
    public static void listarContas(){
        for (Conta elem : contas){
            System.out.println("Nº da Conta: "+elem);
        }
    }
    
    public static void listarClientes(){
        for (Cliente elem : clientes){
            System.out.println("Cliente: "+elem);
        }
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static List<Conta> getContas() {
        return contas;
    }

    public static List<Cartao> getCartoes() {
        return cartoes;
    }    
}
