package bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryProvider {
    public static AbstractFactory getFactory(){
        try {
            Properties prop = new Properties();
            InputStream input = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("config.properties");;

            prop.load(input);
            String environment = prop.getProperty("environment");

            if(environment.equals("production")){
                return new ProductionFactory();
            }else if(environment.equals("test")){
                return new TestFactory();
            }else{
                System.out.println("environment property not set correctly");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
