package vye;

import vye.util.Roller;

public class Mob {
	
	private int str;
	private int intl;
	private int wis;
	private int dex;
	private int con;
	private int cha;
	
	private String fname;
	private String lname;
	
	private String home;
	private char gender;
	
	public static char MALE = 'm';
	public static char FEMALE = 'f';
	
	public Mob() {

		this.str = Roller.roll(3, 6);
		this.intl = Roller.roll(3, 6);
		this.wis = Roller.roll(3, 6);
		this.dex = Roller.roll(3, 6);
		this.con = Roller.roll(3, 6);
		this.cha = Roller.roll(3, 6);
		
		if(Roller.roll(1, 2) == 1) {
			this.gender = MALE;
		} else {
			this.gender = FEMALE;
		}
	}
		
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getIntl() {
		return intl;
	}
	public void setIntl(int intl) {
		this.intl = intl;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lname);
		sb.append(", ");
		sb.append(fname);
		sb.append(": ");
		sb.append(str);
		sb.append(", ");
		sb.append(intl);
		sb.append(", ");
		sb.append(wis);
		sb.append(", ");
		sb.append(dex);
		sb.append(", ");
		sb.append(con);
		sb.append(", ");
		sb.append(cha);
		return sb.toString();
	}
}
