package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.repository.CountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CountryControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CountryRepository countryRepository;

    private String id;

    @BeforeEach
    public void init(final WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        id = countryRepository.save(new Country(null, "Belarus", "BY")).getId();
    }

    @AfterEach
    public void clean() {
        countryRepository.deleteAll();
    }

    @Test
    public void getAll_ShouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/countries").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAll_ShouldReturnNotEmpty() throws Exception {
        mockMvc.perform(get("/countries").accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertTrue(
                    mapper.readValue(result.getResponse().getContentAsString(), Country[].class).length > 0
            );
        });
    }

    @Test
    public void getById_ShouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/countries/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getById_ExistingId_ShouldReturnNotNull() throws Exception {
        mockMvc.perform(get("/countries/" + id).accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertNotNull(mapper.readValue(result.getResponse().getContentAsString(), Country.class));
        });
    }

    @Test
    public void getById_NotExistingId_ShouldReturnEmpty() throws Exception {
        mockMvc.perform(get("/countries/noId").accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertTrue(result.getResponse().getContentAsString().isBlank());
        });
    }

    @Test
    public void getById_BelarusId_ShouldReturnBelarus() throws Exception {
        final Country belarus = countryRepository.findById(id).get();
        mockMvc.perform(get("/countries/" + id).accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            final Country country = mapper.readValue(result.getResponse().getContentAsString(), Country.class);
            assertTrue(country.getId().equals(belarus.getId()) &&
                    country.getName().equals(belarus.getName()) &&
                    country.getAlpha2().equals(belarus.getAlpha2())
            );
        });
    }

}
