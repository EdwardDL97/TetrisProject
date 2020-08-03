// Group 1 Team Tetris
package application;


import javafx.scene.shape.Rectangle;

public class Controller {
	// Getting the numbers and the GRID from Tetris
	public static final int MOVE = Tetris.MOVE;
	public static final int SIZE = Tetris.SIZE;
	public static int X = Tetris.X;
	public static int Y = Tetris.Y;
	public static int[][] GRID = Tetris.GRID;

	public static void right(Form form) {
		if (form.a.getX() + MOVE <= X - SIZE && form.b.getX() + MOVE <= X - SIZE
				&& form.c.getX() + MOVE <= X - SIZE && form.d.getX() + MOVE <= X - SIZE) {
			int movea = GRID[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
			int moveb = GRID[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
			int movec = GRID[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
			int moved = GRID[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
			if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setX(form.a.getX() + MOVE);
				form.b.setX(form.b.getX() + MOVE);
				form.c.setX(form.c.getX() + MOVE);
				form.d.setX(form.d.getX() + MOVE);
			}
		}
	}

	public static void left(Form form) {
		if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
				&& form.d.getX() - MOVE >= 0) {
			int movea = GRID[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
			int moveb = GRID[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
			int movec = GRID[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
			int moved = GRID[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
			if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setX(form.a.getX() - MOVE);
				form.b.setX(form.b.getX() - MOVE);
				form.c.setX(form.c.getX() - MOVE);
				form.d.setX(form.d.getX() - MOVE);
			}
		}
	}

	/*
	 * makeRect method creates the shapes. There are a total of seven shape and each shape represent a letter.
	 * These shapes are j, l, o, s, t, z, i
	 */
	public static Form makeRect() {
		int block = (int) (Math.random() * 100);
		String name;
		Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
				d = new Rectangle(SIZE-1, SIZE-1);
		if (block < 15) { 
			a.setX(X / 2 - SIZE);
			b.setX(X / 2 - SIZE);
			b.setY(SIZE);
			c.setX(X / 2);
			c.setY(SIZE);
			d.setX(X / 2 + SIZE);
			d.setY(SIZE);
			name = "j";
		} else if (block < 30) { 
			a.setX(X / 2 + SIZE);
			b.setX(X / 2 - SIZE);
			b.setY(SIZE);
			c.setX(X / 2);
			c.setY(SIZE);
			d.setX(X / 2 + SIZE);
			d.setY(SIZE);
			name = "l";
		} else if (block < 45) { 
			a.setX(X / 2 - SIZE);
			b.setX(X / 2);
			c.setX(X / 2 - SIZE);
			c.setY(SIZE);
			d.setX(X / 2);
			d.setY(SIZE);
			name = "o";
		} else if (block < 60) { 
			a.setX(X / 2 + SIZE);
			b.setX(X / 2);
			c.setX(X / 2);
			c.setY(SIZE);
			d.setX(X / 2 - SIZE);
			d.setY(SIZE);
			name = "s";
		} else if (block < 75) { 
			a.setX(X / 2 - SIZE);
			b.setX(X / 2);
			c.setX(X / 2);
			c.setY(SIZE);
			d.setX(X / 2 + SIZE);
			name = "t";
		} else if (block < 90) { 
			a.setX(X / 2 + SIZE);
			b.setX(X / 2);
			c.setX(X / 2 + SIZE);
			c.setY(SIZE);
			d.setX(X / 2 + SIZE + SIZE);
			d.setY(SIZE);
			name = "z";
		} else { 
			a.setX(X / 2 - SIZE - SIZE);
			b.setX(X / 2 - SIZE);
			c.setX(X / 2);
			d.setX(X / 2 + SIZE);
			name = "i";
		}
		return new Form(a, b, c, d, name);
	}
}