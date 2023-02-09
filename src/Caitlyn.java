import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Caitlyn extends champ{
	public Caitlyn(int x, int y) {
		super(x,y);
		ImageIcon c = new ImageIcon("Caitlyn.PNG");
		Image cScale = c.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		c = new ImageIcon(cScale);
		setVisible(true);
		super.setSize(new Dimension(50,50));
		super.setIcon(c);
		super.setBounds(x,y,50,50);
		super.attack = 62;
		super.attackspeed = 1;
		ImageIcon a = new ImageIcon("CaitlynAuto.PNG");
		Image aScale = a.getImage().getScaledInstance(45,30,java.awt.Image.SCALE_SMOOTH);
		super.auto = new ImageIcon(aScale);
	}
	public int levelUp() {
		super.attack += 3;
		super.level += 1;
		super.lvlUpCost += 200;
		return lvlUpCost - 200;
	}
	public int sell() {
		return ((level-1)*lvlUpCost + 400);
	}
}
