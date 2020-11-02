package puzzle.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import puzzle.model.Coordinate;
import puzzle.model.Model;
import puzzle.model.Puzzle;
import puzzle.model.Tile;

public class PuzzlePanel extends JPanel {

	Model model;

	public static final int tileSize = 100;
	public static final int offSet = 2;
	public static final int numberSize = 80;

	public PuzzlePanel(Model m) {
		this.model = m;
	}

	/**
	 * Computes a rectangle for the tiles. 
	 * @param t
	 * @return
	 */
	public Rectangle computeRectangle(Tile t) {
		int col = t.getColumn();
		int row = t.getRow();
		Rectangle rect = new Rectangle(col*tileSize+offSet, row*tileSize+offSet, t.width*tileSize - 2*offSet, t.height*tileSize - 2*offSet);
		return rect;
	}

	/**
	 * Paints the puzzle piece colors and puts values in the middle of squares. 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (model == null) {
			return;
		} // nothing to drwa. Only here for window builder

		Tile selectedTile = model.getSelectedTile();
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {

			if (t.getInPlay()) {
				if (t.equals(selectedTile)) {
					g.setColor(Color.red);
				}

				else if (model.isGameOver() && model.getPuzzle().isWinner()) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.gray);
				}
			}

			else {
				g.setColor(Color.white);
			}

			

			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			if (t.getInPlay()) {
				g.setColor(Color.black);
				g.setFont(new Font("", 0, 40));
				g.drawString(Integer.toString(t.getValue()), (r.x + 25), (r.y + 60));
			}
			
		}
	}

	public Coordinate pointsToCoordinate(Point p) {
		return new Coordinate(p.x / tileSize, p.y / tileSize);
	}
}
