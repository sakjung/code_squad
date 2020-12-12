package view;

public enum Messages {
	CLI("CUBE JOA> ");

	private String name;

	Messages(String name) {
		this.name = name;
	}

	public String getMessage() {
		return name;
	}
}
