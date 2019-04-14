package containermodel;

import java.util.HashMap;

import mainmodel.Klijent;
import mainmodel.Smestaj;

public class KlijentTravelHistory {
	
	private HashMap<Klijent, TravelDetails> travelHistory;
	
	public KlijentTravelHistory() {
		travelHistory = new HashMap<Klijent, TravelDetails>();
	}

	public HashMap<Klijent, TravelDetails> getHistory() {
		return travelHistory;
	}

	public void setHistory(HashMap<Klijent, TravelDetails> history) {
		this.travelHistory = history;
	}
	
	public void addClientToHistory(Klijent k) {
		travelHistory.put(k, new TravelDetails());
	}
	
	public void removeClientFromHistory(Klijent k) {
		travelHistory.remove(k);
	}
	
	public void clearClientHistory(Klijent k) {
		travelHistory.replace(k, new TravelDetails());
	}
	
	public void addSmestajToClientHistory(Klijent k, Smestaj s) {
		((TravelDetails) travelHistory.get(k)).addNewSmestaj(s);
	}
	
	public double getKlijentProsecnaUdaljenost(Klijent k) {
		return ((TravelDetails) travelHistory.get(k)).getProsecnaUdaljenost();
	}
	
}
