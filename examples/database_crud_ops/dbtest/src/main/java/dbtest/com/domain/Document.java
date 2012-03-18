package dbtest.com.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@RooJavaBean
@RooToString
@RooEntity
public class Document {

    @NotNull
    @Size(max = 30)
    private String name;

    @Size(max = 500)
    private String description;

    @NotNull
    private String filename;
    
    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @NotNull
    private String contentType;

    private java.lang.Long size;
    
    @Transient
    @Size(max = 100)
    private String url;
}
