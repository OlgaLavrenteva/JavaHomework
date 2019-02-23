import notebook.*;

public class HW1Solution {
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
        for (int i=4; i<202; i++)
        {
            notebook1.addNote(i + " note");
        }

        //remove notes without shrink of notebook
        for (int i=4; i<155; i++)
        {
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

        //Negative cases:
        //negative notebook size and empty name
        String str = null;

        Notebook notebook5 = new Notebook(str, -3);
        notebook5.showAllNotes();

        Notebook notebook6 = new Notebook(str);
        notebook6.showAllNotes();

        Notebook notebook7 = new Notebook(-3);
        notebook7.addNote("First note");
        notebook7.showAllNotes();

        Notebook notebook8 = new Notebook("My notebook 8", 1);
        notebook8.setNotebookName(str);

        //adding of empty note
        Notebook notebook9 = new Notebook("My notebook 9", 10);
        notebook9.addNote(str);
        notebook9.showAllNotes();

        //updating of note to empty
        notebook9.addNote("Some note");
        notebook9.updateNote("Some note", str);
        notebook9.showAllNotes();

        //updating of null note
        notebook9.updateNote(str, "Updated note");
        notebook9.showAllNotes();

        //updating of unexisting note
        notebook9.updateNote("Some unexisting note", "Updated note");
        notebook9.showAllNotes();

        //removing of null note
        notebook9.removeNote(str);

        //removing of unexisting note
        notebook9.removeNote("Some unexisting note");
        notebook9.showAllNotes();
    }
}
