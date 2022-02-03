package GameEx_Final;

import java.awt.Component;
import java.awt.Graphics;

/**
 * This interface represents a (very basic) geometric (2D) shape in the plane.
 * The methods includes: translating the shape on both x and y axes, testing if
 * two shapes are intersected, getting and setting the change of x/y direction
 * to be applied on the shape, and draw the shape on a given component.
 * 
 * Ex4: you should NOT change this interface!
 * 
 * @author Asaly.Saed
 */

public interface GeoShape {
	public void translateX();// Translates the shape by dx quantity in the x axis direction.

	public void translateY();// Translates the shape by dy quantity in the y axis direction.

	public void setColor(int r, int g, int b);// Sets(changes) the fill color of the shape.

	public boolean intersects(GeoShape g);// returns true if the current shape intersects with the given shape,
											// false otherwise.

	public int getDx();// gets the change of x direction set to the shape

	public void setDx(int dx);// sets the change of x direction set to the shape

	public int getDy();// gets the change of y direction set to the shape

	public void setDy(int dy);// sets the change of y direction set to the shape

	// Do not change!
	public void draw(Graphics g, Component c);// draws the current shape on the given component using the given
												// graphics.

	public int getX();// gets the x value of the representative point of the shape

	public void setX(int x );// sets the x value of the representative point of the shape

	public int getY();// gets the y value of the representative point of the shape

	public void setY(int y);// sets the y value of the representative point of the shape

	public int getRed();// gets the red value of the color of the shape

	public int getGreen();// gets the green value of the color of the shape

	public int getBlue();// gets the blue value of the color of the shape

}
