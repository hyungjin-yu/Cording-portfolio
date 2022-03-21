package java_test;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


public class Test {

	
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		BookService bookService = (BookService) context.getBean("bookService");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int num = 0;
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 목록 출력");
			System.out.println("3. 종료");
			System.out.println("-----------");
			System.out.print("번호 : ");
			num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:
				BookVO vo = new BookVO();
				System.out.print("도서 코드 : ");
				vo.setBook_num(sc.next());
				System.out.print("도서명 : ");
				vo.setBook_name(sc.next());
				System.out.print("저자 : ");
				vo.setBook_writer(sc.next());
				System.out.print("출판사 : ");
				vo.setPublisher(sc.next());
				System.out.print("가격 : ");
				vo.setPrice(sc.nextInt());
				System.out.print("출판일 : ");
				vo.setBook_date(sc.next());
				
				int result = bookService.insertBook(vo);
				
				if(result > 0) {
					System.out.println("도서 등록 성공");
				} else {
					System.out.println("도서 등록 실패");
				}
				break;
			case 2:
				List<BookVO> list = bookService.getBookList();
				
				if(list.size() > 0) {
					for(BookVO vo1 : list) {
						System.out.println(vo1.toString());
					}
				} else {
					System.out.println("출력할 정보가 없습니다");
				}
				break;
			case 3:
				System.out.println(" ** 종료합니다 ** ");
				context.close();
				break;
			}
			System.out.println();
		}
	}
}
