package com.ma.de.service;

import com.ma.de.domain.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by mariuszdekarski on 02/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressLookupServiceTest {

    private static Address address1;
    private static final String POSTCODE = "W43NU";

    @MockBean
    private AddressLookupService remoteLookupService;

    @Autowired
    private AddressLookupService lookupService;

    @Before
    public void init(){
        address1 = new Address("10D", "Street Saint");
    }

    @Test
    public void getAnyResponseFromRemoteService(){
        List<Address> addressList = new ArrayList<>();
        given(remoteLookupService.lookupPostcode(POSTCODE)).willReturn(addressList);


        List<Address> realAddressList =  lookupService.lookupPostcode(POSTCODE);
        assertThat(realAddressList).isEqualTo(addressList);
    }

    @Test
    public void getOneAddressForGivenPostCode(){
        List<Address> addressList = Arrays.asList(address1);
        given(remoteLookupService.lookupPostcode(POSTCODE)).willReturn(addressList);

        List<Address> realAddressList =  lookupService.lookupPostcode(POSTCODE);
        assertThat(realAddressList).hasSameSizeAs(addressList);
        assertThat(realAddressList).hasSameElementsAs(addressList);
    }

    @Test
    public void getNoAddressForGivenPostCode(){
        given(remoteLookupService.lookupPostcode(POSTCODE)).willReturn(null);

        List<Address> realAddressList =  lookupService.lookupPostcode(POSTCODE);
        assertThat(realAddressList).isNull();
    }

}
