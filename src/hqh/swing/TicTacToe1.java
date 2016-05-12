package hqh.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class TicTacToe1 extends JFrame {
	private static final long serialVersionUID = 1L;
	public int turn;
	int xPosition;
	int yPosition;
	boolean flag = false;

	public TicTacToe1() {
		super("Tictactoe Board");
		/**
		 * 添加监听时间， 方法1 实现 MouseListener 接口 addMouseListener(this); //添加监听事件
		 */
		/**
		 * 方法2 new MouseAdapter
		 */
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int xWherePressed, yWherePressed;
				xWherePressed = e.getX();
				yWherePressed = e.getY();
				processWherePressed(xWherePressed, yWherePressed);
				repaint();
			}
		});
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		TicTacToe1 newBoard;
		newBoard = new TicTacToe1();
		// myBoard.setVisible(true);
	}

	public void paint(Graphics g) {
		int red = 255, green = 0, blue = 0;
		Font my_font;
		my_font = new Font("Serif", Font.BOLD, 18);
		g.setColor(new Color(red, green, blue));
		// One way to set color
		g.drawLine(70, 170, 170, 170);
		g.drawLine(70, 203, 170, 203);
		g.drawLine(103, 137, 103, 237);
		g.drawLine(137, 137, 137, 237);

		g.setColor(new Color(0, 0, 0));
		g.fillRect(50, 117, 140, 5);
		g.fillRect(50, 117, 5, 140);
		g.fillRect(50, 252, 140, 5);
		g.fillRect(185, 117, 5, 140);
		g.setColor(Color.blue);

		// Another way to set color
		g.setFont(my_font);
		g.drawString("My Tic Tac Toe Board", 0, 30);

		if (turn == 1) {
			drawX(g, xPosition, yPosition);
			turn = 2;
		} else {
			drawCircle(g, xPosition, yPosition);
			turn = 1;
		}
	}

	private void drawX(Graphics g, int xPosition2, int yPosition2) {
		g.drawLine(xPosition, yPosition, xPosition + 10, yPosition + 20);
		g.drawLine(xPosition + 10, yPosition, xPosition, yPosition + 20);
	}

	private void drawCircle(Graphics g, int xPosition2, int yPosition2) {
		g.fillOval(xPosition, yPosition, 20, 20);
	}

	/**
	 * public void mousePressed(MouseEvent e) { 
	 * int xWherePressed,yWherePressed; 
	 * xWherePressed = e.getX(); 
	 * yWherePressed = e.getY();
	 * processWherePressed(xWherePressed, yWherePressed); repaint();
	 * 
	 * }
	 */
	public void processWherePressed(int x, int y) {
		int xTable[] = { 46, 79, 113 };
		int yTable[] = { 113, 146, 180 };
		int rowNumber, columNumber;
		if ((x < 40) || (x > 140) || (y < 73) || (y > 207))
			System.out.println(" Illegal mouse event. Try again.");
		else {
			if (x < 73) {
				columNumber = 0;
			} else if (x < 107) {
				columNumber = 1;
			} else {
				columNumber = 2;
			}
			if (y < 140) {
				rowNumber = 0;
			} else if (y < 173) {
				rowNumber = 1;
			} else {
				rowNumber = 2;
			}
			xPosition = xTable[columNumber];
			yPosition = yTable[rowNumber];
		}
	}
}
