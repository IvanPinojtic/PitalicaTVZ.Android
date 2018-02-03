package tvz.pitalicatvz.remote;

/**
 * Created by Ivan on 2/3/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://localhost:44344/";
    //public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}