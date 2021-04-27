package cl.SegurosFalabella.SegurosFalabellaTest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Repository.SegurosFalabellaTestRepository;

@Service
public class SegurosFalabellaTestService {

	@Autowired
	private SegurosFalabellaTestRepository segurosFalabellaTestRepository;

	public String ventaDeProducto(int id) {
		try {
			segurosFalabellaTestRepository.ventaDeProducto(id);
			return "OK";

		} catch (Exception ex) {
			return "NOK";
		}

	}

	public String agregarProducto(Producto producto) {

		try {
			segurosFalabellaTestRepository.agregarProducto(producto);
			return "OK";

		} catch (Exception ex) {
			return "NOK";
		}

	}

	public List<Producto> listaProductosVendidos() {

		try {

			return segurosFalabellaTestRepository.listaProductosVendidos();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
			return null;
		}

	}

	public List<Producto> listaProductosVendidosXDias(int dias) {

		try {

			return segurosFalabellaTestRepository.listaProductosVendidos();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
			return null;
		}

	}

}
