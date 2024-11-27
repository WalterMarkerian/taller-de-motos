//package com.tallerDeMotos.commons.mapper;
//
//import com.tallerDeMotos.commons.domain.BaseException;
//import com.tallerDeMotos.commons.model.ApiError;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//import java.time.LocalDateTime;
//
//@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
//public interface ApiErrorMapper {
//
//    @Mappings({
//            @Mapping(target = "timestamp", expression = "java(LocalDateTime.now().toString())"),
//            @Mapping(source = "errorCode", target = "error"),
//            @Mapping(source = "exc.code", target = "code"),
//            @Mapping(source = "exc.message", target = "message"),
//            @Mapping(source = "path", target = "path")
//    })
//    ApiError toApiError(String errorCode, BaseException exc, String path);
//}
