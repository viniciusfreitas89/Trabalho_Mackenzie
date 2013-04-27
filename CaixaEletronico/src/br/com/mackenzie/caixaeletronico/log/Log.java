/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.log;

import br.com.mackenzie.caixaeletronico.model.conta.Conta;
import br.com.mackenzie.caixaeletronico.util.ConstantsUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius
 */
public class Log {
    
    private static File getFileLog(Conta conta){
        File pastaLog = new File(ConstantsUtil.LOG_PASTA_ARQUIVO);
        pastaLog.mkdir();
        File logFile = new File(pastaLog, conta.getNumero()+".log");
            
        return logFile;
    }
    
    private static boolean gravarArquivo(Conta conta, String txt){
        File fileLog = getFileLog(conta);
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(fileLog, true);
            bw = new BufferedWriter(fw);
            bw.write(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss - ").format(new Date())+ txt);
            bw.newLine();
            bw.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    
    public static boolean limparLog(Conta conta){
        File fileLog = getFileLog(conta);
        if (fileLog.exists()){
            fileLog.delete();
        }
        
        return true;
    }
    
    public static void exibirLog(Conta conta){
        File fileLog = getFileLog(conta);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileLog);
            br = new BufferedReader(fr);
            
            String linha;
            
            System.out.println("################### LOG - INÍCIO ###################");
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
            System.out.println("################### LOG - FIM ###################");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean gravarTransacao(Conta conta, String txt){
        return gravarArquivo(conta, txt);
    }
    
}
