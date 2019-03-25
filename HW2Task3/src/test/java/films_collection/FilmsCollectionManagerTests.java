package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import main.java.films_collection.FilmsCollection;
import main.java.films_collection.FilmsCollectionManager;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class FilmsCollectionManagerTests {
    @Test
    public void storeCollection() throws Exception{
        String title = "Collection1";
        String filmTitle1 = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(filmTitle1,actor1);
        String filmTitle2 = "Film2";
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film2 = new Film(filmTitle2,actor2);
        HashSet<Film> films = new HashSet<>();
        films.add(film1);
        films.add(film2);
        FilmsCollection collection = new FilmsCollection(title,films);
        String currentDir = System.getProperty("user.dir");
        String collectionStore = currentDir + "\\out\\Collection.txt";
        String returnedFileName = FilmsCollectionManager.storeCollection(collection, collectionStore);
        assertEquals(collectionStore, returnedFileName);
    }

    @Test
    public void restoreCollection() throws Exception{
        String title = "Collection1";
        String filmTitle1 = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(filmTitle1,actor1);
        String filmTitle2 = "Film2";
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film2 = new Film(filmTitle2,actor2);
        HashSet<Film> films = new HashSet<>();
        films.add(film1);
        films.add(film2);
        FilmsCollection collection = new FilmsCollection(title,films);
        String currentDir = System.getProperty("user.dir");
        String collectionStore = currentDir + "\\out\\Collection.txt";
        FilmsCollectionManager.storeCollection(collection, collectionStore);
        FilmsCollection collectionRestored = FilmsCollectionManager.restoreCollection(collectionStore);
        assertEquals(collection.toString(),collectionRestored.toString());
    }

    @Test
    public void storeNullCollection(){
        try {
            FilmsCollection collection = null;
            String currentDir = System.getProperty("user.dir");
            String collectionStore = currentDir + "\\out\\Collection.txt";
            FilmsCollectionManager.storeCollection(collection, collectionStore);
        } catch (Exception e){
            String expectedExceptionMessage = "Films collection is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void storeNullFile(){
        try {
            String title = "Collection1";
            FilmsCollection collection = new FilmsCollection(title);
            String collectionStore = null;
            FilmsCollectionManager.storeCollection(collection, collectionStore);
        } catch (Exception e){
            String expectedExceptionMessage = "File is null";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void storeFileDoesNotExist(){
        try {
            String title = "Collection1";
            FilmsCollection collection = new FilmsCollection(title);
            String collectionStore = "DoesNotExist";
            FilmsCollectionManager.storeCollection(collection, collectionStore);
        } catch (Exception e){
            String expectedExceptionMessage = "DoesNotExist doesn't exist.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void restoreNullFile(){
        try {
            String collectionStore = null;
            FilmsCollectionManager.restoreCollection(collectionStore);
        } catch (Exception e){
            String expectedExceptionMessage = "File is null";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void restoreFileDoesNotExist(){
        try {
            String collectionStore = "DoesNotExist";
            FilmsCollectionManager.restoreCollection(collectionStore);
        } catch (Exception e){
            String expectedExceptionMessage = "DoesNotExist doesn't exist.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }
}
