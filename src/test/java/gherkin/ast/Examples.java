package gherkin.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.mycompany.core.testdata.ExcelTestDataUtility;
import com.mycompany.core.testdata.ScenarioTestData;

public class Examples extends Node {
	private final List<Tag> tags;
	private final String keyword;
	private final String name;
	private final String description;
	private final TableRow tableHeader;
	private final List<TableRow> tableBody;

	@SuppressWarnings("null")
	public Examples(Location location, List<Tag> tags, String keyword, String name, String description,
			TableRow tableHeader, List<TableRow> tableBody) {
		super(location);
		this.tags = Collections.unmodifiableList(tags);
		this.keyword = keyword;
		this.name = name;
		this.description = description;
		
		ExcelTestDataUtility ScenarioTestData = new ExcelTestDataUtility("C:\\Users\\rajiv.sharma\\Documents\\TestData.xls","124");
		ScenarioTestData.getDataFromExcel();
		ScenarioTestData.fillTestDataToMap();
		
		List<String> headerList=ScenarioTestData.getHeaderList();
		
		List<TableCell> tableRowHeader = new ArrayList<TableCell>();
		TableCell tableHeaderCell;
		for (int i=0;i<headerList.size();i++) {
			tableHeaderCell = new TableCell(location, headerList.get(i));
			tableRowHeader.add(tableHeaderCell);
		}

		TableRow tableHeaderRow = new TableRow(location, tableRowHeader);
		this.tableHeader = tableHeaderRow;
			
		List<TableRow> listTableRow = new ArrayList<TableRow>();
		
		for(int i=0;i<ScenarioTestData.getTestDataList().size();i++) {
			
			List<TableCell> tableCellsRow = new ArrayList<TableCell>();
			TableRow tableRow = null;
			TableCell tableRow1Cell = null;
			
			for(int a=0;a<ScenarioTestData.getTestDataList().get(i).size();a++) {
				String cellValue=ScenarioTestData.getTestDataList().get(i).get(tableRowHeader.get(a).getValue());
				
				tableRow1Cell = new TableCell(location, cellValue);
				tableCellsRow.add(tableRow1Cell);
				tableRow = new TableRow(location, tableCellsRow);
				
			}
			
			listTableRow.add(tableRow);
			
		}
		
		this.tableBody = listTableRow != null ? Collections.unmodifiableList(listTableRow) : null;
		
	}

	public String getKeyword() {
		return keyword;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<TableRow> getTableBody() {
		return tableBody;
	}

	public TableRow getTableHeader() {
		return tableHeader;
	}

	public List<Tag> getTags() {
		return tags;
	}
}
