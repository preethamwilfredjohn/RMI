import java.rmi.*;
import java.util.Scanner;
public class johnP2Client {
	public static void main (String[] args) 
	{
		johnP2RMIInterface client;
		try {
  		    	System.setSecurityManager(new RMISecurityManager());
  		    	
  		    	//Connecting to RMI Registry
  		    	client = (johnP2RMIInterface)Naming.lookup("rmi://localhost/AOSProject2");
  		    	
  		    	//Client Logging in
  		    	Scanner scanner = new Scanner(System.in);
  				System.out.println("Username : ");
  				String userName = scanner.next();  				
  				System.out.println("Password : ");
  				String password = scanner.next();  		    	
  				boolean status = client.authenticate(userName, password);
  				System.out.println("Welcome...");
  				
  				//If authentication is successful
  				if(status)
  				{
  					while(true)
  					{
  						//Getting list of courses by invoking server object
  						String course_list = client.courses(); 
  						System.out.println(course_list);
  						System.out.println("Select the Course ID to get further details");
  						int selectedCourse=scanner.nextInt();  	
  						
  						//Getting details of the selected course by invoking server object
  						System.out.println("Getting Details for the Course "+selectedCourse+" from server");
  						if(selectedCourse==1||selectedCourse==2||selectedCourse==3||selectedCourse==4)
  						{
  							String CourseD = client.courseDetails(selectedCourse);
  							System.out.println(CourseD);
  							
  							//Enrolling for courses 
  							System.out.println("Would you like to enroll?(y/n)");
  							String enroll = scanner.next();
  							if(enroll.equals("y"))
  							{
  								boolean enrolled=client.enroll(selectedCourse);
  								if(enrolled)
  								{
  									System.out.println("You have been enrolled to course");
  									client.taken(selectedCourse);
  								}
  								else
  								{
  									System.out.println("Course has no seats left. Please try again later.");
  								}
  							}  							
  						}
  						
  						else
  						{
  							System.out.println("Choose appropriate course");
  						}
  						
  						//checking if client wants to enroll for more courses
  						System.out.println("Would you like to continue?(y/n)");
  						String cont = scanner.next(); 
  						if(cont.equals("n")) 
  							break;
  					}
  					
  					//dropping courses
  					while(true)
  					{	
  					System.out.println("Would you like to drop course you have enrolled for?(y/n)");
					String read = scanner.next();
					if(read.equals("y"))
					{
						System.out.println("Enter the course ID you want to drop");
						String dropCourse=scanner.next();
						boolean check=client.checkCoursesEnrolled(dropCourse);
						if(check)
						{
							boolean dropped=client.drop(dropCourse);
							if(dropped)
							{
								System.out.println("Course Dropped");
							}
							else
							{
								System.out.println("unable to drop");
							}
						}												
						else
						{
							System.out.println("Please enroll for courses to drop");
						}						
					}
					else
					{
						System.out.println("Thank you");
						break;
					}
  				}

  				}  				
  				else 
  				{  					
  					System.out.println("Unauthorized Login Attempt");
  				}  				
  				scanner.close();
			}
			catch (Exception e) 
			{		
				System.out.println("HelloClient exception: " + e);
			}
		}
}