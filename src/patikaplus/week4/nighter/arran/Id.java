package patikaplus.week4.nighter.arran;

import java.util.HashMap;
import java.util.Map;

public enum Id {
    VESSEL, ITEM, LOCATION;

    final int id;
    static Map<Id, Integer> assignReadyIds = new HashMap<>();

    Id() {
        this.id = initId(this);
        updateAssignReadyIds(this);
    }

    public int getValue() {
        return id;
    }

    private int initId(Id type) {
        return assignReadyIds.get(type);
    }

    private void updateAssignReadyIds(Id type) {
        assignReadyIds.put(type, (type.id + 1));
    }
}
