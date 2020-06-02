package co.id.panritamaccule.data.source

import co.id.panritamaccule.R

/**
 * Created by Sainal Sultan on 6/1/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class DataAksaraLontara {

    fun lontaraBugis(): List<String> {
        val data = listOf(
            "ᨀ", "ᨁ", "ᨂ", "ᨃ", "ᨄ", "ᨅ", "ᨆ", "ᨇ",
            "ᨈ", "ᨉ", "ᨊ", "ᨋ", "ᨌ", "ᨍ", "ᨎ", "ᨏ",
            "ᨐ", "ᨑ", "ᨒ", "ᨓ", "ᨔ", "ᨕ", "ᨖ"
        )
        return data
    }

    fun lontara(): List<String> {
        val data = listOf(
            "Ka", "Ga", "Nga", "Ngka", "Pa", "Ba", "Ma", "Mpa",
            "Ta", "Da", "Na", "Nra", "Ca", "Ja", "Nya", "Nca",
            "Ya", "Ra", "La", "Wa", "Sa", "A", "Ha"
        )
        return data
    }

    fun diaktrik(): List<String> {
        val data = listOf("-i", "-u", "-é", "-o", "-e")
        return data
    }

    fun imgDiaktrik(): List<Int> {
        val data = listOf(R.drawable.i, R.drawable.u, R.drawable.e, R.drawable.o, R.drawable.e2)
        return data
    }

    fun descDiaktrik(): List<String> {
        val data = listOf(
            "tetti’ riase’",
            "tetti’ riawa",
            "kecce’ riolo",
            "kecce’ rimunri",
            "kecce’ riase’"
        )
        return data
    }

    fun contohDiaktrik(): List<String> {
        val data = listOf("na", "ni", "nu", "né", "no", "ne (nang)")
        return data
    }

    fun contohLontaraDiaktrik(): List<String> {
        val data = listOf("ᨊ", "ᨊᨗ", "ᨊᨘ", "ᨊᨙ", "ᨊᨚ", "ᨊᨛ")
        return data
    }

}