import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class LoadImages {

	final BufferedImage[] cards;
	
	LoadImages() throws IOException {
		  BufferedImage cardSheet = ImageIO.read(new File("/home/tres/Code/Java/CardsGUI/src/playing-cards.png"));
		  final int width = 73;
		  final int height= 98;
		  final int rows = 13;
		  final int columns = 4;
		  
		  cards = new BufferedImage[rows*columns];
		  
		  for(int i = 0; i < rows; i++) {
		         for(int j = 0; j < columns; j++) {
		            cards[(i * columns) + j] = cardSheet.getSubimage(i * width, j * height, width, height);
		         }
		      }
	}
}
