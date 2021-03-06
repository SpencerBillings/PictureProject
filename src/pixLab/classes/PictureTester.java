package pixLab.classes;
import java.awt.*;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
	public static void testSteganography()
	{
		Picture source= new Picture("blue-mark.jpg");
		
		Picture hidden = new Picture("JohannesG.jpg");
		source.explore();
		hidden.explore();
		source.hidePicture(hidden);
		source.explore();
		source.revealPicture();
		source.explore();
	}
	
	public static void testShiftLeftRight()
	{
		Picture temp = new Picture("moon-surface.jpg");
		temp.explore();
		temp.shiftLeftRight(-20);
		temp.explore();
	}
	
	public static void testGlitcher()
	{
		Picture spaceWalk = new Picture("space-walk.png");
		Picture galaxy = new Picture("galaxy.png");
		
		spaceWalk.horizontalGreen();
		spaceWalk.chromakey(galaxy, Color.GREEN);
		spaceWalk.zeroGreen();
		spaceWalk.verticleGlitcher();
		spaceWalk.horizontalGlitcher();
		spaceWalk.explore();
	}
	
	public static void testChromakey()
	{
		Picture source = new Picture("bBear.jpg");
		Picture background = new Picture("spaceBG.jpg");
		source.explore();
		background.explore();
		source.chromakey(background, Color.BLACK);
		source.explore();
	}
	
	
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroRed();
	  beach.explore();
  }
  
  public static void testSetAlpha()
  {
	  Picture spaceWalk = new Picture("space-walk.png");
	  spaceWalk.explore();
	  spaceWalk.setCustomAlpha(75);
	  spaceWalk.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("blue-mark.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRToL()
  {
	  Picture blueMark = new Picture("blue-mark.jpg");
	  blueMark.explore();
	  blueMark.mirrorVerticalRToL();
	  blueMark.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture redMotor = new Picture("redMotorcycle.jpg");
	  redMotor.explore();
	  redMotor.mirrorHorizontal();
	  redMotor.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorSeagull()
  {
	  Picture seagull = new Picture("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorSeagull();
	  seagull.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	  //testSteganography();
	  //testShiftLeftRight();
	  testGlitcher();
    //testZeroBlue();
    //testZeroRed();
    //testHalfAlpha();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRToL();
	//testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorSeagull();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}