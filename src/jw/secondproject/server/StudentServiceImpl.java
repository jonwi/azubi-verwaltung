package jw.secondproject.server;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import jw.secondproject.client.StudentService;
import jw.secondproject.shared.business.role.Student;

@SuppressWarnings("serial")
public class StudentServiceImpl extends RemoteServiceServlet implements StudentService {

	@Override
	public List<Student> getStudents(String name, String vorname) {
		return Arrays.asList(new Student(5), new Student(6));
	}

}
