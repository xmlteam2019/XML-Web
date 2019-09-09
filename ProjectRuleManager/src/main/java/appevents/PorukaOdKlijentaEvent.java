package appevents;

import org.kie.api.definition.type.Role;

import mainmodel.Agent;
import mainmodel.Klijent;
import mainmodel.Smestaj;

@Role(Role.Type.EVENT)
public class PorukaOdKlijentaEvent {
	public Klijent klijent;
	public Smestaj smestaj;
	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}

	public String poruka;
	
	public PorukaOdKlijentaEvent() {
	}
	
	public PorukaOdKlijentaEvent(Klijent klijent, String poruka) {
		this.klijent = klijent;
		this.poruka = poruka;
	}
	
	public PorukaOdKlijentaEvent(Klijent klijent, Smestaj smestaj, String poruka) {
		this.klijent = klijent;
		this.smestaj = smestaj;
		this.poruka = poruka;
	}


	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
}
