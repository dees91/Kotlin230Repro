package pl.deesoft.kotlinrepro

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import pl.deesoft.kotlinrepro.db.AppDatabase

object DatabaseHelper {
    private var database: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            val driver = AndroidSqliteDriver(AppDatabase.Schema, context, "app.db")
            AppDatabase(driver).also { database = it }
        }
    }
}
