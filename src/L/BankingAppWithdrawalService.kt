package L

import java.math.BigDecimal
/*
>>Here The BankingAppWithdrawalService is a client of the Account class. It expects that
  both Account and its subtypes guarantee the behavior that the Account class has specified
  for its withdraw method. But for FixedTermAccount the withdraws method is not allowed/ doesn't
  have a similar behavior unlike others. It violates the Liskov Substitution Principle..
  i.e. Parent class object should be replaceable by it's child class Object.
  (Should inherit all the behaviour(Same working) from it's parent)
>>Solution: Amendment to satisfy Liskov Substitution Principle (LSP)

class FixedTermDeposit: Account() {
    override fun withdraw(amount: BigDecimal) {
        throw UnsupportedOperationException("Can't Withdraw fund if lock in period is not over")
    }

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }

}
open class BankingAppWithdrawalService(private val account: Account) {
    open fun withdrawFromAccount(amount: BigDecimal) {
        account.withdraw(amount)
    }

    open fun depositInAccount(amount: BigDecimal) {
        account.deposit(amount)
    }
}

fun main() {
    val acc = FixedTermDeposit()
    val service = BankingAppWithdrawalService(acc)
    service.depositInAccount(BigDecimal(5000))
    service.withdrawFromAccount(BigDecimal(5000))
}*/

//Here we have separated the withdraw method from the account and added another account
// WithdrawableAccount abstract class which allows withdraw
abstract class Account {
    abstract fun deposit(amount: BigDecimal)
}
abstract class WithdrawableAccount: Account() {
    abstract fun withdraw(amount: BigDecimal)
}

class FixedTermDeposit: Account() {
    private var mature: Boolean = false

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }
}

class CurrentAccount(): WithdrawableAccount() {
    override fun withdraw(amount: BigDecimal) {
        TODO("Withdraw 'amount' from balance if amount<balance")
    }

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }
}
class SavingsAccount(private val path: String): WithdrawableAccount() {
    override fun withdraw(amount: BigDecimal) {
        TODO("Withdraw 'amount' from balance if amount<balance")
    }

    override fun deposit(amount: BigDecimal) {
        TODO("Deposit 'amount' in balance")
    }
}
//Since it is a withdrawal service we now hold a reference of With
open class BankingAppWithdrawalService(private val account: WithdrawableAccount) {
    open fun withdrawFromAccount(amount: BigDecimal) {
        account.withdraw(amount)
    }

    open fun depositInAccount(amount: BigDecimal) {
        account.deposit(amount)
    }
}