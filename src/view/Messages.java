package view;

public enum Messages {
	CLI("CUBE JOA> "),

	NOT_AVAILABLE_INPUT_ERROR("정의되지 않은 조작 기호가 존재합니다."),
	MALFORMED_INPUT_ERROR("조작 기호 순서가 잘못 구성되어 있습니다. 입력을 다시 확인해주세요.");

	private String name;

	Messages(String name) {
		this.name = name;
	}

	public String getMessage() {
		return name;
	}
}
