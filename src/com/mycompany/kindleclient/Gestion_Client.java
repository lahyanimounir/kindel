/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kindleclient;

import com.mycompany.kindleclient.config.ConfigSocket;
import java.io.IOException;

/**
 *
 * @author user
 */
public class Gestion_Client {
    public String login(String username,String password ) throws IOException{
        ConfigSocket soc = new ConfigSocket();
        String login = username+","+password;
        String res = soc.getSocket("login,"+login);
        System.out.println("reponse " + res);
        return res;
    }
}
