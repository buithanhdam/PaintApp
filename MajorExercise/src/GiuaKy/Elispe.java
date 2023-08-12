package GiuaKy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
public class Elispe extends AShape {
	int radius;
	double x ;
	double y ;
	Ellipse2D e = new Ellipse2D.Double();
	public Elispe(int x, int y,int x1,int y1, Color color,Ellipse2D point1,Ellipse2D point2) {
		super(x, y,x1,y1, color,point1,point2);
		radius = 1;
	}
	

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		e= new Ellipse2D.Double(this.x,this.y,1.5*radius,radius);
		
		g.fill(point1);
		
		g.fill(point2);
		
		g.draw(e);
	}
	@Override
	public void setFirstPoint(double x, double y, Ellipse2D point1) {
		
		this.x=x;
		this.y=y;
		this.point1=point1;
		
		
	}

	@Override
	public void setSecondPoint(double x, double y,Ellipse2D point2) {
//		point2.setRect(e.getMaxX(), e.getMaxY(), 8, 8);
		this.point2=point2;
		
		
		radius = (int) Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));		
	}





	@Override
	public boolean isHit(float x, float y) {
		
		return e.getBounds2D().contains(x,y) ;
	}
	@Override
	public void visiblePoint(boolean a) {
		if(a==false) {
			point1 = new Ellipse2D.Double();
			point2 = new Ellipse2D.Double();
		}
		if(a==true) {
			point1 = new Ellipse2D.Double(e.getMinX(),e.getMinY(),8,8);
			point2 = new Ellipse2D.Double(e.getMaxX(),e.getMaxY(),8,8);
			
		}
	}


	@Override
	public void fixLinePoint(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}