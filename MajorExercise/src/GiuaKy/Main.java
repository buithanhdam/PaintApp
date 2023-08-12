package GiuaKy;

import java.awt.BorderLayout;

import javax.swing.*;
public class Main extends JFrame{
	ToolBar toolBar;
	DrawingPanel drawingPanel;
	
	StatusBar statusBar ;
	Menubar menu ;
	
	public Main() {
		
		super("My Painter");
		
		
		statusBar = new StatusBar();
		drawingPanel = new DrawingPanel(statusBar);
		menu = new Menubar(drawingPanel);
		toolBar = new ToolBar(drawingPanel);
		
		getContentPane().add(toolBar, BorderLayout.WEST);
		getContentPane().add(drawingPanel, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		
		setJMenuBar(menu);
		setSize(900,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();

	}

}
