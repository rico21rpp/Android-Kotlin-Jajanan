package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network

import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

/**
 * An abstract class for handling errors when call any API request.
 * Here will be network operation, so we use "suspend" as
 * the asynchronous task mechanism with Coroutines
 */
abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        }
        else {
            val message = StringBuilder()
            val error = response.errorBody()?.string()

            // error? means if error variable is not null
            error?.let {
                try {
                    // Get the "message" string value of Json got from error and append it to the message variable
                    message.append(JSONObject(it).getString("message"))
                }
                catch (e: JSONException) {}
                message.append("\n")
            }
            message.append("Error Code: ${response.code()}")

            throw ApiException(message.toString())
        }
    }
}