package jw.secondproject.client;

import java.util.Arrays;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
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

	private VerticalPanel body = new VerticalPanel();

	private VerticalPanel navigation = new VerticalPanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get().add(mainPanel);
		mainPanel.add(headline);
		headline.add(new Label("Auszubildendensuche"));
		mainPanel.add(bodyWrapper);
		bodyWrapper.add(navigation);
		bodyWrapper.add(body);

		if (this instanceof SecondProject) {

		}

		// Navigation
		navigation.add(new Label("Navigation"));
		// Suche
		body.add(initializeSuche());
		// Liste
		body.add(initializeStudentList());

	}

	private Panel initializeSuche() {
		// Suche nach Schuelern
		VerticalPanel search = new VerticalPanel();
		HorizontalPanel searchCrit = new HorizontalPanel();
		Button suchen = new Button("Suchen");
		suchen.addStyleName("superSuche");
		Label labelBetrieb = new Label("Betrieb");
		TextBox betrieb = new TextBox();
		Label labelName = new Label("Name");
		TextBox name = new TextBox();
		Label labelVorname = new Label("Vorname");
		TextBox vorname = new TextBox();
		Label labelKlasse = new Label("Klasse");
		TextBox klasse = new TextBox();
		Label labelMatrikelnummer = new Label("Matrikelnummer");
		TextBox matrikelnummer = new TextBox();
		CheckBox vollzeit = new CheckBox("Vollzeit");
		vollzeit.setValue(true);

		searchCrit.add(labelBetrieb);
		searchCrit.add(betrieb);
		searchCrit.add(labelName);
		searchCrit.add(name);
		searchCrit.add(labelVorname);
		searchCrit.add(vorname);
		searchCrit.add(labelKlasse);
		searchCrit.add(klasse);
		searchCrit.add(labelMatrikelnummer);
		searchCrit.add(matrikelnummer);
		searchCrit.add(vollzeit);

		search.add(searchCrit);
		search.add(suchen);
		return search;
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
		HorizontalPanel listWrapper = new HorizontalPanel();
		listWrapper.add(label);
		listWrapper.add(studentList);

		return listWrapper;
	}

	class StudentCell extends AbstractCell<Student> implements Cell<Student> {

		@Override
		public void render(Context context, Student value, SafeHtmlBuilder sb) {
			sb.append(context.getIndex() + 1);
			sb.appendEscaped(value.toString());
		}

	}

}
