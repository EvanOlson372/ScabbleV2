package code;
import code.Tile;


public class Multiplier {
	
	int _wordMult;
	int _letterMult;
	
	public void Tile(int w, int l){
		_wordMult = w;
		_letterMult= l;
	}
	
	public int getWordMult(){
		return _wordMult;
	}
    public int getLetterMult(){
    	return _letterMult;
    }
}
