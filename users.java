package project;

import java.io.*;
import java.util.Scanner;

public class users {
        public static void main(String []args)
        {
            String loti;
            Scanner sc= new Scanner(System.in);
            System.out.println(">Create Account<");
            System.out.println(">Login<");
            System.out.println(">Exit<");
            loti = sc.nextLine();
            boolean usernameExists;
            boolean passwordExists;
            boolean AdminExists ;
            boolean CustomerExists ;
            boolean accExists = false;
            File file = new File("AccountRegistrations1.txt");

            if("1".equals(loti)){
                try {
                    FileWriter fw = new FileWriter(file,true);
                    System.out.println("Register as:");
                    System.out.println(">Admin<");
                    System.out.println(">Customer<");
                    int loti1= sc.nextInt();
                   if(loti1==1) {
                       System.out.println("Enter username: ");
                       String name3 = sc.next();
                       System.out.println("Enter Password:");
                       String apass1 = sc.next();
                       fw.append(name3 + " " + apass1 + " " + loti1 + "\n");
                       System.out.println("----------------------");
                       System.out.println("You have successfully registered as an Admin" + " " + name3 + "!\n");
                       fw.close();
                   }

                       if(loti1==2){
                            System.out.println("Enter username: ");
                            String Uname = sc.next();
                            System.out.println("Enter Password:");
                            String pass1 = sc.next();
                            fw.append( Uname+" "+pass1+" "+loti1+"\n");
                           System.out.println("----------------------");
                            System.out.println("You have successfully registered as a Customer"+" "+Uname+"!\n");
                           fw.close();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

          if("2".equals(loti)){

                try {
                    String name2 ;
                    String pass2 ;
                    String role2 ;
                    Scanner rsc = new Scanner(file);
                    FileReader fr =new FileReader("AccountRegistrations.txt");
                    System.out.println("Enter Username:");
                    String name1 = sc.nextLine();
                    System.out.println("Enter Password:");
                    String pass1 = sc.nextLine();
                    System.out.println("Login as:\nAdmin\nCustomer");
                    String role=sc.nextLine();


                    while(rsc.hasNextLine()){

                        name2 = rsc.next();
                        pass2 = rsc.next();
                        role2 = rsc.next();
                        if (name2.equals(name1)) {
                            usernameExists = true;

                        }
                        else{
                            usernameExists = false;

                        }

                        if (pass2.equals(pass1)) {
                            passwordExists = true;

                        }
                        else{
                            passwordExists = false;


                        }
                        if(role2.equals(role)){

                                AdminExists=true;


                        }
                        else{
                            AdminExists=false;
                        }
                        if(role2.equals(role)){

                                CustomerExists=true;

                        }
                        else{
                            CustomerExists=false;
                        }
                        if(usernameExists){

                            if(passwordExists){
                                if(AdminExists||CustomerExists){
                                    accExists=true;
                                    break;
                                }
                                System.out.println("You are logging in into the wrong role!");
                                break;
                            }
                            System.out.println("Password does not match!");
                            break;
                        }
                    }
                    if(accExists){
                        if(role.equals("1")){
                            System.out.println("You have logged in as an Admin!");
                            System.out.println("Welcome back"+" "+name1+" !");
                            System.out.println("-------------------");
                            System.out.println(">Log Out<");
                            return;

                        }
                        if(role.equals("2")){
                            System.out.println("You have logged in as a Customer!");
                            System.out.println("Welcome back"+" "+name1+" !");
                        }
                    }
                    else{
                        System.out.println(" Username does not Match!");
                    }
                    fr.close();
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if("3".equals(loti)){
                if(accExists){
                    System.out.println("You have successfully logged out!");
                }
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

