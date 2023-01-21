import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    private int day_of_week;
    private int dep_time;
    private int dep_delay;
    private int arr_time;
    private int arr_delay;
    private int cancelled;
    private int diverted;
    private int air_time;
    private int distance;

    public void setAttr(int day_of_week,
                  int dep_time,
                  int dep_delay,
                  int arr_time,
                  int arr_delay,
                  int cancelled,
                  int diverted,
                  int air_time,
                  int distance) {
        this.day_of_week = day_of_week;
        this.dep_time = dep_time;
        this.dep_delay = dep_delay;
        this.arr_time = arr_time;
        this.arr_delay = arr_delay;
        this.cancelled = cancelled;
        this.diverted = diverted;
        this.air_time = air_time;
        this.distance = distance;
    }

    public String toString() {
        return "Flight [ day_of_week: " + this.day_of_week +
                ", dep_time: " + this.dep_time +
                ", dep_delay: " + this.dep_delay +
                ", arr_time: " + this.arr_time +
                ", arr_delay: " + this.arr_delay +
                ", cancelled: " + this.cancelled +
                ", diverted: " + this.diverted +
                ", air_time: " + this.air_time +
                ", distance: " + this.distance +
                " ]";
    }

}
