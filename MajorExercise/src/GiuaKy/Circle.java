package GiuaKy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
public class Circle extends AShape {
//	private Rectangle2D point1  ;
//	private Rectangle2D point2 ;
	Ellipse2D c= new Ellipse2D.Double();
	double x = 0;
	double y = 0;
	int radius;
	
	public Circle(int x, int y,int x1,int y1, Color color,Ellipse2D point1,Ellipse2D point2) {
		super(x, y,x1,y1, color, point1, point1);
		radius = 1;
		
	}
	
	

	@Override
	public void draw(Graphics2D g) {
	
		g.setColor(color);
		
		
//		c.setFrame(location.x,location.x,2*radius,2*radius);
//		point2 = new Rectangle2D.Double(c.getMaxX()-radius,c.getMaxY() ,8, 8) ;
//		point1 =new Rectangle2D.Double(c.getMinX()+radius,c.getMinY() ,8, 8);
		c= new Ellipse2D.Double(this.x,this.y,2*radius,2*radius);
		
		g.fill(point1);
		g.fill(point2);

		g.draw(c);
	}


	@Override
	public void setSecondPoint(double x, double y,Ellipse2D point2) {
//		point2.setRect(c.getMaxX(), c.getMaxY(), 8, 8);
		this.point2=point2;
		radius = (int) Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));		
	}


	@Override
	public void setFirstPoint(double x, double y, Ellipse2D point1) {
	
		this.x =x;
		this.y=y;
		
		 
		
		this.point1=point1;
		
	}


	@Override
	public boolean isHit(float x, float y) {
		return c.getBounds2D().contains(x,y) ;
		
	}


	@Override
	public void visiblePoint(boolean a) {
		if(a==false) {
			point1 = new Ellipse2D.Double();
			point2 = new Ellipse2D.Double();
		}
		if(a==true) {
			point1 = new Ellipse2D.Double(c.getMinX(),c.getMinY(),8,8);
			point2 = new Ellipse2D.Double(c.getMaxX(),c.getMaxY(),8,8);
			
		}
		
		
	}


	@Override
	public void fixLinePoint(double x, double y) {
		// TODO Auto-generated method stub
		
	}





	}



	





