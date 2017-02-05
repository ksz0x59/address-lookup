package com.ma.de.controller;

import com.ma.de.domain.Address;
import com.ma.de.service.AddressLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by @ma-de on 05/02/2017.
 */
@Controller
public class AddressLookupController {

    @Autowired
    private AddressLookupService service;

    @RequestMapping(value = "/lookup/postcode/{postcode}", method=GET)
    public @ResponseBody
    List<String> lookupPostcode(@PathVariable String postcode){

        List<String> list = service.lookupPostcode(postcode)
                .stream()
                .map(i -> concatAddressIntoString(i))
                .collect(Collectors.toList());
        return list;
    }

    private String concatAddressIntoString(Address i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i.getNumber() != null ? i.getNumber() : i.getPremise());
        sb.append(" ");
        sb.append(i.getStreet());
        if(i.getOrganisation() !=null){
            sb.append(" - ");
            sb.append(i.getOrganisation());
        }
        return sb.toString();
    }

}
