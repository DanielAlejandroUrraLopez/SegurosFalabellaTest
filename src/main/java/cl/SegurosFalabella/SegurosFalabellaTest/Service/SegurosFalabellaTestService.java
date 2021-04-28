package cl.SegurosFalabella.SegurosFalabellaTest.Service;

import java.util.List;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.ProductoVendido;


public interface SegurosFalabellaTestService {
	
	String ventaDeProducto(int id);
	
	String agregarProducto(Producto producto);
	
	List<ProductoVendido> listaProductosVendidos();
	
	List<ProductoVendido> listaProductosVendidosXDias(int dias);

}
