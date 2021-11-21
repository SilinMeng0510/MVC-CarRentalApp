package Model.car;

import java.time.LocalDate;

public class Time implements Comparable<Time>{
    private LocalDate fromDate;
    private LocalDate toDate;

    public Time(LocalDate fromDate, LocalDate toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public String ToString() {
        return fromDate.toString() + "to" + toDate.toString();
    }

    @Override
    public int compareTo(Time o) {
        if (fromDate.compareTo(o.fromDate) >= 0 && fromDate.compareTo(o.toDate) <= 0){
            return 0;
        }
        else if (toDate.compareTo(o.fromDate) >= 0 && toDate.compareTo(o.toDate) <= 0){
            return 0;
        }
        else if (o.fromDate.compareTo(fromDate) >= 0 && o.fromDate.compareTo(toDate) <= 0){
            return 0;
        }

        return fromDate.compareTo(o.fromDate);
    }
}