import java.time.Duration
import java.time.LocalDate
import java.time.Period

class Accounting(val budgetRepository: IBudgetRepository) {
    fun totalAmount(start: LocalDate, end: LocalDate): Double {

        val period = DayPeriod(start, end)

        val budgets = budgetRepository.getAll()
        if (budgets.any()) {

            return period.days()
        }

        return 0.0
    }

}
