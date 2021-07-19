package S

import java.io.File
/*
*>>The loginUser() in Repo Class Violates Single Responsibility since it is making log in network call
*  and also handling Exceptions by logging it in a file - dual responsibility.
*
* >>The class/method should have only one reason to change.
*  Here login method and error handling two things could result in change.
*
* >>Solution: Create separate class for error handling/logging
* */
class Repository(private val auth: MyAuth) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signInWithEmailAndPassword(email, password)
        } catch(e:Exception) {
            val file = File("errors.txt")
            file.appendText(
                text = e.message.toString()
            )
        }
    }
}