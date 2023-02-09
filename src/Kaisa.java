import java.awt.*;
import javax.swing.*;

public class Kaisa extends champ{
	public int passive = 0;
	public ImageIcon AA = new ImageIcon("KaisaAuto.PNG");
	public Kaisa(int x, int y) {
		super(x,y);
		ImageIcon k = new ImageIcon("Kaisa.PNG");
		Image kScale = k.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		k = new ImageIcon(kScale);
		setVisible(true);
		super.setSize(new Dimension(50,50));
		super.setIcon(k);
		super.setBounds(x,y,50,50);
		super.attack = 56;
		super.attackspeed = 2;
		ImageIcon a = new ImageIcon("KaisaAuto.PNG");
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
		return ((level-1)*lvlUpCost + 300);
	}
	
}
