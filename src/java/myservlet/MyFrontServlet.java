package myservlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.lang.reflect.*;
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
                out.println("resultat : "+MappingUrls.get(url).getMethod());
                out.println("url : "+url);
                Class A=Class.forName(MappingUrls.get(url).getClassName());
                Method method=A.getMethod(MappingUrls.get(url).getMethod());
                Object objet=  A.newInstance();
                out.println(method.invoke(objet));
                //  response.sendRedirect("index.jsp");
                // RequestDispatcher dispat = request.getRequestDispatcher("../index.jsp");
                // dispat.forward(request, response);

            }catch (Exception e){
                out.println("ce cle n'existe pas , veillez verifie");
                out.println(e);
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