import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class ListenerBox implements MouseListener{
	
	private Box box1;
	private Swath swath;

	
	public ListenerBox(Box box1, Swath swath) {
		super();
		this.box1 = box1;
		this.swath = swath;
	}


	public void mouseClicked(MouseEvent e) {// Appelé lorsque la souris a été cliquée sur un composant.
		
	}

	public void mouseEntered(MouseEvent e) {// Appelé lorsque la souris entre dans un composant.

	
	}

	
	public void mouseReleased(MouseEvent e) {// Appelé lorsqu'un bouton de la souris a été relâché sur un composant.
		
	}


	public void mousePressed(MouseEvent e) {// Appelé lorsqu'un bouton de la souris a été enfoncé sur un composant.
		if(box1.isSelected()){
			try {
				swath.move(box1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}



	public void mouseExited(MouseEvent e) {// Appelé lorsque la souris quitte un composant.
	
		
	}
	


	
	
	

}
