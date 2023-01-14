import java.util.*

var scanner = Scanner(System.`in`)

fun main(args: Array<String>) {

    println("---------------------------------------------")
    println("Bienvenuedans l'app 1")
    println("---------------------------------------------")
    println("1. Lancer le menu USSD")
    println("2. Lancer le converstisseur de monnaie")
    println("Entrez votre choix :")

    var choixApp = scanner.nextInt()

    when(choixApp){
        1 -> afficherMenuUSSD()
        2 -> afficherConvertisseurMonnaie()
        else -> println("Choix invalide")
    }

    /*
    println("Program arguments: ${args.joinToString()}")
    */
}

fun afficherMenuUSSD(){
    println("-------- Bienvenue dans le menu USSD --------")
    println(" ")

    println("Entrez votre code :")
    var codeUSSD = scanner.nextLine()
    println("Le code saisi est $codeUSSD")
    println(" ")

    if (codeUSSD == "*200#") {
        println("Bienvenue dans votre menu de services MTN")
        println("---------------------------------------------")
        println("1. SERVICES")
        println("2. ABONNEMENTS")
        println("3. PLAN TARIFAIRES")
        println("4. VOTRE COMPTE")
        println("5. AIDE")
        println("Entrez votre choix :")
        println(" ")

        var choix = scanner.nextInt()
        println("Le choix saisi est $choix")
        println("SERVICES")
        println("---------------------------------------------")
        println("1. MTN Me2U")
        println("2. MTN Libota")
        println("3. MTN Call me")
        println("4. MTN Pay 4 Me")
        println("5. MTN Mobile Money")
        println("6. MTN Xtra Time")
        println("7. MTN Play")
        println("8. MTN KDO")
        println("# Suivant")
        println("Entrez votre choix :")
        println(" ")

        when(choix){
            1 -> {
                println("Vous avez choisi le menu SERVICES")
                println(" ")
                afficherContentMenuUSSDServices()
            }
            2 -> {
                println("Vous avez choisi le menu ABONNEMENTS")
                println(" ")
                afficherContentMenuUSSDAbonnements()
            }
            3 -> {
                println("Vous avez choisi le menu PLAN TARIFAIRES")
                println(" ")
                afficherContentMenuUSSDPlanTarifaires()
            }
            4 -> {
                println("Vous avez choisi le menu VOTRE COMPTE")
                println(" ")
                afficherContentMenuUSSDCompte()
            }
            5 -> {
                println("Vous avez choisi le menu AIDE")
                println(" ")
                afficherContentMenuUSSDAide()
            }
            else -> println("Choix invalide")
        }

    } else {
        println("Code USSD incorrect")
    }
}

fun afficherContentMenuUSSDServices() {
    println("SERVICES")
    println("---------------------------------------------")
    println("1. MTN Me2U")
    println("2. MTN Libota")
    println("3. MTN Call me")
    println("4. MTN Pay 4 Me")
    println("5. MTN Mobile Money")
    println("6. MTN Xtra Time")
    println("7. MTN Play")
    println("8. MTN KDO")
    println("# Suivant")
    println("Entrez votre choix :")
    println(" ")
}

fun afficherContentMenuUSSDAbonnements() {
    println("ABONNEMENTS")
    println("---------------------------------------------")
    println("1. Forfait international")
    println("2. MTN FLOW")
    println("3. MTN ZIK")
    println("4. MTN SMS")
    println("5. MTN MAXINET")
    println("6. PORTAIL RELIGIEUX INFOS")
    println("# Suivant")
    println("Entrez votre choix :")
    println(" ")
}

fun afficherContentMenuUSSDPlanTarifaires() {
    println("PLAN TARIFAIRES")
    println("---------------------------------------------")
    println("1. MTN Zone")
    println("2. MTN Free")
    println("3. MTN Boss")
    println("Entrez votre choix :")
    println(" ")
}

fun afficherContentMenuUSSDCompte() {
    println("VOTRE COMPTE")
    println("---------------------------------------------")
    println("1. Solde compte")
    println("2. Recharge du compte")
    println("3. Bonus Voix")
    println("4. Bonus SMS")
    println("5. Bonus MMS/GPRS")
    println("6. MTN Rewards")
    println("7. Cumul Conso")
    println("# Suivant")
    println("Entrez votre choix :")
    println(" ")
}

