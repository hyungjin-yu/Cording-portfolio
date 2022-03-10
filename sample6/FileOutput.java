package sample6;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Outputter{
	private String filePath;

	public FileOutput() {
		System.out.println("1. Bean의 생성자 호출");
	}
	
	@Override
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(filePath);	// 파일 생성
		out.write(message);		// 파일에 문자열 1개 출력
		out.close();
		System.out.println("6. 파일 전송 성공");
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("2. 파일 결로와 파일 이름 설정");
	}
}
