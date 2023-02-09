import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class main {
	public static JFrame f = new JFrame();
	public static JPanel p = new JPanel();
	public static List <champ> tower = new ArrayList<>();
	public static JLabel goldDisplay = new JLabel();
	public static int gold = 500;
	public static JLabel hud = new JLabel();
	public static JLabel mouse = new JLabel("default");
	public static JLabel background = new JLabel();	
	public static int mouseX, mouseY;
	public static JPanel mouseIn = new mouseTest();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIcon back = new ImageIcon("Background.PNG");
		Image b = back.getImage().getScaledInstance(1890,1060,java.awt.Image.SCALE_SMOOTH);
		back = new ImageIcon(b);		
	
		
		ImageIcon VAAup = new ImageIcon("VayneAutoUp.PNG");
		Image VAA = VAAup.getImage().getScaledInstance(75,150,java.awt.Image.SCALE_SMOOTH);
		VAAup = new ImageIcon(VAA);
		JLabel vAA = new JLabel();
		vAA.setIcon(VAAup);
		vAA.setSize(VAAup.getIconWidth(),VAAup.getIconHeight());
		vAA.setLocation(725,250);
		vAA.setVisible(true);
		drawMinion();
		
		background.setIcon(back);
		background.setLocation(0,0);
		background.setSize(1890,1060);
		
		p.add(vAA);
		
		
		drawHud();
		
		p.setVisible(true);
		p.setLayout(null);
		
		
		mouseIn.setSize(1890,1060); // 842 510
		
		//p.add(background);
		drawTower();
		p.setSize(1890,1060);
		f.setSize(1890,1060);
		f.add(p);
		f.add(mouseIn);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		
	}
	//Function takes in a champ object(tower) and adds buttons around it(rotate, exit, info)
	public static void addButtons(champ x) {
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton rotate = new JButton("Rotate");
				rotate.setBounds(x.getX()+115,x.getY()+30,75,40);
				JButton levelUp = new JButton("Level Up - Cost: " + x.getCost());
				levelUp.setBounds(x.getX()-25,x.getY()-60,150,40);
				JButton close = new JButton("Close");
				close.setBounds(x.getX()-105,x.getY()+30,75,40);
				JButton stats = new JButton("stats");
				stats.setBounds(x.getX() -30,x.getY()+115,75,40);
				JButton sell = new JButton("Sell");
				sell.setBounds(x.getX() +50,x.getY()+115,75,40);
				
				JLabel arrow = new JLabel();
				ImageIcon a = new ImageIcon(x.getDirection()+"arrow.PNG");
				Image aScale = a.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
				a = new ImageIcon(aScale);
				arrow.setIcon(a);
				arrow.setLocation(x.getX()+20,x.getY()-120);
				arrow.setSize(50,50);
				arrow.setVisible(true);
				
				stats.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame towerStat = new JFrame();
						JPanel stats = new JPanel();
						JLabel ad = new JLabel();
						JLabel aSpeed = new JLabel();
						JLabel level = new JLabel();
						JLabel Direction = new JLabel();
						towerStat.setSize(300,300);
						ad.setText("Attack damage: " + x.getAttack());
						aSpeed.setText("Attack speed: " + x.getAttackspeed());
						level.setText("Level: " + x.getLevel());
						Direction.setText("Direction: " + x.getDirection());
						stats.add(ad, BorderLayout.SOUTH);
						stats.add(aSpeed,  BorderLayout.SOUTH);
						stats.add(level,  BorderLayout.SOUTH);
						stats.add(Direction, BorderLayout.SOUTH);
						towerStat.add(stats);
						towerStat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						towerStat.setVisible(true);
					}
				});
				
				levelUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(gold >= x.getCost())
							x.levelUp();
						drawScreen();
					}
				});
				
				close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						drawScreen();
					}
				});
				
				rotate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						x.rotate();					
						drawScreen();
					}
				});
				
				sell.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gold += x.sell();
						tower.remove(x);
						drawScreen();
					}
				});
				
				p.add(arrow);
				p.add(sell);
				p.add(stats);
				p.add(close);
				p.add(levelUp);
				p.add(rotate);
				f.repaint();
			}
		});
	}
	public static JButton addChampButton(ImageIcon i) {
		JButton b = new JButton();
		Image scale = i.getImage().getScaledInstance(75,75,java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scale);
		b.setIcon(i);
		return b;
	}
	public static void drawHud() {
		ImageIcon hudI = new ImageIcon("ChampSelectHud1.PNG");
		hud.setIcon(hudI);
		
		goldDisplay.setBackground(Color.BLUE);
		goldDisplay.setText(("Gold: "+ gold));
		goldDisplay.setOpaque(true);
		goldDisplay.setVisible(true);
		goldDisplay.setLocation(500,500);
		
		hud.setVerticalAlignment(JLabel.CENTER);
		hud.setSize(200,1060);
		hud.setLocation(0,0);
		hud.setVisible(true);
		addHudButtons();
		p.add(hud);
		p.add(goldDisplay);
	}
	
	
	public static void addHudButtons() {
		
		JButton addVayne = addChampButton(new ImageIcon("VayneIcon.PNG"));
		JButton addKaisa = addChampButton(new ImageIcon("KaisaIcon.PNG"));
		JButton addAshe = addChampButton(new ImageIcon("AsheIcon.PNG"));
		JButton addCaitlyn = addChampButton(new ImageIcon("CaitlynIcon.PNG"));
		JButton addDraven = addChampButton(new ImageIcon("DravenIcon.PNG"));
		addVayne.setBounds(60,293,60,60);
		addKaisa.setBounds(60,393,60,60);
		addAshe.setBounds(60,493,60,60);
		addCaitlyn.setBounds(60,593,60,60);
		addDraven.setBounds(60,693,60,60);
		hud.add(addVayne);
		hud.add(addKaisa);
		hud.add(addAshe);
		hud.add(addCaitlyn);
		hud.add(addDraven);
		//vayne costs 250 gold each tower
		addVayne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseX = mouseIn.getX()-50;
				mouseY = mouseIn.getY()-50;
				if(gold >= 250) {
					tower.add(new Vayne(mouseX,mouseY));
					gold -= 250;
				}
				drawTower();
				f.repaint();
			}
		});
		//kaisa costs 400 gold
		addKaisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseX = mouseIn.getX()-50;
				mouseY = mouseIn.getY()-50;
				if(gold >= 400) {
					tower.add(new Kaisa(mouseX,mouseY));
					gold -= 400;
				}
				drawTower();
				f.repaint();
			}
		});
		//ashe costs 450 gold
		addAshe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseX = mouseIn.getX()-50;
				mouseY = mouseIn.getY()-50;
				if(gold >= 450) {
					tower.add(new Ashe(mouseX,mouseY));
					gold -= 450;
				}
				drawTower();
				f.repaint();
			}
		});
		//draven costs 1000 gold
		addDraven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseX = mouseIn.getX()-50;
				mouseY = mouseIn.getY()-50;
				if (gold >= 10000) {
					tower.add(new Draven(mouseX,mouseY));
					gold -= 1000;
				}
				drawTower();
				f.repaint();
			}
		});
		//caitlyn costs 500 gold
		addCaitlyn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseX = mouseIn.getX()-50;
				mouseY = mouseIn.getY()-50;
				if(gold >= 500) {
					tower.add(new Caitlyn(mouseX,mouseY));
					gold -= 500; 
				}
				drawTower();
				f.repaint();
			}
		});
		
	}
	public static void drawTower() {
		for(int i = 0; i < tower.size(); i++) {
			p.add(tower.get(i));
			addButtons(tower.get(i));
		}
		
	}
	public static void drawMinion() {
		ImageIcon minion = new ImageIcon("Minion_Melee.PNG");
		Image m = minion.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		minion = new ImageIcon(m);
		JLabel min = new JLabel();
		min.setIcon(minion);
		min.setLocation(850,150);
		min.setSize(50,50);
		min.setVisible(true);
		JLabel min2 = new JLabel();
		min2.setIcon(minion);
		min2.setLocation(800,150);
		min2.setSize(50,50);
		min2.setVisible(true);
		JLabel min3 = new JLabel();
		min3.setIcon(minion);
		min3.setLocation(750,150);
		min3.setSize(50,50);
		min3.setVisible(true);
		p.add(min3);
		p.add(min2);
		p.add(min);
	}
	
	public static void drawScreen() {
		p.removeAll();
		drawTower();
		drawMinion();
		drawHud();
		f.repaint();
	}
	
}


//store all the towers into an list/array
//draw all the towers at once
//make a close menu button for each tower (clear screen then draw all tower without the menus)