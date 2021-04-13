import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Swath extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;

	private static final int SIZE=9;
	private Box boxActive;
    private int deadblack,deadwhite;
	private boolean T;
	private PrintWriter writer;

	public Swath(int size) throws FileNotFoundException, UnsupportedEncodingException{
		 writer = new PrintWriter("1.txt", "UTF-8");
	deadblack =0;
	deadwhite= 0;
		T=false;
		setLayout(new GridLayout(SIZE, SIZE));
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){//si i et j sont de meme paritee 
					addBox(Colorg.BLACKG);// on ajoute un case noir
				}
				else{
					addBox(Colorg.WHITEG);// on ajoute un case blanche
				}
			}
		}
		initPawn();
	}

	public void addBox(Colorg Colorg){
		Box box1 = new Box(Colorg);
		box1.addMouseListener(new ListenerBox(box1, this));// ajouter les evenement de la souris au cases
		add(box1);
	}

	private Pawn createPawn(Colorg colorg, boolean J){
		Pawn pawn = new Pawn(colorg, J);
		pawn.addMouseListener(new ListenerPawn(pawn, this));// ajouter les evenement de la souris au pions
		return pawn;
	}

	public void initPawn(){
		for(int j=0; j<SIZE*3; j+=2){
			
			
			getBox(j).add(createPawn(Colorg.BLACKG, false)); // ajouter un pion noir dans la j ieme case 
			getBox(SIZE*SIZE-j-1).add(createPawn(Colorg.WHITEG, true));// ajouter un pion noir dans la case nemero egale  nbr totale de case -j -1  
			
		}
	}

	public Box getBox(int i, int j){
		return (Box) getComponent(j+i*SIZE);
	}

	public Box getBox(int i){ 
		return (Box) getComponent(i);
	}

	public void afficherPossibilites(Pawn p){
		if((p.getColorp().equals(Colorg.BLACKG) && T) || (p.getColorp().equals(Colorg.WHITEG) && !T))//si le pion de couleur noir et la tour de noir ou le pion de couleur blanc et le tour de blanc 
		{
			int i=0;
			int j=0;
			for(int k=0; k<SIZE*SIZE; k++){
				getBox(k).setSelected(false);
				if(getBox(k).getComponentCount()!=0 && getBox(k).getComponent(0).equals(p)){ //si case (k/SISE,k%SISE)contient un pion   
					boxActive=getBox(k);
					i=k/SIZE;
					j=k%SIZE;

				}
			}
			selectBoxes(i, j, p.getColorp());
		}
	}

	public void selectBoxes(int i, int j, Colorg colorg){// identifier tout les cas possible 
		Pawn pawn = (Pawn)(getBox(i, j).getComponent(0));
		if(pawn.isJ()){
			if(i-1>=0 && j-1>=0 && getBox(i-1, j-1).getComponentCount()==0){ //si la case (i-1,j-1) est vide  
				getBox(i-1, j-1).setSelected(true); // selectionnee la case (i-1,j-1)
			}
			else if(i-2>=0 && j-2>=0 && getBox(i-2, j-2).getComponentCount()==0 && !((Pawn)(getBox(i-1, j-1).getComponent(0))).getColorp().equals(colorg)){//si la case (i-2,j-2) est vide et le pion (i-1,j-1)  est de couleur different 
				getBox(i-2, j-2).setSelected(true); // selectionnee la case (i-2,j-2)
			}
			if(i-1>=0 && j+1<SIZE && getBox(i-1, j+1).getComponentCount()==0){//si la case (i-1,j+1) est vide 
				getBox(i-1, j+1).setSelected(true); // selectionnee la case (i-1,j+1)
			}
			else if(i-2>=0 && j+2<SIZE && getBox(i-2, j+2).getComponentCount()==0 && !((Pawn)(getBox(i-1, j+1).getComponent(0))).getColorp().equals(colorg)){//si la case (i-2,j+2) est vide et le pion (i-1,j+1)  est de couleur different 
				getBox(i-2, j+2).setSelected(true);// selectionnee la case (i-2,j+2)
			}
		}
		else{
			if(i+1<SIZE && j+1<SIZE && getBox(i+1, j+1).getComponentCount()==0){//si la case (i-1,j+1) est vide  
				getBox(i+1, j+1).setSelected(true);// selectionnee la case (i+1,j+1)
			}
			else if(i+2<SIZE && j+2<SIZE && getBox(i+2, j+2).getComponentCount()==0 && !((Pawn)(getBox(i+1, j+1).getComponent(0))).getColorp().equals(colorg)){//si la case (i+1,j+1) est vide et le pion (i-1,j+1)  est de couleur different 
				getBox(i+2, j+2).setSelected(true);
			}
			if(i+1<SIZE && j-1>=0 && getBox(i+1, j-1).getComponentCount()==0){//si la case (i+1,j-1) est vide 
				getBox(i+1, j-1).setSelected(true);// selectionnee la case (i+1,j-1)
			}
			else if(i+2<SIZE && j-2>=0 && getBox(i+2, j-2).getComponentCount()==0 && !((Pawn)(getBox(i+1, j-1).getComponent(0))).getColorp().equals(colorg)){//si la case (i+1,j-1) est vide et le pion (i-1,j+1)  est de couleur different 
				getBox(i+2, j-2).setSelected(true);
			}
			
		}
	}
	

	public void move(Box box1) throws IOException {
		 
		box1.add(boxActive.getComponent(0));
		for(int k=0; k<SIZE*SIZE; k++){
			getBox(k).setSelected(false);
		}
		if(Math.abs(getLigne(box1)-getLigne(boxActive))==2){// la difference en ligne entre les deux case et egale 2
			int i = (getLigne(box1)+getLigne(boxActive))/2;
			int j = (getColonne(box1)+getColonne(boxActive))/2;
			
			if(T) {
				//deplacement de pion dans la label correspondante 
				deadwhite++;
				gameLancher.addpawn(0);
			}else {
				deadblack++;
			
				gameLancher.addpawn(1);
			}
			
			getBox(i, j).removeAll();
			getBox(i, j).validate();
			getBox(i, j).repaint();
			if (deadblack==14)  {
				writer.write("historique du blanc          historique de noir \n");
				writer.close();
				// affichage de la fenetre end game 
				  JTextArea textArea = new JTextArea("                GAME OVER    \n \n            PLAYER  1  WIN");

				  textArea.setColumns(30);
				  textArea.setLineWrap( true );
				  textArea.setWrapStyleWord( true );
				  textArea.setSize(textArea.getPreferredSize().width, 1);
				  Font font = new Font("Freestyle Script", Font.PLAIN, 40);
				  textArea.setFont(font);
				
				  textArea.setBackground(new Color(0,0,0,0));
				  JOptionPane.showMessageDialog(
				  null, textArea, "THE END", JOptionPane.PLAIN_MESSAGE);
				
				
			}
			else if(deadwhite ==14) {
				writer.write("historique du joueur 1          historique du joueur 2 \n");
				writer.close();
				// affichage de la fenetre end game 
				  JTextArea textArea = new JTextArea("                GAME OVER    \n \n            PLAYER  2  WIN");

				  textArea.setColumns(30);
				  textArea.setLineWrap( true );
				  textArea.setWrapStyleWord( true );
				  textArea.setSize(textArea.getPreferredSize().width, 1);
				  Font font = new Font("Freestyle Script", Font.PLAIN, 40);
				  textArea.setFont(font);
				
				  textArea.setBackground(new Color(0,0,0,0));
				  JOptionPane.showMessageDialog(
				  null, textArea, "THE END", JOptionPane.PLAIN_MESSAGE);
				
				
			}
			
		}
		
		
	

		if(T) {
			
		    
		    (gameLancher.b3).setText( (gameLancher.b3).getText()+"\n "+"("+(1+getLigne(boxActive))+","+(1+ getColonne(boxActive))+")"+" =>"+"("+(getLigne(box1)+1)+","+(1+getColonne(box1))+")");// ecriture dans la label de nouvement de noir
		    writer.write("              ("+(1+getLigne(boxActive))+","+(1+ getColonne(boxActive))+")"+" =>"+"("+(getLigne(box1)+1)+","+(1+getColonne(box1))+")\n")           ;// ecriture dans le fichier text le nouvement de noir
		    (gameLancher.b3).updateUI();
		    
		 
		}
		else {
		
			(gameLancher.b4).setText((gameLancher.b4).getText()+"\n "+"("+(9-getLigne(boxActive))+","+(1+ getColonne(boxActive))+")"+" =>"+"("+(-getLigne(box1)+9)+","+(1+getColonne(box1))+")");		// ecriture dans la label de nouvement de blanc  
			writer.write("    ("+(9-getLigne(boxActive))+","+(1+ getColonne(boxActive))+")"+" =>"+"("+(-getLigne(box1)+9)+","+(1+getColonne(box1))+")");// ecriture dans le fichier text le nouvement de blanc
			(gameLancher.b4).updateUI();
		}
	
		T=!T;
		boxActive.removeAll();
		boxActive.repaint();
		boxActive=null;
		box1.repaint();
		if(getLigne(box1)==0){
			Pawn p=(Pawn)(box1.getComponent(0));
			p.setJ(false);
		}
		if(getLigne(box1)==SIZE-1){
			Pawn p=(Pawn)(box1.getComponent(0));
			p.setJ(true);
		}
		
		
		

	
	}
	

	

	private int getLigne(Box box1){
		int res=0;
		for(int i=0; i<SIZE*SIZE; i+=2){
			if(getBox(i).equals(box1)){
				res=i/SIZE;
			}
		}
		return res;
	}

	private int getColonne(Box box1){
		int res=0;
		for(int i=0; i<SIZE*SIZE; i+=2){
			if(getBox(i).equals(box1)){
				res=i%SIZE;
			}
		}
		return res;
	}
	
  
	


}
