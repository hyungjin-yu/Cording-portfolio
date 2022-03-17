package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;
import test.service.ScoreService;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		ScoreService socreService = (ScoreService) context.getBean("scoreService");
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		ScoreDAOSpring dao = new ScoreDAOSpring();
		int num = 0;
		
		do {
		System.out.println("<실행 결과>");
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.println("------------------");
		System.out.print("번호 : ");
		num = sc.nextInt();
		System.out.println();
		
		switch (num) {
		case 1:
			System.out.print("학번 입력\t");
			vo.setStudNo(sc.next());
			System.out.print("이름 입력\t");
			vo.setName(sc.next());
			System.out.print("국어 점수 입력\t");
			vo.setKor(sc.nextInt());
			System.out.print("영어 점수 입력\t");
			vo.setEng(sc.nextInt());
			System.out.print("수학 점수 입력\t");
			vo.setMath(sc.nextInt());
			vo.setTot(vo.getKor() + vo.getEng() + vo.getMath());
			vo.setAvg((double) vo.getTot()/3);
			
			int result = socreService.insertScore(vo);
			if(result > 0) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}
			break;
		case 2:
			List<ScoreVO>list = socreService.getScoreList();		// dao로 넣으면 안되고 socreService로 넣어야함
			if(list.size() > 0) {
				for(ScoreVO vo1 : list) {
					System.out.println(vo1.toString());
				}
			} else {
				System.out.println("성적 정보가 없습니다.");
			}
			break;
		case 3:
			System.out.print("학번 입력\t");
			vo.setStudNo(sc.next());
			System.out.println("국어 점수 입력\t");
			vo.setKor(sc.nextInt());
			System.out.println("영어 점수 입력\t");
			vo.setEng(sc.nextInt());
			System.out.println("수학 점수 입력\t");
			vo.setMath(sc.nextInt());
			vo.setTot(vo.getKor() + vo.getEng() + vo.getMath());
			vo.setAvg((double) vo.getTot()/3);
		
			int update = socreService.updateScore(vo);
			if(update > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			break;
		case 4:
			System.out.println("학번 입력\t");
			vo.setStudNo(sc.next());
			
			result = socreService.deleteScore(vo);
			if(result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			break;
		case 5:
			System.out.println("종료합니다.");
			System.exit(0);
			context.close();
			break;	
		default:
			System.out.println("1~5사이의 번호를 입력해주세요.\t");
			break;
		}
		} while (true);
	}
}

