package GiuaKy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
public class Square extends AShape{
	double x = 0;
	double y = 0;
	int canh;
	Rectangle2D s =new Rectangle2D.Double();
	
	public Square(int x, int y,int x1,int y1, Color color,Ellipse2D point1,Ellipse2D point2) {
		super(x, y,x1,y1, color,point1,point2);
		canh = 1;
	
		}
	

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		s.setRect(this.x,this.y, canh, canh);
		g.fill(point1);
		g.fill(point2);
		g.draw(s);
	}


	@Override
	public void setSecondPoint(double x, double y,Ellipse2D point2) {
		this.point2=point2;
		
		canh = (int) ((Math.abs(this.x-x) + Math.abs(this.y-y) )/2);
         
        
	}


	@Override
	public void setFirstPoint(double x, double y, Ellipse2D point1) {
		this.x=x;
		this.y=y;
		
		this.point1=point1;
		
	}


	@Override
	public boolean isHit(float x, float y) {
		
		return s.getBounds2D().contains(x,y) ;
	}
	
	@Override
	public void visiblePoint(boolean a) {
		if(a==false) {
			point1 = new Ellipse2D.Double();
			point2 = new Ellipse2D.Double();
		}
		if(a==true) {
			point1 = new Ellipse2D.Double(s.getMinX()-8,s.getMinY()-8,8,8);
			point2 = new Ellipse2D.Double(s.getMaxX(),s.getMaxY(),8,8);
			
		}
		
		
	}


	@Override
	public void fixLinePoint(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}

