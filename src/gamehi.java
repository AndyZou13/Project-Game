import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;


public class gamehi extends JPanel {
	public static gamehi bot = new gamehi();
	public static List <champ> tower = new ArrayList<champ>();
	public static List <Minion> creeps = new ArrayList<Minion>();
	public static List <Rectangle> minionHitBox = new ArrayList <Rectangle>();
	public static Map<champ,Rectangle> AutoAttacks = new HashMap<champ,Rectangle>();
	public static int mouseX, mouseY;
	public static JPanel mouseIn = new mouseTest();
	public static int minionCounter = 0;
	

	
	private static ImageIcon[] images = new ImageIcon[10];
	private static ImageIcon img = new ImageIcon ("nexus.jpg");
	private static ImageIcon img1 = new ImageIcon ("Minion_Melee.png");
	private static ImageIcon img2 = new ImageIcon ("ChampSelectHud1.PNG");
	private static ImageIcon img3 = new ImageIcon ("Fast.jpg");
	private static ImageIcon img4 = new ImageIcon ("play.png");
	private static JFrame frame = new JFrame("GameScreen");
	private static boolean p = true;
	public static void pics () {
		images[0] = new ImageIcon (img.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH));
		images[1] = new ImageIcon (img1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		images[2] = new ImageIcon (img2.getImage().getScaledInstance(180, 400, Image.SCALE_SMOOTH));
		images[3] = new ImageIcon (img3.getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		images[4] = new ImageIcon (img4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	}
	private static int x = 850;
	private static int y = 380;
	private static int gold = 1000;
	public static int wave = 1;
	private static int time = 20;
	private static int health = 1;
	private static JTextField g = new JTextField("Gold:" + gold);
	private static JTextField w = new JTextField("Wave:" + wave);
	private static JTextField h = new JTextField("Health:" + health);
	private static Rectangle r1 = new Rectangle(180, 0, 55, 430);
	private static Rectangle r2 = new Rectangle(235, 0, 600, 50);
	private static Rectangle r3 = new Rectangle(785, 50, 50, 330);
	private static Rectangle r4 = new Rectangle(285, 330, 500, 50);
	private static Rectangle r5 = new Rectangle(285, 100, 50, 230);
	private static Rectangle r6 = new Rectangle(335, 100, 400, 50);
	//private static Rectangle min = new Rectangle(x, y, 49, 49);
	private static Rectangle nexus = new Rectangle(610, 150, 75, 75);
	//private static ArrayList <Minion> m = new ArrayList <Minion> ();
	protected void paintComponent (Graphics g) {
		super.paintComponents(g);
		
		Color c = new Color(20, 198, 26);
		g.setColor(c);
		g.fillRect(180, 430, 655, 50);
		g.fillRect(180, 0, 55, 430);
		g.fillRect(235, 0, 600, 50);
		g.fillRect(785, 50, 50, 330);
		g.fillRect(285, 330, 500, 50);
		g.fillRect(285, 100, 50, 230);
		g.fillRect(335, 100, 400, 50);
		g.fillRect(685, 150, 50, 125);
		g.fillRect(390, 225, 295, 50);
		g.fillRect(390, 200, 225, 25);
		Color d = new Color (0, 0, 0);
		g.setColor(d);
		g.fillRect(0, 400, 180, 85);
		g.drawImage(images[0].getImage(), 610, 150, null);
//		if(!creeps.isEmpty()) {
//			for(int i = 0; i < creeps.size(); i++) {
//				g.drawImage(images[1].getImage(), creeps.get(i).getx(),creeps.get(i).gety(), null);
//			}
//		}
		for(int i = 0; i < creeps.size(); i++) {
			g.drawImage(images[1].getImage(), creeps.get(i).getx(),creeps.get(i).gety(), null);
		}
	
		g.drawImage(images[2].getImage(), 0, 0, null);
		
		if(!tower.isEmpty()) {
			for(int i = 0; i < tower.size(); i++) {
				g.drawImage(tower.get(i).getAuto(), tower.get(i).getXAuto(),tower.get(i).getYAuto()+10, null);
			}
		}
	}

	
	public static void box () {
		g.setBounds(5, 400, 50, 5);
		g.setEditable(false);
		g.setSize(new Dimension (120, 25));
		g.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		g.setOpaque(false);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		frame.add(g);
		w.setBounds(5, 425, 50, 5);
		w.setEditable(false);
		w.setSize(new Dimension (120, 25));
		w.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		w.setOpaque(false);
		w.setFont(new Font("Arial", Font.BOLD, 18));
		frame.add(w);
		h.setBounds(5, 450, 50, 5);
		h.setEditable(false);
		h.setSize(new Dimension (120, 25));
		h.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		h.setOpaque(false);
		h.setFont(new Font("Arial", Font.BOLD, 18));
		frame.add(h);
		JButton pause = new JButton (images[4]);
		pause.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				if (p == false)
					p = true;
				else
					p= false;
			}

		});
		pause.setBounds(120, 410, 25, 25);
		frame.add(pause);
		JButton fast = new JButton (images[3]);
		fast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				if (time == 20) {
					time= 10;
				}
				else {
					time = 20;
				}
			}

		});
		fast.setBounds(120, 440, 25, 25);
		frame.add(fast);
	}
	
	public gamehi() {
		Handlerclass handler = new Handlerclass();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	public static void starter () throws InterruptedException{	
		
		creeps.add(new Minion(850,380));
		minionHitBox.add(new Rectangle(850,360,49,49));
		drawTower();
		pics();
		box();
		frame.add(mouseIn);
		drawHud();
		
		frame.add(bot);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(842, 510));
		frame.setResizable(false);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		frame.repaint();
		
		while (true) {
			while (p == false) {


				//gold += 1;
				g.setText("Gold:" + gold);
				w.setText("Wave:" + wave);
				h.setText("Health:" + health);
				frame.repaint();
				Thread.sleep(time);
				updateMinPosition();
				
				updateBulletPosition();
				minionDeath();
				
				if (health <= 0)
					break;
			}
			if (health <= 0)
				break;
			System.out.print(p);
			
		}

	}
	public static void drawHud() {

		addHudButtons();
		//p.add(hud);
	}
	
	
	public static void addHudButtons() {
		JButton addVayne = addChampButton(new ImageIcon("VayneIcon.PNG"));
		JButton addKaisa = addChampButton(new ImageIcon("KaisaIcon.PNG"));
		JButton addAshe = addChampButton(new ImageIcon("AsheIcon.PNG"));
		JButton addCaitlyn = addChampButton(new ImageIcon("CaitlynIcon.PNG"));
		JButton addDraven = addChampButton(new ImageIcon("DravenIcon.PNG"));
		addVayne.setBounds(52,7,48,48);
		addKaisa.setBounds(52,88,48,48);
		addAshe.setBounds(52,169,48,48);
		addCaitlyn.setBounds(52,250,48,48);
		addDraven.setBounds(52,331,48,48);
		frame.add(addVayne);
		frame.add(addKaisa);
		frame.add(addAshe);
		frame.add(addCaitlyn);
		frame.add(addDraven);
		//vayne costs 250 gold each tower
		addVayne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gold >= 250) {
					tower.add(new Vayne(mouseX-25,mouseY-25));
					gold -= 250;
					g.setText("Gold:" + gold);
					AutoAttacks.put(tower.get(tower.size()-1),new Rectangle(tower.get(tower.size()-1).getX(),tower.get(tower.size()-1).getY()+10,45,30));
				}
				drawTower();
				frame.repaint();
			}
		});
		//kaisa costs 400 gold
		addKaisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				mouseX = mouseIn.getX()-50;
