package com.liveclock;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
	
//	private JLabel heading;
	private JLabel clockLabel;
	private JLabel dateLabel;
	private Font font = new Font("",Font.BOLD,30);
	
	Window(){
		super.setTitle("Live Clock");
		super.setSize(240, 180);
		super.setLocation(300, 150);
		this.createGUI();
		this.startClock();
		super.setVisible(true);
	}

	public void createGUI() {
//		heading=new JLabel("Live Clock");
		clockLabel=new JLabel("Clock");
		dateLabel=new JLabel("Clock");
//		heading.setFont(font);
		clockLabel.setFont(font);
		dateLabel.setFont(font);
		
		this.setLayout(new GridLayout(2,1));
//		this.add(heading);
		this.add(clockLabel);
		this.add(dateLabel);
	}
	
	private void startClock() {
		Thread t=new Thread() {
			public void run() {
				try {
					while(true) {
						Date d=new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
						SimpleDateFormat sdf2 = new SimpleDateFormat("dd / MM / yyyy");
						String dateTime=sdf.format(d);
						String dateTime2=sdf2.format(d);
						clockLabel.setText(dateTime);
						dateLabel.setText(dateTime2);
						Thread.currentThread().sleep(1000);
					}
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		
		t.start();
		
	}
}
