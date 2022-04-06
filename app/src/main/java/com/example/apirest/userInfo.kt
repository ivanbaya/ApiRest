import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("id") val id: String?,
    @SerializedName("nom") val nom: String?,
)
data class CicleInfo (
    @SerializedName("id") val id: String?,
    @SerializedName("nom") val nom: String?,
    @SerializedName("nivell") val nivell: String?,
)
data class QualificacionsInfo (
    @SerializedName("id") val id: String?,
    @SerializedName("modul") val modul: String?,
    @SerializedName("alumne") val alumne: String?,
    @SerializedName("nota") val nota: String?,
)
data class UserResponse(val code: Int?, val meta: String?, val data: UserInfo?)