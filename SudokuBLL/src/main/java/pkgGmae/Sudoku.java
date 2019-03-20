package pkgGmae;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	public static void main(String[] args) {
	}
	private int iSize;
	
	private int iSqrtSize;
	
	public Sudoku() {
		super();
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	protected int [][] getpuzzle() {
		return super.getLatinSquare();
	}
	
	public int [] getRegion(int Col, int Row) throws Exception  {
		int iSize = super.getLatinSquare().length;
		int iSqrtSize = (int) Math.sqrt(iSize);
		int r = (Col / iSize) + (Row / iSize) * iSqrtSize;
		
		return getRegion(r);
	}
	
	public int [] getRegion(int r) throws Exception
	{
		int iSize = super.getLatinSquare().length;
		int iSqrtSize = (int) Math.sqrt(iSize);
		int Arrayplace = 0;
		int [] A = new int [super.getLatinSquare().length];
		if((r+1)>iSize)
			throw new Exception("Bad Region Call");
		for (int a=(r/iSqrtSize)*iSqrtSize;a<(r/iSqrtSize)*iSqrtSize+iSqrtSize;a++) {
			for(int b=((r%iSqrtSize)*iSqrtSize);b<((r%iSqrtSize)*iSqrtSize)+iSqrtSize;b++) {
				
				A[Arrayplace++] = super.LatinSquare[a][b];
				
				}
			}
		return A;
	}	
	/**
	 * If the puzzle is a Sudoku... and any of the values is zero
	 * 
	 * @return
	 */
	public boolean isPartialSudoku() throws Exception {
		boolean isPartialSudoku;
		for(int H=0;H < super.LatinSquare.length-1; H++) {
			for(int S=0;S < super.LatinSquare.length-1; S++) {
				if(super.hasDuplicates(getRegion(H,S)) == false) {
					isPartialSudoku = true;
				}
				else {
					return false;
				}
				if(super.hasAllValues(super.getRow(S), getRegion(H,S))==true) {
					isPartialSudoku = true;
				}
				else {
					return false;
				}
			}
		}
		if(super.isLatinSquare()==true) {
			isPartialSudoku = true;
		}
		else {
			return false;
		}
		if(super.ContainsZero()==true) {
			isPartialSudoku = true;
		}
		else {
			return false;
		}
		return isPartialSudoku;
	}
	/**
	 * If the puzzle is a LatinSqaure... and each value of each region exists in the first row
	 * of the puzzle
	 * 
	 * 
	 * @return true, if it's a complete Sudoku
	 * @throws Exception 
	 */
	public boolean isSudoku() throws Exception {
		boolean isSudoku = true;
		if(isPartialSudoku()==true) {
			isSudoku = true;
		}
		else {
			return false;
		}
		if(super.ContainsZero()==true) {
			return false;
		}
		else {
			isSudoku = true;
		}
		return isSudoku;
		
	}

	
	/**
	 * 
	 * @param iValue - value you're attempting
	 * @param Col - column in the puzzle
	 * @param Row - row in the puzzle
	 * @return - return 'true' if the given value is possible in the puzzle
	 */
	public boolean isValueValid(int iValue, int Col, int Row) throws Exception{
		boolean isValueValid = true;
		for(int H=0;H < super.LatinSquare.length-1; H++) {
			if(super.doesElementExist(super.getColumn(H), iValue)==true) {
				isValueValid = true;
			}
			else {
				isValueValid = false;
			}
		}
		for(int S=0;S < super.LatinSquare.length-1; S++) {
			if(super.doesElementExist(super.getRow(S), iValue)) {
				isValueValid = true;
			}
			else {
				isValueValid = false;
			}
		}
		return isValueValid;
	}
	public boolean hasDuplicates() throws Exception{
		if (super.hasDuplicates(null))
				return false;
		
		for(int iRegion = 0; iRegion < this.getLatinSquare().length; iRegion++) {
			
			try {
				if (hasDuplicates(getRegion(iRegion)))
					return true;
			} catch (Exception e) {
				throw e;
			}
		}
		return false;
	}
}

