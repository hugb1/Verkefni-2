/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.byrjun.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ebba Þóra Hvannberg
 */
@Controller
public class VilluController   implements ErrorController{
    
    private static final String PATH = "/error";
    
    @Autowired
    private ErrorAttributes errorAttributes;
    
/**
 * Meðhöndlar villu sem verður á þjóninum 
 * @param request  beiðnin með villuskilaboðum 
 * @param response 
 * @return 
 */    
    @RequestMapping(value = PATH)
    public ModelAndView villa(HttpServletRequest request) {
     
        // sendir attribute til viðmótsins og birtir síðuna með villuskilaboðum  
    	//Map<String, Object> a = getErrorAttributes
        return new ModelAndView("demo/villuSida", "attrs", getErrorAttributes(request, false));
    }
    
    /**
     * Skilar slóðinni fyrir villu
    */
    @Override
    public String getErrorPath() {
        return PATH;
    } 
    
    
    /**
     * Nær í villu-attribute sem komu út úr Http beiðni 
     * @param request  Http beiðnin 
     * @param includeStackTrace ef true þá er skilað stack trace annars ekki 
     * @return mengi af tvíundum með nafni af attributi og gildi þeirra 
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
			boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}
}

