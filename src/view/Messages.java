package view;

public enum Messages {
	CLI("CUBE JOA> "),
	QUIT_MESSAGE("이용해주셔서 감사합니다. 뚜뚜뚜."),
	NUMBER_OF_CONTROLS("조작갯수: "),
	TIME_ELAPSED("경과시간: "),
	CONGRATULATIONS("축하합니다! 큐브를 맞히셨습니다."),

	NOT_AVAILABLE_INPUT_ERROR("정의되지 않은 조작 기호가 존재합니다."),
	MALFORMED_INPUT_ERROR("조작 기호 순서가 잘못 구성되어 있습니다. 입력을 다시 확인해주세요.");

	private String message;

	Messages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
