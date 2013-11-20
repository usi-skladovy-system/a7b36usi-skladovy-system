package cz.a7b36usi.sklad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cz.a7b36usi.sklad.Controller.LoginController;


/**
 * Hello world!
 *
 */


public class App 
{
    
    
    
    
    
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        LoginController login = ctx.getBean(LoginController.class);
        
        login.showLogForm("login");

    }
}
