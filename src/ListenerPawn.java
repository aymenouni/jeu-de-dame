import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPawn implements MouseListener {
	
	private Swath swath;
	private Pawn pawn;
	
	public ListenerPawn(Pawn pawn, Swath swath){
		this.swath=swath;
		this.pawn=pawn;
	}

	public void mouseClicked(MouseEvent e) {// Appelé lorsque la souris a été cliquée sur un composant.
		
	}

	public void mouseEntered(MouseEvent e) {// Appelé lorsque la souris entre dans un composant.

	
	}

	

	public void mousePressed(MouseEvent e) {// Appelé lorsqu'un bouton de la souris a été enfoncé sur un composant.
		swath.afficherPossibilites(pawn);
	}

	public void mouseReleased(MouseEvent e) {// Appelé lorsqu'un bouton de la souris a été relâché sur un composant.
		
	}
	
	public void mouseExited(MouseEvent e) {// Appelé lorsque la souris quitte un composant.
		
	}

}
