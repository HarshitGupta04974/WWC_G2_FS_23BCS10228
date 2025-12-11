public class BankAccount {
    private String username;
    private int balance;
    private int pin;
    BankAccount(String username, int balance, int pin) {
        this.username = username;
        this.balance = balance;
        this.pin = pin;
    }
    public int get_balance() {
        return balance;
    }
    public void set_balance(int balance) {
        this.balance = balance;
    }
    public String get_username() {
        return username;
    }
    public void set_username(String username) {
        this.username = username;
    }
    public int get_pin() {
        return pin;
    }
    public void set_pin(int pin) {
        this.pin = pin;
    }
}
