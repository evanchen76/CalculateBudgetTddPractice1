import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class AccountingTests {

    lateinit var accounting: Accounting

    @Mock
    lateinit var budgetRepository: IBudgetRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        accounting = Accounting(budgetRepository)
    }

    @Test
    fun no_Budgets() {
        amountShouldBe(0.0, "20180301", "20180301")

    }

    @Test
    fun period_inside_budget_month() {
        val budgets = listOf<Budget>(Budget("201803", 31))
        `when`(budgetRepository.getAll()).thenReturn(budgets)
        amountShouldBe(1.0, "20180301", "20180301")
    }


    private fun amountShouldBe(expected: Double, start: String, end: String) {
        val start = StringToDate(start)
        val end = StringToDate(end)
        Assert.assertEquals(expected, accounting.totalAmount(start, end), 0.1)
    }

    private fun StringToDate(date: String) = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"))
}