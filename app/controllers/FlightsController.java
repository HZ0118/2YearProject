package controllers;

import controllers.*;
import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

import models.*;
import models.users.User;

public class FlightsController extends Controller {
    private FormFactory FormFactory;

    @Inject
    public FlightsController(FormFactory f){
        this.FormFactory = f;
    }

    public Result flights() {
        List<FlightSchedule> flightsList = FlightSchedule.findAll();
        return ok(list.render(flightsList, User.getUserById(session().get("email"))));
    }

    public Result addFlight(){
        Form<FlightSchedule> addFlightForm = FormFactory.form(FlightSchedule.class);
        return ok(addFlight.render(addFlightForm, User.getUserById(session().get("email"))));
    }

    @Transactional
    public Result addFlightSubmit(){
        Form<FlightSchedule> newFlightForm = FormFactory.form(FlightSchedule.class).bindFromRequest();
        if(newFlightForm.hasErrors()){
            return badRequest(addFlight.render(newFlightForm, User.getUserById(session().get("email"))));
        }
        FlightSchedule newFlight = newFlightForm.get();
            newFlight.save();
        flash("success", "Flight " + newFlight.getFlightID() + " has been created/ updated");
        return redirect(controllers.routes.FlightsController.flights());
    }

    @Transactional
    public Result deleteFlight(int id){
        FlightSchedule.find.ref(id).delete();
        flash("success", "Flight has been deleted");
        return redirect(routes.FlightsController.flights());
    }

    @Transactional
    public Result updateFlight(int id) {
        FlightSchedule f;
        Form<FlightSchedule> flightForm;
        try{
            f = FlightSchedule.find.byId(id);
            flightForm = FormFactory.form(FlightSchedule.class).fill(f);
        } catch (Exception ex) {
            return badRequest("error");
        }
        return ok(addFlight.render(flightForm, User.getUserById(session().get("email"))));
    }

}