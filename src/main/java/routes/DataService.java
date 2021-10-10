package routes;

import com.spotify.apollo.Environment;
import com.spotify.apollo.Response;
import com.spotify.apollo.route.AsyncHandler;
import com.spotify.apollo.route.Route;
import com.spotify.apollo.route.RouteProvider;

import java.util.stream.Stream;

public class DataService {

    public static void init(Environment environment) {

        RouteProvider addressResource = new AddressResource();
        environment.routingEngine().registerAutoRoutes(addressResource);
    }

    private static class AddressResource implements RouteProvider {

        @Override
        public Stream<? extends Route<? extends AsyncHandler<?>>> routes() {
            return Stream.of(
                    Route.sync("GET", "/v1/address/<name>", requestContext ->
                            getAddress(requestContext.pathArgs().get("name"))),

                    Route.sync("PUT", "/v1/address/<name>", requestContext ->
                            putAddress(requestContext.pathArgs().get("name")))
            );
        }

        private Response putAddress(String name) {
            if (name.equals("shah")) {
                return Response.forPayload(name)
                        .withPayload("Nice work")
                        .withHeader("X-Payload-Length", String.valueOf(name.length()));
            }
            return Response.forPayload(name);
        }


        private String getAddress(String name) {
            if (name.equals("shah"))
                return "Lives at google.com";
            return "200 OK";
        }

    }
}
