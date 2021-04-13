import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPawn implements MouseListener {
	
	private Swath swath;
	private Pawn pawn;
	
	public ListenerPawn(Pawn pawn, Swath swath){
		this.swath=swath;
		this.pawn=pawn;
	}

	public void mouseClicked(MouseEvent e) {// Appel� lorsque la souris a �t� cliqu�e sur un composant.
		
	}

	public void mouseEntered(MouseEvent e) {// Appel� lorsque la souris entre dans un composant.

	
	}

	

	public void mousePressed(MouseEvent e) {// Appel� lorsqu'un bouton de la souris a �t� enfonc� sur un composant.
		swath.afficherPossibilites(pawn);
	}

	public void mouseReleased(MouseEvent e) {// Appel� lorsqu'un bouton de la souris a �t� rel�ch� sur un composant.
		
	}
	
	public void mouseExited(MouseEvent e) {// Appel� lorsque la souris quitte un composant.
		
	}

}
