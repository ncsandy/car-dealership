package com.dealership;

import java.util.Comparator;

public class DateSorter implements Comparator<Customer> {
	
	@Override
	public int compare(Customer o1, Customer o2) {
        return o2.getDate().compareTo(o1.getDate());
    }




}

