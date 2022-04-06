import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    fun addUser(userData: UserInfo, onResult: (UserInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<UserInfo>, response: Response<UserInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun updateUser(user_id: String, user: UserInfo) {
        val retroInstance = ServiceBuilder.buildService(RestApi::class.java)
        val call = retroInstance.updateUser(user_id, user)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                print("Fail")
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    print("Bravo")
                } else {
                    print("Failx2")
                }
            }
        })
    }

    fun deleteUser(user_id: String?) {
        val retroInstance = ServiceBuilder.buildService(RestApi::class.java)
        val call = retroInstance.deleteUser(user_id!!)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                print("Fail")
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    print("Bravo")
                } else {
                    print("Failx2")
                }
            }
        })
    }

    fun getCicle(id: String?) {
        val retroInstance = ServiceBuilder.buildService(RestApi::class.java)
        val call = retroInstance.getCicle(id!!)
        call.enqueue(object : Callback<CicleInfo?> {
            override fun onFailure(call: Call<CicleInfo?>, t: Throwable) {
                print("Fail")
            }

            override fun onResponse(call: Call<CicleInfo?>, response: Response<CicleInfo?>) {
                if(response.isSuccessful) {
                    Log.d("Cicle", response.body().toString())
                } else {
                    print("Failx2")
                }
            }
        })
    }
    fun getNota() {
        val retroInstance = ServiceBuilder.buildService(RestApi::class.java)
        val call = retroInstance.getNota()
        call.enqueue(object : Callback<List<QualificacionsInfo>> {
            override fun onFailure(call: Call<List<QualificacionsInfo>>, t: Throwable) {
                Log.d("fail", "fallo0")
            }

            override fun onResponse(call: Call<List<QualificacionsInfo>>, response: Response<List<QualificacionsInfo>>) {
                if(response.isSuccessful) {
                    Log.d("Alumnes aprovats:", response.body()?.size.toString())
                } else {
                    Log.d("fail", "fallo1")
                }
            }
        })
    }
}