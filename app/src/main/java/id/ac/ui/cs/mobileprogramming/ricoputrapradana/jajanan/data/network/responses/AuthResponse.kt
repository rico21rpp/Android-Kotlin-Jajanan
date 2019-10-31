package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network.responses

import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User

/**
 * A class for parsing JSON response to this kotlin class
 */
data class AuthResponse (
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)