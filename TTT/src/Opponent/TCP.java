/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class TCP {
    
    private int port;
    PrintWriter outStream;
    BufferedReader inStream;
    Socket client;
    
    public TCP(){
        port = 5678;
    }
    
    public void newClient(){
        try{
            for(int i = 1; i < 256; i++){
                client = new Socket(InetAddress.getLocalHost(), port);
            }
            outStream = new PrintWriter(client.getOutputStream());
            inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void newServer(){
        try{
            ServerSocket s = new ServerSocket(port);
            System.out.println("Warte auf Verbindung...");
            client = s.accept();
            System.out.println("Verbindung zu " + client.getInetAddress() + " hergestellt");

            // create Streams for I/O to the client
            outStream = new PrintWriter(client.getOutputStream());
            inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void writeLn(String line){
        // send text message to client
        outStream.println("Hallo ich bin dein Server");
        // clear the output-buffer
        outStream.flush();
    }
    
    public String readLn(){
        String answer = null;
        try {
            // read text message form the client
            answer = inStream.readLine();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return answer;
    }
}
