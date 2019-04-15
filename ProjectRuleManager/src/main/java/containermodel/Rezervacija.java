package containermodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mainmodel.Klijent;
import mainmodel.Smestaj;

public class Rezervacija {
	private Klijent klijent;
	private Smestaj smestaj;
	private Date datumZakazivanja;
	private Date datumOtkazivanja;
	private int popust;

	public Rezervacija() {
		smestaj = new Smestaj();
		datumZakazivanja = new Date();
		datumOtkazivanja = null;
		popust = 0;
	}
	
	public Rezervacija(Smestaj smestaj) {
		this.smestaj = smestaj;
		datumZakazivanja = new Date();
		datumOtkazivanja = null;
		popust = 0;
	}
	
	public Rezervacija(Smestaj smestaj, Date datumZakazivanja) {
		this.smestaj = smestaj;
		this.datumZakazivanja = datumZakazivanja;
		datumOtkazivanja = null;
		popust = 0;
	}
	
	public Rezervacija(Smestaj smestaj, String dateString) {
		this.smestaj = smestaj;
		try {
			datumZakazivanja = (new SimpleDateFormat("dd/MM/yyyy")).parse(dateString);
		} catch (ParseException e) {
			datumZakazivanja = new Date();
		}
		popust = 0;
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
}
