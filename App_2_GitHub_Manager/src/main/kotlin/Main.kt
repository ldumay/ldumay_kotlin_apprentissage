import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv

var dotenv: Dotenv? = null

fun main() {
    println("Hello World!")

    loadDotenvConfiguration()

    var foo = dotenv?.get("FOO")
    println("FOO = ${foo}")
}

/**
 * Load the dotenv configuration from a .env file and add all found value into
 * the {@link java.lang.System System} Property
 */
fun loadDotenvConfiguration() {
    // Lecture de la configuration de l'application
    //Dotenv dotenv = Dotenv.configure().systemProperties().directory("./").filename(".env").ignoreIfMalformed().ignoreIfMissing().load();
    //dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

    dotenv = dotenv {
        directory = "./"
        filename = ".env" // instead of '.env', use 'env'
    }
}