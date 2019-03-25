package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FilmTests {
    @Test
    public void createFilmWithTitle() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        assertEquals(title,film.getTitle());
    }

    @Test
    public void createFilmWithTitleActor() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(title,actor);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor);
        assertEquals(title,film.getTitle());
        assertEquals(actors,film.getActors());
    }

    @Test
    public void createFilmWithTitleActors() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        Film film = new Film(title,actors);
        assertEquals(title,film.getTitle());
        assertEquals(actors,film.getActors());
    }

    @Test
    public void setValidTitle() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        String newTitle = "ChangedFilm1";
        film.setTitle(newTitle);
        assertEquals(newTitle,film.getTitle());
    }

    @Test
    public void setActor() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film = new Film(title,actor1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        film.setActors(actor2);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor2);
        assertEquals(actors,film.getActors());
    }

    @Test
    public void setNullActor() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(title,actor);
        Actor nullActor = null;
        film.setActors(nullActor);
        assertEquals(0,film.getActors().size());
    }

    @Test
    public void setActors() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        film.setActors(actors);
        assertEquals(actors,film.getActors());
    }

    @Test
    public void addNotNullActor() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film = new Film(title,actor1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        film.addActor(actor2);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        assertEquals(actors,film.getActors());
    }

    @Test
    public void addNullActor() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film = new Film(title,actor1);
        Actor nullActor = null;
        film.addActor(nullActor);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor1);
        assertEquals(actors,film.getActors());
    }

    @Test
    public void removeActor() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film = new Film(title,actor1);
        film.addActor(actor2);
        film.removeActor(actor1);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor2);
        assertEquals(actors,film.getActors());
    }

    @Test
    public void toStringFilmWithTitle() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        String expectedFilmString = "Film title: " + title + "\nActors: No actors available";
        assertEquals(expectedFilmString,film.toString());
    }

    @Test
    public void toStringFilmWithTitleActors() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        HashSet<Actor> actors = new HashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        Film film = new Film(title,actors);
        String expectedFilmString = "Film title: " + title + "\nActors:\nActor name: " + name1 + " Actor surname: " +
                surname1 + " Actor`s date of birth: null\nActor name: " + name2 + " Actor surname: " +
                surname2 + " Actor`s date of birth: null";
        assertEquals(expectedFilmString,film.toString());
    }

    @Test
    public void equalsFilmsSameObject() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(title,actor);
        assertTrue(film.equals(film));
    }

    @Test
    public void equalsFilmsEqualObject() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film1 = new Film(title,actor);
        Film film2 = new Film(title,actor);
        assertTrue(film1.equals(film2));
        assertTrue(film2.equals(film1));
    }

    @Test
    public void equalsFilmsNotEqualObjectDifTitle() throws Exception{
        String title1 = "Film1";
        String title2 = "Film2";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film1 = new Film(title1,actor);
        Film film2 = new Film(title2,actor);
        assertTrue(!film1.equals(film2));
        assertTrue(!film2.equals(film1));
    }

    @Test
    public void equalsFilmsNotEqualObjectDifActors() throws Exception{
        String title = "Film";
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        Film film1 = new Film(title,actor1);
        String name2 = "Name2";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        Film film2 = new Film(title,actor2);
        assertTrue(!film1.equals(film2));
        assertTrue(!film2.equals(film1));
    }

    @Test
    public void equalsFilmsOtherObjectClass() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        assertTrue(!film.equals(title));
    }

    @Test
    public void hashCodeEqualFilms() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film1 = new Film(title,actor);
        Film film2 = new Film(title,actor);
        assertTrue(film1.hashCode()==film2.hashCode());
    }

    @Test
    public void hashCodeNotEqualFilms() throws Exception{
        String title1 = "Film1";
        String title2 = "Film2";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film1 = new Film(title1,actor);
        Film film2 = new Film(title2,actor);
        assertTrue(!(film1.hashCode()==film2.hashCode()));
    }

    @Test
    public void createFilmWithInvalidTitle(){
        try {
            String invalidTitle = null;
            Film film = new Film(invalidTitle);
        } catch (Exception e){
            String expectedExceptionMessage = "Film title is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void setInvalidTitle(){
        try {
            String title = "Film1";
            Film film = new Film(title);
            String invalidTitle = null;
            film.setTitle(invalidTitle);
        } catch (Exception e){
            String expectedExceptionMessage = "Film title is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }
}
