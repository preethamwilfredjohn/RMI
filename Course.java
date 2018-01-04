import java.io.Serializable;  
@SuppressWarnings("serial")
public class Course implements Serializable
{  
	String CourseNo;
	String CName;
	String Desc;
	int Cred;
	String day;
	String startTime, endTime;
	int capacity;
	public Course(String CourseID) 
	{    
		this.CourseNo = CourseID;  
	}
	public Course(String CourseID, String CourseName, String Description, int Credits)
	{
		this.CourseNo=CourseID;
		this.CName=CourseName;
		this.Desc=Description;
		this.Cred=Credits;
	}
	public Course(String dayOfWeek, String sTime, String eTime)
	{
		this.day=dayOfWeek;
		this.startTime=sTime;
		this.endTime=eTime;
	}
	public Course(int cap) 
	{
		this.capacity=cap;
	}	
	public byte[] getBytes() 
	{
	// TODO Auto-generated method stub
	return null;
	}  
}  
