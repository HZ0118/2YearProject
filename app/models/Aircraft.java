package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Aircraft extends Model {
    @Id
    private int aircraft_ID;
    private String aircraft_number;
    private int capacity;

    @OneToMany
    private List<FlightSchedule> flight_schedule;

    public Aircraft (){
    }

    public Aircraft(int id, String number, int capacity, List<FlightSchedule> flight_schedule){
        this.aircraft_ID = id;
        this.aircraft_number = number;
        this.capacity = capacity;
        this.flight_schedule = flight_schedule;
    }

    public static Finder<Integer,Aircraft> find = new Finder<Integer,Aircraft>(Aircraft.class);

    public static List<Aircraft> findAll(){
        return Aircraft.find.all();
    }
    
    public int getAircraftID(){
        return aircraft_ID;
    }

    public String getAircraftNumber(){
        return aircraft_number;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setAircraftID(int id){
        this.aircraft_ID = id;
    }

    public void setAircraftNumber(String number){
        this.aircraft_number = number;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    //get and set flight_schedule
    public List<FlightSchedule> getFlightSchedule(){
        return flight_schedule;
    }

    public void setFlightSchedule(List<FlightSchedule> flight_schedule){
        this.flight_schedule = flight_schedule;
    }

}