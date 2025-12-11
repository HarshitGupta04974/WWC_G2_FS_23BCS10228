public class userAccount extends BankAccount{
    userAccount(String username,int balance,int pin){
        super(username,balance,pin);

    }
    public void transaction(String type,int amount)throws InvalidTransaction,InsufficientAmount {
        try {
            if (!(type.equalsIgnoreCase("WITHDRAW") || type.equalsIgnoreCase("Deposite"))) {
                throw new InvalidTransaction("Invalid Transcation");
            } else if (amount > super.get_balance()) {
                throw new InsufficientAmount("Not enough balance");
            }
            if (type.equalsIgnoreCase("WITHDRAW")) {
                super.set_balance(super.get_balance() - amount);
            } else if (type.equalsIgnoreCase("Deposite")) {
                super.set_balance(super.get_balance() + amount);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        public static void main(String args[]) throws InvalidTransaction, InsufficientAmount {
        userAccount obj=new userAccount("Harshit",5000,1234);
        obj.transaction("withdraw",2000);
        System.out.println("Balance after withdraw:"+obj.get_balance());
        obj.transaction("withdraw",3100);
        }


        }

