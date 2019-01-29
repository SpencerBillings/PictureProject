package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */ 
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void shiftLeftRight(int amount)
  {
		Pixel[][] pixels = this.getPixels2D();
		Picture temp = new Picture(this);
		Pixel[][] copied = temp.getPixels2D();
		
		int shiftedValue = amount;
		int width = pixels[0].length;
		
		for(int row = 0; row < pixels.length; row++)
		{
			for(int col = 0; col < pixels[0].length; col++)
			{
				shiftedValue = (col + amount) % width;
				if (amount < 0)
				{
					shiftedValue = ((col + amount) % width + width) % width;
				}
				copied[row][col].setColor(pixels[row][shiftedValue].getColor());
			}
		}
		for(int row = 0; row < pixels.length; row++)
		{
			for(int col = 0; col < pixels[0].length; col++)
			{
				pixels[row][col].setColor(copied[row][col].getColor());
			}
		}
		
  }
  
  public void shiftUpDown(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
		
	  int shiftedValue = amount;
	  int height = pixels.length;
		
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  shiftedValue = (row + amount) % height;
			  if (amount < 0)
				{
					shiftedValue = ((row + amount) % height + height) % height;
				}
			  copied[row][col].setColor(pixels[shiftedValue][col].getColor());
		  }
	  }
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setColor(copied[row][col].getColor());
		  }
	  }
  }
  
  public void verticleGlitcher()
  {
	  Pixel copiedPixel = null;
	  Pixel nextPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  int glitchPoint = 150;
	  
	  int col = glitchPoint - 20;
	  
	  while(col < 1130)
	  {
		  for (int row = 0; row < 848; row++)
		  {
			  for (col = glitchPoint - 20; col < glitchPoint; col++)
			  {
					  copiedPixel = pixels[row][glitchPoint];
					  nextPixel = pixels[row][col];
					  nextPixel.setColor(copiedPixel.getColor());
			  }
		  }
		  glitchPoint += 100;
	  }
  }
  
  public void horizontalGlitcher()
  {
	  Pixel copiedPixel = null;
	  Pixel nextPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  int glitchPoint = 40;
	  
	  int row = glitchPoint - 5;
	  
	  while(row < 800)
	  {
		  for (int col = 0; col < 1280; col++)
		  {
			  for (row = glitchPoint - 5; row < glitchPoint; row++)
			  {
					  copiedPixel = pixels[glitchPoint][col];
					  nextPixel = pixels[row][col];
					  nextPixel.setColor(copiedPixel.getColor());
			  }
		  }
		  glitchPoint += 50;
	  }
  }
  
  public void glitcher()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture spaceWalk = new Picture(this);
	  Pixel[][] copied = spaceWalk.getPixels2D();
	
  }
  
  public void zeroRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void setCustomAlpha(int a)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setAlpha(a);
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRToL()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < width / 2; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int col = 0; col < pixels[0].length; col++)
	  {
		  for (int row = 0; row < height / 2; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  //topPixel.setColor(bottomPixel.getColor());
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  public void revealPicture()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)
			  {
				  pixels[row][col].setColor(Color.CYAN);
			  }
			  else if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setColor(Color.MAGENTA);
			  }
		  }
	  }
  }
  
  public void hidePicture(Picture hidden)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] hiddenPixels =  hidden.getPixels2D();
	  
	  for(int row = 0; row < pixels.length && row < hiddenPixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length && col < hiddenPixels[0].length; col++)
		  {
			  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
			  }
			  else if(pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
			  }
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorSeagull()
  {
	  int mirrorPointOne = 350;
	  int mirrorPointTwo = 470;
	  int mirrorPointThree = 590;
	  
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 230; row < 330; row++)
	  {
		  for (int col = 230; col < mirrorPointOne; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][mirrorPointOne - col + mirrorPointOne];
			  rightPixel.setColor(leftPixel.getColor());
		  }
//		  for (int col = 350; col < mirrorPointTwo; col++)
//		  {
//			  leftPixel = pixels[row][col];
//			  rightPixel = pixels[row][mirrorPointTwo - col + mirrorPointTwo];
//			  rightPixel.setColor(leftPixel.getColor());
//		  }
//		  for (int col = 470; col < mirrorPointThree; col++)
//		  {
//			  leftPixel = pixels[row][col];
//			  rightPixel = pixels[row][mirrorPointThree - col + mirrorPointThree];
//			  rightPixel.setColor(leftPixel.getColor());
//		  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void chromakey(Picture replacement, Color changeColor)
  {
	  Pixel [][] mainPixels = this.getPixels2D();
	  Pixel [][] replacementPixels = replacement.getPixels2D();
	  
	  for (int row = 0; row < mainPixels.length; row++)
	  {
		  for (int col = 0; col < mainPixels[0].length; col++)
		  {
			  if (mainPixels[row][col].colorDistance(changeColor) < 75)
			  {
				  mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
			  }
		  }
	  }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the 0;distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.zeroRed();
    beach.explore();
  }
  

  
} // this } is the end of class Picture, put all new methods before this
