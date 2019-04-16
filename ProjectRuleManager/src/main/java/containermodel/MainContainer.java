package containermodel;

import java.util.ArrayList;
import java.util.HashMap;

import mainmodel.Agent;
import mainmodel.Klijent;
import mainmodel.Smestaj;

public class MainContainer {

	private ArrayList<Klijent> klijentContainer;
	private ArrayList<Agent> agentContainer;
	private ArrayList<Smestaj> smestajContainer;
	private HashMap<Klijent, ArrayList<Smestaj>> travelHistory;
	private HashMap<Klijent, ArrayList<Rezervacija>> reservationHistory;

	public MainContainer() {
		klijentContainer = new ArrayList<Klijent>();
		agentContainer = new ArrayList<Agent>();
		smestajContainer = new ArrayList<Smestaj>();
		travelHistory = new HashMap<Klijent, ArrayList<Smestaj>>();
		reservationHistory = new HashMap<Klijent, ArrayList<Rezervacija>>();
	}
	
	public HashMap<Klijent, ArrayList<Rezervacija>> getReservationHistory() {
		return reservationHistory;
	}

	public void setReservationHistory(HashMap<Klijent, ArrayList<Rezervacija>> reservationHistory) {
		this.reservationHistory = reservationHistory;
	}
	
	public ArrayList<Klijent> getKlijentContainer() {
		return klijentContainer;
	}

	public void setKlijentContainer(ArrayList<Klijent> klijentContainer) {
		this.klijentContainer = klijentContainer;
	}

	public ArrayList<Agent> getAgentContainer() {
		return agentContainer;
	}

	public void setAgentContainer(ArrayList<Agent> agentContainer) {
		this.agentContainer = agentContainer;
	}

	public ArrayList<Smestaj> getSmestajContainer() {
		return smestajContainer;
	}

	public void setSmestajContainer(ArrayList<Smestaj> smestajContainer) {
		this.smestajContainer = smestajContainer;
	}

	public HashMap<Klijent, ArrayList<Smestaj>> getKlijentTravelHistory() {
		return travelHistory;
	}

	public void setKlijentTravelHistory(HashMap<Klijent, ArrayList<Smestaj>> klijentTravelHistory) {
		this.travelHistory = klijentTravelHistory;
	}

	public void dodajNovogKlijenta(Klijent k) {
		klijentContainer.add(k);
		travelHistory.put(k, new ArrayList<Smestaj>());
		reservationHistory.put(k, new ArrayList<Rezervacija>());
	}

	public void dodajNoviSmestaj(Smestaj s) {
		smestajContainer.add(s);
	}

	public void dodajSmestajUTravelHistory(Klijent k, Smestaj s) {
		((ArrayList<Smestaj>) travelHistory.get(k)).add(s);		
	}
	
	public Boolean klijentJeBioUSmestaju(Klijent k, Smestaj s) {
		return travelHistory.get(k).contains(s);		
	}

	public void dodajRezervacijuUReservationHistory(Klijent k, Rezervacija r) {
		((ArrayList<Rezervacija>) reservationHistory.get(k)).add(r);
		
	}
	
}
