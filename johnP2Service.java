import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.*;
import java.rmi.server.*;
public class johnP2Service extends UnicastRemoteObject implements johnP2RMIInterface 
{
	int course_no;	
	public johnP2Service () throws RemoteException {}
	
	//Authenticating Client
    public boolean authenticate(String userName, String password) throws RemoteException 
  	{
    	if ((userName != null && !userName.isEmpty()) && (password != null && !password.isEmpty())) 
  		{
  			if((userName.equalsIgnoreCase("aos")) && (password.equalsIgnoreCase("project2"))) 
  			{
  				return true;
  			}
  		}
  		return false;
  	}
    
    //Remote method for providing List of courses
	public String courses() throws RemoteException 
	{
		String Course_list = null;
		ObjectInputStream input;
		try 
		{
				input = new ObjectInputStream(new FileInputStream("Course.txt"));
				Course c1=(Course)input.readObject();  
				Course c2=(Course)input.readObject();
				Course c3=(Course)input.readObject();
				Course c4=(Course)input.readObject();				
				Course_list = "Courses: \n" + c1.CourseNo+"\n" +c2.CourseNo+"\n"+c3.CourseNo+"\n"+c4.CourseNo;			
		} 
		catch (IOException | ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		return Course_list;  		
	}
	
	//Remote method for sending Course Details
	public String courseDetails(int courseID) 
	{
		String CourseDetails = null;
		ObjectInputStream inputCourseDetails;
		ObjectInputStream inputTiming;
		ObjectInputStream inputCapacity1;
		ObjectInputStream inputCapacity2;
		ObjectInputStream inputCapacity3;
		ObjectInputStream inputCapacity4;
		try 
		{
				inputCourseDetails = new ObjectInputStream(new FileInputStream("Course_details.txt"));
				Course cd1=(Course)inputCourseDetails.readObject();  
				Course cd2=(Course)inputCourseDetails.readObject();
				Course cd3=(Course)inputCourseDetails.readObject();
				Course cd4=(Course)inputCourseDetails.readObject();				
								
				inputTiming = new ObjectInputStream(new FileInputStream("Course_timings.txt"));
				Course ct1=(Course)inputTiming.readObject();
				Course ct2=(Course)inputTiming.readObject();
				Course ct3=(Course)inputTiming.readObject();
				Course ct4=(Course)inputTiming.readObject();
				
				inputCapacity1 = new ObjectInputStream(new FileInputStream("Course1_capacity.txt"));
				Course cp1=(Course)inputCapacity1.readObject();
				
				inputCapacity2 = new ObjectInputStream(new FileInputStream("Course2_capacity.txt"));
				Course cp2=(Course)inputCapacity2.readObject();
				
				inputCapacity3 = new ObjectInputStream(new FileInputStream("Course3_capacity.txt"));
				Course cp3=(Course)inputCapacity3.readObject();
				
				inputCapacity4 = new ObjectInputStream(new FileInputStream("Course4_capacity.txt"));
				Course cp4=(Course)inputCapacity4.readObject();
				
				if(courseID==1)
				{
					CourseDetails = "Course details: \nCourse Number : " + cd1.CourseNo+"\nCourse Name : " +cd1.CName+"\nCourse Description : "+cd1.Desc+"\nCredits : "
							+cd1.Cred+"\nCourse Timing : \nDay of the week : "+ct1.day+"\nStart Time : "+ct1.startTime+"\nEnd Time : "+ ct1.endTime+
							"\nCurrent Capacity : "+cp1.capacity;
				}
				else if(courseID==2)
				{
					CourseDetails = "Course details: \nCourse Number : " + cd2.CourseNo+"\nCourse Name : " +cd2.CName+"\nCourse Description : "+cd2.Desc+"\nCredits : "
							+cd2.Cred+"\nCourse Timing : \nDay of the week : "+ct2.day+"\nStart Time : "+ct2.startTime+"\nEnd Time : "+ ct2.endTime+
							"\nCurrent Capacity : "+cp2.capacity;
				}
				else if(courseID==3)
				{
					CourseDetails = "Course details: \nCourse Number : " + cd3.CourseNo+"\nCourse Name : " +cd3.CName+"\nCourse Description : "+cd3.Desc+"\nCredits : "
							+cd3.Cred+"\nCourse Timing : \nDay of the week : "+ct3.day+"\nStart Time : "+ct3.startTime+"\nEnd Time : "+ ct3.endTime+
							"\nCurrent Capacity : "+cp3.capacity;
				}
				else if(courseID==4)
				{
					CourseDetails = "Course details: \nCourse Number : " + cd4.CourseNo+"\nCourse Name : " +cd4.CName+"\nCourse Description : "+cd4.Desc+"\nCredits : "
							+cd4.Cred+"\nCourse Timing : \nDay of the week : "+ct4.day+"\nStart Time : "+ct4.startTime+"\nEnd Time : "+ ct4.endTime+
							"\nCurrent Capacity : "+cp4.capacity;
				}
		} 
		catch (IOException | ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		return CourseDetails; 
	}
	
	//Remote method for Enrolling to courses
	public boolean enroll(int courseID) 
	{
		ObjectInputStream checkCapacity1;
		ObjectInputStream checkCapacity2;
		ObjectInputStream checkCapacity3;
		ObjectInputStream checkCapacity4;	
		try
		{
			checkCapacity1 = new ObjectInputStream(new FileInputStream("Course1_capacity.txt"));
			Course cp1=(Course)checkCapacity1.readObject();
			checkCapacity2 = new ObjectInputStream(new FileInputStream("Course2_capacity.txt"));
			Course cp2=(Course)checkCapacity2.readObject();
			checkCapacity3 = new ObjectInputStream(new FileInputStream("Course3_capacity.txt"));
			Course cp3=(Course)checkCapacity3.readObject();
			checkCapacity4 = new ObjectInputStream(new FileInputStream("Course4_capacity.txt"));
			Course cp4=(Course)checkCapacity4.readObject();
			if(courseID==1) 
			{
				if(cp1.capacity!=0)
				{
					int c1Update = cp1.capacity-1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course1_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					checkCapacity1.close();
					Course1CapacityOut.close();
					return true;					
				}
			}
			else if(courseID==2) 
			{
				if(cp2.capacity!=0)
				{
					int c1Update = cp1.capacity-1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course2_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();
					checkCapacity2.close();
					return true;					
				}
			}
			else if(courseID==3) 
			{
				if(cp3.capacity!=0)
				{
					int c1Update = cp1.capacity-1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course3_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();					
					checkCapacity3.close();
					return true;					
				}
			}
			else if(courseID==4) 
			{
				if(cp4.capacity!=0)
				{
					int c1Update = cp1.capacity-1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course4_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();
					checkCapacity4.close();
					return true;					
				}
			}
		}
		catch (IOException | ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		return false;
	}
	
	//Remote method for dropping enrolled courses
	public boolean drop(String courseID) 
	{
		ObjectInputStream checkCapacity1;
		ObjectInputStream checkCapacity2;
		ObjectInputStream checkCapacity3;
		ObjectInputStream checkCapacity4;	
		try
		{
			checkCapacity1 = new ObjectInputStream(new FileInputStream("Course1_capacity.txt"));
			Course cp1=(Course)checkCapacity1.readObject();
			checkCapacity2 = new ObjectInputStream(new FileInputStream("Course2_capacity.txt"));
			Course cp2=(Course)checkCapacity2.readObject();
			checkCapacity3 = new ObjectInputStream(new FileInputStream("Course3_capacity.txt"));
			Course cp3=(Course)checkCapacity3.readObject();
			checkCapacity4 = new ObjectInputStream(new FileInputStream("Course4_capacity.txt"));
			Course cp4=(Course)checkCapacity4.readObject();
			if(courseID.equals("CSCI-1222")) 
			{				
					int c1Update = cp1.capacity+1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course1_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					checkCapacity1.close();
					Course1CapacityOut.close();
					return true;									
			}
			else if(courseID.equals("CSCI-4332")) 
			{
					int c1Update = cp2.capacity+1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course2_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();
					checkCapacity2.close();
					return true;					
			}
			else if(courseID.equals("CSCI-5432")) 
			{
				int c1Update = cp3.capacity+1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course3_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();					
					checkCapacity3.close();
					return true;					
			}
			else if(courseID.equals("CSCI-5531")) 
			{
				int c1Update = cp4.capacity+1;					
					Course c1UpdateFile=new Course(c1Update);
					FileOutputStream Course1Capacity=new FileOutputStream("Course4_capacity.txt");  
					ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity);
					Course1CapacityOut.writeObject(c1UpdateFile);
					Course1CapacityOut.close();
					checkCapacity4.close();
					return true;					
			}
		}
		catch (IOException | ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		return false;
	}
	
	//Remote method for making note of courses client has enrolled for
	public void taken(int courseID) throws IOException, RemoteException
	{		
		johnP2Service ctaken1=new johnP2Service(courseID);
		if(courseID==1)
		{
			try 
			{
				FileOutputStream courseTaken=new FileOutputStream("Course1Taken.txt");
				ObjectOutputStream CourseTakenOut=new ObjectOutputStream(courseTaken); 
				CourseTakenOut.writeObject(ctaken1);
				CourseTakenOut.flush();
				CourseTakenOut.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		else if(courseID==2)
		{
			try 
			{
				FileOutputStream courseTaken=new FileOutputStream("Course2Taken.txt");
				ObjectOutputStream CourseTakenOut=new ObjectOutputStream(courseTaken); 
				CourseTakenOut.writeObject(ctaken1);
				CourseTakenOut.flush();
				CourseTakenOut.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		else if(courseID==3)
		{
			try 
			{
				FileOutputStream courseTaken=new FileOutputStream("Course3Taken.txt");
				ObjectOutputStream CourseTakenOut=new ObjectOutputStream(courseTaken); 
				CourseTakenOut.writeObject(ctaken1);
				CourseTakenOut.flush();
				CourseTakenOut.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		if(courseID==4)
		{
			try 
			{
				FileOutputStream courseTaken=new FileOutputStream("Course4Taken.txt");
				ObjectOutputStream CourseTakenOut=new ObjectOutputStream(courseTaken); 
				CourseTakenOut.writeObject(ctaken1);
				CourseTakenOut.flush();
				CourseTakenOut.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	//Remote method for checking for the courses client has enrolled for dropping courses
	public boolean checkCoursesEnrolled(String courseID) throws IOException,RemoteException
	{
		ObjectInputStream inputCourseTaken = null;
		int cid1 = 0,cid2 = 0,cid3 = 0,cid4 = 0;		
		if(courseID.equals("CSCI-1222"))
		{
			cid1=1;
			try 
			{
				inputCourseTaken = new ObjectInputStream(new FileInputStream("Course1Taken.txt"));
				while(inputCourseTaken != null)
				{	
					johnP2Service ctak1=(johnP2Service)inputCourseTaken.readObject();
					if(ctak1.course_no==cid1)
					{
						inputCourseTaken.close();						
						break;
					}					
				}
				return true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(courseID.equals("CSCI-4332"))
		{
			cid2=2;
			try 
			{
				inputCourseTaken = new ObjectInputStream(new FileInputStream("Course2Taken.txt"));
				while(inputCourseTaken !=null)
				{	
				johnP2Service ctak1=(johnP2Service)inputCourseTaken.readObject();
				if(ctak1.course_no==cid2)
				{
					inputCourseTaken.close();
					return true;				
				}
			}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(courseID.equals("CSCI-5432"))
		{
			cid3=3;
			try 
			{
				inputCourseTaken = new ObjectInputStream(new FileInputStream("Course3Taken.txt"));
				while(inputCourseTaken !=null)
				{	
				johnP2Service ctak1=(johnP2Service)inputCourseTaken.readObject();
				if(ctak1.course_no==cid3)
				{
					inputCourseTaken.close();
					return true;				
				}
			}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(courseID.equals("CSCI-5531"))
		{
			cid4=4;
			try 
			{
				inputCourseTaken = new ObjectInputStream(new FileInputStream("Course4Taken.txt"));
				while(inputCourseTaken !=null)
				{	
				johnP2Service ctak1=(johnP2Service)inputCourseTaken.readObject();
				if(ctak1.course_no==cid4)
				{
					inputCourseTaken.close();
					return true;				
				}
			}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		  
		inputCourseTaken.close();
		return false;
	}
	public johnP2Service(int cid) throws RemoteException
	{
		this.course_no=cid;
	}
	
 }