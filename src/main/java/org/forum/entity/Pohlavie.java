package org.forum.entity;

public enum Pohlavie {
    MUZ(0),
    ZENA(1);

    private static String[] muzskeSymboly = {"m", "muz"};
    private static String[] zenskeSymboly = {"z", "zena"};

    Pohlavie(int index) {
    }

    Pohlavie(String value) {
        parse(value);
    }
    public static Pohlavie parse(String value) {
        value = value.trim();
        for (String m : muzskeSymboly) {
            if (m.equalsIgnoreCase(value)) {
                return MUZ;
            }
        }

        for (String f : zenskeSymboly) {
            if (f.equalsIgnoreCase(value)) {
                return ZENA;
            }
        }
        //throw new ForumException(ForumException.ErrorCode.INVALID_GENDER);
        return null;
    }
}
