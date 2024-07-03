/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;

/**
 *
 * @author nicoz
 */
public class AuxiliarIcono {
    
    public static Image IconToImage(Icon icon){
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage bi = gc.createCompatibleImage(w, h);
        Graphics2D g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }
    
    public static byte[] imageToByte (Image image){
     BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB); 
     Graphics g = bi.getGraphics();
     g.drawImage(image, 0, 0, null);
     g.dispose();
     ByteArrayOutputStream stream = new ByteArrayOutputStream();
     try{
         ImageIO.write(bi, "JPG", stream);
     }catch(Exception e){
        System.out.println("error al convertir la imagen a byte" + e.getMessage());
     }
        return stream.toByteArray();
    }
}
