package com.hushunjian.mapstructMap;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    
    
}
