package model;

public class Klijent extends Osoba {

	private Kategorija kategorija;
	
	public Klijent() {
		kategorija = Kategorija.BRONZE;
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
	
}
