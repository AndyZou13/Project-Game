import java.awt.*;
import javax.swing.*;

public class Vayne extends champ{
	public int passive = 0;
	public Vayne(int x, int y) {
		super(x,y);
		ImageIcon V = new ImageIcon("Vayne.PNG");
		Image vScale = V.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		V = new ImageIcon(vScale);
		setVisible(true);
		super.setSize(new Dimension (50,50));
		super.setIcon(V);
		super.setBounds(x,y,50,50);
		super.attack = 59;
		super.attackspeed = 1;
		ImageIcon a = new ImageIcon("VayneAuto.PNG");
		Image aScale = a.getImage().getScaledInstance(45,30,java.awt.Image.SCALE_SMOOTH);
		super.auto = new ImageIcon(aScale);
	}
	public int levelUp() {
		super.attack += 2;
		super.level += 1;
		super.lvlUpCost += 200;
		return lvlUpCost - 200;
	}
	public int sell() {
		return ((level-1)*lvlUpCost + 150);
	}
}
