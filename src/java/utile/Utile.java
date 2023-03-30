/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utile;

import jakarta.servlet.http.HttpServletRequest;

public class Utile {
    public String getUrl(HttpServletRequest req) throws Exception{
        if(req.getPathInfo() == null){
            return "/";
        }
        return req.getPathInfo();
    }
}
