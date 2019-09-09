package mainmodel;

import java.util.ArrayList;
import java.util.Date;

import helperclasses.DateMath;

public class Klijent extends Osoba {

	private Kategorija kategorija;
	private Date datumRegistracije = new Date();
	private ArrayList<Kupon> kuponi = new ArrayList<Kupon>();
	
	public Klijent() {
		kategorija = Kategorija.BRONZE;
	}
	
	public Klijent(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
		kategorija = Kategorija.BRONZE;
	}
	
	public Klijent(String ime, String prezime, Kategorija kategorija) {
		this.ime = ime;
		this.prezime = prezime;
		this.kategorija = kategorija;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Kategorija getKategorija() {
		return kategorija;
	}
	
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Date getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public void unesiDatumPrekoStringa(String string) {
		datumRegistracije = DateMath.getDateFromString(string);
		
	}
	
	public void giveKupon(Kupon k) {
		kuponi.add(k);
	}
	
}
