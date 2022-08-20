package org.shiva.kotlin.oops

fun main() {
    fun use(controller: Controller) {
        controller.logAll()
        val customer = controller.getById(1)
    }
}
interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

class Customer(val name: String, val id: Int) {

}


class Controller (
        repository: Repository,
        logger: Logger
) : Repository by repository, Logger by logger // we don't need to write code to delegate
