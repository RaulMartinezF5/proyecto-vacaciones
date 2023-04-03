package com.vacaciones.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebAppConfiguration
public class UserAccesSecurityTest {
    
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
              .webAppContextSetup(context)
              .apply(SecurityMockMvcConfigurers.springSecurity())
              .build();  
    }

    @Test
    void test_user_unauthenticated() throws Exception{
        MockHttpServletResponse response = mvc.perform(get("/api/login"))
                                           .andExpect(unauthenticated())
                                           .andReturn()
                                           .getResponse();
        assertThat(response.getStatus(), equalTo(401));                           
    }
    @Test
    void test_user_authenticad() throws Exception{
        MockHttpServletResponse response = mvc.perform(get("/api/login").with(user("1234567L").password("password").roles("ADMIN")))
                                            .andExpect(authenticated())
                                            .andReturn()
                                            .getResponse();

        assertThat (response.getStatus(), equalTo(202));
        assertThat (response.getContentType(), equalTo("application/json"));
        assertThat (response.getContentAsString(), contains("role","ROLE_USER","message","Logged") != null);
    }
}
