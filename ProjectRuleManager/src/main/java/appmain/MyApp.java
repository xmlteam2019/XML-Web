package appmain;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import containermodel.MainContainer;
import mainmodel.Klijent;
import mainmodel.Lokacija;
import mainmodel.Smestaj;

import java.awt.geom.Point2D;

public class MyApp {

	public static void main(String[] args) {
		pokreniPreporukuSmestaja();
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
	    	
	    	Klijent k = new Klijent("Aleksandar", "Aleksandrovic");
	    	mainContainer.dodajNovogKlijenta(k);
	    	
	    	Smestaj s1 = new Smestaj(new Lokacija("Prva", 10.1, 11.2));
	    	Smestaj s2 = new Smestaj(new Lokacija("Druga", 5.1, 13.7));
	    	Smestaj s3 = new Smestaj(new Lokacija("Druga", 1.1, 5.4));
	    	Smestaj s4 = new Smestaj(new Lokacija("Druga", 6.5, 9.3));
	    	Smestaj s5 = new Smestaj(new Lokacija("Druga", 30.0, 8.5));
	    	mainContainer.dodajNoviSmestaj(s1);
	    	mainContainer.dodajNoviSmestaj(s2);
	    	mainContainer.dodajNoviSmestaj(s3);
	    	mainContainer.dodajNoviSmestaj(s4);
	    	mainContainer.dodajNoviSmestaj(s5);
	    	
	    	kSession.setGlobal("izabranaLokacija", new Point2D.Double(1.1, 2.2));
	    	kSession.insert(mainContainer);
	    	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}

}
