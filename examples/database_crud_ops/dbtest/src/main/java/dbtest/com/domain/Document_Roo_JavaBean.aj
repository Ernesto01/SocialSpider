// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package dbtest.com.domain;

import java.lang.Long;
import java.lang.String;

privileged aspect Document_Roo_JavaBean {
    
    public String Document.getName() {
        return this.name;
    }
    
    public void Document.setName(String name) {
        this.name = name;
    }
    
    public String Document.getDescription() {
        return this.description;
    }
    
    public void Document.setDescription(String description) {
        this.description = description;
    }
    
    public String Document.getFilename() {
        return this.filename;
    }
    
    public void Document.setFilename(String filename) {
        this.filename = filename;
    }
    
    public byte[] Document.getContent() {
        return this.content;
    }
    
    public void Document.setContent(byte[] content) {
        this.content = content;
    }
    
    public String Document.getContentType() {
        return this.contentType;
    }
    
    public void Document.setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public Long Document.getSize() {
        return this.size;
    }
    
    public void Document.setSize(Long size) {
        this.size = size;
    }
    
    public String Document.getUrl() {
        return this.url;
    }
    
    public void Document.setUrl(String url) {
        this.url = url;
    }
    
}
