package com.fh.service;

import com.fh.model.Property;
import com.fh.model.PropertyQuery;
import com.fh.model.Types;

import java.util.List;

public interface PropertyService {

    void addProperty(Property property);

    void deleteProperty(Integer id);

    void updateProperty(Property property);

    List<Property> queryProperty(PropertyQuery propertyQuery);

    List<Types> queryType();

    void deleteBathProperty(String[] ids);

    long selectCountt(PropertyQuery propertyQuery);
}

