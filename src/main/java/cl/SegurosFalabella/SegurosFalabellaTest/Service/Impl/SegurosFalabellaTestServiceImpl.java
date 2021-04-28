package cl.SegurosFalabella.SegurosFalabellaTest.Service.Impl;

import java.util.Collection;
import java.util.List;

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

	@Autowired
	private SegurosFalabellaTestRepository segurosFalabellaTestRepository;

	@Autowired
	private SegurosFalabellaTestProductoVendidoRepository segurosFalabellaTestProductoVendidoRepository;

	@Override
	public String ventaDeProducto(int id) {
		try {

			segurosFalabellaTestProductoVendidoRepository
					.save(this.deProductoAProductoVendido(segurosFalabellaTestRepository.findById(id).get()));

			return "ok";

		} catch (Exception ex) {

			System.out.println("Error: " + ex);
			return "nok";
		}
	}

	@Override
	public String agregarProducto(Producto producto) {
		try {
			segurosFalabellaTestRepository.save(producto);
			return "ok";

		} catch (Exception ex) {

			System.out.println("Error: " + ex);
			return "nok";
		}

	}

	@Override
	public List<ProductoVendido> listaProductosVendidos() {
		return (List<ProductoVendido>) ((Collection<ProductoVendido>) segurosFalabellaTestProductoVendidoRepository
				.findAll());
	}

	@Override
	public List<ProductoVendido> listaProductosVendidosXDias(int dias) {

		List<ProductoVendido> listProductoVendido = (List<ProductoVendido>) ((Collection<ProductoVendido>) segurosFalabellaTestProductoVendidoRepository
				.findAll());
		int cont = 0;

		while (cont <= dias) {

			System.out.println("-----------------día " + cont + "-----------------");
			System.out.println("nombre, sellIn, price");
			listProductoVendido.forEach(lpv -> {

				if (lpv.getNombre().equals(NomProductoEnum.FULL_COBERTURA.getNomProducto())) {
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

				} else if (lpv.getNombre().equals(NomProductoEnum.FULL_COBERTURA_SUPER_DUPER.getNomProducto())) {
					int d = lpv.getSellIn();
					if (d >= 0) {

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

		return null;
	}

	public ProductoVendido deProductoAProductoVendido(Producto producto) {

		ProductoVendido pv = new ProductoVendido();

		pv.setId(producto.getId());
		pv.setNombre(producto.getNombre());
		pv.setPrice(producto.getPrice());
		pv.setSellIn(producto.getSellIn());

		return pv;
	}

}
