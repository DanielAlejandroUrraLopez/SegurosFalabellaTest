package cl.SegurosFalabella.SegurosFalabellaTest.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto_vendido")
public class ProductoVendido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTbl;
	private int id;
	private String nombre;
	private int sellIn;
	private int price;
	
	
	public int getIdTbl() {
		return idTbl;
	}

	public void setIdTbl(int idTbl) {
		this.idTbl = idTbl;
	}

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
}
