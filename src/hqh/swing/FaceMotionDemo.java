package hqh.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class FaceMotionDemo extends JFrame {
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	public static final int MOUTH_WIDTH = 100;
	public static final int MOUTH_HEIGHT = 50;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_ARC_SWEEP = 180;
	public static final int FACE_DIAMETER = 200;
	public static final int EYE_WIDTH = 20;
	public static final int EYE_HEIGHT = 10;
	private Coordinate referencePointForFace;
	private int numTimesFaceTouched = 0;
	Color faceColor = Color.pink;
	Color mouthColor = Color.RED;
	Color eyeColor = Color.black;
	Coordinate currentMousePosition;
	private int numberOfDrags = 0;
	String message;
	boolean faceIsTouched;

	public FaceMotionDemo() {
		super("Graphics Demonstration 2");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		getContentPane().setBackground(Color.white);
		message = "hello";
		referencePointForFace = new Coordinate(100, 100);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				faceIsTouched = false;
				currentMousePosition = new Coordinate(e.getX(), e.getY());
				if (faceIsSelected(currentMousePosition)) {
					faceIsTouched = true;
					numTimesFaceTouched++;
					if (numTimesFaceTouched == 1) {
						faceColor = Color.RED;
						message = "Don't touch me";
						mouthColor = Color.white;
					} else {
						faceColor = Color.white;
						message = "I told you not to touch me";
						mouthColor = Color.white;
						eyeColor = Color.white;
					}
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				if (numTimesFaceTouched == 1) {
					faceColor = Color.PINK;
					faceIsTouched = false;
					mouthColor = Color.red;
					message = "hello";
					numberOfDrags = 0;
				}
				repaint();
			}
		}); // This finishes the definition of the event handler

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Coordinate mousePositionWhereDragged, changeOfCoordinates;
				mousePositionWhereDragged = new Coordinate(e.getX(), e.getY());
				changeOfCoordinates = mousePositionWhereDragged.difference(currentMousePosition);
				referencePointForFace = referencePointForFace.add(changeOfCoordinates);
				currentMousePosition = mousePositionWhereDragged;
				if ((faceIsSelected(mousePositionWhereDragged)) && (numTimesFaceTouched == 1)) {
					message = "HELP";
					numberOfDrags++;
				}
				repaint();
			}
		});
		setVisible(true);
	}

	public void paint(Graphics g) {
		Font fontObject;
		int xFace;
		int yFace;
		int xMouth, yMouth;
		int xRightEye;
		int yRightEye;
		int xLeftEye;
		int yLeftEye;
		super.paint(g);
		if (numberOfDrags == 0) {
			fontObject = new Font("SansSerif", Font.PLAIN, 12);
		} else if (numberOfDrags < 10) {
			fontObject = new Font("SansSerif", Font.BOLD, 18);
		} else if (numberOfDrags < 20) {
			fontObject = new Font("SansSerif", Font.BOLD, 24);
		} else {
			fontObject = new Font("SansSerif", Font.BOLD | Font.ITALIC, 36);
		}
		xFace = referencePointForFace.getX();
		yFace = referencePointForFace.getY();
		xRightEye = xFace + 55;
		yRightEye = yFace + 60;
		xLeftEye = xFace + 130;
		yLeftEye = yFace + 60;
		g.setColor(faceColor);
		if (faceIsTouched) {
			g.fillOval(xFace, yFace, FACE_DIAMETER, FACE_DIAMETER);
		} else {
			g.drawOval(xFace, yFace, FACE_DIAMETER, FACE_DIAMETER);
		}
		// Draw Eyes:
		g.setColor(eyeColor);
		g.fillOval(xRightEye, yRightEye, EYE_WIDTH, EYE_HEIGHT);
		g.fillOval(xLeftEye, yLeftEye, EYE_WIDTH, EYE_HEIGHT);
		// Draw Mouth:
		g.setColor(mouthColor);
		xMouth = xFace + 50;
		yMouth = yFace + 100;
		if (faceIsTouched) {
			g.drawArc(xMouth, yMouth, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE - 180, MOUTH_ARC_SWEEP);
		} else {
			g.drawArc(xMouth, yMouth, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, MOUTH_ARC_SWEEP);
		}
		g.setColor(Color.blue);
		g.drawString(message, xFace + 100, yFace + 250);
	}
	public static void main(String args[]){
		FaceMotionDemo myFrame;
		myFrame = new FaceMotionDemo();
	}
	private boolean faceIsSelected(Coordinate point) {
		double distanceFromCenter;
		Coordinate center;
		center = referencePointForFace.add(new Coordinate(FACE_DIAMETER / 2, FACE_DIAMETER / 2));
		distanceFromCenter = center.distance(point);
		if (distanceFromCenter < FACE_DIAMETER / 2 - 5) {
			return true;
		} else {
			return false;
		}
	}
}
