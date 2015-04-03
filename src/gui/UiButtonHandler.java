package gui;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import gui.ModelTICTACTOE;

	public class UiButtonHandler implements ActionListener {

		private ModelTICTACTOE _model;
		private int _row;
		private int _col;

		public UiButtonHandler(int i, ModelTICTACTOE model) {
			_model = model;
			_row = i/3;
			_col = i%3;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_model.mark(_row, _col);
		}

	

}
