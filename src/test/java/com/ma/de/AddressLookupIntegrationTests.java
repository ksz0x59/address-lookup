package com.ma.de;

import com.ma.de.domain.Address;
import com.ma.de.service.AddressLookupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressLookupIntegrationTests {

    private static final String POSTCODE_MULTI = "W6 0LG";
    private static final String POSTCODE = "SW1A 2AA";
    private static final String POSTCODE_NO_NUMBER = "BT48 6DQ";

    @Autowired
    private AddressLookupService lookupService;


	@Test
    public void multiple_street_address_from_postcode(){
        List<Address> addressList = lookupService.lookupPostcode(POSTCODE_MULTI);
        assertThat(addressList).hasSize(13);

        assertThat(addressList.get(0).getStreet()).isEqualToIgnoringCase("Hammersmith Grove");
        assertThat(addressList.get(0).getNumber()).isEqualTo("5-17");
    }


    @Test
    public void street_address_from_postcode(){
        List<Address> addressList = lookupService.lookupPostcode(POSTCODE);
        assertThat(addressList).hasSize(1);

        assertThat(addressList.get(0).getStreet()).isEqualToIgnoringCase("Downing Street");
        assertThat(addressList.get(0).getNumber()).isEqualTo("10");
    }

    @Test
    public void street_address_without_number_from_postcode(){
        List<Address> addressList = lookupService.lookupPostcode(POSTCODE_NO_NUMBER);
        assertThat(addressList).hasSize(1);

        assertThat(addressList.get(0).getStreet()).isEqualToIgnoringCase("Shipquay Place");
        assertThat(addressList.get(0).getNumber()).isNull();
    }

}
