package O

import java.math.BigDecimal

/*
*>>The BankingAppWithdrawalService Class Violates Open/Closed Principle because if we want to add
* new Account Type or any requirement comes then we will have to modify class. Moreover, every time if
*  we want to add new Account type/methods then we would end up modifying the class.
*
*>>In case if the BankingAppWithdrawalService would have been a library class (SDK component) then we wouldn't be
*  able to modify the method.
*
*>>Solution: Make class open for extension but close for modification.
*
class BankingAppWithdrawalService {
    private val saving : SavingsAccount?
    private val current : CurrentAccount?

    fun setSavingsAccount(saving: SavingsAccount?) {
        this.saving = saving
    }

    fun setCurrentAccount(current: CurrentAccount?) {
        this.current = current
    }

    fun withdrawFromSavingAccount(amount: BigDecimal) {
        saving?.withdrawSaving(amount)
    }

    fun depositInSavingAccount(amount: BigDecimal) {
        saving?.depositSaving(amount)
    }

    fun withdrawFromCurrentAccount(amount: BigDecimal) {
        current?.withdrawCurrent(amount)
    }

    fun depositInCurrentAccount(amount: BigDecimal) {
        current?.depositCurrent(amount)
    }
}
 */
abstract class Account {
    abstract fun withdraw(amount: BigDecimal)
    abstract fun deposit(amount: BigDecimal)
}
class CurrentAccount(): Account() {
    override fun withdraw(amount: BigDecimal) {
        TODO("Withdraw 'amount' from balance if amount<balance")
    }

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }
}
class SavingsAccount(private val path: String): Account() {
    override fun withdraw(amount: BigDecimal) {
        TODO("Withdraw 'amount' from balance if amount<balance")
    }

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }
}
// A Banking App Withdrawal Service Class is used to withdraw/deposit in the account. We can pass any subclass
// of abstract class Account and we will not have to modify the Class for withdrawing/depositing amount for respective account
open class BankingAppWithdrawalService(private var account: Account) {

    open fun withdrawFromAccount(amount: BigDecimal) {
        account.withdraw(amount)
    }

    open fun depositInAccount(amount: BigDecimal) {
        account.deposit(amount)
    }
}
