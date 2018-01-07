package security.bercy.com.amazonbooksfriday.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.GET;
import security.bercy.com.amazonbooksfriday.model.Book;

/**
 * Created by Bercy on 1/5/18.
 */

public class RemoteDataSourece {
    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com";

    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


        return retrofit;
    }
    public static Call<List<Book>> getBooks() {
        Retrofit retrofit = create();
        RemoteService remoteService =retrofit.create(RemoteService.class);
        return remoteService.getBook();
    }

    public interface RemoteService{

        @GET("books.json")
        Call<List<Book>> getBook();
    }



}
