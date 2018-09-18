package lk.ijse.sms.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory buildEntityManagerFactory(){


        File file = new File("src/application.properties");
        FileReader fileReader = null;


        try {
            fileReader = new FileReader(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }


        entityManagerFactory = Persistence.createEntityManagerFactory("boot2", properties);
        return entityManagerFactory;



    }
    public static EntityManagerFactory getEntityManagerFactory(){

        return buildEntityManagerFactory();

    }
}
