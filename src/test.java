import javax.swing.JFrame;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame screen = new JFrame();
		mouseTest test = new mouseTest();
		screen.add(test);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setSize(1000,1000);
		screen.setVisible(true);
		
	}

}
