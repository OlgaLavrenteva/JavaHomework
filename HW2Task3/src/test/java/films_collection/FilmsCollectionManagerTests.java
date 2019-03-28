package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import main.java.films_collection.FilmsCollection;
import main.java.films_collection.FilmsCollectionManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FilmsCollectionManagerTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Set<Film> films = new HashSet<>();
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
        Set<Film> films = new HashSet<>();
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
    public void storeNullCollection() throws Exception{
        FilmsCollection collection = null;
        String currentDir = System.getProperty("user.dir");
        String collectionStore = currentDir + "\\out\\Collection.txt";
        thrown.expect(Exception.class);
        thrown.expectMessage("Films collection is null.");
        FilmsCollectionManager.storeCollection(collection, collectionStore);
    }

    @Test
    public void storeNullFile() throws Exception{
        String title = "Collection1";
        FilmsCollection collection = new FilmsCollection(title);
        String collectionStore = null;
        thrown.expect(Exception.class);
        thrown.expectMessage("File is null");
        FilmsCollectionManager.storeCollection(collection, collectionStore);
    }

    @Test
    public void restoreNullFile() throws Exception{
        String collectionStore = null;
        thrown.expect(Exception.class);
        thrown.expectMessage("File is null");
        FilmsCollectionManager.restoreCollection(collectionStore);
    }

    @Test
    public void restoreFileDoesNotExist() throws Exception{
        String collectionStore = "DoesNotExist";
        thrown.expect(IOException.class);
        thrown.expectMessage("DoesNotExist doesn't exist.");
        FilmsCollectionManager.restoreCollection(collectionStore);

    }
}
