package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errorhandling.CityNotFoundException;
import facades.Facade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cityinfo")
public class CityInfoResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Facade FACADE = Facade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllCityInfos() throws CityNotFoundException
    {
        return Response
                .ok()
                .entity(GSON.toJson(FACADE.getAllCityInfos()))
                .build();
    }
}