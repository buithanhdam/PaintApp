package GiuaKy;


	import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.Map;
import java.awt.geom.Ellipse2D;




	public class Line extends AShape{
		Point secondPoint;
		double x = 0;
		double y = 0;
		
		Line2D l =new Line2D.Double();

		public Line( int x ,int y,int x1,int y1,Color color, Ellipse2D point1  ,Ellipse2D point2) {
			super(x, y,x1,y1, color, point2, point2);
			this.secondPoint = new Point();

		}
		

		@Override
		public void setSecondPoint(double x, double y,Ellipse2D point2) {
			this.secondPoint.setLocation(x, y);	
			location2.setLocation(x,y);
			this.point2=point2;
		}

		@Override
		public  void draw(Graphics2D g) {
			
			g.setColor(color);
//			point1= new Rectangle2D.Double(location.x,location.y, 8, 8);
//			point2= new Rectangle2D.Double(secondPoint.x, secondPoint.y, 8, 8);
//			point1.getCenterX(), point1.getCenterY(),point2.getCenterX(), point2.getCenterY()
			l.setLine(this.x,this.y,location2.x,location2.y);
			
			g.fill(point1);
 			g.fill(point2);
			
			g.draw(l);
		}


		@Override
		public void setFirstPoint(double x, double y, Ellipse2D point1) {
			this.x= x;
			this.y = y;
			
			this.point1 = point1;
			
			
		}


		@Override
		public boolean isHit(float x, float y) {
			
			return l.getBounds2D().contains(x,y) ;
		}

		@Override
		public void visiblePoint(boolean a) {
			if(a==false) {
				point1 = new Ellipse2D.Double();
				point2 = new Ellipse2D.Double();
			}
			if(a==true) {
				point1 = new Ellipse2D.Double(l.getX1(),l.getY1(),8,8);
				point2 = new Ellipse2D.Double(l.getX2(),l.getY2(),8,8);
				location2.x =(int) l.getX2();
				location2.y = (int) l.getY2();
			}
			
			
		}


		@Override
		public void fixLinePoint(double x, double y) {
			
			this.secondPoint.setLocation(x, y);
			location2.setLocation(x,y);
		}



	
	

	}



