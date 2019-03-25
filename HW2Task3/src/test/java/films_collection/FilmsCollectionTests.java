package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import main.java.films_collection.FilmsCollection;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class FilmsCollectionTests {
    @Test
    public void createFilmsCollectionWithTitle() throws Exception{
        String title = "Collection1";
        FilmsCollection collection = new FilmsCollection(title);
        assertEquals(title,collection.getTitle());
    }

    @Test
    public void createFilmsCollectionWithTitleFilm() throws Exception{
        String title = "Collection1";
        String filmTitle = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(filmTitle,actor);
        FilmsCollection collection = new FilmsCollection(title,film);
        HashSet<Film> films = new HashSet<Film>();
        films.add(film);
        assertEquals(title,collection.getTitle());
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void createFilmsCollectionWithTitleFilms() throws Exception{
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
        HashSet<Film> films = new HashSet<Film>();
        films.add(film1);
        films.add(film2);
        FilmsCollection collection = new FilmsCollection(title,films);
        assertEquals(title,collection.getTitle());
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void setValidTitle() throws Exception{
        String title = "Collection1";
        FilmsCollection collection = new FilmsCollection(title);
        String newTitle = "ChangedCollection1";
        collection.setTitle(newTitle);
        assertEquals(newTitle,collection.getTitle());
    }


}
