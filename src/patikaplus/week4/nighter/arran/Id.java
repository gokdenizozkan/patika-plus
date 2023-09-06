package patikaplus.week4.nighter.arran;

public class Id {
    private final int id;
    private static int[] assignReadyIds;
    private final Type type;

    public enum Type {
        VESSEL, ITEM, LOCATION
    }

    static {
        assignReadyIds = new int[Type.values().length];
        for (int i = 0; i < assignReadyIds.length; i++) {
            assignReadyIds[i] = 1;
        }
    }

    public Id(Type type) {
        this.type = type;
        this.id = initId(type);
        updateAssignReadyIds(type);
    }

    public int getValue() {
        return id;
    }

    private int initId(Type type) {
        return assignReadyIds[type.ordinal()];
    }

    private void updateAssignReadyIds(Type type) {
        assignReadyIds[type.ordinal()]++;
    }
}
