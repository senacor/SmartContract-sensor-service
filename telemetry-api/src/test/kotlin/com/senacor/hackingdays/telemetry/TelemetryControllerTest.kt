package com.senacor.hackingdays.telemetry

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
class TelemetryControllerTest {

    @Autowired
    private lateinit var controller: TelemetryController

    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var service: TelemetryEventService

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    @Test
    fun `should return 415`() {
        val data = Telemetry(System.currentTimeMillis())

        mockMvc.perform(MockMvcRequestBuilders
                .post("/telemetries")
                .contentType(MediaType.APPLICATION_ATOM_XML)
                .content(data.serialize())
        ).andExpect(
                status().isUnsupportedMediaType
        )
    }

    @Test
    fun postData() {
        val data = Telemetry(System.currentTimeMillis())

        `when`(service.send(data)).thenReturn(Matchers.any())

        mockMvc.perform(MockMvcRequestBuilders
                .post("/telemetries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(data.serialize())
        ).andExpect(
                status().isOk
        )
    }
}
