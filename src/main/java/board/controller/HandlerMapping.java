package board.controller;

import java.util.HashMap;
import java.util.Map;

//Map 클래스 관리
//=> Model(데이터 처리 클래스)과 요청정보 저장
public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/login.do", new LoginController());
		map.put("/boardWriteForm.do", new BoardWriteFormController());
		map.put("/boardWrite.do", new BoardWriteController());
		map.put("/boardDelete.do", new BoardDeleteController());
		map.put("/boardView.do", new BoardViewController());
		map.put("/boardList.do", new BoardListController());
	}
	
	public Controller getController(String path) {
		return map.get(path);
	}
}
