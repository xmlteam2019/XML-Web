package appevents;

import org.kie.api.definition.type.Role;

import mainmodel.Agent;
import mainmodel.Klijent;

@Role(Role.Type.EVENT)
public class ObavestitiKlijentaEvent {
	public Agent agent;
	public Klijent klijent;
	public String poruka;
	
	public ObavestitiKlijentaEvent() {
	}
	
	public ObavestitiKlijentaEvent(Agent agent, Klijent klijent, String poruka) {
		this.agent = agent;
		this.klijent = klijent;
		this.poruka = poruka;
	}
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
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
