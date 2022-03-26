public class CheckingAccount implements Account {
    private int funds;

    public CheckingAccount(int funds) {
        this.funds = funds;
    }

    @Override
    public void pay(int amount) {
        if (funds - amount < 0) {
            System.out.println("Через расчетный счёт вы можете заплатить максимально " + Math.abs(funds) + " руб.");
        } else {
            funds -= amount;
            System.out.println("Совершен платеж на сумму " + amount + " руб.");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (funds - amount < 0) {
            System.out.println("С расчетного счёта вы можете вывести максимально " + Math.abs(funds) + " руб.");
        } else if(account instanceof CreditAccount) {
            if (account.getFunds() + amount > 0) {
                ((CreditAccount) account).limit();
            }
        } else {
            account.addMoney(amount);
            funds -= amount;
            System.out.println("Совершен перевод в размере " + amount
                    + " рублей с расчетного счета на счет " + account.getClass().getName());
        }
    }

    @Override
    public void addMoney(int amount) {
        funds += amount;
        System.out.println("Расчетный счет пополнен на сумму " + amount + " руб.");
    }

    @Override
    public int getFunds() {
        return funds;
    }
}
