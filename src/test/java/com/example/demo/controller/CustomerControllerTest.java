package com.example.demo.controller;

import com.example.demo.service.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = CustomerController.class)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    String bodyJsonTest = "[{\"id\": 10000091,\"name\":\"Hoyt Duke\",\"duetime\":\"2015-04-03T13:52:53-07:00\",\"jointime\":\"2014-05-07T15:20:37-07:00\"}]";

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    CustomerServiceImpl customerService;

    @Test
    public void testPostAndReadCustomersStatusOk() {
        this.webTestClient.post().uri("/customers/getByDueTimeAsc")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(bodyJsonTest)
                .exchange()
                .expectStatus().isOk();
    }

}
