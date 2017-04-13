package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Flight extends Model {
    @Id
    private int flightID;

    @Constraints.Required
    private String flightDate;

    @Constraints.Required
    private String depTime;

    @Constraints.Required
    private String arrTime;

    @Constraints.Required
    private int aircraftID;

    @Constraints.Required
    private int routeID;

    public Flight() {
    }

    public Flight(int flightID, String flightDate, String depTime, String arrTime,
    int aircraftID, int routeID) {
        this.flightID = flightID;
        this.flightDate = flightDate;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.aircraftID = aircraftID;
        this.routeID = routeID;
    }

    public static Finder<Integer,Flight> find = new Finder<Integer,Flight>(Flight.class);

    public static List<Flight> findAll() {
	return Flight.find.all();
    }

    //Getter Methods
    public int getID(){
        return flightID;
    }

    public String getDate(){
        return flightDate;
    }

    public String getDepTime(){
        return depTime;
    }

    public String getArrTime(){
        return arrTime;
    }

    public int getAircraftID(){
        return aircraftID;
    }

    public int getRouteID(){
        return routeID;
    }

    //Setter Methods
    public void setID(int flightID){
        this.flightID = flightID;
    }

    public void setDate(String flightDate){
        this.flightDate = flightDate;
    }

    public void setDepTime(String depTime){
        this.depTime = depTime;
    }

    public void setArrTime(String arrTime){
        this.arrTime = arrTime;
    }

    public void setAircraftID(int aircraftID){
        this.aircraftID = aircraftID;
    }
    public void setRouteID(int routeID){
        this.routeID = routeID;
    }

}
