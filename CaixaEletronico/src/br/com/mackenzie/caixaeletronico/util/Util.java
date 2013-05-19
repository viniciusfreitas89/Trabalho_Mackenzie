/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
public class Util {
    public static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean isLong(String str){
        try {
            Long.parseLong(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean isFloat(String str){
        try {
            Float.parseFloat(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static Date isAValidDate(String dateToValidate, String dateFromat){
        Date date = null;
        if(dateToValidate == null){
            return date;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(dateToValidate);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
}
