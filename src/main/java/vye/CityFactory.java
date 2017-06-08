package vye;

import java.util.ArrayList;
import java.util.List;

import vye.util.Roller;

public class CityFactory {
	
	private static List<City> cities = new ArrayList<City>();
	
	public static int genCitySize(char type) {
		
		int size = 0;
		
		switch(type) {
		case 'h':
			size = Roller.toss(40);
			break;
		case 'v':
			size = Roller.toss(600);
			break;
		case 't':
			size = Roller.toss(4000);
			break;	
		case 'c':
			size = Roller.toss(10000);
			break;	
		case 'b':
			size = Roller.toss(12000);
			break;	
		default:
			size = Roller.toss(4000);
		}
		
		return size;
	}
	
	public static void loadCities(String filename) {
		
	}

}
