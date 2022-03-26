public class CreditAccount implements Account {
    private int funds;

    public CreditAccount(int funds) {
        this.funds = funds;
    }

    @Override
    public void pay(int amount) {
        funds -= amount;
        System.out.println("Совершен платеж на сумму " + amount + " руб.");
    }

    @Override
    public void transfer(Account account, int amount) {
        account.addMoney(amount);
        funds -= amount;
        System.out.println("Совершен перевод в размере " + amount
                + " рублей с кредитного счета на счет " + account.getClass().getName());
    }

    @Override
    public void addMoney(int amount) {
        if (funds + amount > 0) {
            limit();
        } else {
            funds += amount;
            System.out.println("Кредитный счет пополнен на сумму " + amount + " руб.");
        }
    }

    @Override
    public int getFunds() {
        return funds;
    }

    public void limit() {
        System.out.println("На кредитный счёт вы можете положить максимально " + Math.abs(funds) + " руб.");
    }
}
