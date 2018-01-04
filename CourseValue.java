import java.io.*;  
class CourseValue
{  
	public static void main(String args[])throws Exception
	{  
		//Initializing courses
		Course c1 =new Course("1)CSCI-1222");  
		Course c2 =new Course("2)CSCI-4332");
		Course c3 =new Course("3)CSCI-5432");
		Course c4 =new Course("4)CSCI-5531");
		FileOutputStream fout=new FileOutputStream("Course.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  
		out.writeObject(c1);  
		out.writeObject(c2);
		out.writeObject(c3);
		out.writeObject(c4);
		out.flush();
		out.close();
		
		//Initializing Course Details
		Course cd1=new Course("CSCI-1222","Computer Cryptography","Cryptography Techniques",3);
		Course cd2=new Course("CSCI-4332","Gaming Course","Developing Games",3);
		Course cd3=new Course("CSCI-5432","Design and Analysis of Algorithm","Algorithm Analysis and Creation",3);
		Course cd4=new Course("CSCI-5531","Advance Operating System","Operating SYstem Advanced Concepts",3);
		FileOutputStream CourseDetailsF=new FileOutputStream("Course_details.txt");  
		ObjectOutputStream CourseDetailsOut=new ObjectOutputStream(CourseDetailsF); 
		CourseDetailsOut.writeObject(cd1);
		CourseDetailsOut.writeObject(cd2);
		CourseDetailsOut.writeObject(cd3);
		CourseDetailsOut.writeObject(cd4);
		CourseDetailsOut.flush();
		CourseDetailsOut.close();
		
		// Initializing Course Timings
		Course ct1= new Course("W","4:00PM","7:00PM");
		Course ct2= new Course("M","9:00AM","12:00PM");
		Course ct3= new Course("TT","1:00PM","2:30PM");
		Course ct4= new Course("MW","1:00PM","2:30PM");
		FileOutputStream CourseDetailsT=new FileOutputStream("Course_timings.txt");  
		ObjectOutputStream CourseTimingOut=new ObjectOutputStream(CourseDetailsT); 
		CourseTimingOut.writeObject(ct1);
		CourseTimingOut.writeObject(ct2);
		CourseTimingOut.writeObject(ct3);
		CourseTimingOut.writeObject(ct4);
		CourseTimingOut.flush();
		CourseTimingOut.close();
		
		//Initializing Course Capacity
		Course cp1= new Course(5);		
		FileOutputStream Course1Capacity=new FileOutputStream("Course1_capacity.txt");  
		ObjectOutputStream Course1CapacityOut=new ObjectOutputStream(Course1Capacity); 
		Course1CapacityOut.writeObject(cp1);
		Course1CapacityOut.flush();
		Course1CapacityOut.close();
		
		Course cp2= new Course(5);
		FileOutputStream Course2Capacity=new FileOutputStream("Course2_capacity.txt");  
		ObjectOutputStream Course2CapacityOut=new ObjectOutputStream(Course2Capacity); 
		Course2CapacityOut.writeObject(cp2);
		Course2CapacityOut.flush();
		Course2CapacityOut.close();
		
		Course cp3= new Course(5);
		FileOutputStream Course3Capacity=new FileOutputStream("Course3_capacity.txt");  
		ObjectOutputStream Course3CapacityOut=new ObjectOutputStream(Course3Capacity); 
		Course3CapacityOut.writeObject(cp3);
		Course3CapacityOut.flush();
		Course3CapacityOut.close();
		
		Course cp4= new Course(5);
		FileOutputStream Course4Capacity=new FileOutputStream("Course4_capacity.txt");  
		ObjectOutputStream Course4CapacityOut=new ObjectOutputStream(Course4Capacity); 
		Course4CapacityOut.writeObject(cp4);
		Course4CapacityOut.flush();
		Course4CapacityOut.close();
		System.out.println("Added course details for student access");  
	}  
}  