package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import containermodel.MainContainer;
import containermodel.Rezervacija;
import helperclasses.DateMath;
import mainmodel.Kategorija;
import mainmodel.Klijent;
import mainmodel.Lokacija;
import mainmodel.Smestaj;

public class appTests {
	
	@Test
	public void pokreniDodeluPopusta() {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("klijent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k1 = new Klijent("Bogdan", "Bogdanovic", Kategorija.GOLD);
	    	Klijent k2 = new Klijent("Cane", "Canic", Kategorija.BRONZE);
	    	Klijent k3 = new Klijent("Dragoje", "Dragojevic", Kategorija.SILVER);
	    	mainContainer.dodajNovogKlijenta(k1);
	    	mainContainer.dodajNovogKlijenta(k2);
	    	mainContainer.dodajNovogKlijenta(k3);
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7));
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), Kategorija.GOLD);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), Kategorija.PLATINUM);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), Kategorija.SILVER);
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	
	    	Date trenutniDatum = new Date();
	    	Rezervacija r1 = new Rezervacija(s1);
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r3 = new Rezervacija(s3, "05/01/2018");
	    	
	    	mainContainer.dodajRezervacijuUReservationHistory(k1, r1);
	    	mainContainer.dodajRezervacijuUReservationHistory(k2, r2);
	    	mainContainer.dodajRezervacijuUReservationHistory(k3, r3);
	    	
	    	/*
	    	kSession.insert(k1);
	    	kSession.insert(k2);
	    	kSession.insert(k3);
	    	*/
	    	
	    	HashMap<Rezervacija, Integer> razlikaUDanima = new HashMap<Rezervacija, Integer>();
	    	
	    	kSession.insert(r1);
	    	kSession.insert(r2);
	    	kSession.insert(r3);
	    	kSession.insert(trenutniDatum);
	    	kSession.insert(razlikaUDanima);
	    	
	    	kSession.fireAllRules();
	    	
	        assertThat(50, is(r1.getPopust()));
	        assertThat(25, is(r3.getPopust()));
	}

	@Test
	public void pokreniCenuOtkazivanja() {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("klijent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k1 = new Klijent("Bogdan", "Bogdanovic", Kategorija.GOLD);
	    	Klijent k2 = new Klijent("Cane", "Canic", Kategorija.BRONZE);
	    	Klijent k3 = new Klijent("Dragoje", "Dragojevic", Kategorija.SILVER);
	    	mainContainer.dodajNovogKlijenta(k1);
	    	mainContainer.dodajNovogKlijenta(k2);
	    	mainContainer.dodajNovogKlijenta(k3);
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7));
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), Kategorija.GOLD);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), Kategorija.PLATINUM);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), Kategorija.SILVER);
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	//Date trenutniDatum = new Date();
	    	//Rezervacija r1 = new Rezervacija(s1);
	    	Rezervacija r1 = new Rezervacija(s2, "20/03/2019", "23/03/2019");
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019", "28/03/2019");
	    	Rezervacija r3 = new Rezervacija(s2, "30/03/2019", "04/04/2019");
	    	
	    	r1.unesiDatumOtkazivanjaPrekoStringa("20/01/2019");
	    	r2.unesiDatumOtkazivanjaPrekoStringa("20/03/2019");
	    	r3.unesiDatumOtkazivanjaPrekoStringa("01/03/2019");
	    	
	    	r1.izracunajRazlikuUDanima();
	    	r2.izracunajRazlikuUDanima();
	    	r3.izracunajRazlikuUDanima();
	    	
	    	mainContainer.dodajRezervacijuUReservationHistory(k1, r1);
	    	mainContainer.dodajRezervacijuUReservationHistory(k2, r2);
	    	mainContainer.dodajRezervacijuUReservationHistory(k3, r3);
	    	
	    	//HashMap<Rezervacija, Integer> razlikaUDanima = new HashMap<Rezervacija, Integer>();
	    	
	    	kSession.insert(r1);
	    	kSession.insert(r2);
	    	kSession.insert(r3);
	    	//kSession.insert(trenutniDatum);
	    	//kSession.insert(razlikaUDanima);
	    	
	    	kSession.fireAllRules();
	    	
	        assertThat(0, is(r1.getPopust()));
	        assertThat(55, is(r2.getPopust()));
	        assertThat(30, is(r3.getPopust()));
	}

}
