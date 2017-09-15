package jw.secondproject.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import jw.secondproject.shared.business.role.Student;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SecondProject implements EntryPoint {

	private VerticalPanel mainPanel = new VerticalPanel();

	private HorizontalPanel headline = new HorizontalPanel();

	private HorizontalPanel bodyWrapper = new HorizontalPanel();

	private FlowPanel body = new FlowPanel();

	private FlowPanel navigation = new FlowPanel();

	private StudentServiceAsync studentService = GWT.create(StudentService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get().add(mainPanel);
		mainPanel.add(headline);
		headline.add(new Label("Auszubildendensuche"));

		mainPanel.add(bodyWrapper);

		navigation.setStyleName("navbar");
		bodyWrapper.add(navigation);

		bodyWrapper.add(body);

		// Navigation
		navigation.add(new Label("Navigation"));
		// Suche
		body.add(initializeSuche());
		// Liste
		body.add(initializeStudentList());

	}

	private Panel initializeSuche() {
		// Suche nach Schuelern
		FlowPanel search = new FlowPanel();
		HorizontalPanel searchCrit = new HorizontalPanel();
		Button suchen = new Button("Suchen");
		suchen.addStyleName("btn btn-primary");

		CheckBox vollzeit = new CheckBox("Vollzeit");
		vollzeit.setValue(true);

		searchCrit.add(createInput("Betrieb"));
		searchCrit.add(createInput("Name"));
		searchCrit.add(createInput("Vorname"));
		searchCrit.add(createInput("Klasse"));
		searchCrit.add(createInput("Matrikelnummer"));
		searchCrit.add(vollzeit);

		search.add(searchCrit);
		search.add(suchen);
		return search;
	}

	private FlowPanel createInput(String name) {
		Label label = new Label(name);
		label.setStyleName("");
		TextBox box = new TextBox();
		box.setStyleName("form-control");
		FlowPanel pane = new FlowPanel();
		pane.add(label);
		pane.add(box);
		pane.addStyleName("form-group");
		return pane;
	}

	private Panel initializeStudentList() {
		// Liste initialisieren
		StudentCell cell = new StudentCell();
		CellList<Student> studentList = new CellList<>(cell);
		SingleSelectionModel<Student> selectionModel = new SingleSelectionModel<>();
		studentList.setSelectionModel(selectionModel);
		Label label = new Label();
		selectionModel.addSelectionChangeHandler(ev -> label.setText(selectionModel.getSelectedObject().toString()));

		studentList.setRowData(0, Arrays.asList(new Student(1), new Student(2), new Student(3)));
		FlowPanel listWrapper = new FlowPanel();
		listWrapper.add(label);
		listWrapper.add(studentList);

		return listWrapper;
	}

	private String wrapDiv(String content, String htmlClass) {
		return "<div class=\"" + htmlClass + "\">" + content + "</div>";
	}

	private String wrapDiv(String content) {
		return "<div>" + content + "</div>";
	}

	class StudentCell extends AbstractCell<Student> implements Cell<Student> {

		@Override
		public void render(Context context, Student value, SafeHtmlBuilder sb) {
			sb.appendHtmlConstant("<div class=\"container row\"><div class=\"col-1\">" + context.getColumn()
					+ "</div><div class=\"col\">" + wrapDiv(wrapDiv(String.valueOf(value.getNr()), "col") + wrapDiv(value.getBetrieb(), "col") + wrapDiv(value.getName(), "col")
					+ wrapDiv(value.getVorname(), "col"),"row") + "</div></div>");
		}
	}
	
	
	// Service implementation
	private void getStudents(){
		if (studentService == null) {
			studentService = GWT.create(StudentService.class);
		}
		
		AsyncCallback<List<Student>> callback = new AsyncCallback<List<Student>>() {

			@Override
			public void onFailure(Throwable caught) {
				// assertFailure
			}

			@Override
			public void onSuccess(List<Student> result) {
				
			}
		};
		studentService.getStudents("", "", callback);
	}
}
