package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Route extends Model {
    @Id
    private int route_ID;
    private String route_code;
    private String airport;
    private String destination;
    private double cost;

    @OneToMany
    private List<FlightSchedule> flight_schedule;

    public Route(){
    }

    public Route(int id, String code, String airport, String destination, double cost, List<FlightSchedule> flight_schedule){
        this.route_ID = id;
        this.route_code = code;
        this.airport = airport;
        this.destination = destination;
        this.cost = cost;
        this.flight_schedule = flight_schedule;
    }

    public static Finder<Integer, Route> find = new Finder<Integer, Route>(Route.class);
    
    public static List<Route> findAll(){
        return Route.find.all();
    }

    //get and set route id
    public int getRouteID(){
        return route_ID;
    }

    public void setRouteID(int id){
        this.route_ID = id;
    }

    //get and set route code
    public String getRouteCode(){
        return route_code;
    }

    public void setRouteCode(String code){
        this.route_code = code;
    }

    //get and set airport
    public String getAirport(){
        return airport;
    }

    public void setAirport(String airport){
        this.airport = airport;
    }

    //Get and set destination
    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    //Get and set cost
    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    //get and set flight_schedule
    public List<FlightSchedule> getFlightSchedule(){
        return flight_schedule;
    }

    public void setFlightSchedule(List<FlightSchedule> flight_schedule){
        this.flight_schedule = flight_schedule;
    }

}