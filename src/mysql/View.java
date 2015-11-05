package src.mysql;

public class View {

	private String name;
	private String query;

	public View() {
		super();
	}

	public View(String name, String query) {
		super();
		this.name = name;
		this.query = query;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
