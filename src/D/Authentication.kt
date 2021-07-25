package D

import S.FileLogger
import S.MyAuth

/*
*>>The Repository class is dependent on concretion not on abstraction, which violates the
*  Dependency inversion principle.
*>>In future if we want to authenticate via some third party api then we will have to modify
*  the repository class since it is tightly coupled.
*
*>>For Mock Testing we might want our testing authentication for that too will have to modify the class
*
* >>Solution: Dependency Inversion i.e. make it dependent on abstraction rather on concretion
*
* >>Loosely Coupled
*
*

class Authentication(private val repository: Repository) {
    suspend fun authenticate() {
        repository.loginUser("xyz@gmail.com","****")
    }
}

class Repository(private val auth: MyAuth, private val fileLogger: FileLogger) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signInWithEmailAndPassword(email, password)
        } catch(e:Exception) {
            fileLogger.logErrorInFile(e.message.toString())
        }
    }
}
*
*/

//Here we provide abstraction through interface IAuthenticate..
//Any concrete class which will be authenticating must implement the IAuthenticate
//This will help us achieve loose coupling and will help in flexibility
interface IAuthenticate {
    suspend fun signInWithEmailAndPassword(email: String, password: String)
}

class MyAuth: IAuthenticate {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        //MyNetworkCall
    }
}

class FirebaseAuth: IAuthenticate {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        //FireBase Handling The Authentication
    }
}

class FaceBookAuth: IAuthenticate {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        //Facebook Handling The Authentication
    }
}

class Authentication(private val repository: Repository) {
    suspend fun authenticate() {
        repository.loginUser("xyz@gmail.com","****")
    }
}

class Repository(private val auth: IAuthenticate, private val fileLogger: FileLogger) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signInWithEmailAndPassword(email, password)
        } catch(e:Exception) {
            fileLogger.logErrorInFile(e.message.toString())
        }
    }
}