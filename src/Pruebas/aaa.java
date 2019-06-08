package Pruebas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class aaa {

	public aaa() {
		JFrame frame = new JFrame ("Test");
		frame.setSize(500,500);
		frame.setResizable(false);
		//

		//TEXT AREA
		JTextArea textArea = new JTextArea("TEST");
		textArea.setSize(400,400);    

		    textArea.setLineWrap(true);
		    textArea.setEditable(true);
		    textArea.setVisible(true);

		    JScrollPane scroll = new JScrollPane (textArea);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		    frame.add(scroll);
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
	}
}
