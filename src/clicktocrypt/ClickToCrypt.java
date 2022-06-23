/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktocrypt;

import java.awt.SystemTray;

/**
 *
 * @author Maciej
 */
public class ClickToCrypt {

    public  static  CTCMain ctc_main;
   
    
    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ctc_main = new CTCMain();
      
        
        CTCtray ctc_tray = new CTCtray();
        ctc_tray.launch_tray(ctc_main);
         

        
        
    }
    
}



