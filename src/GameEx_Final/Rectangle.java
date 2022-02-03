package GameEx_Final;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author Asaly.Saed
 *
 */
public class Rectangle implements GeoShape {
	int x, y, dx, dy, width, height, r, g, b;

	public Rectangle(int x, int y, int width, int height, int r, int g, int b) {
		//super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.r = r;
		this.g = g;
		this.b = b;
		this.dx=0;
		this.dy=0;
	}



	public void draw(Graphics g, Component c) {
		g.setColor(new Color(getRed(), getGreen(), getBlue()));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(new Color(0, 0, 0));
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}

	public int getHeight() {
		return this.height;
	}


	public int getWidth() {
		return this.width;
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
		int x1=this.x ,x2=this.x+this.width, y1=this.y, y2=this.y-this.height;

		
		if(name.equals("Circle")) {
			int xc = g.getX(), yc = g.getY(), r= ((Circle) g).getRadius();			
		    int Xn = Math.max(x1, Math.min(g.getX(), x2));
		    int Yn = Math.max(y1, Math.min(g.getY(), y2));
		    int Dx = Xn - xc;
		    int Dy = Yn - yc;
		    return (Dx * Dx + Dy * Dy) <= r * r;
		    
		}
		else if(name.equals("Rectangle")) {
			Rectangle temp = (Rectangle)g;
			int tx1=temp.getX() ,tx2=temp.getX()+temp.getWidth(), ty1=temp.getY(), ty2=temp.getY()-temp.getHeight();
			boolean flag=((x1>tx2)||(x2<tx1)||(y1>ty2)||(y2<ty1));
			return !flag;
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
