package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@SpringBootTest
@AutoConfigureMockMvc // Lo necesito para poder hacer peticiones simuladas
class TimeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `GET time should return current server time`() {
        mockMvc.perform(get("/time")) // Simulo una petición GET a /time
            .andExpect(status().isOk) // Compruebo que la respuesta sea 200 -> OK
            .andExpect(jsonPath("$.time").exists()) // Compruebo que el JSON contiene el campo "time"
    }
}