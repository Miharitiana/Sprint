package spring;

import utile.Utile;
import mapping.Mapping;
import traitement.Traitement;
import java.util.HashMap;

public class Spring {

    public static void main(String[] args) throws ClassNotFoundException {
        HashMap<String,Mapping> MappingUrls = Traitement.getAnnotedUrls(Traitement.getClasses("modele"));
            try {
                Mapping mapping = MappingUrls.get("emp_all");
                System.out.println(mapping.getMethod() + " ito " + mapping.getClassName());
            } catch (Exception e) {           
            }     
    }   
}

