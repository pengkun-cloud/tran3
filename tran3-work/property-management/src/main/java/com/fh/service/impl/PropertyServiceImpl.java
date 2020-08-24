package com.fh.service.impl;

import com.fh.mapper.PropertyMapper;
import com.fh.model.Property;
import com.fh.model.PropertyQuery;
import com.fh.model.Types;
import com.fh.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Resource
    private PropertyMapper propertyMapper;


    @Override
    public void addProperty(Property property) {
        propertyMapper.addProperty(property);
    }

    @Override
    public void deleteProperty(Integer id) {
        propertyMapper.deleteProperty(id);
    }

    @Override
    public void updateProperty(Property property) {
        propertyMapper.updateProperty(property);
    }

    @Override
    public List<Property> queryProperty(PropertyQuery propertyQuery) {
        return propertyMapper.queryProperty(propertyQuery);
    }

    @Override
    public List<Types> queryType() {
        return propertyMapper.queryType();
    }

    @Override
    public void deleteBathProperty(String[] ids) {
        propertyMapper.deleteBathProperty(ids);
    }

    @Override
    public long selectCountt(PropertyQuery propertyQuery) {
        return propertyMapper.selectCountt(propertyQuery);
    }

}
