package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

//import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@AllArgsConstructor
@Controller
public class BoardController {

	private BoardService brdService;
	
	//DI
	@Autowired
	public BoardController(BoardService boardService) {
		this.brdService = boardService;
	}
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String brdList(Model model) {
		List<BoardVO> brdList = brdService.brdList();
		model.addAttribute("boards", brdList);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
	//          RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String brdInfo(Model model, BoardVO boardVO) {
		BoardVO findVO = brdService.brdInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String brdInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//             RETURN - 단건조회 다시 호출
	@PostMapping("boardInsert")
	public String brdInsertProcess(BoardVO boardVO) {
		int bno = brdService.brdInsert(boardVO);
		return "boardInfo?boardNo="+bno;
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//               RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String brdUpdateForm(BoardVO boardVO, Model model) {
		
		model.addAttribute("brdInfo",boardVO);
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	//             RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody // => AJAX
	public Map<String,Object> brdUpdateAJAXJSON(@RequestBody BoardVO boardVO){
		
		return brdService.brdUpdate(boardVO);
	}
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer
	//             RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String brdDelete(@RequestParam Integer boardNo) {
		brdService.brdDelete(boardNo);
		return "redirect:boardList";
	}
}
