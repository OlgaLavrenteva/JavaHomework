package test.java.films_collection;

import main.java.films_collection.Actor;
import main.java.films_collection.Film;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        Set<Actor> actors = new HashSet<>();
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
        assertFalse(film1.equals(film2));
        assertFalse(film2.equals(film1));
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
        assertFalse(film1.equals(film2));
        assertFalse(film2.equals(film1));
    }

    @Test
    public void equalsFilmsOtherObjectClass() throws Exception{
        String title = "Film1";
        Film film = new Film(title);
        assertFalse(film.equals(title));
    }

    @Test
    public void equalsFilmsNullOtherObject() throws Exception{
        String title = "Film1";
        Film film1 = new Film(title);
        Film film2 = null;
        assertFalse(film1.equals(film2));
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
        assertFalse(film1.hashCode()==film2.hashCode());
    }

    @Test
    public void compareToDifTitles() throws Exception{
        String title1 = "Film1";
        Film film1 = new Film(title1);
        String title2 = "Film2";
        Film film2 = new Film(title2);
        assertTrue(film1.compareTo(film2)<0);
        assertTrue(film2.compareTo(film1)>0);
    }

    @Test
    public void compareToSameTitlesDifActors() throws Exception{
        String title = "Film1";
        String name1 = "Name1";
        String name2 = "Name2";
        String surname = "Surname1";
        Actor actor1 = new Actor(name1,surname);
        Actor actor2 = new Actor(name2,surname);
        Film film1 = new Film(title,actor1);
        Film film2 = new Film(title,actor2);
        assertTrue(film1.compareTo(film2)<0);
        assertTrue(film2.compareTo(film1)>0);
    }

    @Test
    public void compareToSameTitlesActors() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor1 = new Actor(name,surname);
        Actor actor2 = new Actor(name,surname);
        Film film1 = new Film(title,actor1);
        Film film2 = new Film(title,actor2);
        assertTrue(film1.compareTo(film2)==0);
        assertTrue(film2.compareTo(film1)==0);
    }

    @Test
    public void compareToSameTitlesNullActors() throws Exception{
        String title = "Film1";
        Actor actor1 = null;
        Actor actor2 = null;
        Film film1 = new Film(title,actor1);
        Film film2 = new Film(title,actor2);
        assertTrue(film1.compareTo(film2)==0);
        assertTrue(film2.compareTo(film1)==0);
    }

    @Test
    public void compareToSameFilm() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        Film film = new Film(title,actor);
        assertTrue(film.compareTo(film)==0);
    }

    @Test
    public void compareToSameTitlesNullOneActor() throws Exception{
        String title = "Film1";
        String name = "Name1";
        String surname = "Surname1";
        Actor actor1 = new Actor(name,surname);
        Actor actor2 = null;
        Film film1 = new Film(title,actor1);
        Film film2 = new Film(title,actor2);
        assertTrue(film1.compareTo(film2)<0);
        assertTrue(film2.compareTo(film1)>0);
    }

    @Test
    public void createFilmWithInvalidTitle(){
        String invalidTitle = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Film title is null.");
        Film film = new Film(invalidTitle);
    }

    @Test
    public void setInvalidTitle(){
        String title = "Film1";
        Film film = new Film(title);
        String invalidTitle = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Film title is null.");
        film.setTitle(invalidTitle);
    }

    @Test
    public void compareToNullFilm(){
        String title = "Film1";
        Film film1 = new Film(title);
        Film film2 = null;
        thrown.expect(NullPointerException.class);
        film1.compareTo(film2);
    }
}
