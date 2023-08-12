package GiuaKy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
public class Rectangle extends AShape{
	Rectangle2D r = new Rectangle2D.Double();
	double x = 0;
	double y = 0;
	int width;
	int height;
	public Rectangle(int x, int y,int x1,int y1, Color color,Ellipse2D point1,Ellipse2D point2) {
		super(x, y,x1,y1, color,point1,point2);
		width = 1;
		height = 1;
		}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		r.setRect(this.x, this.y, width, height);
		
		g.fill(point1);
		g.fill(point2);	
		
		
		g.draw(r);
		
	}


	@Override
	public void setSecondPoint(double x, double y,Ellipse2D point2) {
		this.point2=point2;
		width = (int) (Math.abs(this.x- x));
         
        height = (int) (Math.abs(this.y- y) );	
	}

	@Override
	public void setFirstPoint(double x, double y, Ellipse2D point1) {
		this.x=x;
		this.y=y;
		this.point1=point1;
		
	}

	@Override
	public boolean isHit(float x, float y) {
		
		return r.getBounds2D().contains(x,y) ;
	}
	@Override
	public void visiblePoint(boolean a) {
		if(a==false) {
			point1 = new Ellipse2D.Double();
			point2 = new Ellipse2D.Double();
		}
		if(a==true) {
			point1 = new Ellipse2D.Double(r.getMinX()-8,r.getMinY()-8,8,8);
			point2 = new Ellipse2D.Double(r.getMaxX(),r.getMaxY(),8,8);
			
		}
		
		
	}

	@Override
	public void fixLinePoint(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}
