package cl.SegurosFalabella.SegurosFalabellaTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Service.SegurosFalabellaTestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SegurosFalabellaTestController {
	
	@Autowired
	private SegurosFalabellaTestService segurosFalabellaTestService;	
	
	@ApiOperation(value = "Venta de producto por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se vendió producto"),@ApiResponse(code = 404, message = "Error") })
	@PostMapping(value ="ventaDeProducto/{id:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ventaDeProducto(@PathVariable(required = true) int id) {		
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.ventaDeProducto(id));
	}
	
	@ApiOperation(value = "Agregar producto")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se Agregar producto"),@ApiResponse(code = 404, message = "Error") })
	@PostMapping(value ="agregarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarProducto(@PathVariable(required = true) Producto producto) {		
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.agregarProducto(producto));
	}
	
	@ApiOperation(value = "Listar productos vendidos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Lista productos vendidos"),@ApiResponse(code = 404, message = "Error") })
	@GetMapping(value ="listaProductosVendidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listaProductosVendidos() {		
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.listaProductosVendidos());
	}
	
	@ApiOperation(value = "Listar productos vendidos por X días")
	@ApiResponses({ @ApiResponse(code = 200, message = "Lista productos vendidos por X días"),@ApiResponse(code = 404, message = "Error") })
	@GetMapping(value ="listaProductosVendidosXDias/{dias:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listaProductosVendidosXDias(@PathVariable(required = true) int dias) {		
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.listaProductosVendidosXDias(dias));
	}
}
