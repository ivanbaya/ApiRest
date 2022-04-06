import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("alumnes")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>


    @PATCH("alumnes/{user_id}")
    fun updateUser(@Path("user_id") user_id: String, @Body params: UserInfo): Call<UserResponse>

    @DELETE("alumnes/{user_id}")
    fun deleteUser(@Path("user_id") user_id: String): Call<UserResponse>

    @GET("cicles/{id}")
    fun getCicle(@Path("id") id: String): Call<CicleInfo>

    @GET("qualificacions/?nota=5&nota=6&nota=7&nota=8&nota=9&nota=10&modul=1")
    fun getNota(): Call<List<QualificacionsInfo>>
}