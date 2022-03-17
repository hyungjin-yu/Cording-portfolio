package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;



import test.bean.ScoreVO;
import test.service.ScoreService;

@Component
public class HelloSpring {
	@Autowired
	ScoreService scoreService;
	Scanner sc = new Scanner(System.in);

	// 메뉴
	public void menu() {
		while (true) {
			int x = 0;
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 학번검색");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("-----------");
			System.out.print("번호 : ");
			x = sc.nextInt();
			System.out.println();

			switch (x) {
			case 1:
				insert();
				break;
			case 2:
				list();
				break;
			case 3:
				search();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			case 6:
				System.out.println(" ** 종료합니다 ** ");
				return;
			}
			System.out.println();
		}
	}

	private void insert() {
		ScoreVO vo = new ScoreVO();
		System.out.print("학번 : ");
		vo.setStudNo(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		
		vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
		vo.setAvg((double)vo.getTot()/3);
		
		//System.out.println(vo.toString());
		
		int result = scoreService.insertScore(vo);
		
		if(result > 0) {
			System.out.println("입력 성공");
		} else {
			System.out.println("입력 실패");
		}
	}

	private void list() {
		List<ScoreVO> list = scoreService.getScoreList();
		
		if(list.size() > 0) {
			for(ScoreVO vo1 : list) {
				System.out.println(vo1.toString());
			}
		} else {
			System.out.println("출력할 정보가 없습니다");
		}
	}

	private void search() {
		ScoreVO vo = new ScoreVO();
		System.out.print("검색할 학번 : ");
		vo.setStudNo(sc.next());
		
		ScoreVO scoreVO = scoreService.getScore(vo);
		
		if(scoreVO != null) {
			System.out.println(scoreVO.toString());
		} else {
			System.out.println("정보가 없습니다");
		}
	}

	private void modify() {
		ScoreVO vo = new ScoreVO();
		System.out.print("수정할 학번 : ");
		vo.setStudNo(sc.next());
		System.out.print("국어 점수 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 점수 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 점수 : ");
		vo.setMat(sc.nextInt());
		
		vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
		vo.setAvg((double)vo.getTot()/3);
		
		int update = scoreService.updateScore(vo);
		
		if(update > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}

	private void delete() {
		ScoreVO vo = new ScoreVO();
		System.out.print("삭제할 학번 : ");
		vo.setStudNo(sc.next());

		int delete = scoreService.deleteScore(vo);

		if (delete > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");

		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu();
		
		context.close();
	}
}










