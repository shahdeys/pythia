package routes;

import com.spotify.apollo.route.AsyncHandler;
import com.spotify.apollo.route.Route;
import com.spotify.apollo.route.RouteProvider;

import java.util.stream.Stream;

public class HelloWorld implements RouteProvider {
        @Override
        public Stream<? extends Route<? extends AsyncHandler<?>>> routes() {
                return Stream.of(
                        Route.sync("GET", "/hello", ctx -> "hello, world")
                );
        }
}
