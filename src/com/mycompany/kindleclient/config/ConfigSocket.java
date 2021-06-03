/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kindleclient.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author myself
 */
public class ConfigSocket {

    static String host = "127.0.0.1";
    static int port = 1000;
    private Socket soc;

    public String getSocket(String commande) throws IOException {
        System.out.println("Hello from client socket..." + commande);
        String message;
        this.soc = new Socket(host, port);
        
        // Write stream
        OutputStream output = soc.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(commande);

        InputStream input = soc.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        message = reader.readLine();    // reads a line of text
        

        return message;
    }
}
