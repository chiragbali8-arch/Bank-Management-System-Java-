import java.util.*;

class AccountHolder{
 long AccountNo;
 String Name;// Name of Account Holder
 int age;
 double PhNo;// Contact no of user 
 String Gender;
 String PanNo;//Pan card number
 String Occupation;//occupation of account holder
 String NomineName;//Nae of Nomine  
 double  Balance;
 // Constructor
  AccountHolder(long AccountNo,int age,double PhNo, String Name, String Gender, String PanNo, String Occupation, String NomineName,double Balance){
    this.AccountNo=AccountNo;
    this.Name=Name;
    this.age=age;
    this.Gender=Gender;
    this.PanNo=PanNo;
    this.PhNo=PhNo;
    this.Occupation=Occupation;
    this.NomineName=NomineName;
    this.Balance=Balance;

 
}
public long getAccountNo(){
    return AccountNo;

}
public int getage(){
    return age;

}
public double getPhNo(){
    return PhNo;

}


public String getGender(){
    return Gender;
}
public String getPanNo(){
    return PanNo;
}
public String getOccupation(){
    return Occupation;

}
public String getNomineName(){
    return NomineName;
}
public double getBalance(){
    return Balance;
}
// seters 
public void setAccountNo(long AccountNo){
    this.AccountNo=AccountNo;
}
public void setage(int age){
    this.age=age;
}
public void setPhNo(double PhNo){
    this.PhNo=PhNo;
}
public void setName(String Name){
    this.Name=Name;
}
public void setGender(String Gender){
    this.Gender=Gender;
}
public void setPanNo(String PanNo){
    this.PanNo=PanNo;
}
public void setOccupation(String Occupation){
    this.Occupation=Occupation;

}
public void setNomineName(String NomineName){
    this.NomineName=NomineName;
}

public void setBalance(double Balance){
    this.Balance=Balance;
}
// Diposite function 
public double setDiposite(double amount){
    Balance=Balance+amount;
    return Balance;
}
public  String  toString(){
    return "Account No :"+String.format("%07d",AccountNo)+" \t Name : "+Name+"\t Age :"+age+"\t Ph No : "+PhNo+"\t Gender : "+Gender+" \t PanCard No : "+PanNo+" \t Occupation : "+Occupation+" \t NomineName : "+NomineName+"\t Balance : "+Balance;

}
}
// AccountHolder management system main ckass
public class BankManagementSystem{
   public static  Scanner sc=new Scanner(System.in);
    public static ArrayList<AccountHolder> Account= new ArrayList<>();
    public static void main(String[] args){
        int choice;//user choice 
        do{
              System.out.println("\t \t \t \t \t \t Bank Management System");
              System.out.println("\t \t \t \t \t \t 1. Open new Accunt");
              System.out.println("\t \t \t \t \t \t 2. Display Account Details");
              System.out.println("\t \t \t \t \t \t 3. Update Account Details ");
              System.out.println("\t \t \t \t \t \t 4. Remove Account ");
              System.out.println("\t \t \t \t \t \t 5. Check balance");
              System.out.println("\t \t \t \t \t \t 6. Diposite amount");
              System.out.println("\t \t \t \t \t \t 7. Exit");

              choice=sc.nextInt();
              switch (choice) {
                       case 1: openNewAccount();
                        break;
                        case 2: displayAccountDetails();
                        break;
                        case 3: updateAccount();
                        break;
                        case 4: closeAccount();
                        break;
                        case 5: checkBalance();
                        break; 
                        case 6: dipositAmount();
                        break;
                        case 7 : System.out.println("\t\t\t\t\t\t\tThank you ");   
                        break;             
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
               while(choice!=7);
             
        }
        // Genrate account number function 
        public static long genrateAccountNo(ArrayList<AccountHolder> Account){
            if(Account.isEmpty()){
                return 1L;

            }
            AccountHolder lastAccount=Account.get(Account.size()-1);
            return  lastAccount.getAccountNo()+1;
           
        }
        // create new account 
        public static void openNewAccount(){
            System.out.println("Account No.");
            long  AccountNo=genrateAccountNo(Account);
            System.out.println("Account No Allocated");
            System.out.printf("Account No : %07d%n ",AccountNo);
            System.out.println("Enter name:");
            sc.nextLine();
            String Name=sc.nextLine();
            System.out.println("Enter age ");
            int age=sc.nextInt();
            System.out.println("Enter Phone No ");
            double PhNo=sc.nextDouble();

            System.out.println("Enter Gender ");
            sc.nextLine();
            String Gender=sc.nextLine();
            System.out.println("Account Holder have pan card if hsve enter trure if not enter false. ");
            boolean have=sc.nextBoolean();
            String PanNo="NULL";
            if(have){
                System.out.println("Enter PAN card nummber.");
                sc.nextLine();
                 PanNo=sc.nextLine();
            }
            if(!have){
                System.out.println("Tell account holder to give PAN card number when it is available.");
                sc.nextLine();
            }
            System.out.println("Enter occupation");
            String Occupation=sc.nextLine();
            System.out.println("Enter Nomine Name.");
            String NomineName=sc.nextLine();
            System.out.println("ATM");
            if(age<18){
                System.out.println("Account Holder is not eligble for ATM");

            }
            if(age>=18){
                System.out.println("ATM is delivered at your home");
                
            }
        
        
            //Balance 
            System.out.println("Enter amount account holder deposite to open new account.");
            int AccountOpenAmount=sc.nextInt();
            double Balance=AccountOpenAmount;
           Account.add(new AccountHolder( AccountNo, age, PhNo,  Name,  Gender,  PanNo,  Occupation,  NomineName, Balance));
        }
        // Display accout details 

        public static void displayAccountDetails(){
            if(Account.isEmpty()){
                System.out.println("No AccountHolder account is the system from this branch.");
            }else{
                System.out.println("\t\t\t\t\t\t Account list ");
                for(AccountHolder b:Account){
                    System.out.println(b);
                }
            }
        }
        public static void updateAccount(){
            System.out.println("Enter Account No to update");
            double AccountNo=sc.nextDouble();
            boolean found=false;
            for(AccountHolder A: Account){
                if(A.getAccountNo()==AccountNo){
                    found=true;
                    System.out.println("Enter yes to change name and Gender of Account Holder and 'No' to avoid  update name and gender.");
                    sc.nextLine();
                    String choice=sc.nextLine();
                    if(choice.equalsIgnoreCase("Yes")){
                        System.out.println("Enter name of Account Holder");
                        String newName=sc.nextLine();
                        A.setName(newName);
                        System.out.println("Enter Gender of Account Holder");
                        String newGender=sc.nextLine();
                        A.setGender(newGender);
                    }if(choice.equalsIgnoreCase("No")){
                        System.out.println("Update other details");

                    }
                    System.out.println("Enter new age of Account Holder:");
                    int newage=sc.nextInt();
                    A.setage(newage);
                    System.out.println("Enter new contact number of Account Holder:");
                    double newPhNo=sc.nextDouble();
                    A.setPhNo(newPhNo);
                    System.out.println("Enter Yesto change PAN Card number of Account Holder and  \nEnter No to update other details without chage in PAN card number  ");
                    sc.nextLine();
                    String c=sc.nextLine();// operator input 
                    if(c.equalsIgnoreCase("Yes")){
                        System.out.println("Enter new PAN card number:");
                        String newPanNo=sc.nextLine();
                        A.setPanNo(newPanNo);

                    }if(c.equalsIgnoreCase("NO")){
                        System.out.println("Update other details");

                    }
                    System.out.println("Enter name of Nomine");
                    String newNomine=sc.nextLine();
                    A.setNomineName(newNomine);
                    System.out.println("Enter occupation of Account Holder");
                    String newOccupation=sc.nextLine();
                    A.setOccupation(newOccupation);
                                    
                }

            }
            if(!found){
                System.out.println("Please check Account Number");
            }
            
        }

        public static void closeAccount(){
            System.out.println("Enter Account Number to close");
            double AccountNo=sc.nextDouble();
            boolean remove=false;
            for(AccountHolder A:Account){
                if(A.getAccountNo()==AccountNo){
                    remove=true;
                    Account.remove(A);
                    System.out.println("Account closed successfully.");
                    break;
                }

            }
            if(!remove){
                System.out.println("There is some problem please check Account number carefully.");
            }
        }
        public static void checkBalance(){
            System.out.println("Enter Account Number:");
            double AccountNo=sc.nextDouble();
            boolean found=false;
            for(AccountHolder A:Account){
                if(A.getAccountNo()==AccountNo){            
                    found=true;
                    double balance=A.getBalance();
                    System.out.println("Balance: "+balance);
                    break;
        }
    }if(!found){
        System.out.println("Check Account Number");
    }
}

        public static void dipositAmount(){

            System.out.println("Enter Account Number to deposite money:");
            double AccountNo=sc.nextDouble();
            boolean found=false;
            for(AccountHolder A:Account){
                if(A.getAccountNo()==AccountNo){
                    found=true;
                     System.out.println("Enter amount to deposite:");
                      double diposite=sc.nextDouble();
                     double currentBalance= A.setDiposite(diposite);
                      System.out.println(diposite+" successfully diposited in account.");
                      System.out.println("Current balance ="+currentBalance);
                       
                } 
        
             }if(!found){
                System.out.println("Account not found\nPleasde check Account Number.");
             }

        }
 }
    

