package com.example.helloworld.resources;


import co.paralleluniverse.fibers.SuspendExecution;
import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.core.Email;
import com.example.helloworld.core.MailChimpSubscribe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/subscribe-user")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {


    private final HttpClient httpClient;
    private final String api = "https://us9.api.mailchimp.com/2.0/lists/subscribe";


    public HelloWorldResource( HttpClient httpClient ) {

        this.httpClient = httpClient;

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/subscribe")
    @Timed
    public String reset( Email email )
            throws InterruptedException, SuspendExecution,IOException {

        String userEmail  = email.getEmail();

        //instantiate a JSON mapper to covert the object to the required JSON format
        ObjectMapper mapper = new ObjectMapper();

        //Add user's email to subscriber list on MailChimp
        MailChimpSubscribe subscribe = new MailChimpSubscribe();
        subscribe.setEmail( subscribe.new MailChimpEmail( email.getEmail() ));

        //convert to json so we can send to mailChimp API
        String mailChimpJson = mapper.writeValueAsString( subscribe );


        //create POST request with correct API address for mailChimp servers
        HttpPost postRequest = new HttpPost( api );


        //create the message entity that the post request requires
        StringEntity message = new StringEntity( mailChimpJson );
        message.setContentType( "application/json" );
        postRequest.setEntity( message) ;


        //HttpResponse response = httpClient.execute(postRequest);
        HttpEntity entity = httpClient.execute( postRequest ).getEntity();

        return EntityUtils.toString(entity, "UTF-8");

    }



}
