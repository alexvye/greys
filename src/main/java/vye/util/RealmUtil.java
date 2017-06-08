package vye.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vye.Mob;

public class RealmUtil {

	public static List<Mob> getKingsGuard(List<Mob> mobs) {
		
		Comparator<Mob> comp = new Comparator<Mob>() {
//		    @Override
		    public int compare(Mob o1, Mob o2) {
		    	int score1 = 3*o1.getStr() + 2*o1.getCon() + 3*o1.getDex() + o1.getWis();
		    	int score2 = 3*o2.getStr() + 2*o2.getCon() + 3*o2.getDex() + o2.getWis();
		        return score1 - score2;
		    }
		};
		
		Collections.sort(mobs, comp);
		
		return mobs;
	}
}
