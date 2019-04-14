package mainmodel;

public class Lokacija {
	private String drzava;
	private String grad;
	private String ulica;
	private String broj;
	private double coordX;
	private double coordY;
	
	public Lokacija(String drzava, double coordX, double coordY) {
		this.drzava = drzava;
		grad = "";
		ulica = "";
		broj = "";
		this.coordX = coordX;
		this.coordY = coordY;		
	}
	
	public Lokacija(String drzava, String grad, String ulica, String broj, double coordX, double coordY) {
		this.drzava = drzava;
		this.grad = grad;
		this.ulica = ulica;
		this.broj = broj;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	public double getCoordY() {
		return coordY;
	}
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

}
