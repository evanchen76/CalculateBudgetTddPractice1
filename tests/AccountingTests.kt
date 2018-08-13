import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class AccountingTests {

    lateinit var accounting: Accounting

    @Mock
    lateinit var budgetRepository:IBudgetRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        accounting = Accounting()
    }

    @Test
    fun no_Budgets() {
        amountShouldBe(0.0, "20180301", "20180301")

    }

    private fun amountShouldBe(expected: Double, start: String, end: String) {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val start = LocalDate.parse(start, formatter)
        val end = LocalDate.parse(end, formatter)
        val totalAmount = accounting.totalAmount(start, end)
        Assert.assertEquals(expected, totalAmount, 0.1)
    }
}