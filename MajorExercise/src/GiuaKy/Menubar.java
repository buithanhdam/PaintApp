package GiuaKy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar{
	DrawingPanel drawingpanel;
	
	JMenu draw ;
	JMenu color ; 
	JMenu modify;
	
	JMenuItem line;
	JMenuItem circle;
	JMenuItem rectangle;
	JMenuItem square;
	JMenuItem elispe;
	
	JMenuItem shapecolor;
	JMenuItem backcolor;
	
	JMenuItem choose;
	JMenuItem resize;
	JMenuItem move;
	JMenuItem delete;
	
	public Menubar(DrawingPanel drawingpanel) {
		this.drawingpanel=drawingpanel;
		
		ActionListener action = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String com = e.getActionCommand();
				drawingpanel.setShapeType(com);
			}
		};
		
		draw = new JMenu("Draw Shape");
		line = new JMenuItem("Draw Line");
		line.addActionListener(action);
		line.setActionCommand("L");
		circle = new JMenuItem("Draw Circle");
		circle.addActionListener(action);
		circle.setActionCommand("C");
		rectangle = new JMenuItem("Draw Rectangle");
		rectangle.addActionListener(action);
		rectangle.setActionCommand("R");
		square = new JMenuItem("Draw Square");
		square.addActionListener(action);
		square.setActionCommand("S");
		elispe = new JMenuItem("Draw Elispe");
		elispe.addActionListener(action);
		elispe.setActionCommand("E");
		
		
		
		
		
		
		
		draw.add(line);
		draw.add(circle);
		draw.add(rectangle);
		draw.add(square);
		draw.add(elispe);
		add(draw);
		
		
		
		color = new JMenu("Change Color");
		shapecolor = new JMenuItem("Change Shape Color");
		shapecolor.addActionListener(new changeColor());
		backcolor = new JMenuItem("Change BackGround Color");
		backcolor.addActionListener(new changeBColor());
		color.add(shapecolor);
		color.add(backcolor);
		add(color);
		
		
		
		modify = new JMenu("Modify");

		choose = new JMenuItem("Choose Shape");
		choose.addActionListener(action);
		choose.setActionCommand("c");
		resize = new JMenuItem("Resize");
		resize .addActionListener(action);
		resize .setActionCommand("r");
		move = new JMenuItem("Moving");
		move.addActionListener(action);
		move.setActionCommand("m");
		delete = new JMenuItem("Delete Shape");
		delete.addActionListener(action);
		delete.setActionCommand("d");
		
		modify.add(choose);
		modify.add(resize);
		modify.add(move);
		modify.add(delete);
		
		add(modify);
		
		
		
		
	}
	class changeColor implements ActionListener {
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			JColorChooser choose = new JColorChooser();
			Color c = choose.showDialog(null, "Change Shape Color", Color.BLACK);
			
			drawingpanel.setColorType(c);
			
		}
		
		
		}
		class changeBColor implements ActionListener {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser choose = new JColorChooser();
				Color c = choose.showDialog(null, "Change Background Color", Color.BLACK);
				
				drawingpanel.setBColorType(c);
				
			}
			
			
			}
	
}
