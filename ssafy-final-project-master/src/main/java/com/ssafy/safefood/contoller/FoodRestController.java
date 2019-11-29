package com.ssafy.safefood.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Member;
import com.ssafy.safefood.dto.Qna;
import com.ssafy.safefood.service.BoardService;
import com.ssafy.safefood.service.MemberService;
import com.ssafy.safefood.service.QnaService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
public class FoodRestController {
	
	@Autowired
	BoardService bservice;

	@Autowired
	MemberService mservice;
	private Logger log = LoggerFactory.getLogger(FoodRestController.class);

	@Autowired
	QnaService qservice;

	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpStatus, boolean status) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", status);
		resultMap.put("data", data);
		// 상태와 함께 Map을 반환
		return new ResponseEntity<Map<String, Object>>(resultMap, httpStatus);
	}

	@GetMapping("/checkLogin/{id}")
	@ApiOperation(value = "멤버 조회", response = String.class)
	public ResponseEntity<Object> checkLogin(@PathVariable String id) throws Exception {
		log.trace("checkLogin");
		try {
			System.out.println(id);
			Member member = mservice.searchMember(id);
			System.out.println(member);
			if (member == null) {
				return new ResponseEntity<Object>(false, HttpStatus.CONFLICT);
			} else {
				return new ResponseEntity<Object>(true, HttpStatus.OK);
			}

		} catch (RuntimeException e) {
			log.error("checkLogin", e);
			throw e; //
		}
	}

	@GetMapping("/findAllQna")
	@ApiOperation(value = "Qna 조회")
	public ResponseEntity<Object> findAllQna() throws Exception {
		log.trace("findAllQna");
		try {
			List<Qna> qnas = qservice.qselect();
			return new ResponseEntity<Object>(qnas, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllQna", e);
			throw e; //
		}
	}

	@GetMapping("/findDetailQnA/{qnaid}")
	@ApiOperation(value = "Qna 상세 조회", response = Integer.class)
	public ResponseEntity<Object> findDetailQna(@PathVariable int qnaid) throws Exception {
		log.trace("findDetailQnA");
		try {
			Qna qna = qservice.selectone(qnaid);
			return new ResponseEntity<Object>(qna, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findDetailQnA", e);
			throw e; //
		}
	}

	@PostMapping("/QnAregist")
	@ApiOperation(value = "QnA 등록")
	public ResponseEntity<Object> QnAregist(@RequestBody Qna qna) throws Exception {
		log.trace("Boardregist: {}", qna);
		try {
			int c = qservice.regitser(qna);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("QnAregist", e);
			throw e; //
		}
	}

	@DeleteMapping("/QnAdelete/{qnaid}")
	@ApiOperation(value = "QnA 삭제", response = Integer.class)
	public ResponseEntity<Object> QnAdelete(@PathVariable int qnaid) throws Exception {
		log.trace("QnAdelete");
		try {
			int c = qservice.delete(qnaid);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("QnAdelete", e);
			throw e; //
		}
	}

	@PutMapping("/QnAUpdate")
	@ApiOperation(value = "정보 수정")
	public ResponseEntity<Object> QnAUpdate(@RequestBody Qna qna) throws Exception {
		log.trace("QnAUpdate");
		try {
			int c = qservice.update(qna);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("QnAUpdate", e);
			throw e; //
		}
	}

	@PutMapping("/AUpdate")
	@ApiOperation(value = "A 수정")
	public ResponseEntity<Object> AUpdate(@RequestBody Qna qna) throws Exception {
		log.trace("AUpdate");
		try {
			int c = qservice.aupdate(qna);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("AUpdate", e);
			throw e; //
		}
	}

	@PutMapping("/ADelete")
	@ApiOperation(value = "A 삭제")
	public ResponseEntity<Object> ADelete(@RequestBody Qna qna) throws Exception {
		log.trace("ADelete");
		try {
			int c = qservice.adelete(qna);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("ADelete", e);
			throw e; //
		}
	}

	@GetMapping("/SearchQnA/{keyword}")
	@ApiOperation(value = "search 조회", response = String.class)
	public ResponseEntity<Object> SearchQnA(@PathVariable String keyword) throws Exception {
		log.trace("SearchQnA");
		try {
			List<Qna> qnas = qservice.search(keyword);
			return new ResponseEntity<Object>(qnas, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("SearchQnA", e);
			throw e; //
		}
	}
	@GetMapping("/SearchWriterQnA/{writer}")
	@ApiOperation(value = "search 조회", response = String.class)
	public ResponseEntity<Object> SearchWriterQnA(@PathVariable String writer) throws Exception {
		log.trace("SearchWriterQnA");
		try {
			List<Qna> qnas = qservice.searchWriter(writer);
			return new ResponseEntity<Object>(qnas, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("SearchWriterQnA", e);
			throw e; //
		}
	}

	@GetMapping("/findAllBoard")
	@ApiOperation(value = "게시판 조회")
	public ResponseEntity<Object> findAllBoard() throws Exception {
		log.trace("findAllBoard");
		try {
			List<Board> boards = bservice.listAll();
			return new ResponseEntity<Object>(boards, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllBoard", e);
			throw e; //
		}
	}

	@GetMapping("/findDetailBoard/{bno}")
	@ApiOperation(value = "게시판 상세 조회", response = Integer.class)
	public ResponseEntity<Object> findDetailBoard(@PathVariable int bno) throws Exception {
		log.trace("findDetailBoard");
		try {
			Board b = bservice.read(bno);
			return new ResponseEntity<Object>(b, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllBoard", e);
			throw e; //
		}
	}

	@PostMapping("/Boardregist")
	@ApiOperation(value = "게시글 등록")
	public ResponseEntity<Object> addBoard(@RequestBody Board board) throws Exception {
		log.trace("Boardregist: {}", board);
		try {
			int c = bservice.regist(board);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("Boardregist", e);
			throw e; //
		}
	}

	@DeleteMapping("/BoardDelete/{bno}")
	@ApiOperation(value = "게시글", response = Integer.class)
	public ResponseEntity<Object> deleteEmployee(@PathVariable int bno) throws Exception {
		log.trace("BoardDelete");
		try {
			int c = bservice.remove(bno);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("deleteEmployee", e);
			throw e; //
		}
	}

	@PutMapping("/BoardUpdate")
	@ApiOperation(value = "정보 수정")
	public ResponseEntity<Object> updateBoard(@RequestBody Board board) throws Exception {
		log.trace("BoardUpdate");
		try {
			int c = bservice.modify(board);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("updateEmployee", e);
			throw e; //
		}
	}

	@PutMapping("/BoardBUpdate")
	@ApiOperation(value = "정보 수정")
	public ResponseEntity<Object> bupdateBoard(@RequestBody Board board) throws Exception {
		log.trace("BoardBUpdate");
		try {
			int c = bservice.bmodify(board);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("BoardBUpdate", e);
			throw e; //
		}
	}

	@GetMapping("/loginid")
	@ApiOperation(value="로그인 정보 확인")
	public ResponseEntity<Object> logiinCheck(HttpSession session) throws Exception {
		log.trace("loginCheck");
		try {
			Object result = session.getAttribute("member");
			if(result!=null){
				result = (Member)result;
				return new ResponseEntity<Object>(result, HttpStatus.OK);
			}else{
				return new ResponseEntity<Object>(result, HttpStatus.CONFLICT);
			}
			
		} catch (RuntimeException e) {
			log.error("BoardBUpdate", e);
			throw e; //
		}
			// Member member = new Member("ssafy", "1111", "test", "test", "test", "test");
			// member.setAuth(0);
			// return new ResponseEntity<Object>(member, HttpStatus.OK);
	}
}
