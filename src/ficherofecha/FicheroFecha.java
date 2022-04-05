
package ficherofecha;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FicheroFecha {

    
    static String pathLog = "Outfile.log";
    static PrintWriter out = null;
    public static void main(String[] args) {
        
        try {
            //1. Crear un fichero de log
            crearFicheroLog();
            //2. Escribir el fichero de log
            escribirEnFicheroDeLog("Helloooooooooooooooo!!!");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally{
            out.close();
        }
    }
    //metodo para crear fichero de log
    private static void crearFicheroLog()throws FileNotFoundException{
        out= new PrintWriter(pathLog);
        out.print("["+dameFecha("dd/MM/yyyy HH:mm:ss ")+"] ***EMPEZANDO FICHERO DE LOG***");
    }
    //metodo para devolver fecha dependiendo del formato
    private static String dameFecha(String formato){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
        return dtf.format(LocalDateTime.now());
    }
    //metodo para devolver fecham completa con formato por defecto
    private static String dameFechaPorDefecto(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    //metodo para...
    private static void escribirEnFicheroDeLog(String msg){
        out.print(")"+System.currentTimeMillis()+")");
        out.printf("Mi número %d\n", 8);
        out.println("Primera fecha: "+dameFechaPorDefecto());
        out.println("Este es el mensaje "+msg);
        System.out.println("******************************");
    }
    
    
}
