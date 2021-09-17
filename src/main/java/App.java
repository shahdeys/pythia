import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import routes.HelloWorld;

public final class App {

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(App::init, "pythia", args);
    }

    static void init(Environment environment) {
        environment.routingEngine().registerAutoRoutes(new HelloWorld());

    }
}