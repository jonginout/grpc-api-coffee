package site.jongin.springapigrpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringApiGrpcApplication

fun main(args: Array<String>) {
    runApplication<SpringApiGrpcApplication>(*args)
}
