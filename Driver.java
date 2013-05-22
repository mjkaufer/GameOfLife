import javax.swing.JFrame;

public class Driver
{
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Conway's Game of Life");
		frame.setSize(650,650);
		frame.setLocation(0,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Panel00());
		frame.setVisible(true);
	}
	
}