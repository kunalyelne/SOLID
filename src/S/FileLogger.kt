package S

import java.io.File

class FileLogger {
    fun logErrorInFile(message: String) {
        val file = File("errors.txt")
        file.appendText(
            text = message
        )
    }
}