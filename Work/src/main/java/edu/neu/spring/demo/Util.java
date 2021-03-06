/**
 * 
 */
package edu.neu.spring.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author pratiknakave
 *
 */
public class Util {

	private static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Set<String> identifiers = new HashSet<String>();
	public static String nameGenerator() {
		final java.util.Random rand = new java.util.Random();
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public static int ageGenerator() {
		Random rand = new Random(); //instance of random class
	    int upperbound = 50;
	    //generate random values from 0-50
	    int int_random = rand.nextInt(upperbound);
		return int_random;
	}
	
	public static byte[] imageGenerator() {
		int width = 500;
	     int height = 500;
	     //create buffered image object img
	     java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
	     //file object
	     File f = null;
	     //create random image pixel by pixel
	     for(int y = 0; y < height; y++){
	       for(int x = 0; x < width; x++){
	         int a = (int)(Math.random()*256); //alpha
	         int r = (int)(Math.random()*256); //red
	         int g = (int)(Math.random()*256); //green
	         int b = (int)(Math.random()*256); //blue
	 
	         int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
	 
	         img.setRGB(x, y, p);
	       }
	     }
	     //write image
	     try{
	       //f = new File("/Users/pratiknakave/Downloads/Ethics_Group.jpeg");
	       f = new File(nameGenerator()+".jpg");
	       javax.imageio.ImageIO.write(img, "png", f);
	       System.out.println("Image Location : "+f.toPath().toString());
	       return Files.readAllBytes(f.toPath());
	     }catch(IOException e){
	       System.out.println("Error: " + e);
	     }
	     return null;
	}
	
	public static byte[] fileGenerator() {
		int filesize = 129 * 1024;
		//int count = 9500;
		File dir = new File("/Users/pratiknakave/Downloads/");
		String ext = ".txt";
		
		byte[] bytes = new byte[filesize];
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        
        try {
            //for (int i = 0; i < count; i++) {
                Random rand = new Random();
                System.out.println("Into Try block setting name");
                String name = String.format("%s%s", System.currentTimeMillis(), rand.nextInt(100000) + ext);
                File file = new File(dir, name);
 
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos);
 
                rand.nextBytes(bytes);
                bos.write(bytes);
 
                bos.flush();
                bos.close();
                fos.flush();
                fos.close();
                System.out.println("Finished writing a file");
                return Files.readAllBytes(file.toPath());
            //}
 
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("Error while writing to file" + ioe);
        } finally {
            try {
                if (bos != null) {
                    bos.flush();
                    bos.close();
                }
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing streams" + e);
            }
        }
		
		return null;
	}
}
