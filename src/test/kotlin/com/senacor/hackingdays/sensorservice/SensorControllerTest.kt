package com.senacor.hackingdays.sensorservice

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
@WebMvcTest
class SensorControllerTest {

    @Autowired
    private lateinit var controller: SensorController

    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var service: SensorEventService

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    @Test
    fun `should return 415`() {
        val data = SensorEntity(System.currentTimeMillis())

        mockMvc.perform(MockMvcRequestBuilders //
                .post("/telemetries") //
                .contentType(MediaType.APPLICATION_ATOM_XML)
                .content(ObjectMapper().writeValueAsString(data))
        ).andExpect(status().isUnsupportedMediaType)
    }

    @Test
    fun postData() {
        val data = SensorEntity(timestamp = System.currentTimeMillis())

        `when`(service.send(data)).thenReturn(Matchers.any())

        mockMvc.perform(MockMvcRequestBuilders //
                .post("/telemetries") //
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(data))
        ).andExpect(
                status().isOk
        )
    }
}
