package is.hi.byrjun;


import is.hi.byrjun.controller.ChangeController;
import is.hi.byrjun.controller.ProgramController;
import is.hi.byrjun.services.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt 
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.containsString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author Pétur Logi Pétursson
 * @date október 2017 
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest 
*/
@RunWith(SpringRunner.class)
// Sleppum hér @SpringBootTest
/**
 *  Aðeins veflagið er keyrt upp en ekki allur "context"-inn
 *  Getum beðið um að keyra bara upp ProgramController klasann 
 */
@WebMvcTest (ProgramController.class)    
                                            
public class WebLayerTest {
    
        // Þjónninn ekki keyrður upp 
        @Autowired
        private MockMvc mockMvc;
        
        @MockBean
        SearchService searchService;
        /**
         * Aðferð til að athuga hvort virkar að senda HttpRequest á birtaSali
         * og fá til baka synaSali.jsp síðuna 
         */
	@Test 
        public void synaSaliHefurVeislusali() throws Exception {
        this.mockMvc.perform(post("/demo/salir"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("veislusalir"));
    }

}
