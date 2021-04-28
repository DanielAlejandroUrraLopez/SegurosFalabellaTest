package cl.SegurosFalabella.SegurosFalabellaTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.SegurosFalabella.SegurosFalabellaTest.Model.Producto;
import cl.SegurosFalabella.SegurosFalabellaTest.Model.ProductoVendido;
import cl.SegurosFalabella.SegurosFalabellaTest.Service.SegurosFalabellaTestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Segurosfalabella")
public class SegurosFalabellaTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SegurosFalabellaTestController.class);
	
	@Autowired
	private SegurosFalabellaTestService segurosFalabellaTestService;	
	
	@ApiOperation(value = "Venta de producto por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se vendió producto"),@ApiResponse(code = 404, message = "Error") })
	@PostMapping(value ="ventaDeProducto/{id:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ventaDeProducto(@PathVariable(required = true) int id) {	
		logger.info("ventaDeProducto: id "+ id );
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.ventaDeProducto(id));
	}
	
	@ApiOperation(value = "Agregar producto")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se Agregar producto"),@ApiResponse(code = 404, message = "Error") })
	@PostMapping(value ="/agregarProducto")
	public ResponseEntity<String> agregarProducto(@Validated @RequestBody Producto producto) {
		logger.info("agregarProducto: producto "+ producto );
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.agregarProducto(producto));
	}
	
	@ApiOperation(value = "Listar productos vendidos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Lista productos vendidos"),@ApiResponse(code = 404, message = "Error") })
	@GetMapping(value ="listaProductosVendidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoVendido>> listaProductosVendidos() {		
		logger.info("listaProductosVendidos" );
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.listaProductosVendidos());
	}
	
	@ApiOperation(value = "Listar productos vendidos por X días")
	@ApiResponses({ @ApiResponse(code = 200, message = "Lista productos vendidos por X días"),@ApiResponse(code = 404, message = "Error") })
	@GetMapping(value ="listaProductosVendidosXDias/{dias:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoVendido>> listaProductosVendidosXDias(@PathVariable(required = true) int dias) {
		logger.info("listaProductosVendidosXDias: dias "+ dias );
		return ResponseEntity.status(HttpStatus.OK).body(segurosFalabellaTestService.listaProductosVendidosXDias(dias));
	}
}
