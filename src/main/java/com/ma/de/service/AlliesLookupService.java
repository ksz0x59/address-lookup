package com.ma.de.service;

import com.ma.de.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by mariuszdekarski on 02/02/2017.
 */
@Service
public class AlliesLookupService implements AddressLookupService {

    private RestTemplate restTemplate = new RestTemplate();

    private static final Logger logger = LoggerFactory.getLogger(AlliesLookupService.class);

    private static String URL = "http://ws.postcoder.com/pcw/PCWDX-5WC3R-VSH44-MY8NZ/address/UK/{postcode}";

    @Override
    @Cacheable("lookup")
    public List<Address> lookupPostcode(String postcode) {
        Map<String, String> vars = Collections.singletonMap("postcode", postcode);
        List<Address> list = new ArrayList<>();

        try {
            ResponseEntity<List<Address>> response =
                    restTemplate.exchange(URL, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Address>>() {
                            }, vars);
            list = response.getBody();

        }catch (Exception ex){
            logger.error("Error from AlliesLookup: " + ex.getMessage());
        }

        logger.info("Address lookup for postcode {} result {} entries.", postcode, list.size());
        return list;
    }
}
