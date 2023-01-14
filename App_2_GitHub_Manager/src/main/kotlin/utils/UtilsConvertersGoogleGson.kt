package utils

import com.google.gson.Gson

class UtilsConvertersGoogleGson {

    /**
     * Convert a string to a JSON object
     * Moteur - Gson by Google : https://github.com/google/gson/blob/master/UserGuide.md
     * @param string The string to convert
     * @return The JSON object
     */
    companion object {
        @JvmStatic
        fun stringToJSON(text: String): Any? {
            var datas: Any? = null
            try {
                // Serialization
                val gson = Gson()
                datas = gson.toJson(text)
            } catch (e: Exception) {
                println("Erreur lors de la conversion de la chaîne de caractères en JSON : " + e.message)
            }
            return datas
        }

        /**
         * Convert a JSON object to a string
         * Moteur - Gson by Google : https://github.com/google/gson/blob/master/UserGuide.md
         * @param json The JSON object to convert
         * @return The string
         */
        @JvmStatic
        fun JSONToString(json: Any?): String? {
            var datas: String? = null
            try {
                // Serialization
                val gson = Gson()
                datas = gson.fromJson("[" + json + "]", Array<String>::class.java).toString()
            } catch (e: Exception) {
                println("Erreur lors de la conversion du JSON en chaîne de caractères : " + e.message)
            }
            return datas
        }
    }
}