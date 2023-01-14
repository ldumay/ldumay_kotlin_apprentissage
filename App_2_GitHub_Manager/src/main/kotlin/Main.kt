import com.google.gson.Gson
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import java.net.HttpURLConnection
import java.net.URL

var dotenv: Dotenv? = null

var GITHUB_PUBLIC_USER: String? = null
var GITHUB_PUBLIC_REPO_TOKEN: String? = null

var github_uri_api_path  = "https://api.github.com"
var github_uri_api_path_users = "/users"
var github_uri_api_path_repos = "/repos"

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

    //Récupération de la variable d'environnement GITHUB_PUBLIC_USER
    GITHUB_PUBLIC_USER = dotenv?.get("GITHUB_PUBLIC_USER")
    //Vérification de la variable d'environnement GITHUB_PUBLIC_USER
    if(GITHUB_PUBLIC_USER == null || GITHUB_PUBLIC_USER == "" || GITHUB_PUBLIC_USER == "user") {
        println("L'utilisateur GitHub \"GITHUB_PUBLIC_USER\" est incorrect ou n'existe pas.")
    } else {
        println("L'utilisateur GitHub \"GITHUB_PUBLIC_USER\" est présent.")
    }

    //Préparation de l'url de l'api github
    var github_uri_api_path_users_repos = github_uri_api_path + github_uri_api_path_users + "/" + GITHUB_PUBLIC_USER + github_uri_api_path_repos
    println("L'URL de l'API GitHub de l'utilisateur " + GITHUB_PUBLIC_USER + " est : " + github_uri_api_path_users_repos)

    //Récupération des données de l'api github via l'url préparée précédemment de l'utilisateur GITHUB_PUBLIC_USER
    var datas = getDatasToGitHubAPI(github_uri_api_path_users_repos)

    //Récupération de la variable d'environnement GITHUB_PUBLIC_REPO_TOKEN
    GITHUB_PUBLIC_REPO_TOKEN = dotenv?.get("GITHUB_PUBLIC_REPO_TOKEN")
    //Vérification de la variable d'environnement GITHUB_PUBLIC_REPO_TOKEN
    if(GITHUB_PUBLIC_REPO_TOKEN == null || GITHUB_PUBLIC_REPO_TOKEN == "" || GITHUB_PUBLIC_REPO_TOKEN == "token") {
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

fun getDatasToGitHubAPI(url: String): Any? {
    //Connexion à l'API GitHub via l'URL de l'API GitHub de l'utilisateur
    val url = URL(url)
    val con = url.openConnection() as HttpURLConnection
    con.requestMethod = "GET"

    //Récupération du code de retour de l'API GitHub
    val responseCode = con.responseCode
    println("Le code de retour de l'API GitHub est : " + responseCode)

    //Récupération des données de l'API GitHub
    val `in` = con.inputStream
    val input = `in`.bufferedReader().use { it.readText() }

    val gson = Gson()
    val arrayTutorialType = object : TypeToken<Array<Repo>>() {}.type
    var tutorials: Array<Repo> = gson.fromJson(jsonList, arrayTutorialType)
    var datas = JSONObject(input)

    if(responseCode == 200 && datas != null) {
        println("Les données de l'API GitHub sont disponibles.")

        //Affichage des données de l'API GitHub
        println("""
            Données obtenues :
            - type : ${datas::class.simpleName}
            - taille : ${datas.length}
            - contenu : \n${datas}
        """.trimIndent())
    } else {
        println("Les données de l'API GitHub ne sont pas disponibles.")
    }

    //Fermeture de la connexion à l'API GitHub
    con.disconnect()

    //Retour des données de l'API GitHub
    return datas
}