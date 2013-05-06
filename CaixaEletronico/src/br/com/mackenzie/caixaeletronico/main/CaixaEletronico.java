/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.main;

import br.com.mackenzie.caixaeletronico.hardware.LeitoraCartao;
import br.com.mackenzie.caixaeletronico.model.conta.Cartao;
import br.com.mackenzie.caixaeletronico.util.BaseDados;
import br.com.mackenzie.caixaeletronico.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class CaixaEletronico {
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
            System.out.println("2 - Deposito em Cheque");
            System.out.println("3 - Deposito em Dinheiro");
            System.out.println("4 - Transferência entre contas");
            System.out.println("5 - Extrato na tela");
            System.out.println("");
            System.out.println("0 - Finalizar Sistema");
            System.out.println("M - Menu Anterior");
            System.out.println("");
            System.out.print(" -> Informe a opção desejada: ");
            opcao = ler.nextLine();
            System.out.println("");
            System.out.println("##################################################\n");
            
            Executar.funcoesMenuTransacoes(opcao);
        }while (!opcao.equalsIgnoreCase("M"));
    }
    
    public void exibirMenuInicial(){
	Scanner ler = new Scanner(System.in);
	String opcao = "";
        do{
            limparConsole();
            
            System.out.println("##################################################\n");
            System.out.println("1 - Inserir Cartão");
            System.out.println("2 - Transferência entre contas");
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
        List<Cartao> cartoes = BaseDados.getCartoes();
        Scanner ler = new Scanner(System.in);
	String opcao = "";
        do{
            System.out.println("##################################################\n");
            System.out.println("Selecione o cartão desejado: ");
            int i = 0;
            for (Cartao card : cartoes){
                System.out.println((++i)+" - Cartão: "+card);
            }
            System.out.println("");
            System.out.println("0 - Finalizar Sistema");
            System.out.println("M - Menu Anterior");
            System.out.println("");
            System.out.print(" -> Informe a opção desejada: ");
            opcao = ler.nextLine();
            System.out.println("");
            System.out.println("##################################################\n");
            if (Util.isInteger(opcao) && !opcao.equals("0")){
                try{
                    int index = LeitoraCartao.lerCartao(cartoes.get(Integer.parseInt(opcao)-1));
                    if (index > -1){
                        Cartao cartao = BaseDados.getCartoes().get(index);
                        if (cartao.isRetido()){
                            System.err.println("####### Este cartão esta retido! #######");
                        }else{
                            
                            System.out.println("Senha Padrão: 123456");
                            System.out.print(" -> Digite a senha: ");
                            String senha = ler.nextLine();
                            System.out.println("");
                            int tentativas = 0;
                            while (tentativas < 2 && !BaseDados.cartaoSenhaConfere(cartao, senha)){
                                tentativas++;
                                System.out.print(" -> Digite a senha novamente: ");
                                senha = ler.nextLine();
                                System.out.println("");
                            }
                            if (!BaseDados.cartaoSenhaConfere(cartao, senha) && tentativas == 2){
                                cartao.setRetido(true);
                                System.err.println("####### Cartão Retido! #######");
                            }else{
                                exibirMenuTransacoesAutenticadas();
                            }
                        }
                        break;
                    }
                    
                }catch (Exception e){
                    System.out.println("Cartão inválido!");
                }
            }
            
        }while (!opcao.equalsIgnoreCase("M"));
    }
    
    private void limparConsole(){
//        for (int i = 0; i < 55; ++i)    
//                System.out.println();
    }
}
