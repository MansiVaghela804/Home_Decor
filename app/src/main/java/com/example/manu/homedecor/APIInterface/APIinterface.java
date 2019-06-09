package com.example.manu.homedecor.APIInterface;

import com.example.manu.homedecor.Api_response.Registration;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIinterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL_LOGIN(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("registration.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL_REGISTER(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("contact_no") String contact_no,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password);

    @FormUrlEncoded
    @POST("contact_us.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL_CONTACT_US(
            @Field("description") String description);


    @FormUrlEncoded
    @POST("rating_feedback.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL_RATING_FEEDBACK(
            @Field("name") String name,
            @Field("email") String email,
            @Field("contact_no") String contact_no,
            @Field("message") String message);

//    @FormUrlEncoded
//    @POST("common_model.php")
//    Call<CategoryResponse> GET_BRAND_RESPONSE_CALL_COMMON_CATEGORIES(
//            @Field("getUsers") String getUsers);
//
//    @FormUrlEncoded
//    @POST("sub_common_model.php")
//    Call<SubCategoryResponse> GET_BRAND_RESPONSE_CALL_SUB_COMMON_CATEGORIES(
//            @Field("category_id") String category_id,
//            @Field("getUsers") String getUsers);
}
