/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.model.conta.Historico;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
 public class Extrato {
    protected Extrato(){}
    
    public String consultarExtrato(Conta conta, Date dtInicio, Date dtFim){
        String str ="";  
        str+= "### Extrato Bancário:\n\n";
        for (Historico historico : conta.getListaHistorico()){
            str+= historico+"\n";
        }
        
        str+= "\n\n### Saldo: R$"+conta.getSaldo();
        
        return str;
    }
}
