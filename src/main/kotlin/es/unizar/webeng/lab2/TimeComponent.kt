import java.time.LocalDateTime 
import org.springframework.stereotype.Service

data class TimeDTO(val time: LocalDateTime)

interface TimeProvider { 
    fun now(): LocalDateTime 
}


@Service class TimeService : TimeProvider {
     override fun now(): LocalDateTime = LocalDateTime.now() 
}

fun LocalDateTime.toDTO(): TimeDTO = TimeDTO(time = this)

import org.springframework.web.bind.annotation.GetMapping 
import org.springframework.web.bind.annotation.RestController 
@RestController class TimeController(private val service: TimeProvider) { 
    @GetMapping("/time") 
    fun time(): TimeDTO = service.now().toDTO() 
}