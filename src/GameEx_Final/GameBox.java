package GameEx_Final;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;




/**
 * This class represents a simple GUI drawer which extends JPanel to draw and show the game components 
 *  Ex4: you should NOT change this class!
 * @author Asaly.Saed
 */
public class GameBox extends JPanel implements KeyListener, MouseMotionListener {// we give
	private LinkedList shapes = new LinkedList();
	private Circle bullet;
	private Rectangle base;
	private int radius = 10;

	public void buildScene() {
		shapes = new LinkedList();
		int[] color = getRandomColor();
		bullet = new Circle(237, 435, radius, color[0], color[1], color[2]);
		bullet.setDx(3);
		bullet.setDy(3);
		color = getRandomColor();
		base = new Rectangle(175, 480, 150, radius, color[0], color[1], color[2]);
		base.setDx(30);
		base.setDy(30);
		color = getRandomColor();
		for (int i = 0; i < 8; i++) {
			GeoShape gs = new Rectangle((i * 60 + 5), 0, 60, 30, color[0], color[1], color[2]);
			Node N = new Node(gs, null);
			shapes.add(N);
		}
		color = getRandomColor();
		for (int i = 0; i < 8; i++) {
			GeoShape gs = new Circle((i * 60 + 5), 30, 30, color[0], color[1], color[2]);
			Node N = new Node(gs, null);
			shapes.add(N);
		}
		color = getRandomColor();
		for (int i = 0; i < 8; i++) {
			GeoShape gs = new Rectangle((i * 60 + 5), 60, 60, 30, color[0], color[1], color[2]);
			Node N = new Node(gs, null);
			shapes.add(N);
		}
		color = getRandomColor();
		for (int i = 0; i < 8; i++) {
			GeoShape gs = new Circle((i * 60 + 5), 90, 60, color[0], color[1], color[2]);
			Node N = new Node(gs, null);
			shapes.add(N);
		}
	}

	public static int[] getRandomColor() {
		int r, g, b;
		r = (int) (Math.random() * 256);
		g = (int) (Math.random() * 256);
		b = (int) (Math.random() * 256);
		return new int[] { r, g, b };
	}

	public void resetGame() {
		buildScene();
		addKeyListener(this);
		setFocusable(true);
		addMouseMotionListener(this);
	}

	public GameBox() {
		resetGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			new Thread(() -> {
				while (true) {
					updateAllShapes();
					try {
						Thread.sleep(10);
					} catch (InterruptedException err) {
						err.printStackTrace();

					}
				}
			}).start();
		}
	}

	public void paintComponent(Graphics g) {
		Node pc = (Node) shapes.getHead();
		while (pc != null) {
			pc.getData().draw(g, this);
			pc = (Node) pc.getNext();
		}
		bullet.draw(g, this);
		base.draw(g, this);
	}

	public void updateAllShapes() {
		bullet.translateX();
		if (bullet.getX() + bullet.getRadius() > (getWidth() - radius) || bullet.getX() - bullet.getRadius() < 0) {
			bullet.setDx(bullet.getDx() * -1);
		}

		if (bullet.getY() - bullet.getRadius() < 0 || bullet.intersects(base)) {
			bullet.setDy(bullet.getDy() * -1);
		}
		bullet.translateY();
		Node pc = (Node) shapes.getHead();
		while (pc != null) {
			if (bullet.intersects(pc.getData())) {
				Node PP = pc;
				pc = (Node) pc.getNext();
				shapes.remove(PP);
				bullet.setDy(bullet.getDy() * -1);
			} else {
				pc = (Node) pc.getNext();
			}
		}

		if (bullet.getY() + bullet.getRadius() > getHeight()) {
			resetGame();
		}
		RunGame.frame.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		base.setX(e.getX());
		base.setY(e.getY());
		e.consume();
	}

}