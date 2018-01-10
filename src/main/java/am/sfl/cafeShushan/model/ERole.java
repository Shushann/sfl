package am.sfl.cafeShushan.model;

/**
 * Created by Shushi on 1/9/2018.
 */
public enum ERole {

    WAITER("WAITER"),
    MANAGER("MANAGER");

    String eRole;

    private ERole(String eRole) {
        this.eRole = eRole;
    }

    public String eRole() {
        return eRole;
    }
}
