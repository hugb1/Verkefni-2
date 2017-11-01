package is.hi.byrjun;

import is.hi.byrjun.controller.ProgramController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @author Pétur Logi Pétursson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem athugar hvort ProgramController keyrir
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	@Autowired
	ProgramController programController;
	
	/*
	 * Aðferð til að athuga hvort ProgramController hlutur hafi veri búinn til
	 */
	@Test
	public void contextLoads() {
		assertThat(programController).isNotNull();
	}
}
