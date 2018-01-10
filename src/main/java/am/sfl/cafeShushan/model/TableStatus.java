package am.sfl.cafeShushan.model;

/**
 * Created by Shushi on 1/9/2018.
 */
public enum TableStatus {
    AVAILABLE("AVAILABLE"),
    BUSY("BUSY");

    String tableStatus;

    private TableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String tableStatus() {
        return tableStatus;
    }
}
