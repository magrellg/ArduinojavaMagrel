/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librxtx_1;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.util.Enumeration;

/**
 *
 * @author Magrel Londoño
 */
public class obtencionDatosPuerto {
    
    static CommPortIdentifier portId;
    Enumeration puertos;
    SerialPort serialport;
    static InputStream entrada = null;
    Thread t;
    public static int aux=0,aux3=0;
    
     public obtencionDatosPuerto() {
        super();  
        puertos = CommPortIdentifier.getPortIdentifiers();
        t = new Thread((Runnable) new lectura_Serial());
        while (puertos.hasMoreElements()) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar
            //hasmorelements mientras tenga mas eleementos
            portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorreuno por uno
            //System.out.println(portId.getName()); //puertos disponbibles
            if (portId.getName().equalsIgnoreCase("COM4")) {
                try {
                    serialport = (SerialPort) portId.open("LecturaSerial", 1000);//tiempo en ms
                    entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
                    
                    t.start(); // inciamos el hilo para realizar nuestra accion deimprimir el dato serial

                } catch (Exception e) {
                }
            }
        }
    }
 

}
 
