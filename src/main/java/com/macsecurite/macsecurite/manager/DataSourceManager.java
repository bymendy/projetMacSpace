package com.macsecurite.macsecurite.manager;

import com.macsecurite.macsecurite.model.Contact;
import com.opencsv.CSVWriter;

import java.io.FileWriter;

/**
 * Cette classe elle permet de gérer (sauvegarder et lire) les donnée sauvegarder
 */
public class DataSourceManager {
    private static String fileName;
    static {
        fileName="c:/wamp64/www/macsecurite/data/data.csv";
    }

    public static void saveContact(Contact contact) throws Exception{

        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));

        //Create record
        String[] record = "18 Boulevard de la Paix, Cergy".split(",");

        //Write the record to file
        writer.writeNext(contact.getData(),false);

        //close the writer
        writer.close();
    }
}
