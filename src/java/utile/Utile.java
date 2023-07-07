
 
package  utile
import annotation.Urls;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;
import java.lang.reflect.*;
import java.util.*;

import mapping.Mapping;
public class Utile{
    public String url(String url) throws Exception{    
        String supprime_le_baseurl=url.split("\\?")[0];
        return supprime_le_baseurl;
    }
    
    public HashMap<String , Mapping> tout_fichier( String emplacement_des_classes, File dir , HashMap<String, Mapping> resultat) throws Exception{
        File[] liste= dir.listFiles();
        for(int i=0 ; i< liste.length ; i++){
            if(liste[i].isDirectory()){
                resultat= tout_fichier(emplacement_des_classes,liste[i] , resultat);
            }else{
                if(liste[i].getName().contains(".class")){
                    String classe_avec_son_package=liste[i].toString().split("\\.")[0].replace(emplacement_des_classes , "").replace("\\" , ".");
                    Class A=Class.forName(classe_avec_son_package);
                    Class urls= Class.forName("etu1852.annotation.Urls");
                    Class urls= Class.forName("annotation.Urls");

                            System.out.println(classe_avec_son_package);
                    for(int j=0 ; j<emp.length ; j++){
                        Urls u= (Urls)emp[j].getAnnotation(urls);
                        if(emp[i].isAnnotationPresent(urls) ){
                            resultat.put(  u.value(), new Mapping( classe_avec_son_package, emp[j].getName()));
                        }
                    }
                }
            }
        }
        return resultat;
    } 

    
    public static void main(String[] args){
        try{
            List<Mapping> resultat= new ArrayList<Mapping>();
            HashMap<String,Mapping> a = new HashMap<String, Mapping>();
            String pkg="\\";
            File dir = new File(System.getProperty("user.dir")+"\\");
            // System.out.println(System.getProperty("user.dir")+"\\");
            // File dir = new File("E:\\apache_tomcat9\\webapps\\Sprint3\\WEB-INF\\classes\\");
            Utile fonction = new Utile();
            // System.out.println(fonction.tout_fichier1("E:\\apache_tomcat9\\webapps\\Sprint3\\WEB-INF\\classes\\",dir , resultat).get(0).getMethod()
            System.out.println(fonction.tout_fichier("E:\\apache_tomcat9\\webapps\\Sprint4\\framework\\WEB-INF\\classes\\",dir , a).get("emp-all"));

            System.out.println(fonction.tout_fichier("D:\\mirindra\\S4\\web_dynamique\\Sprint",dir , a).get("emp-all"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
 

   
}

   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

import jakarta.servlet.http.HttpServletRequest;

public class Utile {
    public String getUrl(HttpServletRequest req) throws Exception{
        if(req.getPathInfo() == null){
            return "/";
        }
        return req.getPathInfo();
    }
}

