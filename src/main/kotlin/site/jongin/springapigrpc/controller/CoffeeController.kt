package site.jongin.springapigrpc.controller

import com.google.protobuf.Empty
import io.grpc.ManagedChannelBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import site.jongin.coffeegrpc.proto.CoffeeGrpc

@RestController
@RequestMapping("/coffees")
class CoffeeController {
    private var grpcPort: Int = 8979
    private val channel = ManagedChannelBuilder
        .forAddress("localhost", this.grpcPort)
        .usePlaintext()
        .build()

    @GetMapping
    fun coffees(
    ): ResponseEntity<*> {
        val request = Empty.newBuilder().build()

        val stub = CoffeeGrpc.newBlockingStub(this.channel)

        val response = stub.getCoffeeAll(request)

        val result: MutableList<Coffee> = emptyList<Coffee>().toMutableList()
        response.coffeeResponseList.forEach {
            result.add(Coffee(
                id = it.id,
                coffeeStatus = it.coffeeStatus,
                price = it.price,
                menu = it.menu
            ))
        }

        return ResponseEntity.ok(result)
    }
}

