package appevents;

import containermodel.Rezervacija;
import mainmodel.Klijent;
import mainmodel.Smestaj;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class RezervacijaEvent {
	public Klijent klijent;
	public Smestaj smestaj;
	public Rezervacija rezervacija;
	
	public RezervacijaEvent() {
	}
	
	public RezervacijaEvent(Klijent klijent, Smestaj smestaj, Rezervacija rezervacija) {
		this.klijent = klijent;
		this.smestaj = smestaj;
		this.rezervacija = rezervacija;
	}
	
	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	
	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
	
}
