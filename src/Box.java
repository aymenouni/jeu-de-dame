import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;


public class Box extends JPanel {
	


	private Colorg colorg;
	private boolean selected;
	
	
	

	public Box(Colorg colorg){
		setLayout(new GridLayout(1,0));
		this.colorg=colorg;
		initColorg();
	}

	public Colorg getColorg() {
		return colorg;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if(selected){
			setBackground(Color.	red);
			setForeground(Color.red);
		}
		else {
			initColorg();
		}
	}
	
	private void initColorg(){
		switch(colorg){
		case BLACKG :
			setBackground(Color.black);
			setForeground(Color.black);
			break;
		
		
		case WHITEG :
			setBackground(Color.WHITE);
			setForeground(new Color(230, 230, 230));
			
			break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
