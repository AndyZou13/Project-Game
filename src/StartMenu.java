import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class StartMenu {
	public static ArrayList <JTextField> a = new ArrayList <JTextField> (); //These ArrayLists are to store the high scores names and waves
	public static ArrayList <JTextField> b = new ArrayList <JTextField> ();
	public static JTextField htitle = new JTextField("Scores");
	public static JTextField hname = new JTextField("Name");
	public static JTextField hwave = new JTextField("Waves");
	public static JFrame window = new JFrame ("Minion Defender Remastered");
	private static ImageIcon[] images = new ImageIcon[1];
	private static ImageIcon img = new ImageIcon ("MainBack.jpg");
	private static TreeSet <Scores> high = new TreeSet <Scores> ();
	public static int options = 0;
	public static JButton playagain = new JButton("Play Again?");
	public static JButton exit = new JButton("Exit");
	public static JButton play = new JButton ("PLAY");
	public static JButton howto = new JButton ("How to play");
	public static JButton highsc = new JButton ("Highscores");
	private static JPanel menu = new JPanel () {
		protected void paintComponent (Graphics g) { //to draw the background
			super.paintComponent(g);
			g.drawImage(images[0].getImage(), 0, 0, null);
		}
	};
	private static JPanel pic = new JPanel() {
		protected void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.drawImage(images[0].getImage(), 0, 0, null);
		}
	};
	private static JPanel highs = new JPanel() {
		protected void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.drawImage(images[0].getImage(), 0, 0, null);
			window.add(highs);
		}
	};
	private static void Menu() { //No input, This method draws the main screen with the play, how to, and high score button
		images[0] = new ImageIcon (img.getImage().getScaledInstance(852, 520, Image.SCALE_SMOOTH));
		menu.setLayout(null);
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setFocusPainted(false);
		play.setContentAreaFilled(false);
		play.setForeground(Color.yellow);
		play.setBounds(326, 200, 200, 40);
		play.setFont(new Font("Arial", Font.BOLD, 28));
		play.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				System.out.println("1");
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				System.out.println("0");
			}


		});

		howto.setOpaque(false);
		howto.setContentAreaFilled(false);
		howto.setBorderPainted(false);
		howto.setFocusPainted(false);
		howto.setContentAreaFilled(false);
		howto.setForeground(Color.yellow);
		howto.setBounds(326, 250, 200, 40);
		howto.setFont(new Font("Arial", Font.BOLD, 28));
		howto.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				System.out.println("1");
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				System.out.println("0");
			}
		});

		highsc.setOpaque(false);
		highsc.setContentAreaFilled(false);
		highsc.setBorderPainted(false);
		highsc.setFocusPainted(false);
		highsc.setContentAreaFilled(false);
		highsc.setForeground(Color.yellow);
		highsc.setBounds(325, 300, 200, 40);
		highsc.setFont(new Font("Arial", Font.BOLD, 28));
		highsc.addMouseListener(new java.awt.event.MouseAdapter() { //checking if the mouse has crossed into the button area
			public void mouseEntered(java.awt.event.MouseEvent e) {
				System.out.println("1");
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				System.out.println("0");
			}
		});

		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				options = 1;
			}

		});
		howto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				pic.setVisible(true);
				menu.setVisible(false);
				options = 2;
			}

		});
		highsc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				highs.setVisible(true);
				menu.setVisible(false);
				options = 3;
			}

		});
		menu.add(play);
		menu.add(howto);
		menu.add(highsc);
		play.setVisible(true);
		highsc.setVisible(true);
		howto.setVisible(true);
		playagain.setVisible(false);
		exit.setVisible(false);
		window.add(menu);
		window.setPreferredSize(new Dimension(852, 520));
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void highScore() throws IOException{ //no input, this method displays the high score screen, it also takes in the input from a file and adds it to an arraylist to store
													   //It also displays it all into its own JTextField, it displays the top 5 scores
		BufferedReader inFile;
		try {
			inFile = new BufferedReader (new FileReader("Highscore.txt"));
			while (inFile != null && high.size() < 21) {
				String in = inFile.readLine();
				String [] words = in.split(" ");
				if (words.length == 2)
					high.add(new Scores(words[0], Integer.parseInt(words[1])));
			}
			inFile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found!!");
		}
		Iterator <Scores> iter = high.iterator(); //iterates through the score TreeSet
		htitle.setBounds(20, 10, 200, 10);
		htitle.setEditable(false);
		htitle.setSize(new Dimension (200, 25));
		htitle.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		htitle.setOpaque(false);
		htitle.setForeground(Color.yellow);
		htitle.setFont(new Font("Arial", Font.BOLD, 26));
		highs.add(htitle);
		hname.setBounds(20, 50, 200, 10);
		hname.setEditable(false);
		hname.setForeground(Color.yellow);
		hname.setSize(new Dimension (200, 25));
		hname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		hname.setOpaque(false);
		hname.setFont(new Font("Arial", Font.BOLD, 26));
		highs.add(hname);
		hwave.setBounds(300, 50, 200, 10);
		hwave.setEditable(false);
		hwave.setForeground(Color.yellow);
		hwave.setSize(new Dimension (200, 25));
		hwave.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		hwave.setOpaque(false);
		hwave.setFont(new Font("Arial", Font.BOLD, 26));
		highs.add(hwave);
		for (int i = 0; iter.hasNext() && i < 5; i ++) { //draws all the JTextFields for the scores in High score screen
			Scores k = iter.next();
			System.out.println(k.getName());
			System.out.println(k.getWave());
			a.add(new JTextField(k.getName()));
			a.get(i).setBounds(20, (i + 100) + (60* i), 500, 50);
			a.get(i).setEditable(false);
			a.get(i).setSize(new Dimension (200, 25));
			a.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());
			a.get(i).setOpaque(false);
			a.get(i).setForeground(Color.yellow);
			a.get(i).setFont(new Font("Arial", Font.BOLD, 26));
			highs.add(a.get(i));
			b.add(new JTextField(Integer.toString(k.getWave())));
			b.get(i).setBounds(300, (i + 100) + (60* i), 500, 50);
			b.get(i).setEditable(false);
			b.get(i).setSize(new Dimension (200, 25));
			b.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());
			b.get(i).setOpaque(false);
			b.get(i).setForeground(Color.yellow);
			b.get(i).setFont(new Font("Arial", Font.BOLD, 26));
			highs.add(b.get(i));
		}
		JButton back = new JButton ("Back to menu");
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setForeground(Color.yellow);
		back.setBounds(610, 440, 250, 40);
		back.setFont(new Font("Arial", Font.BOLD, 28));
		back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				menu.setVisible(true);
				highs.setVisible(false);
				options = 0;
			}

		});
		highs.add(back);
		highs.setLayout(null);
		window.add(highs);
		window.setPreferredSize(new Dimension(852, 520));
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.repaint();
	}

	public static void howTo () { //no input, draws the background and has the instruction as to how to play and the mechanics
		pic.setLayout(null);
		JButton back = new JButton ("Back to menu");
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setForeground(Color.yellow);
		back.setBounds(610, 440, 250, 40);
		back.setFont(new Font("Arial", Font.BOLD, 28));
		back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) { //will run commands once clicked
				menu.setVisible(true);
				pic.setVisible(false);
				options = 0;
			}

		});
		back.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				System.out.println("1");
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				System.out.println("0");
			}
		});
		JTextArea ins = new JTextArea();
		ins.setBounds(25, 175, 842, 510);
		ins.setText("This is how to play. You start off with 500 gold and an empty square. You get to buy \nchampions to place on the field to defend your nexus from the minions. Your nexus \nhas 100 health and each minion does 10 damage. "
				+ "Your gold is to get the highest \nscore by surviving to a high wave. Click on the desired place on the field, then \nclick the champion to place it and buy it. Good luck on defending you nexus :)");
		ins.setOpaque(false);
		ins.setForeground(Color.yellow);
		ins.setFont(new Font("Arial", Font.BOLD, 20));
		pic.add(back);
		pic.add(ins);
		window.add(pic);
		window.setPreferredSize(new Dimension(852, 520));
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void end () { // no input, this is for the end screen when someone who is playing finally loses all the health of the nexus
		//		playagain.setBounds(150, 200, 250, 100);
		//		playagain.setOpaque(false);
		//		playagain.setContentAreaFilled(false);
		//		playagain.setBorderPainted(false);
		//		playagain.setFocusPainted(false);
		//		playagain.setContentAreaFilled(false);
		//		playagain.setForeground(Color.yellow);
		//		playagain.setFont(new Font("Arial", Font.BOLD, 28));
		//		playagain.addActionListener(new java.awt.event.ActionListener() {
		//            @Override
		//            public void actionPerformed(java.awt.event.ActionEvent e) {
		//                String name = JOptionPane.showInputDialog(window, "Please input name (3 letters)", null);
		//                while (name != null || name.length() != 3) {
		//                    name = JOptionPane.showInputDialog(window, "Please input name (3 letters)", null);
		//                }
		//                if (name != null && name.length() == 3) {
		//                    try {
		//                        PrintWriter p = new PrintWriter (new FileWriter ("Highscore.txt", true));
		//                        p.println(name + " " + gamehi.wave);
		//                        p.close();
		//                        gamehi.reseter();
		//                        options = 0;
		//          
		//                    }
		//                    catch (IOException l) {
		//                        System.out.println("writing error!");
		//                    }
		//                }
		//            }
		//        });
		//menu.add(playagain);
		exit.setBounds(350, 200, 150, 100);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setForeground(Color.yellow);
		exit.setFont(new Font("Arial", Font.BOLD, 28));
		exit.addActionListener(new java.awt.event.ActionListener() {			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String name = JOptionPane.showInputDialog(window, "Please input name (3 letters)", null); //popup window
				while (name == null || (name.length() >3)) {
					name = JOptionPane.showInputDialog(window, "Please input name (3 letters)", null);

				}
				if (name != null ) {
					try {
						PrintWriter p = new PrintWriter (new FileWriter ("Highscore.txt", true)); //writing to the file
						p.println(name + " " + (gamehi.wave-1));
						p.close();
						System.exit(0);

						//                      gamehi.reseter();
						//                      options = 0;

					}
					catch (IOException l) {
						System.out.println("writing error!");
					}
				}


				options = 0;
				//System.exit(0);
			}
		});
		menu.add(exit);
		play.setVisible(false);
		highsc.setVisible(false);
		howto.setVisible(false);
		playagain.setVisible(true);
		exit.setVisible(true);
		window.repaint();
	}

	public static void main(String[] args) throws IOException, InterruptedException{ //main running code
		while (options > -1) { //constantly checking which option is choosen
			if (options == 0)
				Menu();
			if (options == 1) {
				new gamehi();
				window.hide();
				gamehi.starter();
				window.show();
				while(options == 1)
					end();

			}
			if (options == 2) {
				howTo();

			}
			if (options == 3) {
				highScore();
			}
			System.out.println(options);
		}
	}

}