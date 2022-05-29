package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class ConfigService {

    private ILoggerWrapper logger = LoggerFactory.getLogger();

    public String load(String key) {

        Properties properties = new Properties();
        try(InputStream input = new FileInputStream("src/Setting.properties")){
            properties.load(input);
        }catch (IOException ex){
            logger.error("File error[err:404]. Could not load config file");
            ex.printStackTrace();
        }
        if(properties.getProperty(key) == null){
            logger.debug("File error[err:405]. Could not find key: " + key);
        }
        return properties.getProperty(key);

    }
}
