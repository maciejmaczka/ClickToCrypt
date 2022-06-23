/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktocrypt;


import java.awt.SystemTray;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
/**
 *
 * @author Maciej
 */
public class CTCtray {
    
    CTCMain ctc_main;
    
    
    public void launch_tray(CTCMain ctc_main)
    {
        
        
        try
        {
        
            if (!SystemTray.isSupported()) {
                   System.out.println("SystemTray is not supported");
                   return;
               }
              
             BufferedImage  img = ImageIO.read(new File("icon.png"));
              ctc_main.setIconImage((Image) img);
              
              
             ctc_main.setVisible(true); 
              
             final PopupMenu tray_popup = new PopupMenu();
             
             final TrayIcon tray_icon = new TrayIcon(img, "Click and Crypt", tray_popup);
             
             tray_icon.setImageAutoSize(true);
             
             final SystemTray tray = SystemTray.getSystemTray();
                     
                
             tray_icon.addMouseListener(new MouseAdapter() 
             {
                @Override
       
                    public void mouseClicked(MouseEvent e) {
                        
                        ctc_main.setVisible(!ctc_main.isVisible())  ;
                       
                }
             
             });
             
             
            
             tray.add(tray_icon);
            
             

        }
        catch (Exception e)
        {
            
            System.out.println(e.getMessage());
            
        }
    } 
    
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        
        try
        {
            
            URL imageURL = new URL(path);

            if (imageURL == null) {
                System.err.println("Resource not found: " + path);
                return null;
            } else 
            {  
                
                return (new ImageIcon(imageURL, description)).getImage();
            }
        
        }
        catch (Exception e)
        {
            
            System.out.println(e.getMessage());
            
        }
        
        
        return null;
        
    }
    
    
    
}
