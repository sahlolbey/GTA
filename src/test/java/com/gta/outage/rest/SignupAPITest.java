package com.gta.outage.rest;

import com.gta.outage.model.Subscriber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SignupAPITest extends AbstractRestTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void addSubscriber() throws Exception {
        String uri = "/addSubscriber";
        Subscriber subscriber = new Subscriber();
        subscriber.setName("Hamid");
        subscriber.setEmail("sahlolbey@gmail.com");

        String inputJson = super.mapToJson(subscriber);
        System.out.println("inputJson=" + inputJson);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        int status = mvcResult.getResponse().getStatus();

        System.out.println("status=" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "successfully created");
    }
}
