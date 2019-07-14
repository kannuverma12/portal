package com.kv.portal.service;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.time.Instant;

import com.kv.portal.AbstractEndpointTest;
import com.kv.portal.PortalApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PortalApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PortalServiceTest extends AbstractEndpointTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc               mockMvc;

    @Autowired

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void contextLoads() {
        assertNotNull(wac);
    }

    @Test
    public void test1_GetAllEmployeesReturnEmptyResult() throws Exception {
        this.mockMvc.perform(post("/v1/portal/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(0)));
    }

    @Test
    public void test2_AddEmployees() throws Exception {

        String jsonTask = createEmployeeJson("karan", 12356);
        this.mockMvc.perform(post("/v1/portal/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTask))
                .andExpect(status().isOk());

//        this.mockMvc.perform(post("/v1/portal/employees")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.*", hasSize(1)));
    }

    @Test
    public void test3_GetEmployeesWithNotEmptyResult() throws Exception {
        this.mockMvc.perform(post("/v1/portal/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(1)));
    }

}
