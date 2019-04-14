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
	
	public MainContainer() {
		klijentContainer = new ArrayList<Klijent>();
		agentContainer = new ArrayList<Agent>();
		smestajContainer = new ArrayList<Smestaj>();
		travelHistory = new HashMap<Klijent, ArrayList<Smestaj>>();
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
	}

	public void dodajNoviSmestaj(Smestaj s) {
		smestajContainer.add(s);
	}
	
}
