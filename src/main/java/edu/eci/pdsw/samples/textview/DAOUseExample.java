/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.textview;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author hcadavid
 */
public class DAOUseExample {
    
    public static void main(String a[]) throws PersistenceException, IOException{
        Properties properties=new PropertiesLoader().readProperties("applicationconfig.properties");

        
        DaoFactory daof=DaoFactory.getInstance(properties);
        
        daof.beginSession();
        
        /**
         * OPERACIONES CON LOS DAO
         */
        System.out.println(daof.getDaoEntradaForo().loadAll());
        System.out.println("");
        // Prueba load MyBatisDaoUsuario
        System.out.println("juan.perez@gmail.com --"+daof.getDaoUsuario().load("juan.perez@gmail.com").getNombre());
        Usuario p = new Usuario("csa","cris");
        //Prueba SAve MyBatisDaoUsuario
        daof.getDaoUsuario().save(p);
        System.out.println("csa--"+daof.getDaoUsuario().load("csa").getNombre());
        //Prueba load de MyBatisDAoEntradaForo
        System.out.println("Prueba LOAD  "+daof.getDaoEntradaForo().load(2));
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
