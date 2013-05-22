import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Panel00 extends JPanel
{
	private JLabel label,pop,gen;
	private final JLabel[][] life;
	private final JLabel[][] temp;
   private Timer timer;  
	private int count;
	private boolean allow,isPaused,hasBorder;
	private final int r,c;
	private JButton random,button,clear,bord;
	public Panel00()
	{
		r = 50;
		c = 50;
		isPaused = true;
		life = new JLabel[r][c];
		temp = new JLabel[r][c];
      timer = new Timer(50, new TListener());
		setLayout(new BorderLayout());
		pop = new JLabel("");
		pop.setFont(new Font("Serif",Font.BOLD,20));
		pop.setForeground(Color.red);
		gen = new JLabel("");
		gen.setFont(new Font("Serif",Font.BOLD,20));
		gen.setForeground(Color.red);

						
// 		label = new JLabel("123");
// 		label.setFont(new Font("Serif",Font.BOLD,20));
// 		label.setForeground(Color.blue);
// 		add(label, BorderLayout.SOUTH);
		hasBorder = false;
		button = new JButton("Next Frame");
		button.addActionListener(new Listener());
		
		
		JButton toggle = new JButton("Pause/Resume");
		toggle.addActionListener(new PListener());
		count = 0;
		JPanel buttonz = new JPanel();
		buttonz.setLayout(new FlowLayout());
		random = new JButton("Randomize");
		random.addActionListener(new RListener());
		buttonz.add(random);	
		
		clear = new JButton("Clear");
		clear.addActionListener(new CListener());
		buttonz.add(clear);	
		bord = new JButton("Border Toggle");
		bord.addActionListener(new BListener());
		buttonz.add(bord);			
		add(buttonz,BorderLayout.SOUTH);
		
					
		allow = true;
		JPanel timing = new JPanel();
		timing.setLayout(new FlowLayout());
		timing.add(button);	
		timing.add(toggle);	
		JPanel allcont = new JPanel();
		allcont.setLayout(new GridLayout(2,1));
		

		
		JPanel lifecont = new JPanel();
		JPanel stats = new JPanel();
		stats.add(pop);
		stats.add(gen);
		allcont.add(stats);
		allcont.add(timing);
		add(allcont, BorderLayout.NORTH);
		
		lifecont.setLayout(new GridLayout(r,c));
		for(int x = 0; x<life.length;x++)
			for(int y = 0; y<life[0].length;y++)
			{
				temp[x][y] = new JLabel("Temp");
				life[x][y] = new JLabel("");
	 			life[x][y].setFont(new Font("Serif",Font.BOLD,20));
 				life[x][y].setForeground(Color.blue);
				life[x][y].setOpaque(true);
				temp[x][y].setOpaque(true);
				life[x][y].setBackground(Color.white);
				
 				lifecont.add(life[x][y]);				
				final JLabel cell = life[x][y];
				
				
				cell.addMouseListener(new MouseAdapter() {  //no error
            public void mousePressed(MouseEvent me){ 
					if(allow && cell.getBackground() == Color.white) 
					cell.setBackground(Color.black);
					else if(allow && cell.getBackground() == Color.black)
					cell.setBackground(Color.white);
					updateTotals();
             } 
	        });  
			}
			
			life[2][1].setBackground(Color.black);
			life[2][4].setBackground(Color.black);
			
			life[6][1].setBackground(Color.black);
			life[6][4].setBackground(Color.black);			
			
			life[3][1].setBackground(Color.black);
			life[3][2].setBackground(Color.black);
			life[3][3].setBackground(Color.black);
			life[3][4].setBackground(Color.black);
									
			
			life[5][1].setBackground(Color.black);
			life[5][2].setBackground(Color.black);
			life[5][3].setBackground(Color.black);
			life[5][4].setBackground(Color.black);		
			
			life[1][3].setBackground(Color.black);
			life[2][1].setBackground(Color.black);
			life[2][3].setBackground(Color.black);
			life[3][2].setBackground(Color.black);
			life[3][3].setBackground(Color.black);
			
			
			
			
				
					

			
			
			add(lifecont, BorderLayout.CENTER);
			updateTotals();
			
	}
	
       private class TListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
				react();
			}
		}	
		
       private class BListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
				if(!hasBorder){
				for(int x = 0; x<life.length;x++)
				for(int y = 0; y<life[0].length;y++)
				life[x][y].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				}
				if(hasBorder){
				for(int x = 0; x<life.length;x++)
				for(int y = 0; y<life[0].length;y++)
				life[x][y].setBorder(BorderFactory.createLineBorder(Color.gray, 0));
				}	
				hasBorder = !hasBorder;		

			}
		}			
		
       private class PListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
				if(isPaused)
				{
					button.setEnabled(false);
					timer.start();
				}
				else{
					timer.stop();
					button.setEnabled(true);
				}
				isPaused = !isPaused;
			}
		}			
	
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			react();
			allow = false;
			random.setText("New Game");
			

		}
	}
	
	private class CListener implements ActionListener//no error
	{
		public void actionPerformed(ActionEvent e)
		{
			count = 0;
			timer.stop();
			isPaused = true;
			allow = true;
			random.setText("Randomize");
			for(int b = 0; b<r; b++)
			for(int n = 0; n<c;n++)
			{
				life[b][n].setBackground(Color.white);
																				

			}
			updateTotals();
			button.setEnabled(true);

			
		}
	}	
	
	private class RListener implements ActionListener//no error
	{
		public void actionPerformed(ActionEvent e)
		{
			count = 0;
			timer.stop();
			isPaused = true;
			allow = true;
			random.setText("Randomize");

			int f = (int)(Math.random() * ((r + c)/5.0));
			for(int b = 0; b<r; b++)
			for(int n = 0; n<c;n++)
			{
				life[b][n].setBackground(Color.white);
																				

			}

			for(int v = 0; v<f;v++)
			{
				int x = (int)(Math.random() * r);
				int y = (int)(Math.random() * c);
				life[x][y].setBackground(Color.black);
				
				if(x > 0 && x < r - 1 && y > 0 && y < c - 1)
				{
					int ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x][y+1].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x][y-1].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x+1][y+1].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x-1][y+1].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x+1][y-1].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x-1][y-1].setBackground(Color.black);	
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x+1][y].setBackground(Color.black);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					life[x-1][y].setBackground(Color.black);										
					}
				}
			

				updateTotals();
		}
	}	
	
	public boolean hasLife(int row,int col)
	{
		if(life[row][col].getBackground() == Color.black)
		return true;
		return false;
	}
	
	public void setLife(int row, int col, boolean live)//no error
	{
		if(live)
		temp[row][col].setBackground(Color.black);		
		
		else
		temp[row][col].setBackground(Color.white);		
		
	
	}
	public int getLiveNeighbors(int x, int y) //no error
	{
		int neighbors = 0;
	if(x < r - 1){
	if(hasLife(x + 1,y))
	neighbors++;
	
	}
 
	
	if(x > 0){
	if(hasLife(x - 1,y))
	neighbors++;
	
	}
	
	if(y < c - 1){
	if(hasLife(x,y + 1))
	neighbors++;
	
	}
	
	if(y > 0){
	if(hasLife(x,y - 1))
	neighbors++;
	
	}

	
	if(x < r-1 && y < c - 1){
	if(hasLife(x + 1,y + 1))
	neighbors++;
	}
	
	if(x < r - 1 && y > 0){
	if(hasLife(x + 1,y - 1))
	neighbors++;
	}
	
	if(y < c - 1 && x > 0){
	if(hasLife(x - 1,y + 1))
	neighbors++;
	}
	
	if(y > 0 && x > 0){
	if(hasLife(x - 1 ,y - 1))
	neighbors++;
	}
		
	
				
		return neighbors;
	
	}
	
	public void react()
	{
		count++;
		for(int x = 0; x<life.length;x++)
		for(int y = 0; y<life[0].length;y++)
		{
			
		temp[x][y].setBackground(life[x][y].getBackground());

		int k = getLiveNeighbors(x, y);
		if(k < 2)
		setLife(x,y,false);
		if((k == 2 || k == 3) && hasLife(x,y) == true)
		setLife(x,y,true);
		if(k>3)
		setLife(x,y,false);
		if(k==3 && hasLife(x,y) == false)
		setLife(x,y,true);		
		
		
		}
		
		for(int x = 0; x<life.length;x++)
		for(int y = 0; y<life[0].length;y++)		
		life[x][y].setBackground(temp[x][y].getBackground());
		updateTotals();
		
	}
	public void updateTotals(){
		int popu = 0;		
		for(int x = 0; x<life.length;x++)
		for(int y = 0; y<life[0].length;y++){
			if(life[x][y].getBackground() == Color.black)
			popu++; 	
		}
		pop.setText("Population: " + popu);
		gen.setText("Generation: " + count);	
	}
	


}