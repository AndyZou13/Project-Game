import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mouseTest extends JPanel {
	protected int x,y;
	private JLabel status = new JLabel();
	
	public mouseTest() {
		
		setBackground(Color.WHITE);
		add(status, BorderLayout.SOUTH);
		
		Handlerclass handler = new Handlerclass();
		addMouseListener(handler);
		addMouseMotionListener(handler);
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private class Handlerclass implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			status.setText(String.format("X:%d y: %d", x, y));
		}
		public void mousePressed(MouseEvent e) {
			status.setText("pressed Down");
		}
		public void mouseReleased(MouseEvent e) {
			status.setText("released");
		}
		public void mouseEntered(MouseEvent e) {
			status.setText("You Entered the area");
		}
		public void mouseExited(MouseEvent e) {
			status.setText("You have exit the area");
		}
		
		public void mouseDragged(MouseEvent e) {
			status.setText("You are dragging the mouse");
		}
		public void mouseMoved(MouseEvent e) {
			status.setText("you moved the mouse");
		}
		
	}
}
