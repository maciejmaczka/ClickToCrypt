/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktocrypt;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


/**
 *
 * @author Maciej
 */
public class CryptoFunctions 
{

    byte[] encryption_key;
    public String last_error_code = "";
    
    public void create_key(String user_password)
    {
        try
        {
            
         last_error_code = "Ready";
       
         MessageDigest md5 = MessageDigest.getInstance("MD5");
        
         encryption_key = md5.digest(user_password.getBytes());
         
         
         
        }
        catch (Exception e)
        {
            
            System.out.println("Err CF"  + e.getMessage());
            last_error_code = "Unable to create key: " +  e.getMessage();
            
        }
        
    }
    
    public String decrypt(String text_to_decrypt)
    {
        
        try
        {
              last_error_code = "Ready";
           
              Cipher aes_cipher =  Cipher.getInstance("AES/ECB/PKCS5Padding");
              SecretKeySpec aes_key_spec = new SecretKeySpec(encryption_key, "AES");          
            
              aes_cipher.init(Cipher.DECRYPT_MODE, aes_key_spec);

             byte[] byte_to_decrypt = DatatypeConverter.parseHexBinary(text_to_decrypt);
           
              
              byte[] byte_decrypted = aes_cipher.doFinal(byte_to_decrypt);
              byte[] test = new byte[0]; 
              
        
              
              
              String decrypted_text = new String(byte_decrypted, "UTF-8");
            

              return decrypted_text;
              
        }
        catch (Exception e)
        {
            last_error_code = "Unable to decrypt";
            System.out.println("ERR dec:" + e.getMessage());
            return null;
            
        }
        
        
     
    }
    
    
    
    public String encrypt(String text_to_encrypt)
    {
        
        try
        {
            last_error_code = "Ready";
            
            Cipher aes_cipher =  Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec aes_key_spec = new SecretKeySpec(encryption_key, "AES");
         
            aes_cipher.init(Cipher.ENCRYPT_MODE, aes_key_spec);
            byte[] encrypted = aes_cipher.doFinal(text_to_encrypt.getBytes());
            
            String encrypted_text =  "";
            
            for (int i = 0 ; i < encrypted.length ; i++)
            {
        
                
                //    encrypted_text = encrypted_text + String.format("%04x", encrypted[i]);
                //  encrypted_text = encrypted_text + String.format("%02x", encrypted[i]);  
                encrypted_text = encrypted_text + String.format("%02x", encrypted[i]) ;
//            System.out.print(String.format("%02x", encrypted[i]));
            
            }
            
            return encrypted_text;
            
        }
        catch (Exception e)
        {
             last_error_code = "Unable to encrypt: ";
             System.out.println("Err enc"  + e.getMessage());
             return null;
             
        }
        
        
        
    }
    
    
    
}
