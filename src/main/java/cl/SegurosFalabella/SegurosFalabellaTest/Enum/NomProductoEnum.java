package cl.SegurosFalabella.SegurosFalabellaTest.Enum;

public enum NomProductoEnum {
	
			FULL_COBERTURA("Full cobertura")
			,MEGA_COBERTURA("Mega cobertura")
			,FULL_COBERTURA_SUPER_DUPER("Full cobertura Super duper")
			,SUPER_AVANCE("Super avance");
	
			private String nomProducto;
		
			NomProductoEnum(String nomProducto) {
				this.nomProducto = nomProducto;
			}
		
			public String getNomProducto() {
				return this.nomProducto;
			}

}
