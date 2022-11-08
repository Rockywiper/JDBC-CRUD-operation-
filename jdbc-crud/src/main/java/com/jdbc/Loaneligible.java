package com.jdbc;
import java.util.Scanner;
import java.sql.*;

public class Loaneligible 
{
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		int sign;
		int sno = 0;
		String name = null;
		String lname = null;
		String email = null;
		String password = null;
		String aadhar = null;
		
		//Login
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan", "root", "prasanth15");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from signup");
		
		Scanner log = new Scanner(System.in);
		System.out.println("For signup press [1], For login press [2], For exit press[3] : ");
		sign = log.nextInt();
		
		switch(sign)
		{
		case 1:
		{
			System.out.println("\nEnter the sno :");
			sno = log.nextInt();
			
			Scanner n = new Scanner(System.in);
			System.out.println("\nEnter your name : ");
			name = n.next();
			
			Scanner l = new Scanner(System.in);
			System.out.println("\nEnter your last name : ");
			lname = l.next();
			
			Scanner mail = new Scanner(System.in);
			System.out.println("\nEnter your email : ");
			email = mail.next();
			
			Scanner p = new Scanner(System.in);
			System.out.println("\nCreate your new password : ");
			password = p.next();
			
			Scanner num = new Scanner(System.in);
			System.out.println("\nEnter your aadhar number : ");
			aadhar = num.next();
			
			int i = st.executeUpdate("insert into signup values('"+sno+"','"+name+"','"+lname+"','"+email+"','"+password+"','"+aadhar+"')");
			System.out.println("\t\t\tSuccessfully signed up");
		}
		case 2:
		{		
			String user;
		    String pass;
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("\nusername : ");
			name = sc1.nextLine();
			
			System.out.println("\npassword : ");
			pass = sc1.nextLine();
			
			int flag=0;
			while(rs.next())
			{
				if(name.equals(rs.getString("name")) && pass.equals(rs.getString("create_password")))
				{
					System.out.println("\nSuccessfully loggedin");
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("\nInvalid username or password");
			}
		}
		case 3:
		{
			System.out.println("\t\tThank you for visiting our webpage");
		}
		
		}	
		
		//Eligibility
		
		int eage=18;
		int eacc_bal=10000;
		int esav_acc=6;
		
		int age=22;
		int acc_bal=10000;
		int nor_acc=12;
			
		Scanner sc = new Scanner(System.in);
		System.out.println("\nFor education loan press[1], For Normal loan press[2]");
		int i = sc.nextInt();
		
		System.out.println("\t\tWelcome to the loan process");
		System.out.println("\nEnter your acc_no : ");
		int acc = sc.nextInt();
		ResultSet rs1 = st.executeQuery("select * from eligible where acc_no='"+acc+"'");
		
		switch(i)
		{
		case 1:
		{
			System.out.println("\nEnter your coapplicant's monthly income : ");
			int cosal = sc.nextInt();
			while(rs1.next())
			{
				if(rs1.getInt("age")>=eage && rs1.getInt("acc_bal")>=eacc_bal && rs1.getInt("sav_acc_period")>=esav_acc)
				{
					if(cosal >= 100000)
					{
						System.out.println("\nYou are eligible for the education loan");
						System.out.println("\nYou can choose a loan amount upto 15 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 15 lakhs : ");
						int amount3 = sc.nextInt();
						double emi3 = amount3*(1.5/100);
						System.out.println("\nThe emi amount for the "+amount3+" is : "+emi3);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount3+" and the monthly emi for the loan amount is "+emi3);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
						
					}
					else if(cosal >= 80000)
					{
						System.out.println("\nYou are eligible for the education loan");
						System.out.println("\nYou can choose a loan amount upto 13 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 13 lakhs : ");
						int amount1 = sc.nextInt();
						double emi1 = amount1*(1.5/100);
						System.out.println("\nThe emi amount for the "+amount1+" is : "+emi1);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount1+" and the monthly emi for the loan amount is "+emi1);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
						
					}
					else if(cosal >= 50000)
					{
						System.out.println("\nYou are eligible for the education loan");
						System.out.println("\nYou can choose a loan amount upto 8 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 8 lakhs : ");
						int amount2 = sc.nextInt();
						double emi2 = amount2*(1.5/100);
						System.out.println("\nThe emi amount for the "+amount2+" is : "+emi2);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount2+" and the monthly emi for the loan amount is "+emi2);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
						
					}
					else if(cosal >= 20000)
					{
						System.out.println("\nYou are eligible for the education loan");
						System.out.println("\nYou can choose a loan amount upto 3 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 3 lakhs : ");
						int amount3 = sc.nextInt();
						double emi3 = amount3*(1.5/100);
						System.out.println("\nThe emi amount for the "+amount3+" is : "+emi3);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount3+" and the monthly emi for the loan amount is "+emi3);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
						
					}
				}
				else
				{
					System.out.println("\nYou are not eligible for the education loan");
				}
			}
		}

		case 2:
		{		
			while(rs1.next())
			{
				if(rs1.getInt("age")>=age && rs1.getInt("acc_bal")>=acc_bal && rs1.getInt("nor_acc_period")>=nor_acc)
				{
					System.out.println("\nEnter your monthly income : ");
					int sal = sc.nextInt();
					if(sal >= 160000)
					{
						System.out.println("\nYou are eligible for the normal loan");
						System.out.println("\nYou can choose a loan amount upto 20 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 20 lakhs : ");
						int amount5 = sc.nextInt();
						double emi5 = amount5*(2.1/100);
						System.out.println("\nThe emi amount for the "+amount5+" is : "+emi5);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount5+" and the monthly emi for the loan amount is "+emi5);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
					}
					else if(sal >= 120000)
					{
						System.out.println("\nYou are eligible for the normal loan");
						System.out.println("\nYou can choose a loan amount upto 15 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 15 lakhs : ");
						int amount1 = sc.nextInt();
						double emi1 = amount1*(2.1/100);
						System.out.println("\nThe emi amount for the "+amount1+" is : "+emi1);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount1+" and the monthly emi for the loan amount is "+emi1);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
					}
					else if(sal >= 80000)
					{
						System.out.println("\nYou are eligible for the normal loan");
						System.out.println("\nYou can choose a loan amount upto 10 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 10 lakhs : ");
						int amount2 = sc.nextInt();
						double emi2 = amount2*(2.1/100);
						System.out.println("\nThe emi amount for the "+amount2+" is : "+emi2);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount2+" and the monthly emi for the loan amount is "+emi2);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
					}
					else if(sal >= 40000)
					{
						System.out.println("\nYou are eligible for the normal loan");
						System.out.println("\nYou can choose a loan amount upto 5 lakhs");
						System.out.println("\nEnter the loan amount you wanted under 5 lakhs : ");
						int amount3 = sc.nextInt();
						double emi3 = amount3*(2.1/100);
						System.out.println("\nThe emi amount for the "+amount3+" is : "+emi3);
						System.out.println("\nEnter 1 to confirm the loan amount or 2 to exit the loan process : ");
						int confirm = sc.nextInt();
						if(confirm==1)
						{
							System.out.println("\nYou have confirmed the loan amount "+amount3+" and the monthly emi for the loan amount is "+emi3);
						}
						else
						{
							System.out.println("\nCancelled the loan process");
						}
				    }
				else
				{
					System.out.println("\nYou are not eligible for the normal loan");
				}
			}
		}
	}
		default:
		{
			System.out.println("\t\t\tThankyou for choosing our bank");
		}
		}
	}
}
