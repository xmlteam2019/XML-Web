package containermodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import helperclasses.DateMath;
import mainmodel.Klijent;
import mainmodel.Smestaj;

public class Rezervacija {
	private Klijent klijent;
	private Smestaj smestaj;
	private Date datumZakazivanja;
	private Date doKadaJeZakazano;
	private Date datumOtkazivanja;
	private int popust;
	private int razlikaUDanima;
	private Double rating = null;
	private Double ukupnaCena;

	public Rezervacija() {
		smestaj = new Smestaj();
		datumZakazivanja = new Date();
		doKadaJeZakazano = new Date();
		datumOtkazivanja = null;
		popust = 0;
		razlikaUDanima = 0;
	}
	
	public Rezervacija(Smestaj smestaj) {
		this.smestaj = smestaj;
		datumZakazivanja = new Date();
		doKadaJeZakazano = new Date();
		datumOtkazivanja = null;
		popust = 0;
		razlikaUDanima = 0;
	}
	
	public Rezervacija(Smestaj smestaj, Date datumZakazivanja) {
		this.smestaj = smestaj;
		this.datumZakazivanja = datumZakazivanja;
		this.doKadaJeZakazano = datumZakazivanja;
		datumOtkazivanja = null;
		popust = 0;
		razlikaUDanima = 0;
	}
	
	public Rezervacija(Smestaj smestaj, String dateString) {
		this.smestaj = smestaj;
		datumZakazivanja = DateMath.getDateFromString(dateString);
		doKadaJeZakazano = DateMath.getDateFromString(dateString);
		popust = 0;
		razlikaUDanima = 0;
	}
	
	public Rezervacija(Smestaj smestaj, String odKada, String doKada) {
		this.smestaj = smestaj;
		datumZakazivanja = DateMath.getDateFromString(odKada);
		doKadaJeZakazano = DateMath.getDateFromString(doKada);
		popust = 0;
		razlikaUDanima = 0;
	}
	
	public Rezervacija(Klijent klijent, Smestaj smestaj, String odKada, String doKada) {
		this.klijent = klijent;
		this.smestaj = smestaj;
		datumZakazivanja = DateMath.getDateFromString(odKada);
		doKadaJeZakazano = DateMath.getDateFromString(doKada);
		popust = 0;
		razlikaUDanima = 0;
	}

	public void setujCenuKrozPopust(Double cena) {
		ukupnaCena = cena - ((cena*popust)/100);
	}
	
	public void izracunajRazlikuUDanima() {
		razlikaUDanima = DateMath.calculateDateDistanceInDays(datumOtkazivanja, 
															  datumZakazivanja);
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}
	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
	public Date getDatumZakazivanja() {
		return datumZakazivanja;
	}
	public void setDatumZakazivanja(Date datumZakazivanja) {
		this.datumZakazivanja = datumZakazivanja;
	}
	public Date getDatumOtkazivanja() {
		return datumOtkazivanja;
	}
	public void setDatumOtkazivanja(Date datumOtkazivanja) {
		this.datumOtkazivanja = datumOtkazivanja;
	}
	
	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
	
	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	
	public int getRazlikaUDanima() {
		return razlikaUDanima;
	}

	public void setRazlikaUDanima(int razlikaUDanima) {
		this.razlikaUDanima = razlikaUDanima;
	}

	public void unesiDatumOtkazivanjaPrekoStringa(String string) {
		datumOtkazivanja = DateMath.getDateFromString(string);
	}

	public Date getDoKadaJeZakazano() {
		return doKadaJeZakazano;
	}

	public void setDoKadaJeZakazano(Date doKadaJeZakazano) {
		this.doKadaJeZakazano = doKadaJeZakazano;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(Double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
	
	public boolean hasKlijent(Klijent k) {
		if(this.klijent.equals(k)) {
			return true;
		}
		return false;
	}
	
	public boolean hasSmestaj(Smestaj s) {
		if(this.smestaj.equals(s)) {
			return true;
		}
		return false;
	}
}
