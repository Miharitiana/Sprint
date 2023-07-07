package myservlet;

 sprint4
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import mapping.Mapping;
import utile.Utile;
public class MyFrontServlet extends HttpServlet{
    HashMap<String,Mapping> MappingUrls;
    

    public void init() throws ServletException {
        ServletContext context = getServletContext();
        String chemin_de_l_application = context.getRealPath("/");
        File file= new File(chemin_de_l_application+"WEB-INF\\classes\\");
        Utile function = new Utile();
        try{
            MappingUrls= function.tout_fichier(chemin_de_l_application+"WEB-INF\\classes\\" , file , new HashMap<String,Mapping>());
        }catch(Exception e){
            System.out.println(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String url=request.getPathInfo();  
            try {
                out.println("resultat : "+MappingUrls.get(url).getClassName());
                out.println("url : "+url);
            }catch (Exception e){
                out.println("ce cle n'existe pas , veillez verifie");
            }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            processRequest(request, response);
        } catch (Exception e) {
            out.println(e);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            processRequest(request, response);
        } catch (Exception e) {
            out.println(e);
        }
    }

}

import utile.Utile;
import etu1892.framework.Mapping;
import etu1892.framework.Traitement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls;

    public void init() throws ServletException{
        try {
            MappingUrls = Traitement.getAnnotedUrls(Traitement.getClasses("modele"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Utile utile = new Utile();
            try {
                String url = utile.getUrl(request);
                out.println(utile.getUrl(request));
                Mapping mapping = MappingUrls.get(url);
                out.println(mapping.getMethod() + " " + mapping.getClass());
            } catch (Exception e) {
            }            
        }
    }
}

