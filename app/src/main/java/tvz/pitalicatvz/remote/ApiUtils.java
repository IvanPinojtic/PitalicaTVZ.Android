package tvz.pitalicatvz.remote;

/**
 * Created by Ivan on 2/3/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    //public static final String BASE_URL = "http://94.253.242.123:80/";//global
    public static final String BASE_URL = "http://192.168.5.189/";//local

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}