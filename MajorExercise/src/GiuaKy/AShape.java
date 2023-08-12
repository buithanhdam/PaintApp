package GiuaKy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;





public abstract class AShape   {
	protected Point location1;
	protected Point location2;
	protected Color color;
	protected Ellipse2D point1  ;
	protected Ellipse2D point2 ;
	
	
	
	public AShape(int x,int y,int x1,int y1,Color color,Ellipse2D point1  ,Ellipse2D point2) {
		this.location1 = new Point(x,y);
		this.location2 = new Point(x1,y1);
		this.color = color;
		this.point1=point1;
		this.point2=point2;
	
	}
	public abstract void  setFirstPoint(double x, double y,Ellipse2D point1);
	public abstract void  setSecondPoint(double x, double y,Ellipse2D point2);
	 public abstract boolean isHit(float x, float y);
	public abstract void draw(Graphics2D g);
	public abstract void  visiblePoint(boolean a);
	public abstract void  fixLinePoint(double x, double y);
	
	
	
	


	
		
	


}
