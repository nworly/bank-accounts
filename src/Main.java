public class Main {
    public static void main(String[] args) {
        Account savingAccount = new SavingAccount(140000);
        Account creditAccount = new CreditAccount(-14000);
        Account checkingAccount = new CheckingAccount(400000);

        savingAccount.addMoney(20000);
        savingAccount.transfer(checkingAccount, 100);
        System.out.println(savingAccount.getFunds());
        System.out.println(checkingAccount.getFunds());
        savingAccount.transfer(checkingAccount,500000);

        creditAccount.pay(20000);
        System.out.println(creditAccount.getFunds());

        System.out.println(savingAccount.getFunds());
        savingAccount.transfer(creditAccount, 50000);
        System.out.println(savingAccount.getFunds());

        checkingAccount.pay(300000);
    }
}