fun afficherContentMenuUSSDAide() {
    println("AIDE")
    println("---------------------------------------------")
    println("1. Changer de langue")
    println("2. Localités ouvertes")
    println("3. Code PUK")
    println("4. Infos Roaming")
    println("5. Point Mobile Money")
    println("6. Partenaires MTN PRESTIGE")
    println("# Suivant")
    println("Entrez votre choix :")
    println(" ")
}

fun afficherConvertisseurMonnaie() {
    println("-------- Bienvenue dans le convertisseur de monnaie --------")
    println(" ")

    var repeat = false

    var list_menu = listOf(
        "1. USD ($) vers EUR (€)",
        "2. EUR (€) vers USD ($)",
        "3. USD ($) vers XAF (FCFA)",
        "4. XAF (FCFA) vers USD ($)",
        "5. EUR (€) vers XAF (FCFA)",
        "6. XAF (FCFA) vers EUR (€)"
    )

    var taux_echanges = mapOf<Int, Double>(
        1 to 0.84,
        2 to 1.19,
        3 to 550.0,
        4 to 0.0018,
        5 to 655.0,
        6 to 0.0015
    )

    do{
        println("Entrez le montant à convertir :")
        var montant = scanner.nextDouble()

        println("Le montant saisi est $montant")
        println(" ")

        for(menu in list_menu){
            println(menu)
        }
        println("Entrez votre choix :")

        var choix = scanner.nextInt()
        println("Le choix saisi est $choix")

        if(choix == null || choix == 0){
            println("Choix invalide")
            return
        }

        var option = list_menu.get(choix.minus(1))
        //var option = list_menu.get(choix - 1) --> autre manière de faire

        var tb_caracteres = option.split(" ")
        var devise_debut = tb_caracteres.get(1) + " " + tb_caracteres.get(2)
        var devise_fin = tb_caracteres.get(4) + " " + tb_caracteres.get(4)

        println("Devise début : $devise_debut, Devise fin : $devise_fin")

        when(choix){
            1 -> {
                println("Vous avez choisi de convertir USD ($) vers EUR (€)")
                var taux_echange = 0.85
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant USD ($) vers EUR (€)
                $montant USD ($) = $montant_converti EUR (€)
                ---------------------------------------------
            """.trimIndent())
            }
            2 -> {
                println("Vous avez choisi de convertir EUR (€) vers USD ($)")
                var taux_echange = 1.18
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant EUR (€) vers USD ($)
                $montant EUR (€) = $montant_converti USD ($)
                ---------------------------------------------
            """.trimIndent())
            }
            3 -> {
                println("Vous avez choisi de convertir USD ($) vers XAF (FCFA)")
                var taux_echange = 550.0
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant USD ($) vers XAF (FCFA)
                $montant USD ($) = $montant_converti XAF (FCFA)
                ---------------------------------------------
            """.trimIndent())
            }
            4 -> {
                println("Vous avez choisi de convertir XAF (FCFA) vers USD ($)")
                var taux_echange = 0.0018
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant XAF (FCFA) vers USD ($)
                $montant XAF (FCFA) = $montant_converti USD ($)
                ---------------------------------------------
            """.trimIndent())
            }
            5 -> {
                println("Vous avez choisi de convertir EUR (€) vers XAF (FCFA)")
                var taux_echange = 655.0
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant EUR (€) vers XAF (FCFA)
                $montant EUR (€) = $montant_converti XAF (FCFA)
                ---------------------------------------------
            """.trimIndent())
            }
            6 -> {
                println("Vous avez choisi de convertir XAF (FCFA) vers EUR (€)")
                var taux_echange = 0.0015
                var montant_converti = montant * taux_echange
                println("""
                ---------------------------------------------
                conversion de $montant XAF (FCFA) vers EUR (€)
                $montant XAF (FCFA) = $montant_converti EUR (€)
                ---------------------------------------------
            """.trimIndent())
            }
            else -> println("Choix invalide")
        }

        println("""
            
            Voulez-vous effectuer une autre conversion ?
            1. Oui
            2. Non
            Entrez votre choix :
        """.trimIndent())

        var choixrestart = scanner.nextInt()
        println("Le choix saisi est $choixrestart")

        when(choixrestart){
            1 -> repeat = true
            2 -> {
                repeat = false
                println("Au revoir !")
            }
            else -> println("Choix invalide")
        }
    } while (repeat)
}