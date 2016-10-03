package com.vchauhan.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Vineet on 9/24/16.
 */
public class BoxControllerTest {

    private MockMvc mockMvc;

    private BoxController boxController;

    private RequestBuilder requestBuilder;

    @Before
    public void setup(){
        boxController = new BoxController();
        mockMvc = MockMvcBuilders.standaloneSetup(boxController).build();
    }

    //@Test
//    public void testBox() throws Exception{
//        mockMvc.perform(get("/api/v1/boxes"))
//                .andExpect(status().isOk());
//    }
}
