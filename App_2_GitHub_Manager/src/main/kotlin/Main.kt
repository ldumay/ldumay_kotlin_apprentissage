import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv

var dotenv: Dotenv? = null

var TOKEN_GITHUB_PUBLIC_REPO: String? = null

fun main() {
    println("GitHub Manager")

    // Load .env file
    loadDotenvConfiguration()

    /**
     * Créé un système de connexion et de lecture des dépôts personnels github.
     * Sources :
     * - https://docs.github.com/fr/rest/quickstart
     * - https://docs.github.com/fr/rest/quickstart?apiVersion=2022-11-28
     * - https://docs.github.com/fr/rest/repos/repos?apiVersion=2022-11-28
     */

    //Récupération de la variable d'environnement TOKEN_GITHUB_PUBLIC_REPO
    TOKEN_GITHUB_PUBLIC_REPO = dotenv?.get("GITHUB_PUBLIC_REPO")
    //Vérification de la présence du token Github dans le fichier .env
    if(TOKEN_GITHUB_PUBLIC_REPO == null || TOKEN_GITHUB_PUBLIC_REPO == "" || TOKEN_GITHUB_PUBLIC_REPO == "token") {
        println("Le token GitHub \"GITHUB_PUBLIC_REPO\" est incorrect ou n'existe pas.")
    } else {
        println("Le token GitHub \"GITHUB_PUBLIC_REPO\" est présent.")
    }
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