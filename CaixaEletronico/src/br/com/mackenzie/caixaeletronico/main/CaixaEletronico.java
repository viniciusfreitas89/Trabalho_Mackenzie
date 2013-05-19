/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.controller.ContasController;
import br.com.mackenzie.caixaeletronico.model.conta.Cartao;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.util.Util;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
    private Conta contaAutenticada;
    
    public static void main(String[] args) throws IOException {
        CaixaEletronico cx = new CaixaEletronico();
        cx.exibirMenuInicial();
    }
    
    public void exibirMenuTransacoesAutenticadas(){
	Scanner ler = new Scanner(System.in);
	String opcao = "";
        do{
            limparConsole();
            
            System.out.println("##################################################\n");
            System.out.println("1 - Sacar Valor");
            System.out.println("2 - Transferência entre contas");
            System.out.println("3 - Extrato na tela");
            System.out.println("");
            System.out.println("0 - Finalizar Sistema");
            System.out.println("M - Menu Inicial");
            System.out.println("");
            System.out.print(" -> Informe a opção desejada: ");
            opcao = ler.nextLine();
            System.out.println("");
            System.out.println("##################################################\n");
            
            Executar.funcoesMenuTransacoes(opcao, contaAutenticada);
        }while (!opcao.equalsIgnoreCase("M"));
    }
    
    public void exibirMenuInicial(){
	Scanner ler = new Scanner(System.in);
	String opcao = "";
        do{
            limparConsole();
            
            System.out.println("##################################################\n");
            System.out.println("1 - Inserir Cartão");
            System.out.println("2 - Deposito em Cheque");
            System.out.println("3 - Deposito em Dinheiro");
            System.out.println("");
            System.out.println("0 - Finalizar Sistema");
            System.out.println("");
            System.out.print(" -> Informe a opção desejada: ");
            opcao = ler.nextLine();
            System.out.println("");
            System.out.println("##################################################\n");
           
            if (opcao.equals("1")){
                exibirMenuComCartoesValidos();
            }else{
                Executar.funcoesMenuInicar(opcao);
            }
        }while (!opcao.equals("0"));
    }
    
    public void exibirMenuComCartoesValidos(){
//        List<Cartao> cartoes = BaseDados.getCartoes();
        
        ContasController controller = new ContasController();
        Scanner ler = new Scanner(System.in);
	String opcao = "";
        do{
            System.out.println("##################################################\n");
            System.out.println("Selecione o cartão desejado: ");
            
            System.out.println("");
            System.out.println("0 - Finalizar Sistema");
            System.out.println("M - Menu Anterior");
            System.out.println("");
            
            System.out.println("");
            System.out.println("##################################################\n");
            
                try{
                    Cartao cartao = digitarCartao();
                    
                    if (cartao != null){
                        if (cartao.isRetido()){
                            System.err.println("####### Este cartão esta retido! #######");
                        }else{
                            System.out.println("Senha Padrão: 123456");
                            System.out.print(" -> Digite a senha: ");
                            
                            String senha = ler.nextLine();
                            cartao.setSenha(senha);
                            
                            System.out.println("");
                            int tentativas = 0;
                            
                            while (tentativas < 2 && controller.validarSenha(cartao).getStatus() != 0){
                                tentativas++;
                                System.out.print(" -> Digite a senha novamente: ");
                                
                                senha = ler.nextLine();
                                cartao.setSenha(senha);
                                
                                System.out.println("");
                            }
                            
                            if (controller.validarSenha(cartao).getStatus() == 0 && tentativas == 2){
                                cartao.setRetido(true);
                                System.err.println("####### Cartão Retido! #######");
                            }else{
                                contaAutenticada = cartao.getConta();
                                exibirMenuTransacoesAutenticadas();
                            }
                        }
                        break;
                    }
                    
                    opcao = "M";
                }catch (Exception e){
                    System.err.println("Cartão inválido!");
                    e.printStackTrace();
                }
        }while (!opcao.equalsIgnoreCase("M"));
    }
    
    private Cartao digitarCartao(){
        Scanner ler = new Scanner(System.in);
        
        ContasController controller = new ContasController();
        Cartao cartao = null;
        String numeroCartao = "";
        
        do{
            System.out.print(" -> Digite o número do cartão: ");
            
            numeroCartao = ler.nextLine();
            
            if (numeroCartao.equals("0")){
                System.exit(0);
            }else if (numeroCartao.equalsIgnoreCase("M")){
                break;
            }
            
            if (Util.isLong(numeroCartao)){
                cartao = controller.validarCartao(Long.parseLong(numeroCartao));
                if (cartao!=null){
                    break;
                }else{
                    System.err.println("Número do cartão inválido!");
                }
            }else{
                System.err.println("Digite apenas números");
            }
        }while(true);
        
        return new Cartao(cartao.getNumeroCartao());
    }
    
    private void limparConsole(){
//        for (int i = 0; i < 55; ++i)    
//                System.out.println();
    }
}
