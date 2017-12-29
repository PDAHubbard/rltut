package rltut;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;
import rltut.screens.Screen;
import rltut.screens.StartScreen;

public class ApplicationMain extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6780592467346841408L;
	private AsciiPanel terminal;
	private Screen screen;
	
	public ApplicationMain() {
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}
	
	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}
	
	public static void main(String[] argv) throws SecurityException, IOException {
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
		Handler fh = new FileHandler("rltut.log");
		Logger.getLogger("").addHandler(fh);
		Logger.getLogger("rltut").setLevel(Level.FINEST);
	}

	@Override
	public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
