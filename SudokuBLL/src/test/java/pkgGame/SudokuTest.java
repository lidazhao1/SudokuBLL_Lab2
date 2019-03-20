package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgGmae.Sudoku;
import pkgHelper.LatinSquare;

import org.junit.Test;

import java.util.Arrays;




public class SudokuTest {

	@Test
	public void getRegion_test1() throws Exception {
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{ 0,1,2,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		int [] t3 = {1,0,0,1};
		int [] r3 =SD.getRegion(3);
		assertTrue(Arrays.equals(t3,r3));
		System.out.println(Arrays.toString(r3));
	}
	@Test
	public void getRegion_test2() throws Exception {
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{ 0,1,2,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		int [] t3 = {0,1,1,0};
		int [] r3 =SD.getRegion(0);
		assertTrue(Arrays.equals(t3,r3));
		System.out.println(Arrays.toString(r3));
	}
	@Test
	public void getRegion_test3() throws Exception {
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{ 0,1,2,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		int [] t3 = {0,1,1,0};
		int [] r3 =SD.getRegion(1,0);
		assertTrue(Arrays.equals(t3,r3));
		System.out.println(Arrays.toString(r3));
	}
	@Test
	public void isValueValid_test1() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		assertTrue(SD.isValueValid(3,1,1));
	}
	@Test
	public void isValueValid_test2() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{0,2,1,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		assertTrue(SD.isValueValid(3,2,2));
	}
	@Test
	public void isValueValid_test3() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		assertFalse(SD.isValueValid(8,1,1));
	}
	@Test
	public void isPartialSudoku_test1() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{0,1,3,3},{1,0,3,2},{3,2,1,0},{2,3,0,1}};
		SD.setLatinSquare(LatinSquare);
		assertFalse(SD.isPartialSudoku());
	}
	@Test
	public void isPartialSudoku_test2() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{4,1,2,3},{1,4,3,2},{3,2,1,4},{2,3,4,1}};
		SD.setLatinSquare(LatinSquare);
		assertFalse(SD.isPartialSudoku());
	}
	@Test
	public void isPartialSudoku_test3() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{2,1,3,0},{3,0,1,2},{0,3,2,1},{1,2,0,3}};
		SD.setLatinSquare(LatinSquare);
		assertTrue(SD.isPartialSudoku());
	}
	@Test
	public void isSudoku_test1() throws Exception{
		Sudoku SD = new Sudoku();
		int[][] LatinSquare = {{2,1,3,0},{3,0,1,2},{0,3,2,1},{1,2,0,3}};
		SD.setLatinSquare(LatinSquare);
		assertFalse(SD.isSudoku());
	}
}
