// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.dbtest7.web;

import com.dbtest7.domain.Document;
import java.lang.String;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new DocumentConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
    static class com.dbtest7.web.ApplicationConversionServiceFactoryBean.DocumentConverter implements Converter<Document, String> {
        public String convert(Document document) {
            return new StringBuilder().append(document.getName()).append(" ").append(document.getDescription()).append(" ").append(document.getFilename()).append(" ").append(document.getContentType()).toString();
        }
        
    }
    
}