import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Minion{
	public static int baseHealth = 100;
	public int health = baseHealth;
	private int startx = 850;
	private int starty = 380;
	private int x=850,y=380;
	public int movex = -2, movey = 0;
	private static ImageIcon minion = new ImageIcon("Minion_Meleee.PNG");
	public Minion (int a, int b) {
		startx = a;
		starty = b;
		x=a;
		y=b;
	}
	protected void paintComponent (Graphics g) {
		g.drawImage(minion.getImage(), x, y, null);
	}
	public void update () {
		x += movex;
		y += movey;
	}
	public int getx () {
		return x;
	}
	public int gety () {
		return y;
	}
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int x) {
		this.y = x;
	}
	public void resetpos() {
		x = startx;
		y = starty;
		movex = -2;
		movey = 0;
	}
	public void changeDirection(int a, int b) {
		movex = a;
		movey = b;
	}
	public void setmovex(int x) {
		movex = x;
	}
	public void setmovey(int x) {
		movey = x;
	}
	public void startPos() {
		x = startx;
		y = starty;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int x) {
		health = x;
	}
	public void resetHealth() {
		health = baseHealth;
	}
	public static void levelUp() {
		baseHealth += 75;
		//health = baseHealth;
	}
	public static void resetBaseHealth() {
		baseHealth = 100;
	}
}
