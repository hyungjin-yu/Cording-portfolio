package board.controller;

// view 처리 파일 이름 완성시키는 클래스
public class ViewResolver {
	private String prefix; // prefix : 접두사
	private String suffix; // suffix : 접미사
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;	// "./" + "boardList(예시)" + ".jsp"
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
