import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;  

public class StudentManagement {
	
	static Connection c = null;
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		try{
			
		Class.forName("com.mysql.jdbc.Driver");  
		 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Javaprojects","project","sss");  
		Statement st= c.createStatement();
		
		while(true) {
		System.out.println("1.Insert student details");
		System.out.println("2.Update student details");
		System.out.println("3.Delete student details");
		System.out.println("4.Show student details");
		System.out.println("5.Exit");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter choice :");
		int ch = sc.nextShort();
		
		
		int choice = ch;
	
		switch(choice)
		{
		//Insert details
		case 1 :
			System.out.println("Insert new student details -> ");
			System.out.println("Enter Roll Number :");
			int id = sc.nextInt();
			
			System.out.println("Enter Full Name :");
			 String fname= sc.nextLine();
		        fname+=sc.nextLine();
			//System.out.println(fname);
			
			System.out.println("Enter Mobile Number :");
			Long mob = (long) sc.nextLong();
			
			System.out.println("Enter Marks :");
			Double mark = sc.nextDouble();
			
			PreparedStatement p = c.prepareStatement("insert into StudentDetails values(?,?,?,?)");
			p.setInt(1, id);
			p.setString(2,fname);
			p.setLong(3, mob );
			p.setDouble(4, mark);
			int result = p.executeUpdate();
			System.out.println("Data inserted");
			break;
			
			//Update Details
		case 2 :
			System.out.println("Update Previous student details -> ");
			//System.out.println("Enter Student Roll number that you want to be updated :");
			
			System.out.println("What information you want to be updated(1.Roll Numnber, 2.Name, 3. MobileNo, 4.Marks) ");
			int info = sc.nextInt();
			
			
			switch(info) {
			//update id
								case 1 :
									System.out.println("Enter Roll number that you want to Change :");
									int id1 = sc.nextInt();
									
									Statement st2= c.createStatement();
									ResultSet rm= st2.executeQuery("select * from StudentDetails"); 
									while(true) {
									if(rm.next())
									{
										int Rollro = rm.getInt("Rollno"); 
										
							                if(id1 == Rollro )
							                	{
							                		System.out.println("Enter new Roll number :");
							                		int id2 = sc.nextInt();
							                		PreparedStatement p4 = c.prepareStatement("update StudentDetails set RollNo=? where RollNo=? ");
										
							                		p4.setInt(1, id2);
							                		p4.setInt(2, id1);
							                		int result4 = p4.executeUpdate();
							                		System.out.println("Data updated");
							                		break;
							                	}
									}
									
							                  else {
											   
							                	  		System.out.println("wrong roll number inserted");
							                	  		break;
										           }
								
									}
									break;
						                
					//System.out.println("roll number unidentified");
					
		
								//update name
								case 2 :
									System.out.println("Enter Roll number  :");
									int id7 = sc.nextInt();
									Statement stn= c.createStatement();
									ResultSet rn= stn.executeQuery("select * from StudentDetails"); 
									while(true) 
									{
									if(rn.next())
									{
										
										int Roll1 = rn.getInt(1); 
									//System.out.println(Roll1);
											if(id7 == Roll1)
											{
												System.out.println(Roll1);
												System.out.println("Enter new name :");
												PreparedStatement p1 = c.prepareStatement("update StudentDetails set FullName=? where RollNo=? ");
												String name1 = sc.nextLine();
												name1+=sc.nextLine();
											
												p1.setString(1, name1);
												p1.setInt(2, id7);
												int result1 = p1.executeUpdate();
												System.out.println("Data updated");
												break;
											}
									}
											 else {
												   System.out.println("wrong roll number inserted");
												   break;
							         	  		}
									
									
									}
									break;
				
								//update mobno
								case 3 :
									System.out.println("Enter Roll number :");
									int id8 = sc.nextInt();
									Statement stmo= c.createStatement();
									ResultSet rmo= stmo.executeQuery("select * from StudentDetails"); 
									while(true) {
									if(rmo.next()) 
									{
										int Roll2 = rmo.getInt("Rollno"); 
											if(id8 == Roll2)
											{
													System.out.println("Enter new Mobile number:");
													PreparedStatement p2 = c.prepareStatement("update StudentDetails set MobNo=? where RollNo=? ");
													Long mob1 = (long) sc.nextLong();
													
													p2.setLong(1, mob1);
													p2.setInt(2, id8);
													int result2 = p2.executeUpdate();
													System.out.println("Data updated");
													break;
											}
									}
											 else {
												   System.out.println("wrong roll number inserted");
												   break;
							       	  		}
									
									}
									
									break;
				
									//update marks
									case 4 :
										System.out.println("Enter Roll number  :");
										int id9 = sc.nextInt();
										Statement stma= c.createStatement();
										ResultSet rma= stma.executeQuery("select * from StudentDetails"); 
										while(true) {
										if(rma.next()) 
										{
											int Roll3 = rma.getInt("Rollno"); 
													if(id9 == Roll3)
													{
															System.out.println("Enter new Marks:");
															PreparedStatement p3 = c.prepareStatement("update StudentDetails set Marks=? where RollNo=? ");
															Double mark1 = sc.nextDouble();
															
															p3.setDouble(1, mark1);
															p3.setInt(2, id9);
															int result3 = p3.executeUpdate();
															 System.out.println("Data updated");
															 break;
													}
										}
													else {
														   System.out.println("wrong roll number inserted");
														   break;
														   
									    	  		}
										
										}
										break;
									
				
										default:
												{
								               System.out.println("Incorrect Choice");
											}
			}
			
			break;
	    
			
			// Delete details
		case 3:
			System.out.println("Delete student details -> ");
			System.out.println("Enter RollNo that you want to be delete :");
			int id2 = sc.nextInt();
			//PreparedStatement p4 = c.prepareStatement("select * from StudentDetails");
			Statement st1= c.createStatement();
			ResultSet r= st1.executeQuery("select * from StudentDetails");
			
			while(true)
			{
				
			    if(r.next()) 
			      {
					   int Rollno = r.getInt("Rollno"); 
					  // System.out.println(Rollno);
					   
					   		if(id2 == Rollno)
					   		{
						   
					   			PreparedStatement p2 = c.prepareStatement("delete from StudentDetails where RollNo=? ");
					   			p2.setInt(1, id2);
			
					   			int result2 = p2.executeUpdate();
			
					   			System.out.println("Data deleted");
					   			break;
					     }
			
			     }
			
				   else {
					   
					   System.out.println("wrong roll number inserted");
					   break;
					   
				   }
			    
			}
			
			break;
			
		
			//Show details
		case 4:
			System.out.println("Show student details");
			PreparedStatement p3 = c.prepareStatement("select * from StudentDetails");
			ResultSet rs= p3.executeQuery();  
			while(rs.next())
			{
				System.out.println( "RollNumber ="+rs.getInt(1) + "|| " + "Name ="+ rs.getString(2) + "|| " + "MobileNo ="+ rs.getLong(3) + "|| " + "Marks ="+ rs.getDouble(4));
			}
			
			break;
			
		case 5:
			System.out.println("Exit student record system");
			break;
			
		default:
			System.out.println("Choose wrong choice");
		
		
		}
		}
		
		}
		catch(Exception e) {
			  System.out.println("Inserted Wrong information");
		}
		
		finally {
			c.close();
		}
				
	}

}
