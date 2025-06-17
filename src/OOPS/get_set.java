package OOPS;


class bankbal {
    private int amount, balance;

    bankbal() {
        amount = 0;
        System.out.println("Constructor  defalut called also seted minmum balnce successfully and no need the set parameter");
        balance = 500;//minimum balance is account opining
    }

    int getDetails(String msg) {
        if (msg.equals("Check bal")) {
            return balance;
        }
        return 0;
    }
    int setbal(int a) {
        this.amount = a;
        balance += amount;
        System.out.println("The Given Amount is " + a + ",the updated balance is " + balance);
        return balance;
    }

    boolean calmin(int ua) {
        return (balance - ua) < 500;
    }

    void getAmount(int ua) {
        if (balance <= 0) {
            System.out.println("No money in the account.");
        } else if (ua > balance) {
            System.out.println("Withdrawal amount exceeds current balance.");
        } else if (calmin(ua)) {
            System.out.println("Cannot withdraw ₹" + ua + " due to minimum balance requirement of ₹500.");
        } else {
            balance -= ua;
            System.out.println("You withdrew: ₹" + ua);
            System.out.println("Your updated balance is: ₹" + balance);
        }
    }

}


public class get_set {
    public static void main(String[] args) {
        bankbal b = new bankbal();
        int amt = b.setbal(400);
        int bal = b.getDetails("Check bal");
        b.getAmount(200);

    }
}
