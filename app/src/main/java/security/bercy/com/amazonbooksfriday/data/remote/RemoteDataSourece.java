package security.bercy.com.amazonbooksfriday.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bercy on 1/5/18.
 */

public class RemoteDataSourece {
    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com/books.json";

    public static Retrofit Create() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


        return retrofit;
    }

}
