package cl.SegurosFalabella.SegurosFalabellaTest.Service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.SegurosFalabella.SegurosFalabellaTest.Enum.NomProductoEnum;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.ProductoVendido;
import cl.SegurosFalabella.SegurosFalabellaTest.Repository.SegurosFalabellaTestProductoVendidoRepository;
import cl.SegurosFalabella.SegurosFalabellaTest.Repository.SegurosFalabellaTestRepository;
import cl.SegurosFalabella.SegurosFalabellaTest.Service.SegurosFalabellaTestService;

@Service
public class SegurosFalabellaTestServiceImpl implements SegurosFalabellaTestService {
	private static final Logger logger = LoggerFactory.getLogger(SegurosFalabellaTestServiceImpl.class);

	@Autowired
	private SegurosFalabellaTestRepository segurosFalabellaTestRepository;

	@Autowired
	private SegurosFalabellaTestProductoVendidoRepository segurosFalabellaTestProductoVendidoRepository;

	/**
	 * Método para venta de productos por id
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public String ventaDeProducto(int id) {
		logger.info("ventaDeProducto: id "+ id );
		try {

			segurosFalabellaTestProductoVendidoRepository.save(this.deProductoAProductoVendido(segurosFalabellaTestRepository.findById(id).get()));

			logger.info("Producto vendido exitosamente!!!");
			return "Producto vendido exitosamente!!! ";

		} catch (Exception ex) {

			logger.error("Error Al vender producto!!!: "+ex.getMessage());
			return "Error Al vender producto!!!";
		}
	}
	
	/**
	 * Método para agregar producto, se debe enviar un objeto de tipo producto
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public String agregarProducto(Producto producto) {
		logger.info("agregarProducto: Producto "+ producto );
		try {
			
			segurosFalabellaTestRepository.save(producto);
			
			logger.info("Se agrego producto exitosamente!!!");
			return "Se agrego producto exitosamente!!!";

		} catch (Exception ex) {

			logger.error("Error al agregar producto!!!: "+ex.getMessage());
			return "Error al agregar producto!!!";
		}

	}

	/**
	 * Método para listar productos vendidos
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public List<ProductoVendido> listaProductosVendidos() {
		logger.info("listaProductosVendidos");
		try {
			
			List<ProductoVendido> list = (List<ProductoVendido>) ( segurosFalabellaTestProductoVendidoRepository.findAll());
			
			list.forEach(l ->{
				
				this.printNombreProducto(l.getNombre());
			});
			
			return list;
			
			
		}catch(Exception ex) {
			
			logger.error("Error al listar productos vendidos   !!!: "+ex.getMessage());
			return null;
		}
	}

	/**
	 * Método para listar productos vendidos por X días 
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public List<ProductoVendido> listaProductosVendidosXDias(int dias) {
		logger.info("listaProductosVendidosXDias: dias "+dias);

		List<ProductoVendido> listProductoVendido = (List<ProductoVendido>)  segurosFalabellaTestProductoVendidoRepository.findAll();
		int cont = 0;

		try {
			while (cont <= dias) {
	
				System.out.println("-----------------día " + cont + "-----------------");
				System.out.println("nombre, sellIn, price");
				listProductoVendido.forEach(lpv -> {
	
					if (lpv.getNombre().equals(NomProductoEnum.FULL_COBERTURA.getNomProducto()) || lpv.getNombre().equals(NomProductoEnum.FULL_COBERTURA_SUPER_DUPER.getNomProducto()) ) {
						int d = lpv.getSellIn();
	
						if (d > 0) {
	
							if (d <= 10 && d >= 6) {
								lpv.setPrice(lpv.getPrice() + 2);
								if (lpv.getPrice() > 100) {
									lpv.setPrice(100);
								}
							} else if (d <= 5) {
								lpv.setPrice(lpv.getPrice() + 3);
								if (lpv.getPrice() > 100) {
									lpv.setPrice(100);
								}
							}
	
						} else {
							lpv.setPrice(0);
						}
						lpv.setSellIn(d - 1);
	
						System.out.println(lpv.getNombre() + ", " + lpv.getSellIn() + ", " + lpv.getPrice());
	
					} else if (lpv.getNombre().equals(NomProductoEnum.MEGA_COBERTURA.getNomProducto())) {
						lpv.setPrice(180);
	
						System.out.println(lpv.getNombre() + ", " + lpv.getSellIn() + ", " + lpv.getPrice());
					} else if (lpv.getNombre().equals(NomProductoEnum.SUPER_AVANCE.getNomProducto())) {
						int d = lpv.getSellIn();
	
						if (d >= 0) {
	
							if (d <= 10 && d >= 6) {
								lpv.setPrice(lpv.getPrice() + (2 * 2));
							} else if (d <= 5) {
								lpv.setPrice(lpv.getPrice() + (3 * 2));
							}
	
						} else {
							lpv.setPrice(0);
						}
	
						lpv.setSellIn(d - 1);
	
						System.out.println(lpv.getNombre() + ", " + lpv.getSellIn() + ", " + lpv.getPrice());
					} else {
						int d = lpv.getSellIn();
	
						if (d >= 0) {
							lpv.setPrice(lpv.getPrice() - 1);
	
						} else {
							lpv.setPrice(lpv.getPrice() - 2);
							if (lpv.getPrice() <= 0) {
								lpv.setPrice(0);
							}
						}
						lpv.setSellIn(d - 1);
	
						System.out.println(lpv.getNombre() + ", " + lpv.getSellIn() + ", " + lpv.getPrice());
					}
	
				});
	
				cont++;
			}
	
			return listProductoVendido;
		}catch(Exception ex) {
			logger.error("Error al listar productos vendidos por X dias!!!: "+ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Método para pasar de producto a producto vendido
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	private ProductoVendido deProductoAProductoVendido(Producto producto) {

		ProductoVendido pv = new ProductoVendido();

		pv.setId(producto.getId());
		pv.setNombre(producto.getNombre());
		pv.setPrice(producto.getPrice());
		pv.setSellIn(producto.getSellIn());

		return pv;
	}

	/**
	 * Método para imprimir nombre de producto
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	private void printNombreProducto(String nombre) {
		System.out.println(nombre);
	}
}
