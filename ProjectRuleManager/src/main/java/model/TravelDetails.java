package model;

import java.util.ArrayList;

import helperclasses.DistanceMath;
import helperclasses.UslugeCalculations;

public class TravelDetails {
	
	private ArrayList<Smestaj> smestaji;
	private double prosecnaUdaljenost;
	private ArrayList<Smestaj.Usluga> presekUsluga;

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
