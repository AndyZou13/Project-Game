import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class champ extends JButton{
	int x,y;
	int attack, attackspeed, crit,level = 1; 
	protected int lvlUpCost = 150;
	ImageIcon auto = new ImageIcon("VayneAuto.PNG");
	public int AAx, AAy;
	int direction = 0;
	public champ(int x, int y) {
		this.x = x;
		this.y = y;
		setVisible(true);
		setSize(new Dimension(50,50));
		setBounds(x,y,100,100);
		AAx = x;
		AAy = y;
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}
	public void actionPerformed(ActionEvent e) {
		JButton rotate = new JButton("Rotate");
		rotate.setBounds(x+50,y,50,50);
		
	}
	public int getAttack() {
		return attack;
	}
	public int getAttackspeed() {
		return attackspeed;
	}
	public int getLevel() {
		return level;
	}
	public int getCost() {
		return lvlUpCost;
	}
	public int levelUp() {
		return lvlUpCost;
	}
	public String getDirection() {
		if (direction == 0) {
			return "E";
		}
		else if(direction == 45) {
			return "NE";
		}
		else if(direction == 90) {
			return "N";
		}
		else if(direction == 135) {
			return "NW";
		}
		else if(direction == 180) {
			return "W";
		}
		else if(direction == 225) {
			return "SW";
		}
		else if(direction == 270) {
			return "S";
		}
		else if(direction == 315) {
			return "SE";
		}
		return "";
	}
	public void rotate() {
		direction += 45;
		if(direction == 360)
			direction = 0;
	}
	public int sell() {
		return lvlUpCost;
	}
	public Image getAuto() {
		return auto.getImage();
	}
	public int getXAuto() {
		return AAx;
	}
	public int getYAuto() {
		return AAy;
	}
	public void setXAuto(int x) {
		AAx = x;
	}
	public void setYAuto(int x) {
		AAy = x;
	}
	public void updateAuto() {
		if (direction == 0) {
			AAx += attackspeed;
		}
		else if(direction == 45) {
			AAx += attackspeed;
			AAy -= attackspeed; 
		}
		else if(direction == 90) {
			AAy -= attackspeed;
		}
		else if(direction == 135) {
			AAy -= attackspeed;
			AAx -= attackspeed;
		}
		else if(direction == 180) {
			AAx -= attackspeed;
		}
		else if(direction == 225) {
			AAx -= attackspeed;
			AAy += attackspeed;
		}
		else if(direction == 270) {
			AAy += attackspeed;
		}
		else if(direction == 315) {
			AAx += attackspeed;
			AAy += attackspeed; 
		}
		
	}
}
