/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librxtx_1;

import static librxtx_1.obtencionDatosPuerto.entrada;
/**
 *
 * @author Magrel Londoño
 */
public class lectura_Serial implements Runnable {
    
    public static int aux=0,aux3=0;
    public static String  aux2="";
    
    @Override
    public void run() {
                      
            while (true) {
             
                try {      
                       
                    aux = entrada.read(); // aqui estamos obteniendo nuestro dato serial que es el ascii del numero         
                    Thread.sleep(500);
                    if (aux > 0) {
                        String aux4= Character.toString((char)aux);
                        aux2 = aux2 + aux4;
                    }
                    System.out.println(aux2);
                    
                }catch (Exception e) {
                }
                
            }
            
        }
    
}
