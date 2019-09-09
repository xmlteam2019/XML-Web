package mainmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Smestaj {
	
	enum TipSmestaja {
		HOTEL,
		BED_AND_BREAKFAST,
		APARTMAN
	}
	
	public enum Usluga {
		PARKING,
		WIFI,
		DORUCAK,
		POLU_PANSION,
		PANSION,
		ALL_INCLUSIVE,
		KUCNI_LJUBIMCI,
		TV,
		KUHINJA,
		PRIVATNO_KUPATILO,
	}
	
	private Lokacija lokacija;
	private TipSmestaja tipSmestaja;
	private String opis;
	private ArrayList<String> slike;
	private int brojOsoba;
	private HashMap<Usluga, Boolean> dodatneUsluge = new HashMap<Usluga,Boolean>();
	private Date datumOdrzavanja;
	private HashMap<Meseci, Integer> terminskiPlanCena;
	private Kategorija kategorija;
	private Double rating = null;
	private int popust = 0;
	private Double prosek = 0.0;
	private int vOdRez = 0;

	public void populateUsluge() {
		for(Usluga usluga : Usluga.values()){
			dodatneUsluge.put(usluga, false);
		}
	}
	
	public Smestaj() {
		kategorija = Kategorija.BRONZE;
		populateUsluge();
	}
	
	public Smestaj(Lokacija lokacija) {
		this.lokacija = lokacija;
		tipSmestaja = TipSmestaja.APARTMAN;
		opis = "";
		slike = new ArrayList<String>();
		brojOsoba = 1;
		dodatneUsluge = new HashMap<Usluga, Boolean>();
		datumOdrzavanja = new Date();
		terminskiPlanCena = new HashMap<Meseci, Integer>();
		kategorija = Kategorija.BRONZE;
		populateUsluge();
	}
	
	public Smestaj(Lokacija lokacija, Kategorija kategorija) {
		this.lokacija = lokacija;
		tipSmestaja = TipSmestaja.APARTMAN;
		opis = "";
		slike = new ArrayList<String>();
		brojOsoba = 1;
		dodatneUsluge = new HashMap<Usluga, Boolean>();
		datumOdrzavanja = new Date();
		terminskiPlanCena = new HashMap<Meseci, Integer>();
		this.kategorija = kategorija;
		populateUsluge();
	}
	
	public Smestaj(Lokacija lokacija, TipSmestaja tipSmestaja, String opis, ArrayList<String> slike, int brojOsoba,
			HashMap<Usluga, Boolean> dodatneUsluge, Date datumOdrzavanja, HashMap<Meseci, Integer> terminskiPlanCena) {
		this.lokacija = lokacija;
		this.tipSmestaja = tipSmestaja;
		this.opis = opis;
		this.slike = slike;
		this.brojOsoba = brojOsoba;
		this.dodatneUsluge = dodatneUsluge;
		this.datumOdrzavanja = datumOdrzavanja;
		this.terminskiPlanCena = terminskiPlanCena;
		kategorija = Kategorija.BRONZE;
	}
	
	public Smestaj(Lokacija lokacija, TipSmestaja tipSmestaja, String opis, ArrayList<String> slike, int brojOsoba,
			HashMap<Usluga, Boolean> dodatneUsluge, Date datumOdrzavanja, HashMap<Meseci, Integer> terminskiPlanCena,
			Kategorija kategorija) {
		this.lokacija = lokacija;
		this.tipSmestaja = tipSmestaja;
		this.opis = opis;
		this.slike = slike;
		this.brojOsoba = brojOsoba;
		this.dodatneUsluge = dodatneUsluge;
		this.datumOdrzavanja = datumOdrzavanja;
		this.terminskiPlanCena = terminskiPlanCena;
		this.kategorija = kategorija;
	}



	public Smestaj(Lokacija lokacija, Double i) {
		this.lokacija = lokacija;
		tipSmestaja = TipSmestaja.APARTMAN;
		opis = "";
		slike = new ArrayList<String>();
		brojOsoba = 1;
		dodatneUsluge = new HashMap<Usluga, Boolean>();
		datumOdrzavanja = new Date();
		terminskiPlanCena = new HashMap<Meseci, Integer>();
		kategorija = Kategorija.BRONZE;
		rating = i;
		populateUsluge();
	}

	public Lokacija getLokacija() {
		return lokacija;
	}
	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}
	public TipSmestaja getTipSmestaja() {
		return tipSmestaja;
	}
	public void setTipSmestaja(TipSmestaja tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public ArrayList<String> getSlike() {
		return slike;
	}
	public void setSlike(ArrayList<String> slike) {
		this.slike = slike;
	}
	public int getBrojOsoba() {
		return brojOsoba;
	}
	public void setBrojOsoba(int brojOsoba) {
		this.brojOsoba = brojOsoba;
	}
	public HashMap<Usluga, Boolean> getDodatneUsluge() {
		return dodatneUsluge;
	}
	public void setDodatneUsluge(HashMap<Usluga, Boolean> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}
	public Date getDatumOdrzavanja() {
		return datumOdrzavanja;
	}
	public void setDatumOdrzavanja(Date datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}
	public HashMap<Meseci, Integer> getTerminskiPlanCena() {
		return terminskiPlanCena;
	}
	public void setTerminskiPlanCena(HashMap<Meseci, Integer> terminskiPlanCena) {
		this.terminskiPlanCena = terminskiPlanCena;
	}
	
	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public void pruziUsluge(ArrayList<Usluga> usluge) {
		Iterator i = usluge.iterator();
		while (i.hasNext()) {
			dodatneUsluge.replace((Usluga) i.next(),true);
	    }
	}
	
	public void setPopust(int popust) {
		this.popust = popust;
	}
	
	public int getPopust() {
		return popust;
	}
	
	public Double calculateProsek() {
		int prosek = 0;
		Iterator it = terminskiPlanCena.entrySet().iterator();
		while (it.hasNext()) {
			 Map.Entry pair = (Map.Entry)it.next();
			 prosek += (Integer) pair.getValue();
	      }
		return (double) prosek/(terminskiPlanCena.size()); 
	}

	public Double getProsek() {
		return prosek;
	}

	public void setTestProsek(Double prosek) {
		this.prosek = prosek;
	}
	
	public int getVOdRez() {
		return vOdRez;
	}

	public void setTestVOdRez(int vOdRez) {
		this.vOdRez = vOdRez;
	}
}
