package appmain;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import containermodel.MainContainer;
import containermodel.Rezervacija;
import mainmodel.Kategorija;
import mainmodel.Klijent;
import mainmodel.Lokacija;
import mainmodel.Smestaj;

import java.awt.geom.Point2D;
import java.util.Date;
import java.util.HashMap;

public class MyApp {

	public static void main(String[] args) {
		//pokreniPreporukuSmestaja();
		pokreniDodeluPopusta();
	}
	
	public static void pokreniPreporukuSmestaja() {
        try {
			//Load-ovanje knowledge baze.
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
		    /*
		     * Pravljenje nove sesije.
		     * "klijent-modul-rules" se koristi kako bi program znao
		       iz kog paketa da vadi rule-ove.
		     * U fajlu "kmodule.xml" je izvrseno ovo mapiranje.
		     */
	    	KieSession kSession = kContainer.newKieSession("klijent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k = new Klijent("Aleksandar", "Aleksandrovic", Kategorija.GOLD);
	    	mainContainer.dodajNovogKlijenta(k);
	    	
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
	    	mainContainer.dodajSmestajUTravelHistory(k,s3);
	    	mainContainer.dodajSmestajUTravelHistory(k,s4);
	    	mainContainer.dodajSmestajUTravelHistory(k,s5);
	    	
	    	Point2D izabranaLokacija = new Point2D.Double(1.1, 2.2);
	    	/*
	    	HashMap<Smestaj, Double> udaljenosti = DistanceMath.calculateAndGenerateDistances(izabranaLokacija,
	    																					  mainContainer.getSmestajContainer());
			*/
	    	HashMap<Smestaj, Double> distanceOdMesta = new HashMap<Smestaj, Double>();
	    	
	    	//kSession.setGlobal("distanceOdMesta", distanceOdMesta);
	    	kSession.insert(k);
	    	kSession.insert(mainContainer);
	    	kSession.insert(izabranaLokacija);
	    	kSession.insert(distanceOdMesta);
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}

	public static void pokreniDodeluPopusta() {
		try {
			//Load-ovanje knowledge baze.
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
		    /*
		     * Pravljenje nove sesije.
		     * "klijent-modul-rules" se koristi kako bi program znao
		       iz kog paketa da vadi rule-ove.
		     * U fajlu "kmodule.xml" je izvrseno ovo mapiranje.
		     */
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
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
}
