import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Draven extends champ{
	public Draven(int x, int y) {
		super(x,y);
		ImageIcon d = new ImageIcon("Draven.PNG");
		Image dScale = d.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		d = new ImageIcon(dScale);
		setVisible(true);
		super.setSize(new Dimension(50,50));
		super.setIcon(d);
		super.setBounds(x,y,50,50);
		super.attack = 60;
		super.attackspeed = 1;
		ImageIcon a = new ImageIcon("DravenAuto.PNG");
		Image aScale = a.getImage().getScaledInstance(45,30,java.awt.Image.SCALE_SMOOTH);
		super.auto = new ImageIcon(aScale);
	}
	public int levelUp() {
		super.attack += 4;
		super.level += 1;
		super.lvlUpCost += 200;
		return lvlUpCost - 200;
	}
	public int sell() {
		return ((level-1)*lvlUpCost + 800);
	}
}
