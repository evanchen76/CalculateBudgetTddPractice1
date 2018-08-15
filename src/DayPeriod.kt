import java.time.Duration
import java.time.LocalDate

class DayPeriod(private val start: LocalDate, private val end: LocalDate) {
    fun days(): Double {
        return (Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays() + 1).toDouble()
    }

}
