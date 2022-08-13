package cl.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import cl.app.service.LdapClient;

@Configuration
//@PropertySource("classpath:application.yml")
@Profile("default")
public class AppConfig {

    @Autowired
    private Environment env;

    
    @Bean
    public LdapContextSource contextSource() {
    	String dir = "ldap.funcionarios.";
        LdapContextSource contextSource = new LdapContextSource();        
        contextSource.setUrl(env.getProperty(dir + "host") + ":" + env.getProperty(dir + "port"));
        contextSource.setBase(env.getRequiredProperty(dir + "base-dn"));
        contextSource.setUserDn(env.getRequiredProperty(dir + "username"));
        contextSource.setPassword(env.getRequiredProperty(dir + "password"));
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public LdapClient ldapClient() {
        return new LdapClient();
    }

}
