package BoxObserver;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//: BoxObserver.java
//Demonstration of Observer pattern using
//Java's built-in observer classes.
import java.util.Observable;
import java.util.Observer;

//You must inherit a new type of Observable:
class BoxObservable extends Observable {
	public void notifyObservers(Object b) {
		// Otherwise it won't propagate changes:
		setChanged();
		super.notifyObservers(b);
	}
}

public class BoxObserver extends Frame {
	Observable notifier = new BoxObservable();

	public BoxObserver(int grid) {
		setTitle("Demonstrates Observer pattern");
		setLayout(new GridLayout(grid, grid));
		for (int x = 0; x < grid; x++)
			for (int y = 0; y < grid; y++)
				add(new OCBox(x, y, notifier));
	}

	public static void main(String[] args) {
		int grid = 8;
		if (args.length > 0)
			grid = Integer.parseInt(args[0]);
		Frame f = new BoxObserver(grid);
		f.setSize(500, 400);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class OCBox extends Canvas implements Observer {
	Observable notifier;
	int x, y; // Locations in grid
	Color cColor = newColor();
	static final Color[] colors = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green,
			Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	static final Color newColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	OCBox(int x, int y, Observable notifier) {
		this.x = x;
		this.y = y;
		notifier.addObserver(this);
		this.notifier = notifier;
		addMouseListener(new ML());
	}

	public void paint(Graphics g) {
		g.setColor(cColor);
		Dimension s = getSize();
		g.fillRect(0, 0, s.width, s.height);
	}

	class ML extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			notifier.notifyObservers(OCBox.this);
		}
	}

	public void update(Observable o, Object arg) {
		OCBox clicked = (OCBox) arg;
		if (nextTo(clicked)) {
			cColor = clicked.cColor;
			repaint();
		}
	}

	private final boolean nextTo(OCBox b) {
		return Math.abs(x - b.x) <= 1 && Math.abs(y - b.y) <= 1;
	}
}