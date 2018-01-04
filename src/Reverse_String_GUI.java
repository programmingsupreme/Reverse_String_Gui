import java.applet.Applet;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.*;
import java.lang.StringBuilder;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class Reverse_String_GUI extends Applet implements ActionListener{
	
	Label l = new Label("Reverse a String GUI created by Vikram Nadathur");
	
	StringBuilder sb;
	
	String default_text  = "Enter a sentence or word to convert";
	
	String reversed = "";
	
	boolean changebuttoncolor = false;
	
	byte outputcolor = 1;
	
	TextField input = new TextField(default_text);
	
	TextField output = new TextField(30);
	
	Button b = new Button("Reverse String");
	
	Image background;
	
	Font outputfont;
	
	public void init(){
		
		setSize(1000,800);
		setBackground(Color.GREEN);
		
		background = getImage(getCodeBase(),"StringGuiBackground.png");
		
		add(l);
		
		input.setEditable(true);
		input.setBackground(Color.decode("#ffff80"));
		add(input);
		
		b.setLocation(500, 400);
		add(b);
		
		output.setEditable(false);
		
		try {
			outputfont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("\\C:\\Users\\Vikram\\Downloads\\FORTE.ttf"))).deriveFont(Font.PLAIN, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		output.setFont(outputfont);
		add(output);
		
		b.addActionListener(this);
		
	}
	
	public void paint(Graphics g) {
		
		output.setText(reversed);
		g.drawImage(background, 300, 300, 500, 400, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b) {
			
			if(!changebuttoncolor) {
			
				b.setBackground(Color.decode("#0affe2"));
				changebuttoncolor = true;
			
			}
			else {
				
				b.setBackground(Color.decode("#3399ff"));
				changebuttoncolor = false;
			}
			
			if(outputcolor == 1) {
				
				output.setBackground(Color.decode("#ffcc66"));
				
				outputcolor++;
				
			}
			else if(outputcolor == 2) {
				
				output.setBackground(Color.decode("#aaff00"));
				
				outputcolor++;
				
			}
			else {
				
				output.setBackground(Color.decode("#00ffff"));
				
				outputcolor = 1;
				
			}
			
			
			output.setText(reversestring(input.getText()));
			
		}
		
	}
	

	private String reversestring(String text) {
		
		StringBuilder sb = new StringBuilder(text);
		
		StringBuilder reversed = sb.reverse();
			
		return reversed.toString();
	}


}
