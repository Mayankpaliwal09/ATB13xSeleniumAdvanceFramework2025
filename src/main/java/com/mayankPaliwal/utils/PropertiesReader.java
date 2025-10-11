package com.mayankPaliwal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {


    // Responsiblity of this file is to read the Data.properties[in resources folder ] file any one who wants the file data
    // for ex -> url , username etc


//    Here we create a static function. Static function because we don't want to create object every time.

public static String readKey(String key){

    Properties p;
     String user_dir = System.getProperty("user.dir");
     String file_path = user_dir+ "/src/main/resources/data.properties";
    try {
        FileInputStream fileInputStream = new FileInputStream(file_path);
        p = new Properties();
        p.load(fileInputStream);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
   return p.getProperty(key);

}

}
