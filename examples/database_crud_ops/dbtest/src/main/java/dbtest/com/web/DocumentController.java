package dbtest.com.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import dbtest.com.domain.Document;

import org.apache.commons.io.IOUtils;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;


@RooWebScaffold(path = "documents", formBackingObject = Document.class)
@RequestMapping("/documents")
@Controller
public class DocumentController {
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		
	}
	
	@RequestMapping(value="savedoc", method = RequestMethod.POST)
	public String createdoc(@Valid Document document, BindingResult result, Model model,
							@RequestParam("content") MultipartFile content, HttpServletRequest request) {
		document.setContentType(content.getContentType());
		document.setFilename(content.getOriginalFilename());
		document.setSize(content.getSize());
		
		/*
		log.debug("Document: ");
		log.debug("Name: " + content.getOriginalFilename());
		log.debug("Description: " + document.getDescription());
		log.debug("File: " + content.getName());
		log.debug("Type: " + content.getContentType());
		log.debug("Size: " + content.getSize());
		*/
		if(result.hasErrors()) {
			model.addAttribute("document", document);
			return "documents/create";
		}
		document.persist();
		
		
		return "redirect:/documents?page=1&size=10" + encodeUrlPathSegment(document.getId().toString(), request);
	}
	
	/*
	private String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest request) {
		String enc = request.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Document doc = Document.findDocument(id);
		doc.setUrl("/documents/showdoc/" + id);
		model.addAttribute("document", Document.findDocument(id));
		model.addAttribute("itemId", id);
		return "documents/show";
	}
	
	@RequestMapping(value = "/showdoc/{id}", method = RequestMethod.GET)
	public String showdoc(@PathVariable("id") Long id, HttpServletResponse response, Model model) {
		Document doc = Document.findDocument(id);
		
		try {
	          response.setHeader("Content-Disposition", "inline;filename=\"" + doc.getFilename()+ "\"");

	          OutputStream out = response.getOutputStream();
	          response.setContentType(doc.getContentType());
	          IOUtils.copy( new ByteArrayInputStream(doc.getContent()),out);
	            out.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
}


