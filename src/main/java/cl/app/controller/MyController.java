package cl.app.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.app.service.LdapClient;



/**
 * Spring Controller Definitions.
 */
@Controller
public class MyController {
	
	@Autowired
	LdapClient ldap;

    @RequestMapping("/1")
    @ResponseBody
    public String create() {
        System.out.println("Agregar Usuario");
        
        ldap.create("Zara", "1234");       
        return "create";
    }
    
    @RequestMapping("/2")
    @ResponseBody
    public String modify() {
        System.out.println("Editar Usuario");
        
        ldap.modify("Zara", "100");
        
        return "modify";
    }
    
    
    @RequestMapping("/3")
    @ResponseBody
    public String search() {
        System.out.println("Metodo Busqueda");
        List<String> l = ldap.search("pato");
        
        for (String s : l) {
			System.out.println(s);
		}
        
        
        return "search";
    }

}


