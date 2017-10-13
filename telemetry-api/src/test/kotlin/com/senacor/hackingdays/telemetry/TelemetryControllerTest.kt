package com.senacor.hackingdays.telemetry

import com.senacor.hackingdays.telemetry.TestData.getTestData
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
        val data = Telemetry(System.currentTimeMillis().toFloat(), AccelerometerData(), SupersonicData())

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
        `when`(service.send(getTestData())).thenReturn(Matchers.any())

        mockMvc.perform(MockMvcRequestBuilders
                .post("/telemetries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getTestData().serialize())
        )
                .andExpect(status().isOk)
    }

}

object TestData {

    fun getTestData(): Telemetry {
        return Telemetry(1507826045.4362488f,
                AccelerometerData(-3.3446997192382812f, -0.1197100830078125f, 8.702923034667968f),
                SupersonicData(5.243897438049316f))
    }

    fun getTestDataString(): String {
        return "{'accelerometer_data': [{'z': 8.702923034667968, 'x': -3.3446997192382812, 'y': -0.1197100830078125}], 'timestamp': 1507826045.4362488, 'ultrasonic_data': [{'distance': 5.243897438049316}]}"
    }
}
