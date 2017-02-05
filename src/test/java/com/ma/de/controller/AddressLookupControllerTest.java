package com.ma.de.controller;

import com.ma.de.domain.Address;
import com.ma.de.service.AddressLookupService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by @ma-de on 05/02/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AddressLookupController.class)
public class AddressLookupControllerTest {

    private Address address;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressLookupService service;

    @Before
    public void init(){
        address = new Address("10D", "Street Saint");
    }

    @Test
    public void lookup_should_return_address_from_service() throws Exception{
        when(service.lookupPostcode(anyString())).thenReturn( Arrays.asList(address));

        this.mockMvc.perform(get("/lookup/postcode/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("10D Street Saint")));
    }

    @Test
    public void lookup_without_street_number_should_return_address_with_premise_from_service() throws Exception{
        address.setNumber(null);
        address.setPremise("Some Place");

        when(service.lookupPostcode(anyString())).thenReturn( Arrays.asList(address));

        this.mockMvc.perform(get("/lookup/postcode/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Some Place Street Saint")));
    }

    @Test
    public void lookup_should_return_address_name_when_available_from_service() throws Exception{
        address.setOrganisation("Important Corp");
        when(service.lookupPostcode(anyString())).thenReturn( Arrays.asList(address));

        this.mockMvc.perform(get("/lookup/postcode/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("10D Street Saint - Important Corp")));

    }
}
