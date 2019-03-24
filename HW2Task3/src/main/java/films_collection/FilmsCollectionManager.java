package main.java.films_collection;

import java.io.*;

public class FilmsCollectionManager {
    public static String storeCollection(FilmsCollection filmsCollection, String file) throws Exception{
        if(filmsCollection==null){
            throw new Exception("Films collection is null.");
        }
        if(file==null){
            throw new Exception("File is null");
        }

        try(ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(file))){
            objOutStream.writeObject(filmsCollection);
            objOutStream.flush();
        } catch (IOException e){
            throw new Exception(file + " doesn't exist.");
        }

        return file;
    }

    public static FilmsCollection restoreCollection(String file) throws Exception{
        if(file==null){
            throw new Exception("File is null");
        }

        FilmsCollection filmsCollection;

        try(ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(file))){
            filmsCollection = (FilmsCollection)objInStream.readObject();
        } catch (IOException e){
            throw new Exception(file + " doesn't exist.");
        }

        return filmsCollection;
    }

}
