import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Pawn extends JPanel {
	 private BufferedImage image1;
	 private BufferedImage image2;
	
	
	private Colorg colorp;
	private boolean J;

	public Colorg getColorp() {
		return colorp;
	}

	public Pawn(Colorg colorp, boolean J) {
		this.J=J;
		this.colorp = colorp;
		
		this.setOpaque(false);
		switch (colorp) {
		case WHITEG:
			setBackground(new Color(220, 220, 220));
			setForeground(Color.WHITE);
			break;
		case BLACKG :
			setBackground(new Color(00, 00, 00));
			setForeground(new Color(00, 00, 00));
			
			break;
		
		
		}
	}

	
	
	@Override
	public void paintComponent(Graphics g){
		  try {
		      image1 = ImageIO.read(new File("010.png"));//image de pion noir 
		      image2 = ImageIO.read(new File("011.png"));//image de pion blanc
		      this.setPreferredSize(new Dimension(image1.getWidth(),
		        image1.getHeight()));
		      this.setPreferredSize(new Dimension(image2.getWidth(),
				        image2.getHeight()));
		    } catch (IOException ie) {
		      ie.printStackTrace();
		    }
		  
		 
		if (getColorp().equals(Colorg.WHITEG)) {
		    g.drawImage(image2, 4, 4, null);}
		else {
			g.drawImage(image1, 4, 4, null);
		}
		

	}
	
	public boolean isJ() {
		return J;
	}


	public void setJ(boolean J) {
		this.J = J;
	}

}
