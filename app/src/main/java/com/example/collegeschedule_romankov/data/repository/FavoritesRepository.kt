package com.example.collegeschedule_romankov.data.repository

import android.content.Context

class FavoritesRepository(context: Context) {

    private val prefs = context.getSharedPreferences("favorites_prefs", Context.MODE_PRIVATE)

    fun getFavorites(): List<String> {
        return prefs.getStringSet("favorite_groups", emptySet())?.toList() ?: emptyList()
    }

    fun addFavorite(groupName: String) {
        val current = prefs.getStringSet("favorite_groups", emptySet())?.toMutableSet() ?: mutableSetOf()
        current.add(groupName)
        prefs.edit().putStringSet("favorite_groups", current).apply()
    }

    fun removeFavorite(groupName: String) {
        val current = prefs.getStringSet("favorite_groups", emptySet())?.toMutableSet() ?: mutableSetOf()
        current.remove(groupName)
        prefs.edit().putStringSet("favorite_groups", current).apply()
    }

    fun isFavorite(groupName: String): Boolean {
        return prefs.getStringSet("favorite_groups", emptySet())?.contains(groupName) == true
    }
}