package uk.co.mikebelringer.contact.server;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.mikebelringer.person.client.PersonServiceClient;
import uk.co.mikebelringer.person.types.Person;

public class PersonContactServerResource extends ServerResource {

    ObjectMapper objectMapper = new ObjectMapper();
    PersonServiceClient personServiceClient = new PersonServiceClient();

    @Get
    public Representation getPersonContact() throws JsonProcessingException {
        Person person = personServiceClient.getPerson();
        PersonContact personContact = new PersonContact(person, "12345678901");
        return new StringRepresentation(objectMapper.writeValueAsString(personContact));
    }
}
