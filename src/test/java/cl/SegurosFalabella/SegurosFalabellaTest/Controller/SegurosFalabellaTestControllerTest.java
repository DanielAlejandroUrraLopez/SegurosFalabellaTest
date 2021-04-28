package cl.SegurosFalabella.SegurosFalabellaTest.Controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.ProductoVendido;
import cl.SegurosFalabella.SegurosFalabellaTest.Service.SegurosFalabellaTestService;

@ExtendWith(MockitoExtension.class)
public class SegurosFalabellaTestControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private SegurosFalabellaTestController segurosFalabellaTestController;
	
	@Mock
	private SegurosFalabellaTestService segurosFalabellaTestService;
	
	@BeforeEach
    public void config() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(segurosFalabellaTestController).build();
    }
	
	@Test
	public void ventaDeProductoTest() throws Exception {			
		doReturn("ok").when(segurosFalabellaTestService).ventaDeProducto(1);		
		ResponseEntity<String> r = segurosFalabellaTestController.ventaDeProducto(1);		
		
		assertNotNull(r);
		
	}
	
	@Test
	public void agregarProductoTest() {
		Producto producto = new Producto();
		producto.setId(1);
		producto.setNombre("nombre");
		producto.setPrice(100);
		producto.setSellIn(100);
		
		ResponseEntity<String> r = segurosFalabellaTestController.agregarProducto(producto);		
		
		assertNotNull(r);
	}
	
	@Test
	public void listaProductosVendidosTest() throws Exception {
		segurosFalabellaTestController.listaProductosVendidos();
		List<ProductoVendido> list = new ArrayList<>();
		
		doReturn(list).when(segurosFalabellaTestService).listaProductosVendidos();
		
		ResponseEntity<List<ProductoVendido>> r = segurosFalabellaTestController.listaProductosVendidos();		
		
		assertNotNull(r);
		
	}
	
	@Test
	public void listaProductosVendidosXDiasTest() {
		segurosFalabellaTestController.listaProductosVendidosXDias(5);
		List<ProductoVendido> list = new ArrayList<>();
		
		doReturn(list).when(segurosFalabellaTestService).listaProductosVendidosXDias(5);
		
		ResponseEntity<List<ProductoVendido>> r = segurosFalabellaTestController.listaProductosVendidosXDias(5);		
		
		assertNotNull(r);
	}

}
