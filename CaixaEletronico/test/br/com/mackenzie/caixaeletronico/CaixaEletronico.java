package br.com.mackenzie.caixaeletronico;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.mackenzie.caixaeletronico.controller.ContasController;
import br.com.mackenzie.caixaeletronico.model.conta.Cartao;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.util.BaseDados;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
    
    private Cartao cartaoValido;
    private ContasController controller;
    
    public CaixaEletronico() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cartaoValido = BaseDados.getCartoes().get(0);
        controller = new ContasController();
        
        Cartao cartaoTeste = new Cartao(cartaoValido.getConta());
        cartaoTeste.setSenha("12222333");
        int i = 0;
        while (i < ContasController.LIMITE_TENTATIVAS_SENHA){
            controller.validarSenha(cartaoTeste);
            i++;
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void todos() {
        Cartao cartaoTeste = new Cartao(cartaoValido.getConta());
        
        assertEquals("Teste: Validar cartão e senha (3x).", 3, controller.validarSenha(cartaoTeste).getStatus());
        assertEquals("Teste: Cartão inválido.", null, controller.validarCartao(5889966));
    }
    
    @Test
    public void uc01(){
        Conta contaTeste = cartaoValido.getConta();
        assertEquals("Teste: Sacar valor acima do limite de conta.", false, controller.sacarValor(contaTeste, 1559988));
    }
    
    @Test
    public void uc02(){
        assertEquals("Teste: Validar conta de destino.", null, controller.validarConta(1255666));
    }
    
    @Test
    public void uc04(){
        assertEquals("Teste: Transferir valor acima do limite de conta.", false, controller.transferirValor(cartaoValido.getConta(), 1255666, BaseDados.getContas().get(1)));
    }
    
    @Test
    public void uc08(){
        assertEquals("Teste: Inserir datas inválidas.", 2, controller.consultarExtrato(cartaoValido.getConta(), "99/99/9999", "01/01/2013").getStatus());
        assertEquals("Teste: Inserir datas inválidas.", 2, controller.consultarExtrato(cartaoValido.getConta(), "31/02/2013", "01/01/2013").getStatus());
        assertEquals("Teste: Período inicial superior ao período final.", 1, controller.consultarExtrato(cartaoValido.getConta(), "20/02/2013", "01/01/2013").getStatus());
    }
}