import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import routes.DataService;

public final class App {

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(DataService::init, "DataService", args);
    }
}