public class Notebook {
    private String notebookName;
    private int numberOfNotes;
    private Note[] notes;

    public Notebook()
    {
        this.notebookName = "A name is not assigned";
        this.numberOfNotes = 100;
        this.notes = new Note[this.numberOfNotes];
    }

    public Notebook(String notebookName)
    {
        this.notebookName = notebookName;
        this.numberOfNotes = 100;
        this.notes = new Note[this.numberOfNotes];
    }

    public Notebook(int numberOfNotes)
    {
        this.notebookName = "A name is not assigned";
        this.numberOfNotes = numberOfNotes;
        this.notes = new Note[this.numberOfNotes];
    }

    public Notebook(String notebookName, int numberOfNotes)
    {
        this.notebookName = notebookName;
        this.numberOfNotes = numberOfNotes;
        this.notes = new Note[this.numberOfNotes];
    }

}
