package notebook;

public class Note {
    private String record;

    public Note(String record)
    {
        this.record = record;
        //System.out.println("Constructor of Note");
    }

    public void set(String record)
    {
        this.record = record;
        //System.out.println("Setter of Note for string:" + record);
    }

    public String get()
    {
        //System.out.println("Getter of Note for string:" + this.record);
        return this.record;
    }
}
