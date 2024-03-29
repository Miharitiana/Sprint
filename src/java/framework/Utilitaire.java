/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1826.frameworki;

import annotation.Myannotation;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ITU
 */
public class Utilitaire {
    
    @Myannotation(value="decomposition")
    public String[] decomposer(String url){
        String[] tableau=url.split("/");
        return tableau;
    }

    public String getAnnotation(String url){
        String[] tableau=decomposer(url);
        int indice=tableau.length-1;
        if(indice>=0)
            return tableau[indice];
        return null;
    }

    /*
        si l'urlQuery est null on ne peut pas le spliter 
    */
    //prendre l'argument d'un fonction
    public String[] getArgument(String urlQuery){
        if(urlQuery!=null){
            String[]argument=urlQuery.split("\\&"); 
            return argument;
        }
        return null;
    }
}
