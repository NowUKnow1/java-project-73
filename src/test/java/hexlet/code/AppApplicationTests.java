package hexlet.code;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AppApplicationTests {


	@Test
	void testInit() {
		assertThat(true).isTrue();
	}

}
