package site.jongin.springapigrpc.controller

import site.jongin.coffeegrpc.proto.CoffeeStatus

class Coffee(
    var id: Long,
    coffeeStatus: CoffeeStatus,
    var price: Int,
    var menu: String
) {
    val coffeeStatus: String? = coffeeStatus.toString()
}
