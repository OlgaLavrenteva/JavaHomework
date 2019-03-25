package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import main.java.films_collection.FilmsCollection;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        HashSet<Film> films = new HashSet<>();
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
        HashSet<Film> films = new HashSet<>();
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

    @Test
    public void setFilm() throws Exception{
        String title = "Collection1";
        String filmTitle1 = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(filmTitle1,actor1);
        FilmsCollection collection = new FilmsCollection(title,film1);
        String filmTitle2 = "Film2";
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film2 = new Film(filmTitle2,actor2);
        collection.setFilms(film2);
        HashSet<Film> films = new HashSet<>();
        films.add(film2);
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void setNullFilm() throws Exception{
        String title = "Collection1";
        String filmTitle = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(filmTitle,actor);
        FilmsCollection collection = new FilmsCollection(title,film);
        Film nullFilm = null;
        collection.setFilms(nullFilm);
        assertEquals(0,collection.getFilms().size());
    }

    @Test
    public void setFilms() throws Exception{
        String title = "Collection1";
        FilmsCollection collection = new FilmsCollection(title);
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
        collection.setFilms(films);
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void addNotNullFilm() throws Exception{
        String title = "Collection1";
        String filmTitle1 = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(filmTitle1,actor1);
        FilmsCollection collection = new FilmsCollection(title,film1);
        String filmTitle2 = "Film2";
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film2 = new Film(filmTitle2,actor2);
        collection.addFilm(film2);
        HashSet<Film> films = new HashSet<>();
        films.add(film1);
        films.add(film2);
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void addNullFilm() throws Exception{
        String title = "Collection1";
        String filmTitle1 = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(filmTitle1,actor1);
        FilmsCollection collection = new FilmsCollection(title,film1);
        Film nullFilm = null;
        collection.addFilm(nullFilm);
        HashSet<Film> films = new HashSet<>();
        films.add(film1);
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void removeFilm() throws Exception{
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
        FilmsCollection collection = new FilmsCollection(title,film1);
        collection.addFilm(film2);
        collection.removeFilm(film1);
        HashSet<Film> films = new HashSet<>();
        films.add(film2);
        assertEquals(films,collection.getFilms());
    }

    @Test
    public void toStringFilmsCollectionWithTitle() throws Exception{
        String title = "Collection1";
        FilmsCollection collection = new FilmsCollection(title);
        String expectedFilmsCollectionString = "Films collection: " + title + "\nFilms: No films are available";
        assertEquals(expectedFilmsCollectionString,collection.toString());
    }

    @Test
    public void toStringFilmsCollectionWithTitleFilms() throws Exception{
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
        FilmsCollection collection = new FilmsCollection(title,film1);
        collection.addFilm(film2);
        String expectedFilmsCollectionString = "Films collection: " + title + "\nFilms:\nFilm title: " + filmTitle1 +
                "\nActors:\nActor name: " + name1 + " Actor surname: " + surname1 + " Actor`s date of birth: null" +
                "\nFilm title: " + filmTitle2 + "\nActors:\nActor name: " + name2 + " Actor surname: " + surname2 +
                " Actor`s date of birth: null";
        assertEquals(expectedFilmsCollectionString,collection.toString());
    }

    @Test
    public void createFilmsCollectionWithInvalidTitle(){
        try {
            String invalidTitle = null;
            FilmsCollection collection = new FilmsCollection(invalidTitle);
        } catch (Exception e){
            String expectedExceptionMessage = "Collection title is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void setInvalidTitle(){
        try {
            String title = "Collection1";
            FilmsCollection collection = new FilmsCollection(title);
            String invalidTitle = null;
            collection.setTitle(invalidTitle);
        } catch (Exception e){
            String expectedExceptionMessage = "Collection title is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

}