//				mouseY = mouseIn.getY()-50;
				if(gold >= 400) {
					tower.add(new Kaisa(mouseX-25,mouseY-25));
					gold -= 400;
					g.setText("Gold:" + gold);
					AutoAttacks.put(tower.get(tower.size()-1),new Rectangle(tower.get(tower.size()-1).getX(),tower.get(tower.size()-1).getY()+10,45,30));
				}
				drawTower();
				frame.repaint();
			}
		});
		//ashe costs 450 gold
		addAshe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				mouseX = mouseIn.getX()-50;
//				mouseY = mouseIn.getY()-50;
				if(gold >= 450) {
					tower.add(new Ashe(mouseX-25,mouseY-25));
					gold -= 450;
					g.setText("Gold:" + gold);
					AutoAttacks.put(tower.get(tower.size()-1),new Rectangle(tower.get(tower.size()-1).getX(),tower.get(tower.size()-1).getY()+10,45,30));
				}
				drawTower();
				frame.repaint();
			}
		});
		//draven costs 1000 gold
		addDraven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				mouseX = mouseIn.getX()-50;
//				mouseY = mouseIn.getY()-50;
				if (gold >= 1000) {
					tower.add(new Draven(mouseX-25,mouseY-25));
					gold -= 1000;
					g.setText("Gold:" + gold);
					AutoAttacks.put(tower.get(tower.size()-1),new Rectangle(tower.get(tower.size()-1).getX(),tower.get(tower.size()-1).getY()+10,45,30));
				}
				drawTower();
				frame.repaint();
			}
		});
		//caitlyn costs 500 gold
		addCaitlyn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gold >= 500) {
					tower.add(new Caitlyn(mouseX-25,mouseY-25));
					gold -= 500; 
					g.setText("Gold:" + gold);
					AutoAttacks.put(tower.get(tower.size()-1),new Rectangle(tower.get(tower.size()-1).getXAuto(),tower.get(tower.size()-1).getY()+10,45,30));
				}
				drawTower();
				frame.repaint();
			}
		});
		
	}
	public static JButton addChampButton(ImageIcon i) {
		JButton b = new JButton();
		Image scale = i.getImage().getScaledInstance(48,48,java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scale);
		b.setIcon(i);
		return b;
	}
	public static void addButtons(champ x) {
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton rotate = new JButton("Rotate");
				rotate.setBounds(x.getX()+55,x.getY()+10,75,40);
				JButton levelUp = new JButton("Level Up - Cost: " + x.getCost());
				levelUp.setBounds(x.getX()-35,x.getY()-50,150,40);
				JButton close = new JButton("Close");
				close.setBounds(x.getX()-80,x.getY()+10,75,40);
				JButton stats = new JButton("stats");
				stats.setBounds(x.getX() -30,x.getY()+55,75,40);
				JButton sell = new JButton("Sell");
				sell.setBounds(x.getX() +50,x.getY()+55,75,40);
				
				JLabel arrow = new JLabel();
				ImageIcon a = new ImageIcon(x.getDirection()+"arrow.PNG");
				Image aScale = a.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
				a = new ImageIcon(aScale);
				arrow.setIcon(a);
				arrow.setLocation(x.getX()+20,x.getY()-90);
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
						if(gold >= x.getCost()) {
							gold -= x.levelUp();
							g.setText("Gold:" + gold);
						}
						drawScreen();
					}
				});
				
				close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bot.remove(arrow);
						bot.remove(sell);
						bot.remove(stats);
						bot.remove(close);
						bot.remove(levelUp);
						bot.remove(rotate);
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
				
				bot.add(arrow);
				bot.add(sell);
				bot.add(stats);
				bot.add(close);
				bot.add(levelUp);
				bot.add(rotate);
				frame.repaint();
			}
		});
	}
	public static void drawTower() {
		for(int i = 0; i < tower.size(); i++) {
			bot.add(tower.get(i));
			addButtons(tower.get(i));
		}
	}
	public static void drawScreen() {
		bot.removeAll();
		g.setText("Gold:" + gold);
		drawTower();
		drawHud();
		frame.repaint();
	}
	public static void updateBulletPosition() {
		for(int i = 0; i < tower.size(); i++) {
			tower.get(i).updateAuto();
			
			if(tower.get(i).getXAuto() < 180) {
				tower.get(i).setXAuto(tower.get(i).getX());
				tower.get(i).setYAuto(tower.get(i).getY());
			}
			if(tower.get(i).getXAuto() > 842) {
				tower.get(i).setXAuto(tower.get(i).getX());
				tower.get(i).setYAuto(tower.get(i).getY());
			}
			if(tower.get(i).getYAuto() < -30) {
				tower.get(i).setYAuto(tower.get(i).getY());
				tower.get(i).setXAuto(tower.get(i).getX());
			}
			if(tower.get(i).getYAuto() > 510) {
				tower.get(i).setYAuto(tower.get(i).getY());
				tower.get(i).setXAuto(tower.get(i).getX());
			}
			AutoAttacks.replace(tower.get(i),new Rectangle(tower.get(i).getXAuto(),tower.get(i).getY()+10,45,30));
			Rectangle bullet = AutoAttacks.get(tower.get(i));
			for(int z = 0; z < minionHitBox.size(); z++) {
				if (bullet.intersects(minionHitBox.get(z)) == true) {
					tower.get(i).setYAuto(tower.get(i).getY());
					tower.get(i).setXAuto(tower.get(i).getX());
					creeps.get(z).setHealth(creeps.get(z).getHealth()-tower.get(i).getAttack());
				}
			}
		}
		
	}
	public static void addMinion() {
		creeps.add(new Minion(850+((wave-1)*50),380));
		minionHitBox.add(new Rectangle(creeps.get(wave-1).getx(),creeps.get(wave-1).gety(),40,40));
	}
	public static void updateMinPosition() {
		for(int i = 0; i < creeps.size(); i++) {
			creeps.get(i).update();
			minionHitBox.get(i).x = creeps.get(i).getx();
			minionHitBox.get(i).y = creeps.get(i).gety();

			if (minionHitBox.get(i).intersects(r1) == true) {

				creeps.get(i).changeDirection(0,-2);
			}
			if (minionHitBox.get(i).intersects(r2) == true) {

				creeps.get(i).changeDirection(2,0);
			}
			if (minionHitBox.get(i).intersects(r3) == true) {

				creeps.get(i).changeDirection(0,2);
			}
			if (minionHitBox.get(i).intersects(r4) == true) {
				creeps.get(i).changeDirection(-2,0);
			}
			if (minionHitBox.get(i).intersects(r5) == true) {
				creeps.get(i).changeDirection(0,-2);
			}
			if (minionHitBox.get(i).intersects(r6) == true) {
				creeps.get(i).changeDirection(2,0);
			}
			if (minionHitBox.get(i).intersects(nexus) == true) {
				health -= 2;
				creeps.get(i).resetpos();
				minionHitBox.get(i).x = creeps.get(i).getx();
				minionHitBox.get(i).y = creeps.get(i).gety();
				creeps.get(i).changeDirection(0,0);
				if(i == minionHitBox.size()-1) {
					wave +=1;
					resetMinionPosition();
					addMinion();
				}
			}
		}
	}
	public static void resetMinionPosition() {
		for (int i = 0; i < creeps.size(); i++) {
			creeps.get(i).resetpos();
			minionHitBox.get(i).x = creeps.get(i).getx();
			minionHitBox.get(i).y = creeps.get(i).gety();
		}
	}
	public static void minionDeath() {
		for(int i = 0; i < creeps.size();i++) {
			if(creeps.get(i).getHealth()<=0) {
				minionCounter ++;
				gold += 25;
				creeps.get(i).resetpos();
				minionHitBox.get(i).x = creeps.get(i).getx();
				minionHitBox.get(i).y = creeps.get(i).gety();
				creeps.get(i).changeDirection(0,0);
				creeps.get(i).resetHealth();
			}
			if(minionCounter == wave) {
				wave +=1;
				Minion.levelUp();
				creeps.get(i).resetHealth();
				resetMinionPosition();
				addMinion();
				minionCounter =0;
			}
		}
	}
	public static void reseter () {
		
        gold = 1000;
        wave = 1;
        time = 20;
        health = 100;
        p = true;
        tower.clear();
        creeps.clear();
        minionHitBox.clear();
        AutoAttacks.clear();
        Minion.resetBaseHealth();
        g.setText("Gold:" + gold);
        w.setText("Wave:" + wave);
        h.setText("Health:" + health);
        bot.removeAll();
		frame.removeAll();
		frame.repaint();
        frame.repaint();
        frame.dispose();
    }
	
	private class Handlerclass implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			
		}
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
			
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
		}
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}
}