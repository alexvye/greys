package vye.util;

import java.util.List;
import java.util.Random;

public class Roller {
	private static Random die = new Random();
	private static double default_sdev = 1.9599;
	
	public static final int roll(int dice, int sides) {
		int sum = 0;
		
		for(int i=0;i<dice;i++) {
			sum += die.nextInt(sides) + 1;
		}
		return sum;
	}
	
	public static <T> T randomFromList(List<T> items, boolean remove) {
		int index = roll(1,items.size()) - 1;
		
		T item = items.get(index);
		
		if(remove) {
			items.remove(index);
		}
		return item;
	}
	
	public static int toss(int mean, double stdev) {
		
		double sample = die.nextGaussian()*stdev+mean;
		return (int)sample;
	}
	
	public static int toss(int mean) {

		return toss(mean,default_sdev);
	}
}
