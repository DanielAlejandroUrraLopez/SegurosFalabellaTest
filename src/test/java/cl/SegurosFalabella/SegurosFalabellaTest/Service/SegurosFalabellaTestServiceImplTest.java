package cl.SegurosFalabella.SegurosFalabellaTest.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.ProductoVendido;
import cl.SegurosFalabella.SegurosFalabellaTest.Repository.SegurosFalabellaTestProductoVendidoRepository;
import cl.SegurosFalabella.SegurosFalabellaTest.Repository.SegurosFalabellaTestRepository;
import cl.SegurosFalabella.SegurosFalabellaTest.Service.Impl.SegurosFalabellaTestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SegurosFalabellaTestServiceImplTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private SegurosFalabellaTestServiceImpl segurosFalabellaTestServiceImpl;
	
	@Mock
	private SegurosFalabellaTestRepository segurosFalabellaTestRepository;

	@Mock
	private SegurosFalabellaTestProductoVendidoRepository segurosFalabellaTestProductoVendidoRepository;
	
	@BeforeEach
    public void config() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(segurosFalabellaTestServiceImpl).build();
    }
	
	@Test
	public void ventaDeProductoTest() {
		Optional<Producto> op = null ;
		
		doReturn(op).when(segurosFalabellaTestRepository).findById(1);		
		String r = segurosFalabellaTestServiceImpl.ventaDeProducto(1);		
		
		assertNotNull(r);
	}
	
	@Test
	public void agregarProductoTest() {
		Producto p = new Producto();
		p.setId(1);
		p.setNombre("nombre");
		p.setPrice(1000);
		p.setSellIn(10);
		
		doReturn(p).when(segurosFalabellaTestRepository).save(p);		
		String r = segurosFalabellaTestServiceImpl.agregarProducto(p);		
		
		assertNotNull(r);
	}
	
	@Test
	public void listaProductosVendidosTest() {
		Iterable<ProductoVendido> pv = null;
		
		doReturn(pv).when(segurosFalabellaTestProductoVendidoRepository).findAll();		
		 List<ProductoVendido> r = segurosFalabellaTestServiceImpl.listaProductosVendidos();		
		
		assertNull(r);
	}

}
