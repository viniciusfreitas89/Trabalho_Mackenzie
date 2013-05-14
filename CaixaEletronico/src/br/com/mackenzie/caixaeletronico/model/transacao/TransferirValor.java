/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

import br.com.mackenzie.caixaeletronico.log.Log;
import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.model.conta.Historico;
import br.com.mackenzie.caixaeletronico.util.ConstantsUtil;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
public class TransferirValor extends TransacaoFactory{
    protected TransferirValor(){}
    
    public boolean transferir(Conta origem, Conta destino, float valor){
        TransacaoFactory.criarSacarValor().sacar(destino, valor, false);
        TransacaoFactory.criarDepositarValor().depositar(destino, valor, false);
        
        origem.getListaHistorico().add(new Historico("Transferência Enviada para a conta: "+destino, new Date(), valor));
        destino.getListaHistorico().add(new Historico("Transferência Recebida da conta: "+origem, new Date(), valor));
        
        Log.gravarTransacao(origem, ConstantsUtil.LOG_MENSAGEM_ENVIAR_TRANSFERENCIA+valor);
        Log.gravarTransacao(destino, ConstantsUtil.LOG_MENSAGEM_RECEBER_TRANSFERENCIA+valor);
        
        return true;
    }
}
