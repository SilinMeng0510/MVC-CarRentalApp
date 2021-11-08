package Model.car;

import java.time.LocalDate;

public class Time {
    private LocalDate fromDate;
    private LocalDate toDate;

    public Time(LocalDate fromDate, LocalDate toDate) {
        fromDate=this.fromDate;
        toDate=this.toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public String ToString() {
        return null;
    }
}