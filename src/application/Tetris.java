package application;

import java.io.IOException;	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {
	// The variables
	public static final int MOVE = 50;
	public static final int SIZE = 50;
	public static int X = SIZE * 22;
	public static int Y = SIZE * 15;
	public static int[][] GRID = new int[X / SIZE][Y / SIZE];
	private static Pane pane = new Pane();
	private static Form object;
	private static Scene scene = new Scene(pane, X + 150, Y);
	public static int score = 0;
	private static int top = 0;
	private static boolean game = true;
	private static Form nextObj = Controller.makeRect();
	private static int linesNo = 0;

	@Override
	public void start(Stage stage) throws Exception {
		for (int[] a : GRID) {
			Arrays.fill(a, 0);
		}
		pane.setStyle("-fx-background-color: black;");
		Line line = new Line(X, 0, X, Y);
		line.setStroke(Color.WHITE);
		Text scoretext = new Text("Score: ");
		scoretext.setStyle("-fx-font: 20 arial;");
		scoretext.setY(50);
		scoretext.setX(X + 5);
		scoretext.setFill(Color.ALICEBLUE);
		Text level = new Text("Lines: ");
		level.setStyle("-fx-font: 20 arial;");
		level.setY(100);
		level.setX(X + 5);
		level.setFill(Color.GREEN);
		pane.getChildren().addAll(scoretext, line, level);

		Form a = nextObj;
		pane.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPress(a);
		object = a;
		nextObj = Controller.makeRect();
		stage.setScene(scene);
		stage.setTitle("T E A M    T E T R I S");
		stage.show();

		Timer fall = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
								|| object.d.getY() == 0)
							top++;
						else
							top = 0;

						if (top == 2) {
							// GAME OVER
							Text over = new Text("Its Over Son!");
							over.setFill(Color.RED);
							over.setStyle("-fx-font: 70 arial;");
							over.setY(250);
							over.setX(10);
							pane.getChildren().add(over);
							game = false;
						}
						// Exit
						if (top == 15) {
							try {
								FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScores.fxml"));
								Parent root = loader.load();
								HighScoreController highscore = loader.getController();
								highscore.updateHighScores(score, MainController.name);
								highscore.highScores();
								stage.getScene().setRoot(root);


							} catch (IOException e) {
								e.printStackTrace();
							}							
						}

						if (game) {
							down(object);
							scoretext.setText("Score: " + Integer.toString(score));
							level.setText("Lines: " + Integer.toString(linesNo));
						}
					}
				});
			}
		};
		fall.schedule(task, 0, SettingsController.getSpeed()); 
	}
	private void moveOnKeyPress(Form form) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case RIGHT:
					Controller.right(form);
					break;
				case DOWN:
					down(form);
					score++;
					break;
				case LEFT:
					Controller.left(form);
					break;
				case UP:
					MoveTurn(form);
					break;
				default:
					break;
				}
			}
		});
	}

	private void MoveTurn(Form form) {
		int f = form.form;
		Rectangle a = form.a;
		Rectangle b = form.b;
		Rectangle c = form.c;
		Rectangle d = form.d;
		switch (form.getName()) {
		case "j":
			if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
				right(form.a);
				down(form.a);
				down(form.c);
				left(form.c);
				down(form.d);
				down(form.d);
				left(form.d);
				left(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
				down(form.a);
				left(form.a);
				left(form.c);
				up(form.c);
				left(form.d);
				left(form.d);
				up(form.d);
				up(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
				left(form.a);
				up(form.a);
				up(form.c);
				right(form.c);
				up(form.d);
				up(form.d);
				right(form.d);
				right(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
				up(form.a);
				right(form.a);
				right(form.c);
				down(form.c);
				right(form.d);
				right(form.d);
				down(form.d);
				down(form.d);
				form.changeForm();
				break;
			}
			break;
		case "l":
			if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
				right(form.a);
				down(form.a);
				up(form.c);
				right(form.c);
				up(form.b);
				up(form.b);
				right(form.b);
				right(form.b);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
				down(form.a);
				left(form.a);
				right(form.b);
				right(form.b);
				down(form.b);
				down(form.b);
				right(form.c);
				down(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
				left(form.a);
				up(form.a);
				down(form.c);
				left(form.c);
				down(form.b);
				down(form.b);
				left(form.b);
				left(form.b);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
				up(form.a);
				right(form.a);
				left(form.b);
				left(form.b);
				up(form.b);
				up(form.b);
				left(form.c);
				up(form.c);
				form.changeForm();
				break;
			}
			break;
		case "o":
			break;
		case "s":
			if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				down(form.a);
				left(form.a);
				left(form.c);
				up(form.c);
				up(form.d);
				up(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				up(form.a);
				right(form.a);
				right(form.c);
				down(form.c);
				down(form.d);
				down(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				down(form.a);
				left(form.a);
				left(form.c);
				up(form.c);
				up(form.d);
				up(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				up(form.a);
				right(form.a);
				right(form.c);
				down(form.c);
				down(form.d);
				down(form.d);
				form.changeForm();
				break;
			}
			break;
		case "t":
			if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
				up(form.a);
				right(form.a);
				down(form.d);
				left(form.d);
				left(form.c);
				up(form.c);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
				right(form.a);
				down(form.a);
				left(form.d);
				up(form.d);
				up(form.c);
				right(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
				down(form.a);
				left(form.a);
				up(form.d);
				right(form.d);
				right(form.c);
				down(form.c);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
				left(form.a);
				up(form.a);
				right(form.d);
				down(form.d);
				down(form.c);
				left(form.c);
				form.changeForm();
				break;
			}
			break;
		case "z":
			if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				up(form.b);
				right(form.b);
				left(form.c);
				up(form.c);
				left(form.d);
				left(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				down(form.b);
				left(form.b);
				right(form.c);
				down(form.c);
				right(form.d);
				right(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				up(form.b);
				right(form.b);
				left(form.c);
				up(form.c);
				left(form.d);
				left(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				down(form.b);
				left(form.b);
				right(form.c);
				down(form.c);
				right(form.d);
				right(form.d);
				form.changeForm();
				break;
			}
			break;
		case "i":
			if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				up(form.a);
				up(form.a);
				right(form.a);
				right(form.a);
				up(form.b);
				right(form.b);
				down(form.d);
				left(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				down(form.a);
				down(form.a);
				left(form.a);
				left(form.a);
				down(form.b);
				left(form.b);
				up(form.d);
				right(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				up(form.a);
				up(form.a);
				right(form.a);
				right(form.a);
				up(form.b);
				right(form.b);
				down(form.d);
				left(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				down(form.a);
				down(form.a);
				left(form.a);
				left(form.a);
				down(form.b);
				left(form.b);
				up(form.d);
				right(form.d);
				form.changeForm();
				break;
			}
			break;
		}
	}

	private void RemoveRows(Pane pane) {
		ArrayList<Node> rects = new ArrayList<Node>();
		ArrayList<Integer> lines = new ArrayList<Integer>();
		ArrayList<Node> newrects = new ArrayList<Node>();
		int full = 0;
		for (int i = 0; i < GRID[0].length; i++) {
			for (int j = 0; j < GRID.length; j++) {
				if (GRID[j][i] == 1)
					full++;
			}
			if (full == GRID.length)
				lines.add(i);
			//lines.add(i + lines.size());
			full = 0;
		}
		if (lines.size() > 0)
			do {
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				score += 50;
				linesNo++;

				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() == lines.get(0) * SIZE) {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						pane.getChildren().remove(node);
					} else
						newrects.add(node);
				}

				for (Node node : newrects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() < lines.get(0) * SIZE) {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						a.setY(a.getY() + SIZE);
					}
				}
				lines.remove(0);
				rects.clear();
				newrects.clear();
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					try {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				rects.clear();
			} while (lines.size() > 0);
	}

	private void down(Rectangle rect) {
		if (rect.getY() + MOVE < Y)
			rect.setY(rect.getY() + MOVE);

	}

	private void right(Rectangle rect) {
		if (rect.getX() + MOVE <= X - SIZE)
			rect.setX(rect.getX() + MOVE);
	}

	private void left(Rectangle rect) {
		if (rect.getX() - MOVE >= 0)
			rect.setX(rect.getX() - MOVE);
	}

	private void up(Rectangle rect) {
		if (rect.getY() - MOVE > 0)
			rect.setY(rect.getY() - MOVE);
	}

	private void down(Form form) {
		if (form.a.getY() == Y - SIZE || form.b.getY() == Y - SIZE || form.c.getY() == Y - SIZE
				|| form.d.getY() == Y - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
			GRID[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
			GRID[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
			GRID[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
			GRID[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
			RemoveRows(pane);

			Form a = nextObj;
			nextObj = Controller.makeRect();
			object = a;
			pane.getChildren().addAll(a.a, a.b, a.c, a.d);
			moveOnKeyPress(a);
		}

		if (form.a.getY() + MOVE < Y && form.b.getY() + MOVE < Y && form.c.getY() + MOVE < Y
				&& form.d.getY() + MOVE < Y) {
			int movea = GRID[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
			int moveb = GRID[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
			int movec = GRID[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
			int moved = GRID[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
			if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setY(form.a.getY() + MOVE);
				form.b.setY(form.b.getY() + MOVE);
				form.c.setY(form.c.getY() + MOVE);
				form.d.setY(form.d.getY() + MOVE);
			}
		}
	}

	private boolean moveA(Form form) {
		return (GRID[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
	}

	private boolean moveB(Form form) {
		return (GRID[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
	}

	private boolean moveC(Form form) {
		return (GRID[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
	}

	private boolean moveD(Form form) {
		return (GRID[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
	}

	private boolean cB(Rectangle rect, int x, int y) {
		boolean xb = false;
		boolean yb = false;
		if (x >= 0)
			xb = rect.getX() + x * MOVE <= X - SIZE;
		if (x < 0)
			xb = rect.getX() + x * MOVE >= 0;
		if (y >= 0)
			yb = rect.getY() - y * MOVE > 0;
		if (y < 0)
			yb = rect.getY() + y * MOVE < Y;
		return xb && yb && GRID[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
	}

}