package GiuaKy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ToolBar extends JPanel{
	DrawingPanel drawingPanel;
	Icon icon = new ImageIcon();
	public ToolBar(DrawingPanel drawingPanel) {
		JButton button;
		this.drawingPanel = drawingPanel;
		
		ActionListener action = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String com = e.getActionCommand();
				drawingPanel.setShapeType(com);
			}
		};
		
		
        JPanel bpanel = new JPanel();
        bpanel.setLayout(new GridLayout(13,1,5,5));
        
		
		icon = new ImageIcon("icons8-line-24.png");
		
		button = new JButton(icon);
	
		
		button.addActionListener(action);
		button.setActionCommand("L");
		bpanel.add(button);
		icon = new ImageIcon("icons8-circle-24.png");
		button = new JButton(icon);
		
		button.addActionListener(action);
		button.setActionCommand("C");
		bpanel.add(button);
		icon = new ImageIcon("icons8-rectangle-24.png");
		button = new JButton(icon);
		
		button.addActionListener(action);
		button.setActionCommand("R");
		bpanel.add(button);
		
		icon = new ImageIcon("ellipse.png");
		button = new JButton(icon);
	
		button.addActionListener(action);
		button.setActionCommand("E");
		bpanel.add(button);
		icon = new ImageIcon("icons8-rounded-square-24.png");
button = new JButton(icon);
		
		button.addActionListener(action);
		button.setActionCommand("S");
		bpanel.add(button);
//		tao mau
		icon = new ImageIcon("color-circle.png");
		button = new JButton(icon);
		
		button.addActionListener(new changeColor());
		bpanel.add(button);
		icon = new ImageIcon("icons8-color-wheel-24.png");
		button = new JButton(icon);
		
		button.addActionListener(new changeBColor());
		bpanel.add(button);
		
		icon = new ImageIcon("tap.png");
		button=new JButton(icon);
		button.setActionCommand("c");
		button.addActionListener(action);
		bpanel.add(button);
		
		icon = new ImageIcon("expand-view.png");
		button=new JButton(icon);
		button.setActionCommand("r");
		button.addActionListener(action);
		bpanel.add(button);
		
		
	
		icon = new ImageIcon("move.png");
		button=new JButton(icon);
		button.setActionCommand("m");
		button.addActionListener(action);
		bpanel.add(button);


		icon = new ImageIcon("delete.png");
		button=new JButton(icon);
		button.setActionCommand("d");
		button.addActionListener(action);
		bpanel.add(button);
		
		
		
		
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
		add(bpanel,gbc);
		
	}
	class changeColor implements ActionListener {
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JColorChooser choose = new JColorChooser();
		Color c = choose.showDialog(null, "Change Shape Color", Color.BLACK);
		
		drawingPanel.setColorType(c);
		
	}
	
	
	}
	class changeBColor implements ActionListener {
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			JColorChooser choose = new JColorChooser();
			Color c = choose.showDialog(null, "Change Background Color", Color.BLACK);
			
			drawingPanel.setBColorType(c);
			
		}
		
		
		}
	
	
	
}