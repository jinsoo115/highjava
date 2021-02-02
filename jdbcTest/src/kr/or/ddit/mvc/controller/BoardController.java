package kr.or.ddit.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.BoardServiceImpl;
import kr.or.ddit.mvc.service.IBoardService;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardController {
	private Scanner sc = new Scanner(System.in);

	private IBoardService service;

	int boardNo;
	boolean fa;
	public BoardController() {
		//service = new BoardServiceImpl();
		service = BoardServiceImpl.getInstance();
	}
	public static void main(String[] args) {
		new BoardController().boardStart();
	}
	private void boardStart() {
		while(true){
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insertBoard(); // 새글
				break;
			case 2:
				selectBoard(); // 게시글보기
				break;
			case 3:
				searchMenu();// 검색
				break;
			case 0:
				System.out.println("작업을 마칩니다...");// 작업끝
				return;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println("다시 입력하세요");
				break;
			}
		}
	}
	private void searchMenu() {
		sc.nextLine();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		String search = sc.nextLine();
		if(search == ""){
			return;
		}
		List<BoardVO> list = service.getSearchBoard(search);
		System.out.println("-------------------------------------------------------------");
		System.out.println(" No	        제 목            작성자 	조회수   ");
		System.out.println("-------------------------------------------------------------");
		searchBoard(search);
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택 >> ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			insertBoard(); // 새글
			break;
		case 2:
			selectBoard(); // 게시글보기
			break;
		case 3:
			searchMenu();// 검색
			break;
		case 0:
			System.out.println("작업을 마칩니다...");// 작업끝
			return;
		default:
			System.out.println("번호를 잘못 입력하셨습니다.");
			System.out.println("다시 입력하세요");
			break;
		}
	}
	private void searchBoard(String search) {
		List<BoardVO> list = service.getSearchBoard(search);
		if(list==null || list.size() ==0){
			System.out.println("게시글이 없습니다.");
		}else{
			for(BoardVO boardVo : list){
				System.out.print(boardVo.getBoard_no()+"\t");
				System.out.print(boardVo.getBoard_title()+"\t");
				System.out.print(boardVo.getBoard_writer()+"\t");
				System.out.println(boardVo.getBoard_cnt());
			}
		}
	}
	private void selectBoard() {
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		boardNo = sc.nextInt();
		service.countUp(boardNo);
		BoardVO boardVo = service.getSelectBoard(boardNo);
		System.out.println(boardNo+"번글 내용");
		System.out.println("------------------------------------------------------------");
		System.out.println("- 제  목 : " + boardVo.getBoard_title());
		System.out.println("- 작성자 : " + boardVo.getBoard_writer());
		System.out.println("- 내  용 : " + boardVo.getBoard_content());
		System.out.println("- 작성일 : " + boardVo.getBoard_date());
		System.out.println("- 조회수 : " + boardVo.getBoard_cnt());
		System.out.println("------------------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >> ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			updateBoard(boardVo);// 수정
			break;
		case 2:
			deleteBoard();// 삭제
			break;
		case 3:
			// 리스트로 가기
			break;
		default:
			break;
		}


	}
	private void deleteBoard() {
		int cnt = service.deleteBoard(boardNo);
		if(cnt>0){
			System.out.println(boardNo+"번글이 삭제되었습니다.");
		}else{
			System.out.println("삭제 실패 ㅠ");
		}
	}
	private void updateBoard(BoardVO boardVo) {
		sc.nextLine();
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		boardVo.setBoard_title(sc.nextLine());
		System.out.print("- 내  용 : ");
		boardVo.setBoard_content(sc.nextLine());
		int cnt = service.updateBoard(boardVo);
		if(cnt>0){
			System.out.println(boardNo+"번글이 수정되었습니다.");
		}else{
			System.out.println("수정 실패 ㅠ");
		}
	}
	private void insertBoard() {
		BoardVO boardVo = new BoardVO();
		sc.nextLine();
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		boardVo.setBoard_title(sc.nextLine());
		System.out.print("- 작성자 : ");
		boardVo.setBoard_writer(sc.nextLine());
		System.out.print("- 내  용 : ");
		boardVo.setBoard_content(sc.nextLine());

		int cnt = service.insertBoard(boardVo);

		if(cnt>0){
			System.out.println("새글이 추가되었습니다.");
		}else{
			System.out.println("추가 실패 ㅠ");
		}
	}
	private int displayMenu() {
		System.out.println("-------------------------------------------------------------");
		System.out.println(" No	        제 목            작성자 	조회수   ");
		System.out.println("-------------------------------------------------------------");
		displayBoard();
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택 >> ");
		return sc.nextInt();

	}
	private void displayBoard() {
		List<BoardVO> list = service.getAllBoard();
		if(list==null || list.size() ==0){
			System.out.println("게시글이 없습니다.");
		}else{
			for(BoardVO boardVo : list){
				System.out.print(boardVo.getBoard_no()+"\t");
				System.out.print(boardVo.getBoard_title()+"\t");
				System.out.print(boardVo.getBoard_writer()+"\t");
				System.out.println(boardVo.getBoard_cnt());
			}
		}
	}
}