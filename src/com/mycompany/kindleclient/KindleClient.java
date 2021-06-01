package com.mycompany.kindleclient;

import java.io.IOException;
import java.text.ParseException;
import kindleclient.ConfigSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
public class KindleClient {
    public static void main(String[] args) throws IOException{
        ConfigSocket soc = new ConfigSocket();
        String reponse = soc.getSocket("getdocuments");
        System.out.println("reponse " + reponse);
        String title = "titreLivre";
        String consult = soc.getSocket("consultdoc,"+title);
        System.out.println("reponse " + consult);
        
        String bye = soc.getSocket("bye");
    }
    
}
