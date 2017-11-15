package be.dbo.antlr.main;

/**
 * Created by diederikbosmans on 14/11/17.
 */
public class Flow {

    private String departure;
    private String arrival;
    private String time;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flow flow = (Flow) o;

        if (departure != null ? !departure.equals(flow.departure) : flow.departure != null) return false;
        if (arrival != null ? !arrival.equals(flow.arrival) : flow.arrival != null) return false;
        return time != null ? time.equals(flow.time) : flow.time == null;
    }

    @Override
    public int hashCode() {
        int result = departure != null ? departure.hashCode() : 0;
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
