package lpnu;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lpnu.entity.Location;
import lpnu.entity.enums.Status;
import lpnu.mapper.LocationMapper;
import lpnu.repository.LocationRepository;
import lpnu.resource.LocationResource;
import lpnu.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(LocationResource.class)
class LocationResourceTest {

    private static final long ID = 1L;
    private static final long ID1 = 3L;
    private static final Location location = new Location(1L, "Lviv", "Svobody Av", Status.ACTIVE);

    @Autowired
    private MockMvc mockMvc;

    private LocationMapper locationMapper;
    ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    LocationRepository locationRepository;
    @MockBean
    private LocationServiceImpl locationService;


    @Test
    public void findByIdTest() throws Exception {
        final Location location = new Location(1L, "Lviv", "Svobody Av", Status.ACTIVE);

        doThrow(new RuntimeException()).when(locationService).findById(ID);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam(objectMapper.writeValueAsString(ID), objectMapper.writeValueAsString(location.getId())))
                .andExpect(status().isOk());
    }

    @Test
    void saveLocationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/location")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(location)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteLocationTest() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/location/" + ID)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
