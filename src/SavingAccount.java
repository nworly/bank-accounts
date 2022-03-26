public class SavingAccount implements Account {
    private int funds;

    public SavingAccount(int funds) {
        this.funds = funds;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Некорректная операция");
    }

    @Override
    public void transfer(Account account, int amount) {
        if (funds - amount < 0) {
            System.out.println("Вы можете вывести со сберегательного счета максимум " + funds + " руб.");
        } else if(account instanceof CreditAccount) {
            if (account.getFunds() + amount > 0) {
                ((CreditAccount) account).limit();
            }
        } else {
            account.addMoney(amount);
            funds -= amount;
            System.out.println("Совершен перевод в размере " + amount
                    + " рублей со сберегательного счета на счет " + account.getClass().getName());
        }
    }

    @Override
    public void addMoney(int amount) {
        funds += amount;
        System.out.println("Сберегательный счет пополнен на сумму " + amount + " руб.");
    }

    @Override
    public int getFunds() {
        return funds;
    }
}
