package main.java.films_collection;

import java.io.*;

public class FilmsCollectionManager {
    /**
     * Static function allows to store existing FilmsCollection into file.
     * @param filmsCollection
     * @param file
     * @return file name
     * @throws Exception if passed collection is null, if passed file doesn't exist
     */
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
            System.out.println(e.getMessage());
        }

        return file;
    }

    /**
     * Static function allows to restore FilmsCollection from the file.
     * @param file
     * @return FilmsCollection
     * @throws Exception if file doesn't exist
     */
    public static FilmsCollection restoreCollection(String file) throws Exception{
        if(file==null){
            throw new Exception("File is null");
        }

        FilmsCollection filmsCollection;

        try(ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(file))){
            filmsCollection = (FilmsCollection)objInStream.readObject();
        } catch (IOException e){
            throw new IOException(file + " doesn't exist.");
        }

        return filmsCollection;
    }

}
