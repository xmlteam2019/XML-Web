package containermodel;

import java.util.ArrayList;

import helperclasses.DistanceMath;
import helperclasses.UslugeCalculations;
import mainmodel.Smestaj;
import mainmodel.Smestaj.Usluga;

public class TravelDetails {
	
	private ArrayList<Smestaj> smestaji;
	private double prosecnaUdaljenost;
	private ArrayList<Smestaj.Usluga> presekUsluga;
	
	public TravelDetails() {
		smestaji = new ArrayList<Smestaj>();
		prosecnaUdaljenost = 0;
		presekUsluga = new ArrayList<Smestaj.Usluga>(); 
	}
	
	public void calculateProsecnaUdaljenost(double selectedX, double selectedY) {
		prosecnaUdaljenost = DistanceMath.calculateAverageDistance(selectedX, selectedY, smestaji);
	}
	
	public void nadjiPresekUsluga() {
		presekUsluga = UslugeCalculations.nadjiPresekUsluga(smestaji);
	}

	public ArrayList<Smestaj> getSmestaji() {
		return smestaji;
	}

	public void setSmestaji(ArrayList<Smestaj> smestaji) {
		this.smestaji = smestaji;
	}
	
	public double getProsecnaUdaljenost() {
		return prosecnaUdaljenost;
	}

	public void setProsecnaUdaljenost(double prosecnaUdaljenost) {
		this.prosecnaUdaljenost = prosecnaUdaljenost;
	}

	public void addNewSmestaj(Smestaj s) {
		smestaji.add(s);
	}
	
	public ArrayList<Smestaj.Usluga> getPresekUsluga() {
		return presekUsluga;
	}

	public void setPresekUsluga(ArrayList<Smestaj.Usluga> presekUsluga) {
		this.presekUsluga = presekUsluga;
	}
	
}
