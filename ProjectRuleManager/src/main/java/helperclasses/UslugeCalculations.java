package helperclasses;

import java.util.ArrayList;

import model.Smestaj;

public class UslugeCalculations {

	public static ArrayList<Smestaj.Usluga> nadjiPresekUsluga(ArrayList<Smestaj> smestaji) {
		ArrayList<Smestaj.Usluga> presekUsluga = new ArrayList<Smestaj.Usluga>();
		ArrayList<Smestaj.Usluga> ignoreList = new ArrayList<Smestaj.Usluga>();
		for(Smestaj.Usluga u: Smestaj.Usluga.values()) {
			presekUsluga.add(u);
		}
		
		for(Smestaj s: smestaji) {
			for(Smestaj.Usluga u: presekUsluga) {
				if(!((Boolean)s.getDodatneUsluge().get(u)) && !ignoreList.contains(u)) {
					ignoreList.add(u);
				}
			}
			for(Smestaj.Usluga u: ignoreList) {
				presekUsluga.remove(u);
			}
		}
		return presekUsluga;
	}
	
}
