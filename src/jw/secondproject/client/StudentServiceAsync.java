package jw.secondproject.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import jw.secondproject.shared.business.role.Student;

public interface StudentServiceAsync {
	void getStudents(String name, String vorname, AsyncCallback<List<Student>> callback);
}
