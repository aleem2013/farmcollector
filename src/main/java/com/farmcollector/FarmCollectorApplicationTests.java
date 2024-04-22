package com.farmcollector;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.farmcollector.model.Farm;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmCollectorApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Farm farm;

    private FarmCollectorApplication farmCollectorApplication;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        farmCollectorApplication = new FarmCollectorApplication();
        farmCollectorApplication.setFarm(farm); // Inject the mock Farm object manually
    }

    @Test
    public void testAddPlantedData() throws Exception {
        String requestBody = "{\"farmName\": \"MyFarm\", \"plantedArea\": 10, \"cropType\": \"corn\", \"expectedProduct\": 20}";

        mockMvc.perform(MockMvcRequestBuilders.post("/planted")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(farm).addPlantedData(new FarmCollectorApplication.PlantedData("MyFarm", 10, "corn", 20));
    }

    @Test
    public void testAddHarvestedData() throws Exception {
        String requestBody = "{\"farmName\": \"MyFarm\", \"cropType\": \"corn\", \"actualProduct\": 15}";

        mockMvc.perform(MockMvcRequestBuilders.post("/harvested")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(farm).addHarvestedData(new FarmCollectorApplication.HarvestedData("MyFarm", "corn", 15));
    }
}
