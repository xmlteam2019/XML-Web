package containermodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import mainmodel.Agent;
import mainmodel.Klijent;
import mainmodel.Smestaj;
import mainmodel.Smestaj.Usluga;

public class MainContainer {

	private ArrayList<Klijent> klijentContainer;
	private ArrayList<Agent> agentContainer;
	private ArrayList<Smestaj> smestajContainer;
	private HashMap<Klijent, ArrayList<Smestaj>> travelHistory;
	private HashMap<Klijent, ArrayList<Rezervacija>> reservationHistory;
	private HashMap<Klijent, ArrayList<Usluga>> presekUsluga;
	private HashMap<Smestaj, Klijent> zauzetiSmestaji;

	public MainContainer() {
		klijentContainer = new ArrayList<Klijent>();
		agentContainer = new ArrayList<Agent>();
		smestajContainer = new ArrayList<Smestaj>();
		travelHistory = new HashMap<Klijent, ArrayList<Smestaj>>();
		reservationHistory = new HashMap<Klijent, ArrayList<Rezervacija>>();
		presekUsluga = new HashMap<Klijent, ArrayList<Usluga>>();
		zauzetiSmestaji = new HashMap<Smestaj, Klijent>();
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
	
	public HashMap<Smestaj, Klijent> getZauzetiSmestaji() {
		return zauzetiSmestaji;
	}

	public void setZauzetiSmestaji(HashMap<Smestaj, Klijent> zauzetiSmestaji) {
		this.zauzetiSmestaji = zauzetiSmestaji;
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
	
	public ArrayList<Smestaj.Usluga> nadjiPresekUsluga(ArrayList<Smestaj> smestaji) {
		ArrayList<Smestaj.Usluga> skupUsluga = new ArrayList<Smestaj.Usluga>();
		ArrayList<Smestaj.Usluga> presekUsluga = new ArrayList<Smestaj.Usluga>();
		for(Smestaj s : smestaji) {
			Iterator it = s.getDodatneUsluge().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if((Boolean) pair.getValue() && !skupUsluga.contains((Usluga) pair.getKey())) {
		        	skupUsluga.add((Usluga) pair.getKey());
		        	presekUsluga.add((Usluga) pair.getKey());
		        }
		        //it.remove(); // avoids a ConcurrentModificationException
		    }
		}
		
		for(Usluga u : skupUsluga) {
			for(Smestaj s : smestaji) {
				if(s.getDodatneUsluge().get(u) == false) {
					presekUsluga.remove(u);
					break;
				}
			}
		}
		for(Usluga u : presekUsluga) {
			System.out.println("Jedna od usluga u preseku je " + u);
		}
		return presekUsluga;
	}

	public void uvediPresekUslugaZaOsobu(Klijent k, ArrayList<Smestaj> smestaji) {
		ArrayList<Usluga> uslugeOdZnacaja = nadjiPresekUsluga(smestaji);
		presekUsluga.put(k, uslugeOdZnacaja);
	}
	
	public ArrayList<Usluga> nabaviPresekUslugaZaOsobu(Klijent k) {		
		return presekUsluga.get(k);		
	}
	
	public Boolean smestajSadrziUsluge(Klijent k, Smestaj s) {
			ArrayList<Usluga> usluge = presekUsluga.get(k);
			if(usluge != null) {
				for(Usluga u : usluge) {
					if(s.getDodatneUsluge().get(u) != true) {
						return false;
					}
				}
				return true;
			}
		return false;
	}
	
	public int klBoraviloVisePuta(Smestaj smestaj, int brojPuta) {
		int brojPutaCounter = 0;
		int brojKlijenata = 0;
		Iterator it = travelHistory.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        for(Smestaj s : (ArrayList<Smestaj>) pair.getValue()) {
	        	if(s.equals(smestaj)) {
	        		brojPutaCounter++;
	        	}
	        	if(brojPutaCounter == brojPuta) {
	        		brojPutaCounter = 0;
	        		brojKlijenata++;
	        		break;
	        	}
	        }
		}
		return brojKlijenata;
	}
	
	public int brojRazlicitihPoseta(Klijent klijent) {
		ArrayList<Smestaj> sviSmestaji = travelHistory.get(klijent);
		ArrayList<Smestaj> unikantniSmestaji = new ArrayList<Smestaj>();
		for(Smestaj s : sviSmestaji) {
			if(!unikantniSmestaji.contains(s)) {
				unikantniSmestaji.add(s);
			}
		}
		return unikantniSmestaji.size();
	}
	
	public void zauzmiSmestaj(Smestaj smestaj, Klijent klijent) {
		zauzetiSmestaji.put(smestaj, klijent);
	}
	
	public Boolean klijentPosetioSmestaj(Klijent klijent,Smestaj smestaj) {
		if(travelHistory.get(klijent).contains(smestaj)) {
			return true;
		}
		return false;
	}
	
	public boolean smestajJeZauzet(Smestaj smestaj) {
		if(zauzetiSmestaji.containsKey(smestaj)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Smestaj> getZauzeteSmestajeAsList() {
		if(zauzetiSmestaji.size() > 0) {
			return 	new ArrayList<Smestaj>(zauzetiSmestaji.keySet());
		}
		return new ArrayList<Smestaj>();
	}
	
	public int odrediPopustNaOsnovuSlicnih(Smestaj s) {
		int prosek = 0;
		ArrayList<Smestaj> zauzetiSmestaji = getZauzeteSmestajeAsList();
		ArrayList<Smestaj> smestajiOdInteresa = new ArrayList<Smestaj>();
		for(Smestaj smestaj: zauzetiSmestaji) {
			if(smestaj.getKategorija().equals(s.getKategorija())) {
				smestajiOdInteresa.add(smestaj);
			}
		}
		int brojSmestaja = smestajiOdInteresa.size();
		if(brojSmestaja == 0) {
			return 10;
		} else {
			for(Smestaj smestaj: smestajiOdInteresa) {
				prosek+=smestaj.getProsek();
			}
		}
		prosek/=brojSmestaja;
		if(prosek >= s.getProsek()) {
			return 20;
		} else {
			return 30;
		}
	}
}
