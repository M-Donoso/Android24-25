package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.lstMov.data.DataMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    public static final String URL ="http://192.168.43.180:8080/untitled_war_exploded/";
      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })

      Call<MyData> getDataUser(@Query("ACTION") String action);
      /*@GET("MyServlet")
        Call<MyData> getDataUser(@Query("ACTION") String action,
                                 @Query("EMAIL") String email,
                                 @Query("PASSWORD") String pass);
*/
/*      @GET("MyServlet")
        Call<ArrayList<Movie>> getMovies(@Query("genre") String genre,
                                    @Query("year") Integer year,
                                    @Query("director") String director);
      }*/

        @GET("MyServlet")
        Call<DataMovies> getDataMovies(@Query("ACTION") String action);

        @GET("MyServlet")
        Call<DataMovies> getDataMovies2(@Query("ACTION") String action);

        /*
        @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);

        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);*/

        /*
        @FormUrlEncoded
        @POST("/login")
        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
    */
}
