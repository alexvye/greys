package vye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import vye.util.Roller;

public class CityFactory {
	
	private List<City> cities = new ArrayList<City>();
	private MobFactory mobFactory = new MobFactory();
	
	public List<City> getCities() {
		return cities;
	}

	public static int genCitySize(char type) {
		
		int size = 0;
		
		switch(type) {
		case 'h':
			size = Roller.toss(150);
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
	
	public static String getDesc(char type) {
		String desc = "";
		
		switch(type) {
			case 'm':
				desc = "Mountain";
				break;
			case 'i':
				desc = "Inland";
				break;
			case 'r':
				desc = "Riverland";
				break;
			case 'c':
				desc = "Coastal";
				break;
			default:
				desc = "Plains";
				break;
		}
		
		return desc;
	}
	
	public void loadCities(String filename) throws IOException {
		InputStream is = getClass().getResourceAsStream("/" + filename);
		BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
		
		String line = bfr.readLine();
		while(line!=null) {
			cities.add(parseCity(line));
			line = bfr.readLine();
		}
	}
	
	private City parseCity(String line) throws IOException{
		
		StringTokenizer tokenizer = new StringTokenizer(line,",");
		
		// Imperium,c,i
		String name = tokenizer.nextToken();
		char size = tokenizer.nextToken().charAt(0);
		char type = tokenizer.nextToken().charAt(0);
		
		int pop = genCitySize(size);
		
		City city = new City(name, type, pop);
		List<Mob> mobs = mobFactory.loadMobs(pop);
		
		city.setCitizens(mobs);
		
		return city;
	}

}
