package com.ma.de.service;

import com.ma.de.domain.Address;

import java.util.List;

/**
 * Created by mariuszdekarski on 02/02/2017.
 */
public interface AddressLookupService {

    List<Address> lookupPostcode(String postcode);
}
