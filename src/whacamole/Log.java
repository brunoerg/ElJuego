/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bruno Garcia
 */
public class Log {
    
    FileWriter fw;
   
    public Log() throws IOException
    {

            try {
                Date d = new Date(System.currentTimeMillis());
                String nomeArquivo = "log-" + d.getTime() + ".txt";
                //arq = new Formatter("log.txt");
                fw = new FileWriter(nomeArquivo, true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
    
    public void write(String content)
    {
        try {
           fw.write(content);
           fw.flush();
        } catch(IOException ex)
        {
            System.out.println("Erro ao escrever");
        } 
    }
    
    public void write(float content)
    {
        try {
            fw.write((int) content);
            fw.flush();
        } catch(Exception ex)
        {
            System.out.println("Erro ao escrever");
        } 
    }
    
    public void write(String content1, String content2)
    {
        try {
           fw.write(content1);
           fw.write(content2);
           fw.flush();
        } catch(IOException ex) {
            System.out.println("Erro ao escrever");
        }
    }
    
    public void write(float content1, float content2)
    {
        try {
           fw.write((int) content1);
           fw.write((int) content2);
           fw.flush();
        } catch(IOException ex) {
            System.out.println("Erro ao escrever");
        }
    }
    
    public void write(int content1, int content2)
    {
        try {
           fw.write(content1);
           fw.write(content2);
           fw.flush();
        } catch(IOException ex) {
            System.out.println("Erro ao escrever");
        }
    }
    
    public void close() throws IOException
    {
        fw.close();
    }    
}
