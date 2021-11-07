package Model.process;

import java.util.ArrayList;

public class History {
    private String report;
    private static ArrayList<History> list;

    public History(String report, String data) {

    }

    public static ArrayList<History> getList() {
        return list;
    }

    public String getReport() {
        return report;
    }
}