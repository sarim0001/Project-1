import java.util.Scanner;


public class SarimBankSystem
{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        
    

    

    int option;

    do{

         System.out.println("\n===== Sarim Bamk =====");

         System.out.println("1. Add Account: ");

         System.out.println("2. Add Balance: ");

         System.out.println("3. Transfer Fund: ");

         System.out.println("4. Display Account Info: ");

         System.out.println("5. Exit.");

         option = sc.nextInt();
         sc.nextLine();

         switch (option) {
            case 1:
                
                addBankaccount();

                break;
               
            case 2:
               
                addbalance();

                break;

            case 3:

                tranferfund();

                break;

            case 4:
            
                accountinfo();

                break;

            case 5:
            
                System.out.println("Exiting.....");

                return;
        
            default:

                System.out.println("Invalid Choice!");

                 break;
        }



    }while(option != 5);

    }

    public static void addBankaccount(){

        System.out.print("Enter bank branch: ");
        String bankBranch = sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accountholdername = sc.nextLine();

        System.out.print("Enter account number: ");
        long accountnumber = sc.nextLong();
        sc.nextLine();  // Consume the newline

        System.out.print("Enter account type: ");
        String accountType = sc.nextLine();

        System.out.print("Enter account balance: ");
        float accountBalance = sc.nextFloat();
        sc.nextLine(); 

        SarimBank newAcount = new SarimBank(bankBranch, accountholdername, accountnumber, accountType, accountBalance);

        SarimBank.accounts.add(newAcount);

    }

    public static void addbalance(){

        long acno ; float amount;

        boolean accountfound = false;

        SarimBank current = null;

        System.out.print("Enter account number which to add fund: ");
        acno = sc.nextLong();
        sc.nextLine();
        
        for(SarimBank temp : SarimBank.accounts)
        {
            if(temp.Getacnumber()==acno)
            {
                System.out.println("Account not found!!");
                current = temp;
                accountfound = true;
                break;

            }

        }

        if(!accountfound)
        {
            System.out.println("Account Not Found!");
            return;
        }
        
                System.out.println("Enter amount to add: ");
                amount=sc.nextFloat();
                float currentbalance = current.Getacbalance();
                current.Setacbalance(currentbalance+amount);
                System.out.println("Amount added");


    }

    public static void tranferfund()
    {
        long fromac , toca;
        float amount;
        boolean fromaccountfound=false;
        boolean toaccountfound=false;

        SarimBank temp1=null , temp2=null; 

        System.err.println("Enter transfer amount from acc: ");
        fromac = sc.nextLong();

        System.out.println("Enter transfer amount to: ");
        toca = sc.nextLong();

        for(SarimBank fromacc : SarimBank.accounts)
        {
            if(fromacc.Getacnumber()==fromac)
            {
                temp1 = fromacc;
                fromaccountfound = true;
                break;
            }
        }

        for(SarimBank accto : SarimBank.accounts)
        {
            if(accto.Getacnumber()==toca)
            {
                temp2 = accto;
                toaccountfound = true;
                break;
            }
        }

        if(!fromaccountfound)
        {
            System.out.println("Cannot Find Sender Account!");
            return;
        }

        if(!toaccountfound)
        {
            System.out.println("Cannot Find Reciever Account!");
            return;
        }

        System.out.println("Enter amount to transfer: ");
        amount = sc.nextFloat();

        if (temp1.Getacbalance() < amount) {
            System.out.println("Insufficient funds!");
            return;
        }

        temp1.Setacbalance(temp1.Getacbalance() - amount);
        temp2.Setacbalance(temp2.Getacbalance() + amount);
        System.out.println("Transaction successful.");
    
    }

    public static void accountinfo()
    {

        long acno;

        SarimBank current = null;


        System.out.println("Enter account number: ");
        acno = sc.nextLong();
        boolean accountfound = false;

        for(SarimBank temp : SarimBank.accounts)
        {
            if(temp.Getacnumber()==acno)
            {
                   current = temp;

            }

            if(accountfound)
            {
                System.out.println("Cannot Found Account!");
            }

            

        }

        System.out.println("Account Holder Name: "+current.Getacholder()+"\n"+"Account Holder Branch: "+current.Getbbranch()+"\n"+"Account Number: "+current.Getacnumber()+"\n"+
        "Acount Type: "+current.Getactype()+"\n"+"Account Balance: "+current.Getacbalance());

    }

        

    
}

