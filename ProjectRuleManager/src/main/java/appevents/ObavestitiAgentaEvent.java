package appevents;

import org.kie.api.definition.type.Role;

import mainmodel.Agent;
import mainmodel.Klijent;
import mainmodel.Smestaj;

@Role(Role.Type.EVENT)
public class ObavestitiAgentaEvent {
	public Agent agent;
	public Smestaj smestaj;
	public String poruka;
	
	public ObavestitiAgentaEvent() {
	}
	
	public ObavestitiAgentaEvent(Agent agent, String poruka) {
		this.agent = agent;
		this.poruka = poruka;
	}
	
	public ObavestitiAgentaEvent(Agent agent, Smestaj smestaj, String poruka) {
		this.agent = agent;
		this.poruka = poruka;
		this.smestaj = smestaj;
	}
	
	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
}
