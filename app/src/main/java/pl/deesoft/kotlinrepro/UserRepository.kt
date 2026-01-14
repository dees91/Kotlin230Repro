package pl.deesoft.kotlinrepro

import pl.deesoft.kotlinrepro.db.AppDatabase
import pl.deesoft.kotlinrepro.db.User

class UserRepository(private val database: AppDatabase) {

    private val queries = database.userQueries

    fun getAllUsers(): List<User> = queries.selectAll().executeAsList()

    fun getUserById(id: Long): User? = queries.selectById(id).executeAsOneOrNull()

    fun getUserByEmail(email: String): User? = queries.selectByEmail(email).executeAsOneOrNull()

    fun insertUser(name: String, email: String) {
        queries.insert(name, email)
    }

    fun updateUser(id: Long, name: String, email: String) {
        queries.update(name, email, id)
    }

    fun deleteUser(id: Long) {
        queries.deleteById(id)
    }

    fun deleteAllUsers() {
        queries.deleteAll()
    }

    fun getUserCount(): Long = queries.count().executeAsOne()
}
