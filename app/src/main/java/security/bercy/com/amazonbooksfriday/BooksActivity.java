package security.bercy.com.amazonbooksfriday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import security.bercy.com.amazonbooksfriday.data.remote.RemoteDataSourece;
import security.bercy.com.amazonbooksfriday.model.Book;

public class BooksActivity extends AppCompatActivity {

    private static final String TAG = BooksActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);


        Call<List<Book>> bookCall =  RemoteDataSourece.getBooks();


        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> listBooks = response.body();
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                LinearLayoutManager layoutManager = new LinearLayoutManager(BooksActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(BooksActivity.this,DividerItemDecoration.VERTICAL));
                BookAdapter adapter= new BookAdapter(listBooks);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }


}
