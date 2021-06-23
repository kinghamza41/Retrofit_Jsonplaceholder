package com.example.retrofit_codinginflow_fakeapicomplete;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {
    //    @GET("posts")
//    Call<List<Post>> getPosts(@Query("userId") int userId,
//                              @Query("_sort") String sort,
//                              @Query("_order") String order
//    );
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int PostId);

    @GET
    Call<List<Comment>> getComments(@Url String url);


    @POST("posts")
    Call<Post> createPost(@Body Post post);

//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost(@Field("userId") int userId,
//                          @Field("title") String title,
//                          @Field("body") String text
//    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> field);

    @Headers({"Static-Header: 123", "Static-Header2: 456"})
    @PUT("posts/{id}")
    Call<Post> putPost(@Header("Dynamic-Header") String header,
                       @Path("id") int id,
                       @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@HeaderMap Map<String, String> header,
                         @Path("id") int id,
                         @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> delPost1(@Path("id") int id);
}
