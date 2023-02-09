import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ashe extends champ {
	
	public Ashe (int x, int y) {
		super(x,y);
		ImageIcon a = new ImageIcon("Ashe.PNG");
		Image aScale = a.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		a = new ImageIcon(aScale);
		setVisible(true);
		super.setSize(new Dimension(50,50));
		super.setIcon(a);
		super.setBounds(x,y,50,50);
		super.attack = 61;
		super.attackspeed = 2;
		ImageIcon aa = new ImageIcon("AsheAuto.PNG");
		Image aaScale = aa.getImage().getScaledInstance(45,30,java.awt.Image.SCALE_SMOOTH);
		super.auto = new ImageIcon(aaScale);
	}
	public int levelUp() {
		super.attack += 3;
		super.level += 1;
		super.lvlUpCost += 200;
		return lvlUpCost - 200;
	}
	public int sell() {
		return ((level-1)*lvlUpCost + 350);
	}
}
