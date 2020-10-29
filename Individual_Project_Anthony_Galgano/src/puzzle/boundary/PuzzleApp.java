package puzzle.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import puzzle.controller.MoveTileController;
import puzzle.controller.ResetController;
import puzzle.controller.SelectTileController;
import puzzle.model.Model;
import puzzle.model.MoveType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class PuzzleApp extends JFrame {

	private JPanel contentPane;
	Model model;
	PuzzlePanel panel;
	
	JButton btnUp, btnLeft, btnDown, btnRight, btnReset;
	JLabel winLoseLabel;
	private JLabel Instructions_1;
	
	public PuzzlePanel getPuzzlePanel() { return panel; } 
	public JButton getUpButton() { return btnUp;}
	public JButton getDownButton() { return btnDown;}
	public JButton getLeftButton() { return btnLeft;}
	public JButton getRightButton() { return btnRight;}
	public JButton getResetButton() { return btnReset;}
	public JLabel getWinLoseLabel() { return winLoseLabel;}
	

	/**
	 * Create the frame.
	 * @param model 
	 */
	public PuzzleApp(Model model) {
		super();
		this.model = model;
		setTitle("Individual Project Puzzle Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		
		btnUp = new JButton("^");
		btnUp.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).merge(MoveType.Up);
			}
		});

		btnDown = new JButton("v");
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).merge(MoveType.Down);
			}
		});


		btnLeft = new JButton("<");
		btnLeft.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).merge(MoveType.Left);
			}
		});

		btnRight = new JButton(">");
		btnRight.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).merge(MoveType.Right);
			}
		});
		JLabel Instructions = new JLabel("Goal: Leave 1 remaning tile in the center of the Puzzle.");
		
		btnReset = new JButton("Reset Puzzle");
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, PuzzleApp.this).reset();
			}
		});
		
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, PuzzleApp.this).process(me.getPoint());
			}
		});
		
		winLoseLabel = new JLabel("");
		winLoseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Instructions_1 = new JLabel("Instructions: Right adds tiles, left subtracts, up multiplies, down divides.");
		Instructions_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addGap(105)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(winLoseLabel, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(86)
									.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnUp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnDown, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Instructions_1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
								.addComponent(Instructions, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Instructions, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Instructions_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRight, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addComponent(btnLeft, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(winLoseLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset))
					.addGap(0))
		);
		contentPane.setLayout(gl_contentPane);
		
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
