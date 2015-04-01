package gui;

	import java.awt.GridLayout;
	import java.util.ArrayList;
	import java.util.Observable;
	import java.util.Observer;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.SwingUtilities;

	import gui.ModelTICTACTOE;
	import code.Scrabble;

	public class UiScrabbleGame implements Observer, Runnable {
		
		private Scrabble _model;
		private ArrayList<JButton> _buttons;
		
		public UiScrabbleGame() {
			_model = new Scrabble();
			_model.addObserver(this);
			_buttons = new ArrayList<JButton>();
		}

		@Override
		public void update(Observable o, Object arg) {
			String s = _model.toString();
			for (int i=0; i<s.length(); i++) {
				_buttons.get(i).setText(""+s.charAt(i));
			}
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new UiScrabbleGame());
		}

		@Override
		public void run() {
			JFrame window = new JFrame("TicTacToe");
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(3, 3, 1, 1));
			for (int i=0; i<9; i++) {
				JButton b = new JButton("");
				p.add(b);
				b.addActionListener(new UiButtonHandler(i, _model));
				_buttons.add(b);
			}
			window.add(p);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.pack();
			window.setVisible(true);
		}

	


}
