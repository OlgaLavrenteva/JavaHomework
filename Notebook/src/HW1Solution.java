//import notebook.*;
import notebook.*;

public class HW1Solution{
    public static void main(String[] args) {
        // Main is used to do some tests

        //Positive cases:
        //add notebook with default fields
        Notebook notebook1 = new Notebook();

        //add notes
        notebook1.addNote("First note");
        notebook1.addNote("Second note");
        notebook1.addNote("Third note");

        //exceed notebook size
        for (int i=4; i<202; i++) {
            notebook1.addNote(i + " note");
        }

        //remove notes without shrink of notebook
        for (int i=4; i<155; i++) {
            notebook1.removeNote(i + " note");
        }

        //remove note and shrink notebook
        notebook1.removeNote("155 note");

        //update note
        notebook1.updateNote("Second note", "Changed second note");

        //show all notes
        notebook1.showAllNotes();

        //add notebook with name
        Notebook notebook2 = new Notebook("My notebook 2");
        notebook2.showAllNotes();

        //add notebook with size
        Notebook notebook3 = new Notebook(10);
        notebook3.showAllNotes();

        //add notebook with name & size
        Notebook notebook4 = new Notebook("My notebook 4", 5);
        notebook4.showAllNotes();

        //set new notebook name
        notebook4.setNotebookName("Renamed my notebook 4");
        notebook4.showAllNotes();

        //remove only one existing note
        Notebook notebook5 = new Notebook("My notebook 5", 1);
        notebook5.addNote("First note");
        notebook5.removeNote("First note");
        notebook5.showAllNotes();

        //remove first note
        Notebook notebook6 = new Notebook("My notebook 6", 1);
        notebook6.addNote("First note");
        notebook6.addNote("Second note");
        notebook6.removeNote("First note");
        notebook6.showAllNotes();

        //remove last note
        Notebook notebook7 = new Notebook("My notebook 7", 1);
        notebook7.addNote("First note");
        notebook7.addNote("Second note");
        notebook7.removeNote("Second note");
        notebook7.showAllNotes();

        //Negative cases:
        //negative notebook size and empty name
        String str = null;

        Notebook notebook8 = new Notebook(str, -3);
        notebook8.showAllNotes();

        Notebook notebook9 = new Notebook(str);
        notebook9.showAllNotes();

        Notebook notebook10 = new Notebook(-3);
        notebook10.addNote("First note");
        notebook10.showAllNotes();

        Notebook notebook11 = new Notebook("My notebook 11", 1);
        notebook11.setNotebookName(str);
        notebook11.showAllNotes();

        //adding of empty note
        Notebook notebook12 = new Notebook("My notebook 12", 10);
        notebook12.addNote(str);
        notebook12.showAllNotes();

        //updating of note to empty
        notebook12.addNote("Some note");
        notebook12.updateNote("Some note", str);
        notebook12.showAllNotes();

        //updating of null note
        notebook12.updateNote(str, "Updated note");
        notebook12.showAllNotes();

        //updating of unexisting note
        notebook12.updateNote("Some unexisting note", "Updated note");
        notebook12.showAllNotes();

        //removing of null note
        notebook12.removeNote(str);

        //removing of unexisting note
        notebook12.removeNote("Some unexisting note");
        notebook12.showAllNotes();
    }
}
