package vye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import vye.es.ESClient;
import vye.util.Roller;

public class MobFactory {
	
	public List<Mob> loadMobs(int num, String home) throws Exception {
		
		List<Mob> mobs = new ArrayList<Mob>();
		
		InputStream lnameInputStream = getClass().getResourceAsStream("/lnames.dat");
		BufferedReader lbfr = new BufferedReader(new InputStreamReader(lnameInputStream));
		InputStream fnameInputStream = getClass().getResourceAsStream("/ffnames.dat");
		BufferedReader fbfr = new BufferedReader(new InputStreamReader(fnameInputStream));
		InputStream mfnameInputStream = getClass().getResourceAsStream("/mfnames.dat");
		BufferedReader mbfr = new BufferedReader(new InputStreamReader(mfnameInputStream));
		
		List<String> lnames = new ArrayList<String>();
		List<String> fnames = new ArrayList<String>();
		List<String> mfnames = new ArrayList<String>();
		
		String lline = lbfr.readLine();
		while(lline!=null) {
			lnames.add(lline);
			lline = lbfr.readLine();
		}
		
		String fline = fbfr.readLine();
		while(fline!=null) {
			fnames.add(fline);
			fline = fbfr.readLine();
		}
		
		String mfline = mbfr.readLine();
		while(mfline!=null) {
			mfnames.add(mfline);
			mfline = mbfr.readLine();
		}

		for(int i=0; i<num; i++) {

			Mob mob = new Mob();
			mob.setHome(home);
			mob.setLname(Roller.randomFromList(lnames, false));
			
			if(mob.getGender() == 'f') {
				mob.setFname(Roller.randomFromList(fnames, false));				
			} else {
				mob.setFname(Roller.randomFromList(mfnames, false));
			}
			System.out.println("Adding " + mob.getFname() + " " + mob.getLname() + " :" +i);
			ESClient.post(mob);
			mobs.add(mob);
		}
		return mobs;
	}

}
