package coinFlip;

import java.util.*;
import java.io.*;

public class CoinFlip {

	public static void main(String[] args) {
		
		MultiDie die = new MultiDie(2);
		final int SIZE = 8; // Flipping the coin 8 different amounts (1, 10, etc.)
		double[] ratioHeads = new double[SIZE]; // Array to hold ratios landing on heads
		double[] maxRolls = new double[SIZE]; // holds max rolls
		double maxRoll = 1; // first max roll
		int headCount = 0; // holds head counts
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < maxRoll; j++) {
				die.roll();
				int face = die.getFaceValue();
				if(face == 1) headCount++; // heads are 1s
			}
			ratioHeads[i] = headCount/maxRoll; // uses current headCount & maxRoll
			maxRolls[i] = maxRoll;
			maxRoll = maxRoll*10; // increments current maxRoll by power of 10
			headCount = 0; // resets headCount to 0 for next maxRoll
		}
		
		for(int i = 0; i < ratioHeads.length; i++) {
			System.out.print(maxRolls[i]+" roll(s): ");
			System.out.printf("%.7f\n", ratioHeads[i]);
		}
	}
}