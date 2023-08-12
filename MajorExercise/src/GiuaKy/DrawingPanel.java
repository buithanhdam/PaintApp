package GiuaKy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class DrawingPanel extends JPanel{
	String shapeType="";
	StatusBar statusBar;
	Color color = Color.BLACK;
	Color colorb = Color.WHITE;
	AShape lastShape;
	Line line;
	List<AShape> shapes;
	int a= 0 , b =0,c=0,d=0;
	JButton button;
	
	Rectangle2D points ;
	Ellipse2D point1  =  new Ellipse2D.Double();
	Ellipse2D point2 = new Ellipse2D.Double();
	int pos = -1;
	int pos1 = -1;
	Graphics2D ex;
	float[] dash2 = {1f, 1f, 1f};
	BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

	

	
	boolean started = false;
	public DrawingPanel(StatusBar statusBar) {
		
	
		
		
		
		this.statusBar = statusBar;
		shapes = new ArrayList<AShape>();
		
		
		
		addMouseListener(new mouse());
		addMouseMotionListener(new mouse());
//		addMouseListener(new ShapeResizeHandler());
//		addMouseMotionListener(new ShapeResizeHandler());
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		setBackground(colorb);
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
	
	
		for(AShape sh:shapes) sh.draw(g2);
		
		
		
	}
	
	
	
	
	public void setShapeType(String type) {
		this.shapeType = type;
		switch (type) {
		case "L": this.statusBar.setMessage("Bạn đã chọn đường thẳng");
			break;
		case "C": this.statusBar.setMessage("Bạn đã chọn hình tròn");
			break;
		case "R": this.statusBar.setMessage("Bạn đã chọn hình chữ nhật");
			break;
			case "S": this.statusBar.setMessage("Bạn đã chọn hình vuông");
				break;
			case "E": this.statusBar.setMessage("Bạn đã chọn hình elispe");
				break;
			case "r": this.statusBar.setMessage("Bạn đã chọn ReSize ,kéo điểm đen để chỉnh lại kích thước cho hình");
			break;
			case "m": this.statusBar.setMessage("Bạn đã chọn Moving ,kéo hình để chỉnh lại vị trí cho hình");
			break;
			case "c": this.statusBar.setMessage("Bạn đã chọn Choose Shape ,click để chọn hình");
			break;
			case "d": this.statusBar.setMessage("Bạn đã chọn Delete ,click vào bất kỳ hình nào để xóa hình đó");
			break;
			
		}
	

	}
	public void setColorType(Color c) {
		this.color = c;
		
		this.statusBar.setMessage("Bạn đã chọn màu: "+c.toString());
		

	}
	public void setBColorType(Color c) {
		this.colorb = c;
		
		this.statusBar.setMessage("Bạn đã chọn màu: "+c.toString());
		

	}
	
	
	
	
	
	 
	 class mouse extends MouseAdapter{
		 private int x;
		 private int y;
		 double x1;
         double x2;
         double y1;
         double y2;
		private AShape as;
		Ellipse2D  p1;
		Ellipse2D  newp1;
		Ellipse2D newp123;
		
			@Override
			public void mouseClicked(MouseEvent e) {
//				 PointerInfo pi = MouseInfo.getPointerInfo();
//	                Point p = pi.getLocation();
//			point1  =  new Ellipse2D.Double(e.getX(),e.getY() ,8, 8);
	               
				 a = (int) e.getX();
				 b = (int) e.getY();
				if (started) {
					started = false;
					return;
				}
				switch (shapeType) {

				case "C": lastShape = new Circle(a,b  ,c,d, color,point1,point2);
				lastShape.setFirstPoint(a, b, point1);
					shapes.add(lastShape);
					started = true;
					break;
				case "L": lastShape = new Line( a,b ,c,d, color,point1,point2);
				lastShape.setFirstPoint(a, b, point1);
				shapes.add(lastShape);
				started = true;
				break;
				case "R": lastShape = new Rectangle(a, b,c,d ,color,point1,point2);
				lastShape.setFirstPoint(a, b, point1);
				shapes.add(lastShape);
				started = true;                                  
				break;
				case "S": lastShape = new Square(a,b,c,d, color,point1,point2);
				lastShape.setFirstPoint(a, b, point1);
				shapes.add(lastShape);
				started = true;
				break;
				case "E": lastShape = new Elispe(a, b,c,d, color,point1,point2);
				lastShape.setFirstPoint(a, b, point1);
				
				shapes.add(lastShape);
				started = true;
				break;
				
				
		
				case "c":
					 for(int i =0 ;i<shapes.size();i++) {
			            	as =shapes.get(i);
			            	as.visiblePoint(false);
			            	if (as.isHit(a, b)) {
//			            		pos = i;
//			            		pos1 = 5;	
			            		as.visiblePoint(true);
			            		 System.out.println("da cilck");
			            	}
			            
			            }
					
					
					
					break;
				case "d": for(int i =0 ;i<shapes.size();i++) {
	            	as =shapes.get(i);
	            	as.visiblePoint(false);
	            	if (as.isHit(a, b)) {
	            		shapes.remove(i);
	            		
	            		 System.out.println("da xoa");
	            	}
				}
				
				break;

					

				
					

				}	
				repaint();
				
				
			}
		
			@Override
			public void mousePressed(MouseEvent e) {
				
			Point p = e.getPoint();
			switch (shapeType){
			case "r": for(int i =0;i<shapes.size();i++) {
				AShape a = shapes.get(i);
				  
				if(a.point2.contains(p)) {
				;
					pos = i;
					pos1 = 2;
					
			
				}
				if(a.point1.contains(p)) {
					
					pos = i;
					
					pos1 = 3;
					 p1 = shapes.get(pos).point2;
				}
				
				
					
			}
			
			
			break;	
			
			
			
			case "m":
				x = e.getX();
            y = e.getY();
            for(int i =0 ;i<shapes.size();i++) {
            	as =shapes.get(i);
            	
            	if (as.isHit(x, y)) {
            		pos = i;
            		pos1 = 5;	
            		 shapes.get(pos).visiblePoint(false);
            		 System.out.println("da chon dc hinh can move");
            	}
            
            }
            break;
				
			}
			
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			pos = -1;
			pos1 = -1;
			
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				if (pos == -1) return; 
				if(pos1==5) {
					doMove(e);
				
			}
				repaint();
				if (pos == -1) return; 
				if (pos1 == 2) {
				
					newp1 = shapes.get(pos).point1;
					newp123 = shapes.get(pos).point2;
					Ellipse2D newp2 = new Ellipse2D.Double(e.getPoint().x,e.getPoint().y,8, 8);
					
					shapes.get(pos).visiblePoint(false);
					shapes.get(pos).setFirstPoint(newp1.getCenterX(), newp1.getCenterY(),newp1);
				
				shapes.get(pos).setSecondPoint(e.getPoint().x, e.getPoint().y,newp2);
				
//				shapes.get(pos).setFirstPoint(newp1.getCenterX(), newp1.getCenterY(),point1);
				
				}
				
				repaint();
				if (pos == -1) return;
				if (pos1 == 3) {
					Ellipse2D newp2 = shapes.get(pos).point2;
					Ellipse2D  newp1 = new Ellipse2D.Double(e.getPoint().x,e.getPoint().y,8, 8);
					shapes.get(pos).visiblePoint(false);
				
					
				 shapes.get(pos).setFirstPoint(newp1.getCenterX(),newp1.getCenterY() , newp1);
				shapes.get(pos).setSecondPoint(newp2.getCenterX(),newp2.getCenterY(),newp2);
				
				
				}
				
				repaint(); 
			}
			
			
			@Override
			public void mouseMoved(MouseEvent e) {
//				point2 = new Rectangle2D.Double(e.getX(),e.getY() ,8, 8);
			
			c= e.getX();
			d=e.getY();
				
				if (!started) return;
				lastShape.setSecondPoint(c,d,point2);
				repaint();
		
		
			
			}
			 private void doMove(MouseEvent e) {
		             
		            int dx = e.getX() ;
		            int dy = e.getY() ;
		            double x2 = shapes.get(pos).location1.getX();
		            double y2 = shapes.get(pos).location1.getY();
		            shapes.get(pos).fixLinePoint(x2+dx,y2+dy);
		            dx = dx -x;
		            dy = dy -y;
		            
		            point1= new Ellipse2D.Double();
		            		
		            double x1 = shapes.get(pos).location1.getX();
		            double y1 = shapes.get(pos).location1.getY();
//		            x1 +=dx;
//		            y1 +=dy;
		      
		            
		           
		           
		          
		            
//		            shapes.get(pos).fixLinePoint(x2+dx,y2+dy);
		            shapes.get(pos).visiblePoint(false);
			            	 shapes.get(pos).setFirstPoint(dx,dy, point1);
			            	 
			            	 
//			            	  x += dx;
//			                  y += dy; 
		            	 
			            	 
			            	
		            	
		                
		               
		            
		          
		        
		                    
		        }
			
			
			
			
		};
}

