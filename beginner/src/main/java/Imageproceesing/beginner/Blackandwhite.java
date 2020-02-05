package Imageproceesing.beginner;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Blackandwhite 
{
	public static void grayscale() throws IOException
	{
		int height;
		int width;
		File f=new File("C:\\Users\\Arun\\Desktop\\Motivational-Wallpaper-4.jpg");
		BufferedImage image;
		image=ImageIO.read(f);   //reading the image 
		height=image.getHeight();  //get the height and width value for resolution
		width=image.getWidth();
		System.out.println("Image resolution ("+width+"x"+height+")");
		
		//inorder to convert each pixel into a grayscale we need to iterate the height and resolution
		for (int i=0; i<height;i++)
		{
			for (int j=0;j<width;j++)
			{
				Color c=new Color(image.getRGB(j, i));  //get rgb is the green, red and blue on total forms the colored image so inorder to convert each colors to gray we have to multiply by a factor
				
				int red =(int) (c.getRed()*0.299);	
				int green=(int)	(c.getGreen()*0.587);
				int blue=(int)(c.getBlue()*0.114);
				
				int total=red+green+blue; 
				Color newColor=new Color(total,total,total);//Color(int r, int g, int b) : Creates a opaque color with specified RGB
				image.setRGB(j, i, newColor.getRGB());//(height in one unit, width in one unit)
			
			}
		}
		File out=new File("grayscale.jpg");
		ImageIO.write(image, "jpg", out);//(rendered image, formatname, fileoutput)
	}
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        grayscale();
    }
}
