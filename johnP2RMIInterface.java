import java.io.IOException;
import java.rmi.*;
public interface johnP2RMIInterface extends Remote 
{
	public boolean authenticate(String userName, String password) throws RemoteException ;
	public String courses() throws RemoteException ;
	public String courseDetails(int courseID)throws RemoteException;
	public boolean enroll(int courseID) throws RemoteException;
	public boolean drop(String courseID)throws RemoteException;
	public boolean checkCoursesEnrolled(String CourseID) throws IOException,RemoteException;
	public void taken(int courseID) throws IOException,RemoteException;
}