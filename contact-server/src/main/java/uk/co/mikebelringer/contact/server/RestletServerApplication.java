package uk.co.mikebelringer.contact.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class RestletServerApplication extends Application {

    public static void main(String[] args) throws Exception {
        Component c = new Component();
        c.getServers().add(Protocol.HTTP, 8181);
        c.getClients().add(Protocol.HTTP);
        c.getDefaultHost().attach(new RestletServerApplication());

        c.start();
    }

    @Override
    public Restlet createInboundRoot() {
        getMetadataService().setDefaultMediaType(MediaType.APPLICATION_ALL_JSON);

        Router router = new Router(getContext());
        router.attach("/contact", PersonContactServerResource.class);

        return router;
    }
}
