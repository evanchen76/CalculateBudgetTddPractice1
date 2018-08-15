import java.time.Duration
import java.time.LocalDate

class Accounting(val budgetRepository: IBudgetRepository) {
    fun totalAmount(start: LocalDate, end: LocalDate): Double {

        var budgets = budgetRepository.getAll()
        if (budgets.any()) {
            return (Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays() + 1).toDouble()
        }

        return 0.0
    }

}
