package mainmodel;

import java.util.ArrayList;

public class Agent extends Osoba {
	
	protected String adresa;
	protected String maticniBroj;
	protected ArrayList<String> forbiddenPhrases = new ArrayList<String>();

	public Agent(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
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
	
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getMaticniBroj() {
		return maticniBroj;
	}
	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public ArrayList<String> getForbiddenPhrases() {
		return forbiddenPhrases;
	}

	public void setForbiddenPhrases(ArrayList<String> forbiddenPhrases) {
		this.forbiddenPhrases = forbiddenPhrases;
	}
	
	public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
	
	public boolean containsBadPhrases(String text) {
		for(String phrase : forbiddenPhrases) {
			if(containsIgnoreCase(text, phrase)) {
				return true;
			}
		}
		return false;
	}
	
	public void addPhrase(String phrase) {
		forbiddenPhrases.add(phrase);
	}
}
