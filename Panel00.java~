import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.*;
import java.applet.Applet;
import java.net.URL;

import javax.sound.sampled.*;



public class Panel00 extends JPanel
{
	private JLabel label,pop,gen;
	private static Applet music;
	private final JLabel[][] life;
	private final JLabel[][] temp;
   private Timer timer;  
	private Clip clip;
	private int count;
	private boolean allow,isPaused,hasBorder,musicPlaying,disco;
	private final int r,c;
	private JButton random,button,clear,bord,sound,disc;
	public Panel00(){

		URL mediaURL = this.getClass().getResource("background.wav");

		musicPlaying = true;
		disco = false;
		r = 50;
		c = 50;
		isPaused = true;
		life = new JLabel[r][c];
		temp = new JLabel[r][c];
      timer = new Timer(75, new TListener());
		setLayout(new BorderLayout());
		pop = new JLabel("");
		pop.setFont(new Font("Serif",Font.BOLD,20));
		pop.setForeground(Color.red);
		gen = new JLabel("");
		gen.setFont(new Font("Serif",Font.BOLD,20));
		gen.setForeground(Color.red);

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
		sound = new JButton("Toggle Sound");
		sound.addActionListener(new SListener());
		buttonz.add(sound);					
		add(buttonz,BorderLayout.SOUTH);
		disc = new JButton("Toggle Disco!");
		disc.addActionListener(new DListener());
		buttonz.add(disc);					
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
					indChange(cell);
					else if(allow && cell.getBackground() != Color.white)
					cell.setBackground(Color.white);
					updateTotals();
             } 
	        });  
			}
			try{
        clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(mediaURL);
			clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);			
		  }
		  catch(Exception e){}
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
		
       private class DListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
				if(!disco)
				for(int x = 0; x<life.length;x++)
				for(int y = 0; y<life[0].length;y++)
				if(life[x][y].getBackground() != Color.white)
				life[x][y].setBackground(randColor());
				if(disco)
				for(int x = 0; x<life.length;x++)
				for(int y = 0; y<life[0].length;y++)
				if(life[x][y].getBackground() != Color.white)				
				life[x][y].setBackground(Color.black);				
				disco = !disco;
				
			}
		}			
		
       private class SListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
 				if(musicPlaying)
 				clip.stop();
 				else{
				clip.loop(-1);
				clip.start();
				}
				musicPlaying = !musicPlaying;
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
				allow = false;
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
			button.setEnabled(true);
		
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
				discoChange(x,y);
				
				if(x > 0 && x < r - 1 && y > 0 && y < c - 1)
				{
					int ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x,y+1);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x,y-1);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x+1,y+1);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x-1,y+1);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x+1,y-1);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x-1,y-1);	
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x+1,y);
					
					ne = (int)(Math.random() + 0.5);
					if(ne == 1)
					 discoChange(x-1,y);										
					}
				}
			

				updateTotals();
		}
	}	
	
	public boolean hasLife(int row,int col)
	{
		if(life[row][col].getBackground() != Color.white)
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
		if(temp[x][y].getBackground() != Color.white)	
		{
		if(disco)
		life[x][y].setBackground(randColor());
		else
		life[x][y].setBackground(Color.black);
		}
		else
		life[x][y].setBackground(Color.white);		
		updateTotals();
		
	}
	
	public Color randColor(){
	int q = (int)(Math.random() * 8);
	switch(q){
	case 1:return Color.red;
	 
	case 2:return Color.blue;
	 
	case 3:return Color.green;
	 
	case 4:return Color.magenta;
	 
	case 5:return Color.yellow;
	 
	case 6:return Color.orange;
	 
	case 7:return Color.cyan;
	 
						
	}
	return Color.black;
	
	}
	public void updateTotals(){
		int popu = 0;		
		for(int x = 0; x<life.length;x++)
		for(int y = 0; y<life[0].length;y++){
			if(life[x][y].getBackground() != Color.white)
			popu++; 	
		}
		pop.setText("Population: " + popu);
		gen.setText("Generation: " + count);	
	}
	
	public void discoChange(int x, int y){
	if(disco)
	life[x][y].setBackground(randColor());
	else
	life[x][y].setBackground(Color.black);
	}
	
	public void indChange(JLabel a){
	if(disco)
	a.setBackground(randColor());
	else
	a.setBackground(Color.black);
	}	


}
