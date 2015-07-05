package minesweeper;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author KrisTina
 *
 */
public class MineSweeper extends JFrame {
	private static final long serialVersionUID = 1248435587414935159L;
	private ImageIcon img = new ImageIcon("src/minesweeper/bomb3.png");
	private static ImageIcon img1 = new ImageIcon("src/minesweeper/booom.png");
	private static JButton[][] buttons = new JButton[10][10];
	public static int[][] mine = Mine.minesTable(Mine.fillMines());

	/**
	 * Constructor and game logic
	 */
	public MineSweeper() {
		setLayout(new GridLayout(10, 10, 3, 3));
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton(img);
				buttons[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < buttons.length; i++) {
							for (int j = 0; j < buttons.length; j++) {
								if (e.getSource() == buttons[i][j]) {
									if (mine[i][j] == 0) {
										repaint();
										open(i, j);
									} else if (mine[i][j] == 1
											|| mine[i][j] == 2
											|| mine[i][j] == 3
											|| mine[i][j] == 4) {
										buttons[i][j].setText(mine[i][j] + "");
										buttons[i][j].setEnabled(false);
										open(i, j);
									} else if (mine[i][j] == -1) {
										buttons[i][j].setOpaque(true);
										buttons[i][j].setBorderPainted(false);
										buttons[i][j]
												.setBackground(Color.WHITE);
										buttons[i][j].setIcon(img1);
										buttons[i][j].setEnabled(true);
										openAll();
										repaint();
										int dialog = JOptionPane
												.showConfirmDialog(null,
														"You LOSE! Do you want to play again?");

										if (dialog == JOptionPane.YES_OPTION) {
											mine = Mine.minesTable(Mine
													.fillMines());
											dispose();
											new MineSweeper();
										} else if (dialog == JOptionPane.NO_OPTION) {
											System.exit(0);
										} else if (dialog == JOptionPane.CANCEL_OPTION) {
											System.exit(0);
										}
									}

								}
							}

						}
						isWin();
					}

				});

				add(buttons[i][j]);
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setTitle("MineSweeper");
		setVisible(true);
	}

	/**
	 * Recursion fuction for opening fields
	 * 
	 * @param x
	 *            - coordinate of 2d array position and button positon
	 * @param y
	 *            - coorinate of 2d array position and button positon
	 */
	public static void open(int x, int y) {
		if (x < 0 || x >= mine.length || y < 0 || y >= mine.length) {
			return;
		}
		if (mine[x][y] == 1) {
			buttons[x][y].setBackground(new Color(233, 14, 102));
		}
		if (mine[x][y] == 2) {
			buttons[x][y].setBackground(new Color(255, 13, 86));
		}
		if (mine[x][y] == 3) {
			buttons[x][y].setBackground(new Color(212, 65, 124));
		}
		if (mine[x][y] == 4) {
			buttons[x][y].setBackground(new Color(229, 6, 95));
		}

		if (mine[x][y] == 0 && buttons[x][y].isEnabled() != false) {
			buttons[x][y].setText("0");
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setBackground(new Color(250, 209, 225));
			buttons[x][y].setEnabled(false);
			open(x + 1, y);
			open(x - 1, y);
			open(x, y + 1);
			open(x, y - 1);
			open(x - 1, y - 1);
			open(x + 1, y - 1);
			open(x - 1, y + 1);
			open(x - 1, y + 1);
		} else {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);

			buttons[x][y].setText("" + mine[x][y]);
			buttons[x][y].setEnabled(false);
		}
		return;
	}

	/**
	 * The metode account is number of bombs equal number of not cliked fields,
	 * if is, the player wins, and asking palyer "Do you want to play again?"
	 */
	public void isWin() {
		int counter = 0;
		for (int i = 0; i < mine.length; i++)
			for (int j = 0; j < mine[i].length; j++) {
				if (buttons[i][j].isEnabled() != false) {
					counter++;
				}
			}

		if (counter == Mine.numberOfBombs) {
			openAll();
			repaint();
			int c = JOptionPane.showConfirmDialog(null,
					"You WIN! Do you want to play again?");
			if (c == JOptionPane.YES_OPTION) {
				mine = Mine.minesTable(Mine.fillMines());
				dispose();
				new MineSweeper();
			} else if (c == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if (c == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * The metod open all fields, and put image of bomb on 2D array position -1.
	 * Fields that are not clicked are gray.
	 */
	public static void openAll() {
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine[i].length; j++) {
				if (mine[i][j] == -1) {
					buttons[i][j].setOpaque(true);
					buttons[i][j].setBorderPainted(false);
					buttons[i][j].setBackground(Color.WHITE);
					buttons[i][j].setIcon(img1);
					buttons[i][j].setEnabled(true);
				} else {
					buttons[i][j].setText(mine[i][j] + "");
					buttons[i][j].setEnabled(false);
				}
			}
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MineSweeper();
	}

}
