package hu.bm.mobsoft.lab.costlog.mock.interceptors;

import android.net.Uri;

import hu.bm.mobsoft.lab.costlog.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bm.mobsoft.lab.costlog.mock.interceptors.MockHelper.makeResponse;

public class LoginMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "item")) {
            switch (request.method()) {
                case "POST":
                    responseString = "";
                    responseCode = 200;
                    break;
                case "PUT":
                    responseString = "";
                    responseCode = 200;
                    break;
                case "DELETE":
                    responseString = "";
                    responseCode = 200;
                    break;
                case "GET":
                    responseString = "";
                    responseCode = 200;
                    break;
                default:
                    responseString = "ERROR";
                    responseCode = 503;
                    break;

            }
        }else{
            responseString = "ERROR";
            responseCode = 503;
        }
        return makeResponse(request, headers, responseCode, responseString);
    }
}
