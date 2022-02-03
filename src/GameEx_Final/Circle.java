package GameEx_Final;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you should update this class!
 * @author Asaly.Saed
 *
 */
public class Circle implements GeoShape{
	int x, y, dx, dy, radius, r, g, b;

	public Circle(int x, int y, int radius, int r, int g, int b) {
		//super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.r = r;
		this.g = g;
		this.b = b;
		this.dx=0;
		this.dy=0;
	}


	@Override
	public void draw(Graphics g, Component c) {
		g.setColor(new Color( getRed(),getGreen(),getBlue()));
		g.fillOval(getX(), getY(), getRadius(), getRadius());
		g.setColor(new Color(0,0,0));
		g.drawOval(getX(), getY(), getRadius(), getRadius());

	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public void translateX() {
		this.x+=this.dx;		
	}

	@Override
	public void translateY() {
		this.y+=this.dy;		
	}

	@Override
	public void setColor(int r, int g, int b) {
		this.r=r;
		this.g=g;
		this.b=b;

	}

	@Override
	public boolean intersects(GeoShape g) {
		String name = g.getClass().getSimpleName();
		int xc = this.x , yc = this.y, r= this.radius;	

		if(name.equals("Rectangle")) {
			Rectangle temp = (Rectangle)g;
			int x1=temp.getX() ,x2=temp.getX()+temp.getWidth(), y1=temp.getY(), y2=temp.getY()-temp.getHeight();

			int Xn = Math.max(x1, Math.min(this.x, x2));
			int Yn = Math.max(y1, Math.min(this.y, y2));
			int Dx = Xn - xc;
			int Dy = Yn - yc;
			return (Dx * Dx + Dy * Dy) <= r * r;
		}
		else if(name.equals("Circle")) {
			Circle temp = (Circle)g;
			int txc=temp.getX() ,tyc=temp.getY(), trc=temp.getRadius();

			int distSq = (xc - txc) * (xc - txc) +
					(yc - tyc) * (yc - tyc);
			int radSumSq = (r + trc) * (r + trc);
			if (distSq == radSumSq)
				return true;
			else if (distSq > radSumSq)
				return false;
			else
				return true;
		}
		return false;
	}

	@Override
	public int getDx() {
		return this.dx;
	}

	@Override
	public void setDx(int dx) {
		this.dx=dx;		
	}

	@Override
	public int getDy() {
		return this.dy;
	}

	@Override
	public void setDy(int dy) {
		this.dy=dy;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public void setX(int x) {
		this.x=x;		
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setY(int y) {
		this.y=y;		
	}

	@Override
	public int getRed() {
		return this.r;
	}

	@Override
	public int getGreen() {
		return this.g;
	}

	@Override
	public int getBlue() {
		return this.b;
	}




}
