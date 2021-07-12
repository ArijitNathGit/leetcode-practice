package com.arijit.math;

public class ChocolateAndWrapperPuzzle {

	public static void main(String[] args) {
		System.out.println(new ChocolateAndWrapperPuzzleImpl().countMaxChoco(15, 1, 3));
	}

}

class ChocolateAndWrapperPuzzleImpl {
	
	public int countMaxChoco(int money, int price, int wrap) {
		if(money < price) return 0;
		
		int choco = ( money / price );
		
		return choco + countRec(choco, wrap);
	}

	private int countRec(int choco, int wrap) {
		
		if(choco < wrap) return 0;
		
		int newChoco = choco / wrap;
		
		return newChoco + countRec(newChoco + choco % wrap, wrap);
	}
	
	
}
