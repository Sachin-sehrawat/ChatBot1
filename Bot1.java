package com.learning;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEnter = new JTextField();
	private JTextArea txtChat = new JTextArea();

	// this constructor class will show the layout of the whole window
	public Bot1() {
		// scrollbar

		// font
		Font font = new Font("Courier New", Font.BOLD, 18);
		Font font1 = new Font(" Josefin Slab", font.ITALIC, 15);

		txtEnter.setFont(font1);

		// icon
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Users\\sachin\\Desktop\\aa.png");
		this.setIconImage(icon);
		getContentPane().setLayout(null);
		this.setSize(800, 800);
		this.setVisible(true);
		// window attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(560, 600);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);
		this.setTitle("PAPPU");
		// menu bar

		// text area
		txtEnter.setLocation(2, 540);
		txtEnter.setSize(530, 30);
		txtEnter.setSelectedTextColor(Color.green);
		// txt chat
		getContentPane().add(txtEnter);
		txtChat.setSize(540, 540);
		getContentPane().add(txtChat);
		// text ENter action
		txtEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uText = txtEnter.getText();
				txtChat.append("" + "you:" + uText + "\n"); // answer to show in text area
				// question-answered by bot goes here
				if (uText.equals("hi") || uText.equals("hello")) {
					botSay("hello there");
				} else if (uText.contains("what's your name")) {
					botSay("I'm chatbot");
				} else if (uText.contains("launch notepad")) {
					notepad();
				} else if (uText.contains("do you like me")) {
					botSay("Yeah,you are a nice person");
				} else if (uText.contains("who created you") || uText.contains("who made you")) {
					botSay("Sachin");
				} else if (uText.contains("what's the time bot") || uText.contains("show me the time")) {
					setdate();
				}

				else if (uText.contains("how are you") || uText.contains("how you doin")) {
					int decider = (int) (Math.random() * 2 + 1);
					if (decider == 1) {
						botSay("I am doing well,thanks");
					} else if (decider == 2) {
						botSay("not to bad");
					}
				} else if (uText.contains("who created you")) {
					botSay("sachin");
				} else if (uText.contains("sing a song")) {
					sing();
				} else if (uText.contains("who is the most stupid person")) {
					botSay("Varsha Sehrawat");
				} else if (uText.contains("launch google") || uText.contains("search google")) {
					google();
				} else if (uText.contains("launch facebook") || uText.contains("facebook")) {
					facebook();
				} else if (uText.contains("do an impression") || uText.contains("please do an impression")
						|| uText.contains("please chatbot do an impression")) {
					int decider1 = (int) (Math.random() * 3 + 1);
					if (decider1 == 1) {
						botSay("mukgamoo Khuss hua!!");
					} else if (decider1 == 2) {
						botSay("Go TO Hell!!!");
					} else if (decider1 == 3) {
						botSay("i can't do that at this time");
					}
				} else if (uText.contains("tell me a joke") || uText.contains("make me laugh")) {
					int decider2 = (int) (Math.random() * 2 + 1);
					if (decider2 == 1) {
						botSay("Britain has invented a new missile. It's called the civil servant - it doesn't work and it can't be fired.");
					}
					if (decider2 == 2) {
						botSay("What do you call an Englishman with an IQ of 50?  Colonel, sir");
					}
				} else if (uText.contains("are you stupid")) {
					warning();
				}

				else {
					int decider = (int) (Math.random() * 3 + 1);// (int)(math.random()3*1); for generating random num
					if (decider == 1) {
						botSay("I didn,t get that");
					} else if (decider == 2) {
						botSay("please rephrase that");
					} else if (decider == 3) {
						botSay("???");
					}
				}
				txtEnter.setText("");

			}
		});
		// chat area
		txtChat.setLocation(6, 6);
		txtChat.setSize(540, 520);
		txtChat.setEditable(true);
		getContentPane().add(txtChat);

	}
	// text to speech

	// botsay method
	public void botSay(String s) {
		txtChat.append("" + "AI:" + s + "\n");

	}

	// warning
	public void warning() {
		txtChat.append("AI:" + "NEVER SAY THAT AGAIN" + "\n");

	}

	// date method
	public void setdate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		txtChat.append(dateFormat.format(cal.getTime()));
	}

	// launch google method
	public void google() {
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			URI oURL = new URI("http://www.google.com");
			desktop.browse(oURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// launch facebook method
	public void facebook() {
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			URI oURL = new URI("http://www.facebook.com");
			desktop.browse(oURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// launch notepad
	public void notepad() {
		try {
			Runtime.getRuntime().exec("notepad.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// launch sing method
	public void sing() {
		try {
			Runtime.getRuntime().exec("D:\\music\\002 RDB.mp3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Bot1(); // calling bot1 constructor

	}
}
