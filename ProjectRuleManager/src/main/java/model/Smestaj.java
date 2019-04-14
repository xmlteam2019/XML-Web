package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	private HashMap<Usluga, Boolean> dodatneUsluge;
	private Date datumOdrzavanja;
	private HashMap<Meseci, Integer> terminskiPlanCena;
	private Kategorija kategorija;
	
	public Smestaj() {
		kategorija = Kategorija.BRONZE;
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
	
}
