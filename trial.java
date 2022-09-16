import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class trial {

        public void register() throws FileNotFoundException, IOException {
            Scanner scan = new Scanner(System.in);
    
            System.out.println("WELCOME TO ANKA BUSINESS SUPPORT SERVICES");
            System.out.println("REGISTER TO BECOME A MEMBER");
            System.out.println("_________________________________________");
            System.out.println(" ");
    
            System.out.print("Full Name: ");
            String name = scan.nextLine();
            System.out.println(name);
            System.out.println(" ");
    
            System.out.print("Date of Birth: ");
            String date_of_birth = scan.nextLine().trim();
            System.out.println(date_of_birth);
            System.out.println(" ");
    
            System.out.print("Gender(M or F): ");
            String gender = scan.nextLine().trim();
            System.out.println(gender);
            System.out.println(" ");
    
            System.out.print("Username: ");
            String username = scan.nextLine().trim();
            System.out.println(username);
            System.out.println(" ");
    
            System.out.print("Password: ");
            String password = scan.nextLine().trim();
            System.out.println(password);
            System.out.println(" ");
    
            System.out.print("Confirm Password: ");
            String con_pass = scan.nextLine().trim();
            System.out.println(con_pass);
            System.out.println(" ");
            
            
            if(password.equals(con_pass)) {
                
                File f = new File("participants.txt");

                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] lines = br.lines().toArray();
                int id = 0;
                int exist = 0;
                for(int i = 0; i<lines.length; i++) {
                    String line = lines[i].toString().trim();
                    String[] row =  line.split(",");
                    id = Integer.parseInt(row[0]) + 1;

                    if(username.equalsIgnoreCase(row[1])){
                        exist = 1;
                        System.out.println("This Username Already Take!!");
                        System.out.println("Please try other credentials");
                        System.out.println(" ");
                        System.out.println("Select 1 0r 2 to Register or Login");
                        System.out.println("Enter number of Choice");
                        int choice = scan.nextInt();
            
                        if(choice==1){
                            this.register();
                            }else if(choice==2){
                                this.login();
                            }else {
                                System.out.println("Enter Proper Option(1 or 2)");
                            }
                    }
                   
                }
                br.close();
            
                if(exist == 0){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println(id+","+username+","+password+","+name+","+gender+","+date_of_birth);
                    pw.flush();
                    pw.close();
                    bw.close();
    
                    System.out.println("Registration successfull");
                    System.out.println("Here are your details");
                    System.out.println(" ");
                    System.out.println("------------------------------------------------");
                    System.out.println("[id | password | name | gender | date_of_birth]");
                    System.out.println("--------------------------------------------------");
                    System.out.println("[ "+id+" | "+username+" | "+password+" | "+name+" | "+gender+" | "+date_of_birth+" ] ");
                    System.out.println("---------------------------------------------------");
                    System.out.println(" ");
                    System.out.println("Continue to Login Please");
                    System.out.println("----------------------------------");
                    this.login();


                }
                
                
            }else {
                System.out.println("_______________________");
                System.out.println("Passwords do not match");
                System.out.println("_______________________");
                System.out.println("Please try again");
                System.out.println(" ");
    
                System.out.println("Select 1 0r 2 to Register or Login");
                System.out.println("Enter number of Choice");
                int choice = scan.nextInt();
    
                if(choice==1){
                    this.register();
                    }else if(choice==2){
                        this.login();
                    }else {
                        System.out.println("Enter Proper Option(1 or 2)");
                    }
                        
                
            }
            scan.close();
        }

        public void login() throws FileNotFoundException, IOException{
            Scanner scan = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("--------------------------");
            System.out.println("Please Your Credentials");
    
            System.out.print("Username: ");
            String username = scan.nextLine();
            System.out.println(username);
            System.out.println(" ");
    
            System.out.print("Password: ");
            String password = scan.nextLine();
            System.out.println(password);
            System.out.println(" ");
            
            File f = new File("participants.txt");

                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] lines = br.lines().toArray();

                int k = 0;
                int flag = 0;
                while(k<lines.length){
                    String line = lines[k].toString().trim();
                    String[] row =  line.split(",");
                    String user = row[1];
                    String pass = row[2];

                    if(username.equals(user) && password.equals(pass)){
                        System.out.println("login Successful");
                        flag = 1;
                        int userid = Integer.parseInt(row[0]);
                        System.out.println("Your user id is: "+userid);
                        System.out.println("select one product category to post");
                        
                    }
                        
                    k++;
                }

                if(flag==0){
                    System.out.println("Login Failed");
                    System.out.println("----------------------");
                    System.out.println("Select 1 0r 2 to Register or Login");
                    System.out.println("Enter number of Choice");
                    int choice = scan.nextInt();

                    if(choice==1){
                        this.register();
                    }else if(choice==2){
                        this.login();
                    }else {
                        System.out.println("Enter Proper Option(1 or 2)");
                    }
                }
                    
                br.close();
                scan.close();
        }
    
        public static void main(String[] args) throws FileNotFoundException, IOException{
            File obj = new File("participants.txt");
    
            if (obj.createNewFile()){
                System.out.println(("File Created Successfully"));
            }
    
            Scanner scan = new Scanner(System.in);
            System.out.println("Select 1 0r 2 to Register or Login");
            System.out.println("Enter number of Choice");
            int choice = scan.nextInt();
    
                if(choice==1){
                    trial user = new trial();
                    user.register();
                    }else if(choice==2){
                        trial user = new trial();
                        user.login();
                    }else {
                        System.out.println("Enter Proper Option(1 or 2)");
                    }
            scan.close();        
    
        }
    
}
