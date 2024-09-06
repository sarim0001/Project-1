import java.util.ArrayList;

public class SarimBank
{
    private String bank_branch;
    private String account_holder;
    private long account_number;
    private String account_type;
    private float account_balance;

    static public ArrayList<SarimBank> accounts = new ArrayList<>();

    public SarimBank(String bank_branch,String account_holder, long account_number, String account_type, float account_balance)
    {
            this.bank_branch=bank_branch;
            this.account_type=account_type;
            this.account_number=account_number;
            this.account_balance=account_balance;
            this.account_holder=account_holder;
    }

    //GetMethod-----

    public String Getbbranch()
    {
        return bank_branch;
    }

    public long Getacnumber()
    {
        return account_number;
    }

    public String Getactype()
    {
        return account_type;
    }

    public float Getacbalance()
    {
        return account_balance;
    }

    public String Getacholder()
    {
        return  account_holder;
    }

    //SetMethod-----

    public void Setbbranch(String branch)
    {
        bank_branch =  branch;
    }

    public void Setacnumber(int acnumber)
    {
        account_number = acnumber;
    }

    public void Setactype(String type)
    {
        account_type = type;
    }

    public void Setacbalance(float amount)
    {
        account_balance = amount;
    }

    public void Setacholder(String name)
    {
        account_holder = name;

    }

     


}