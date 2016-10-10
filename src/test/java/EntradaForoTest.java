

import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2106088
 */
public class EntradaForoTest {
    
    @Before
    public void setUp(){
        
    }
    @Test
    public void EntradaForoTest1()  throws PersistenceException, IOException{
        Properties properties=new PropertiesLoader().readProperties("applicationconfig.properties");
        DaoFactory daof=DaoFactory.getInstance(properties);
        
        daof.beginSession();
        //Prueba load de MyBatisDAoEntradaForo
        System.out.println("Prueba LOAD  "+daof.getDaoEntradaForo().load(5));
        daof.commitTransaction();
        daof.endSession();
    }
    
    
    
}

class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}
