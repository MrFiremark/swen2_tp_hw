package swen2.tp.swen2_tp_hw.service;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class ConfigService {

    // TODO interface so user input can be used

    public String load(String key) {

        Properties properties = new Properties();
        try(InputStream input = new FileInputStream("src/Setting.properties")){
            properties.load(input);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
