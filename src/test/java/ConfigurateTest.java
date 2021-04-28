import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import cl.SegurosFalabella.SegurosFalabellaTest.SegurosFalabellaTestApplication;



@SpringBootTest(webEnvironment = WebEnvironment.MOCK, 
classes = {
		SegurosFalabellaTestApplication.class
		
	}
)
public class ConfigurateTest {

	@Test
	public void context() {
		
	}
}