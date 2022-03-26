public interface Account {
    void pay(int amount);
    void transfer(Account account, int amount);
    void addMoney(int amount);
    int getFunds();
}
