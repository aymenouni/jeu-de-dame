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


	public void mouseClicked(MouseEvent e) {// Appel� lorsque la souris a �t� cliqu�e sur un composant.
		
	}

	public void mouseEntered(MouseEvent e) {// Appel� lorsque la souris entre dans un composant.

	
	}

	
	public void mouseReleased(MouseEvent e) {// Appel� lorsqu'un bouton de la souris a �t� rel�ch� sur un composant.
		
	}


	public void mousePressed(MouseEvent e) {// Appel� lorsqu'un bouton de la souris a �t� enfonc� sur un composant.
		if(box1.isSelected()){
			try {
				swath.move(box1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}



	public void mouseExited(MouseEvent e) {// Appel� lorsque la souris quitte un composant.
	
		
	}
	


	
	
	

}
