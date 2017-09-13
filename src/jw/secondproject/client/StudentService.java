package jw.secondproject.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import jw.secondproject.shared.business.role.Student;

@RemoteServiceRelativePath("student")
public interface StudentService extends RemoteService{

	List<Student> getStudents(String name, String vorname);
	
}
