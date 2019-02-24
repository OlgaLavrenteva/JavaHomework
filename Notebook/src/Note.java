package notebook;

public class Note {
    private String record;

    /**
     * Note class constructor
     */

    public Note(String record) {
        this.record = record;
    }

    /**
     * Setter of record
     */

    public void setRecord(String record) {
        this.record = record;
    }

    /**
     * Getter of record
     */

    public String getRecord() {
        return record;
    }
}
