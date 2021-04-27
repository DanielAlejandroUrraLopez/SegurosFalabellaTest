package cl.SegurosFalabella.SegurosFalabellaTest.Model;

public class Producto {

	private int id;
	private String nombre;
	private int sellIn;
	private int price;
	//true = vendido, 
	private Boolean vendido; 
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getSellIn() {
		return sellIn;
	}
	
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Boolean getVendido() {
		return vendido;
	}
	
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
	
}
