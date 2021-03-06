package appmain;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import containermodel.MainContainer;
import containermodel.Rezervacija;
import helperclasses.DateMath;
import mainmodel.Agent;
import mainmodel.Kategorija;
import mainmodel.Klijent;
import mainmodel.Lokacija;
import mainmodel.Smestaj;
import mainmodel.Smestaj.Usluga;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class MyApp {

	public static void main(String[] args) {
		//pokreniPreporukuSmestaja();
		//pokreniDodeluPopusta();
		//popustSmestajimaUcestaliBoravak();
		//popustSmestajimaPosetioViseMesta();
		//pokreniCenuOtkazivanja();
		//pokreniKategorijuSmestaja();
		//pokreniKategorijuKlijenta();
		//pokreniAgentPravila();
		//pokreniAdmSaKlAg();
		pokreniRezervacijuIOtkazivanje();
	}
	
	public static void pokreniRezervacijuIOtkazivanje() {
        try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("admin-modul-rules");
	    	
	    	Klijent k1 = new Klijent("Andrej", "Andrejovic", Kategorija.GOLD);

	    	Lokacija lokacija = new Lokacija("JEDAN", 15.1, 11.2);
	    	Smestaj s1 = new Smestaj(lokacija);
	    	Rezervacija r1 = new Rezervacija(k1, s1, "20/03/2018", "23/03/2018");
	    	
	    	//kSession.insert(k1);
	    	kSession.insert(r1);
	    	//kSession.insert(s1);
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}
	
	public static void pokreniAdmSaKlAg() {
        try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("admin-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Agent a1 = new Agent("Stevo", "Stevic");

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
	    	
	    	Rezervacija r1 = new Rezervacija(s1);
	    	Rezervacija r11 = new Rezervacija(s1);
	    	Rezervacija r12 = new Rezervacija(s1);
	    	Rezervacija r13 = new Rezervacija(s1);
	    	Rezervacija r14 = new Rezervacija(s1);
	    	Rezervacija r15 = new Rezervacija(s1);
	    	Rezervacija r16 = new Rezervacija(s1);
	    	Rezervacija r17 = new Rezervacija(s1);
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r21 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r22 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r23 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r24 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r25 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r26 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r27 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r28 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r29 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r31 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r32 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r33 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r34 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r35 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r36 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r37 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r38 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r39 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r41 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r42 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r3 = new Rezervacija(s3, "05/01/2018");
	    	
	    	kSession.insert(a1);
	    	kSession.insert(r1);
	    	kSession.insert(r11);
	    	kSession.insert(r12);
	    	kSession.insert(r13);
	    	kSession.insert(r14);
	    	kSession.insert(r15);
	    	kSession.insert(r16);
	    	kSession.insert(r17);
	    	kSession.insert(r2);
	    	kSession.insert(r21);
	    	kSession.insert(r22);
	    	kSession.insert(r23);
	    	kSession.insert(r24);
	    	kSession.insert(r25);
	    	kSession.insert(r26);
	    	kSession.insert(r27);
	    	kSession.insert(r28);
	    	kSession.insert(r29);
	    	kSession.insert(r31);
	    	kSession.insert(r32);
	    	kSession.insert(r33);
	    	kSession.insert(r34);
	    	kSession.insert(r35);
	    	kSession.insert(r36);
	    	kSession.insert(r37);
	    	kSession.insert(r38);
	    	kSession.insert(r39);
	    	kSession.insert(r41);
	    	kSession.insert(r42);
	    	kSession.insert(r3);
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}
	
	public static void pokreniAgentPravila() {
        try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("agent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Agent a = new Agent("Stevo", "Stevic");
	    	a.addPhrase("poveca popust");
	    	
	    	Klijent k1 = new Klijent("Andrej", "Andrejovic", Kategorija.GOLD);
	    	Klijent k2 = new Klijent("BAndrej", "BAndrejovic", Kategorija.GOLD);
	    	Klijent k3 = new Klijent("CAndrej", "CAndrejovic", Kategorija.GOLD);
	    	Klijent k4 = new Klijent("DAndrej", "DAndrejovic", Kategorija.GOLD);
	    	Klijent k5 = new Klijent("FAndrej", "FAndrejovic", Kategorija.GOLD);
	    	mainContainer.dodajNovogKlijenta(k1);
	    	mainContainer.dodajNovogKlijenta(k2);
	    	mainContainer.dodajNovogKlijenta(k3);
	    	mainContainer.dodajNovogKlijenta(k4);
	    	mainContainer.dodajNovogKlijenta(k5);
	    	Lokacija lokacija = new Lokacija("JEDAN", 15.1, 11.2);
	    	Smestaj s1 = new Smestaj(lokacija);
	    	s1.setTestProsek(10.1);
	    	s1.setTestVOdRez(17);
	    	Smestaj s2 = new Smestaj(lokacija);
	    	s2.setTestProsek(5.3);
	    	Smestaj s3 = new Smestaj(lokacija);
	    	Smestaj s4 = new Smestaj(lokacija);
	    	Smestaj s5 = new Smestaj(lokacija);
	    	Rezervacija r = new Rezervacija(k1, s1, "20/03/2018", "23/03/2018");
	    	
	    	/*
	    	mainContainer.zauzmiSmestaj(s1,k1);
	    	mainContainer.zauzmiSmestaj(s2,k2);
	    	mainContainer.zauzmiSmestaj(s3,k3);
	    	mainContainer.zauzmiSmestaj(s4,k4);
	    	mainContainer.zauzmiSmestaj(s5,k5);
	    	*/
	    	
	    	ArrayList<Smestaj> smestajiNaIstomMestu = new ArrayList<Smestaj>();
	    	smestajiNaIstomMestu.add(s2);
	    	smestajiNaIstomMestu.add(s3);
	    	smestajiNaIstomMestu.add(s4);
	    	smestajiNaIstomMestu.add(s5);
	    	
	    	kSession.insert(a);
	    	kSession.insert(k1);
	    	kSession.insert(s1);
	    	kSession.insert(s2);
	    	kSession.insert(mainContainer);
	    	kSession.insert(smestajiNaIstomMestu);
	    	kSession.insert(r);
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}
	
	public static void pokreniPreporukuSmestaja() {
        try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("klijent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k = new Klijent("Andrej", "Andrejovic", Kategorija.GOLD);
	    	mainContainer.dodajNovogKlijenta(k);
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7));
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), Kategorija.GOLD);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), Kategorija.PLATINUM);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), Kategorija.SILVER);
	    	
	    	s1.pruziUsluge(new ArrayList<Smestaj.Usluga>(
	    			Arrays.asList(Smestaj.Usluga.PANSION,
	    						  Smestaj.Usluga.KUCNI_LJUBIMCI,
	    						  Smestaj.Usluga.TV)
	    	));
	    	s2.pruziUsluge(new ArrayList<Smestaj.Usluga>(
	    			Arrays.asList(Smestaj.Usluga.PANSION,
	    						  Smestaj.Usluga.TV)
	    	));
	    	s3.pruziUsluge(new ArrayList<Smestaj.Usluga>(
	    			Arrays.asList(Smestaj.Usluga.PANSION,
	    						  Smestaj.Usluga.KUCNI_LJUBIMCI)
	    	));
	    	s4.pruziUsluge(new ArrayList<Smestaj.Usluga>(
	    			Arrays.asList(Smestaj.Usluga.WIFI,
	    						  Smestaj.Usluga.PANSION,
	    						  Smestaj.Usluga.KUCNI_LJUBIMCI,
	    						  Smestaj.Usluga.KUHINJA)
	    	));
	    	s5.pruziUsluge(new ArrayList<Smestaj.Usluga>(
	    			Arrays.asList(Smestaj.Usluga.PARKING,
	    						  Smestaj.Usluga.PANSION,
	    						  Smestaj.Usluga.KUCNI_LJUBIMCI,
	    						  Smestaj.Usluga.TV)
	    	));
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	mainContainer.dodajSmestajUTravelHistory(k,s3);
	    	mainContainer.dodajSmestajUTravelHistory(k,s4);
	    	mainContainer.dodajSmestajUTravelHistory(k,s5);
	    	
	    	mainContainer.uvediPresekUslugaZaOsobu(k, new ArrayList<Smestaj>(
	    		Arrays.asList(s3,s4,s5)
	    	));
	    	
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
	    	Rezervacija r11 = new Rezervacija(s1);
	    	Rezervacija r12 = new Rezervacija(s1);
	    	Rezervacija r13 = new Rezervacija(s1);
	    	Rezervacija r14 = new Rezervacija(s1);
	    	Rezervacija r15 = new Rezervacija(s1);
	    	Rezervacija r16 = new Rezervacija(s1);
	    	Rezervacija r17 = new Rezervacija(s1);
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r21 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r22 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r23 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r24 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r25 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r26 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r27 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r28 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r29 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r31 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r32 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r33 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r34 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r35 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r36 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r37 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r38 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r39 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r41 = new Rezervacija(s2, "25/03/2019");
	    	Rezervacija r42 = new Rezervacija(s2, "25/03/2019");
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
	    	kSession.insert(r11);
	    	kSession.insert(r12);
	    	kSession.insert(r13);
	    	kSession.insert(r14);
	    	kSession.insert(r15);
	    	kSession.insert(r16);
	    	kSession.insert(r17);
	    	kSession.insert(r2);
	    	kSession.insert(r21);
	    	kSession.insert(r22);
	    	kSession.insert(r23);
	    	kSession.insert(r24);
	    	kSession.insert(r25);
	    	kSession.insert(r26);
	    	kSession.insert(r27);
	    	kSession.insert(r28);
	    	kSession.insert(r29);
	    	kSession.insert(r31);
	    	kSession.insert(r32);
	    	kSession.insert(r33);
	    	kSession.insert(r34);
	    	kSession.insert(r35);
	    	kSession.insert(r36);
	    	kSession.insert(r37);
	    	kSession.insert(r38);
	    	kSession.insert(r39);
	    	kSession.insert(r41);
	    	kSession.insert(r42);
	    	kSession.insert(r3);
	    	kSession.insert(trenutniDatum);
	    	kSession.insert(razlikaUDanima);
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
	public static void popustSmestajimaUcestaliBoravak() {
		try {
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
	    	s1.setRating(null);
	    	mainContainer.dodajNoviSmestaj(s1);
	    	
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k2,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k3,s1);

	    	kSession.insert(mainContainer);
	    	kSession.insert(s1);
	    	
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
	public static void popustSmestajimaPosetioViseMesta() {
		try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("klijent-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k1 = new Klijent("Bogdan", "Bogdanovic", Kategorija.GOLD);
	    	mainContainer.dodajNovogKlijenta(k1);

	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7));
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4));
	    	//Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), Kategorija.PLATINUM);
	    	//Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), Kategorija.SILVER);
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	
	    	s3.setRating(null);
	    	
	    	mainContainer.dodajSmestajUTravelHistory(k1,s1);
	    	mainContainer.dodajSmestajUTravelHistory(k1,s2);
	    	
	    	
	    	/*
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
	    	
	    	kSession.insert(k1);
	    	kSession.insert(k2);
	    	kSession.insert(k3);
	    	*/
	    	
	    	//HashMap<Rezervacija, Integer> razlikaUDanima = new HashMap<Rezervacija, Integer>();
	    	/*
	    	kSession.insert(r1);
	    	kSession.insert(r2);
	    	kSession.insert(r3);
	    	*/
	    	kSession.insert(mainContainer);
	    	kSession.insert(k1);
	    	kSession.insert(s3);
	    	
	    	
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

	public static void pokreniCenuOtkazivanja() {
		try {
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
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

	public static void pokreniKategorijuSmestaja() {
		try {
			KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("admin-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	//Klijent k1 = new Klijent("Bogdan", "Bogdanovic", Kategorija.GOLD);
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7), 4.0);
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), 1.0);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), 5.0);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), 4.0);
	    	s1.setKategorija(null);
	    	s2.setKategorija(null);
	    	s3.setKategorija(null);
	    	s4.setKategorija(null);
	    	s5.setKategorija(null);
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	
	    	Rezervacija r1 = new Rezervacija(s1, "20/03/2019", "23/03/2019");
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019", "28/03/2019");
	    	Rezervacija r3 = new Rezervacija(s2, "30/03/2019", "04/04/2019");
	    	Rezervacija r4 = new Rezervacija(s2, "07/04/2019", "28/04/2019");
	    	Rezervacija r5 = new Rezervacija(s5, "30/05/2019", "16/06/2019");
	    	r1.setujCenuKrozPopust(200.00);
	    	r2.setujCenuKrozPopust(300.00);
	    	r3.setujCenuKrozPopust(350.00);
	    	r4.setujCenuKrozPopust(400.00);
	    	r5.setujCenuKrozPopust(450.00);
	    	
	    	HashMap<Rezervacija, Integer> daniOdRezervacije = new HashMap<Rezervacija, Integer>();
	    	daniOdRezervacije.put(r1, DateMath.calculateDateDistanceInDays(new Date(), r1.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r2, DateMath.calculateDateDistanceInDays(new Date(), r2.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r3, DateMath.calculateDateDistanceInDays(new Date(), r3.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r4, DateMath.calculateDateDistanceInDays(new Date(), r4.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r5, DateMath.calculateDateDistanceInDays(new Date(), r5.getDatumZakazivanja()));
	    	
	    	//r3.setRating(rating);
	    	
	    	r3.setRating(4.0);
	    	r4.setRating(4.5);
	    	
	    	kSession.insert(s1);
	    	kSession.insert(s2);
	    	kSession.insert(s3);
	    	kSession.insert(s4);
	    	kSession.insert(s5);
	    	kSession.insert(daniOdRezervacije);
	    	kSession.fireAllRules();
	    	
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
	public static void pokreniKategorijuKlijenta() {
		try {
			KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("admin-modul-rules");
	    	
	    	MainContainer mainContainer = new MainContainer();
	    	
	    	Klijent k1 = new Klijent("Andrej", "Andrejovic", Kategorija.GOLD);
	    	Klijent k2 = new Klijent("Bogdan", "Bogdanovic", Kategorija.GOLD);
	    	Klijent k3 = new Klijent("Cane", "Canic", Kategorija.BRONZE);
	    	Klijent k4 = new Klijent("Dragoje", "Dragojevic", Kategorija.SILVER);
	    	Klijent k5 = new Klijent("Eva", "Evic", Kategorija.SILVER);
	    	k1.setKategorija(null);
	    	k2.setKategorija(null);
	    	k3.setKategorija(null);
	    	k4.setKategorija(null);
	    	k5.setKategorija(null);
	    	/*
	    	k1.setKategorija(Kategorija.GOLD);
	    	k2.setKategorija(Kategorija.GOLD);
	    	k3.setKategorija(Kategorija.GOLD);
	    	k4.setKategorija(Kategorija.GOLD);
	    	k5.setKategorija(Kategorija.GOLD);
	    	*/
	    	k1.unesiDatumPrekoStringa("20/01/2018");
	    	k2.unesiDatumPrekoStringa("20/03/2018");
	    	k3.unesiDatumPrekoStringa("01/03/2018");
	    	k4.unesiDatumPrekoStringa("01/03/2019");
	    	k5.unesiDatumPrekoStringa("01/03/2019");
	    	
	    	mainContainer.dodajNovogKlijenta(k1);
	    	mainContainer.dodajNovogKlijenta(k2);
	    	mainContainer.dodajNovogKlijenta(k3);
	    	mainContainer.dodajNovogKlijenta(k4);
	    	mainContainer.dodajNovogKlijenta(k5);
	    	
	    	HashMap<Klijent, Integer> daniOdRegistracije = new HashMap<Klijent, Integer>();
	    	daniOdRegistracije.put(k1, DateMath.calculateDateDistanceInDays(new Date(), k1.getDatumRegistracije()));
	    	daniOdRegistracije.put(k2, DateMath.calculateDateDistanceInDays(new Date(), k2.getDatumRegistracije()));
	    	daniOdRegistracije.put(k3, DateMath.calculateDateDistanceInDays(new Date(), k3.getDatumRegistracije()));
	    	daniOdRegistracije.put(k4, DateMath.calculateDateDistanceInDays(new Date(), k4.getDatumRegistracije()));
	    	daniOdRegistracije.put(k5, DateMath.calculateDateDistanceInDays(new Date(), k5.getDatumRegistracije()));
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7), 4.0);
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), 1.0);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), 5.0);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), 4.0);
	    	s1.setKategorija(Kategorija.BRONZE);
	    	s2.setKategorija(Kategorija.SILVER);
	    	s3.setKategorija(Kategorija.PLATINUM);
	    	s4.setKategorija(Kategorija.PLATINUM);
	    	s5.setKategorija(Kategorija.PLATINUM);

	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	
	    	Rezervacija r1 = new Rezervacija(k1, s1, "20/03/2018", "23/03/2018");
	    	Rezervacija r2 = new Rezervacija(k2, s2, "25/03/2018", "28/03/2018");
	    	Rezervacija r3 = new Rezervacija(k3, s3, "30/03/2018", "04/04/2018");
	    	Rezervacija r4 = new Rezervacija(k4, s4, "07/04/2018", "28/04/2018");
	    	Rezervacija r5 = new Rezervacija(k4, s5, "30/05/2018", "16/06/2018");
	    	Rezervacija r6 = new Rezervacija(k4, s4, "07/06/2018", "28/07/2018");
	    	Rezervacija r7 = new Rezervacija(k4, s5, "30/07/2018", "16/08/2018");
	    	Rezervacija r8 = new Rezervacija(k4, s4, "07/08/2018", "28/09/2018");
	    	Rezervacija r9 = new Rezervacija(k4, s5, "30/09/2018", "16/10/2018");
	    	Rezervacija r10 = new Rezervacija(k4, s4, "07/10/2018", "28/11/2018");
	    	Rezervacija r11 = new Rezervacija(k4, s5, "30/11/2018", "16/12/2018");
	    	Rezervacija r12 = new Rezervacija(k4, s4, "07/12/2018", "28/01/2019");
	    	Rezervacija r13 = new Rezervacija(k4, s5, "30/01/2019", "16/02/2019");
	    	
	    	

	    	r1.setujCenuKrozPopust(200.00);
	    	r2.setujCenuKrozPopust(300.00);
	    	r3.setujCenuKrozPopust(350.00);
	    	r4.setujCenuKrozPopust(400.00);
	    	r5.setujCenuKrozPopust(450.00);
	    	r6.setujCenuKrozPopust(500.00);
	    	r7.setujCenuKrozPopust(550.00);
	    	r8.setujCenuKrozPopust(600.00);
	    	r9.setujCenuKrozPopust(650.00);
	    	r10.setujCenuKrozPopust(700.00);
	    	r11.setujCenuKrozPopust(750.00);
	    	r12.setujCenuKrozPopust(800.00);
	    	r13.setujCenuKrozPopust(850.00);
	    	
	    	HashMap<Rezervacija, Integer> daniOdRezervacije = new HashMap<Rezervacija, Integer>();
	    	daniOdRezervacije.put(r1, DateMath.calculateDateDistanceInDays(new Date(), r1.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r2, DateMath.calculateDateDistanceInDays(new Date(), r2.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r3, DateMath.calculateDateDistanceInDays(new Date(), r3.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r4, DateMath.calculateDateDistanceInDays(new Date(), r4.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r5, DateMath.calculateDateDistanceInDays(new Date(), r5.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r6, DateMath.calculateDateDistanceInDays(new Date(), r6.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r7, DateMath.calculateDateDistanceInDays(new Date(), r7.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r8, DateMath.calculateDateDistanceInDays(new Date(), r8.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r9, DateMath.calculateDateDistanceInDays(new Date(), r9.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r10, DateMath.calculateDateDistanceInDays(new Date(), r10.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r11, DateMath.calculateDateDistanceInDays(new Date(), r11.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r12, DateMath.calculateDateDistanceInDays(new Date(), r12.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r13, DateMath.calculateDateDistanceInDays(new Date(), r13.getDatumZakazivanja()));

	    	kSession.setGlobal("klijentRegistracije", daniOdRegistracije);
	    	kSession.setGlobal("daniOdRezervacije", daniOdRezervacije);
	    	kSession.insert(k1);
	    	kSession.insert(k2);
	    	kSession.insert(k3);
	    	kSession.insert(k4);
	    	kSession.insert(k5);
	    	kSession.insert(r1);
	    	kSession.insert(r2);
	    	kSession.insert(r3);
	    	kSession.insert(r4);
	    	kSession.insert(r5);
	    	kSession.insert(r6);
	    	kSession.insert(r7);
	    	kSession.insert(r8);
	    	kSession.insert(r9);
	    	kSession.insert(r10);
	    	kSession.insert(r11);
	    	kSession.insert(r12);
	    	kSession.insert(r13);
	    	//kSession.insert(daniOdRegistracije);
	    	
	    	kSession.fireAllRules();
	    	
	    	/*
	    	Smestaj s1 = new Smestaj(new Lokacija("JEDAN", 15.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("DVA", 5.1, 13.7), 4.0);
	    	Smestaj s3 = new Smestaj(new Lokacija("TRI", 1.1, 5.4), 1.0);
	    	Smestaj s4 = new Smestaj(new Lokacija("CETIRI", 6.5, 9.3), 5.0);
	    	Smestaj s5 = new Smestaj(new Lokacija("PET", 30.0, 8.5), 4.0);
	    	s1.setKategorija(null);
	    	s2.setKategorija(null);
	    	s3.setKategorija(null);
	    	s4.setKategorija(null);
	    	s5.setKategorija(null);

	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	*/
	    	
	    	/*
	    	Rezervacija r1 = new Rezervacija(s1, "20/03/2019", "23/03/2019");
	    	Rezervacija r2 = new Rezervacija(s2, "25/03/2019", "28/03/2019");
	    	Rezervacija r3 = new Rezervacija(s2, "30/03/2019", "04/04/2019");
	    	Rezervacija r4 = new Rezervacija(s2, "07/04/2019", "28/04/2019");
	    	Rezervacija r5 = new Rezervacija(s5, "30/05/2019", "16/06/2019");

	    	r1.setujCenuKrozPopust(200.00);
	    	r2.setujCenuKrozPopust(300.00);
	    	r3.setujCenuKrozPopust(350.00);
	    	r4.setujCenuKrozPopust(400.00);
	    	r5.setujCenuKrozPopust(450.00);
	    	
	    	HashMap<Rezervacija, Integer> daniOdRezervacije = new HashMap<Rezervacija, Integer>();
	    	daniOdRezervacije.put(r1, DateMath.calculateDateDistanceInDays(new Date(), r1.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r2, DateMath.calculateDateDistanceInDays(new Date(), r2.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r3, DateMath.calculateDateDistanceInDays(new Date(), r3.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r4, DateMath.calculateDateDistanceInDays(new Date(), r4.getDatumZakazivanja()));
	    	daniOdRezervacije.put(r5, DateMath.calculateDateDistanceInDays(new Date(), r5.getDatumZakazivanja()));
	    	
	    	//r3.setRating(rating);
	    	
	    	r3.setRating(4.0);
	    	r4.setRating(4.5);
	    	
	    	
	    	kSession.insert(s1);
	    	kSession.insert(s2);
	    	kSession.insert(s3);
	    	kSession.insert(s4);
	    	kSession.insert(s5);
	    	kSession.insert(daniOdRezervacije);
	    	*/
	    	
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
}
