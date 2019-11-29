package com.ssafy.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;
import com.ssafy.model.service.BoardServiceImpl;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet({ "*.do", "*.log" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
	private MemberService memberService = new MemberServiceImp();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		System.out.println("action: " + action);

		try {
			if (action != null) {
				// TODO: 04 loginform.do가 호출될 때 member/login.jsp를 연결하시오.
				if (action.endsWith("loginform.do")) {
					url = "/member/login.jsp";
				}
				// END:

				// TODO: 05 login.do 가 호출될 때 동작할 login()를 호출하시오.
				else if (action.endsWith("login.do")) {
					url = login(request, response);
				}
				// END:

				// TODO: 06 logout.log 호출 시 동작할 logout()를 호출하시오.
				else if (action.endsWith("logout.log")) {
					url = logout(request, response);
				}
				// END:

				// TODO: 07 insertMemberForm.do 호출 시 /member/insertMember.jsp로 이동하시오.
				else if (action.endsWith("insertMemberForm.do")) {
					url = "/member/insertMember.jsp";
				}
				// END:

				// TODO: 08 insertMember.do 호출 시 동작할 insertMember()를 호출하시오.
				else if (action.endsWith("insertMember.do")) {
					url = insertMember(request, response);
				}
				// END:

				// TODO: 09 memberUpdateForm.log 호출 시 동작할 memberUpdateForm()을 호출하시오.
				else if (action.endsWith("memberUpdateForm.log")) {
					url = memberUpdateForm(request, response);
				}
				// END:

				// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
				else if (action.endsWith("updateMember.log")) {
					url = updateMember(request, response);
				}
				// END:

				// TODO: 11 listBoard.do 호출 시 /board/listBoard.jsp로 이동한다.
				else if (action.endsWith("listBoard.do")) {
					url = "/board/listBoard.jsp";
				}
				// END:

				// TODO: 12-1 listBoardData.do 호출 시 동작할 listBoard()를 구현하시오.
				else if (action.endsWith("listBoardData.do")) {
					url = listBoard(request, response);
				}
				// END:

				// TODO: 13 searchBoard.do 호출시 동작할 searchBoard()를 구현하시오.
				else if (action.endsWith("searchBoard.do")) {
					url = searchBoard(request, response);
				}
				// END:

				// TODO: 14 deleteBoard.do 호출 시 동작할 deleteBoard를 구현하시오.
				else if (action.endsWith("deleteBoard.do")) {
					url = deleteBoard(request, response);
				}
				// END:

				// TODO: 15 updateBoardForm.do 호출 시 동작할 boardUpdateForm()을 구현하시오.
				else if(action.endsWith("updateBoardForm.do")) {
					url = boardUpdateForm(request, response);
				}
				// END:

				// TODO: 16 updateBoard.do 호출 시 동작할 updateBoard()를 구현하시오.
				else if(action.endsWith("updateBoard.do")) {
					url = updateBoard(request, response);
				}
				// END:

				// TODO: 17 insertBoardForm.do 호출 시 /board/insertBoard.jsp로 이동하시오.
				// END:

				// TODO: 18 insertBoard.do 호출 시 동작할 insertBoard()를 구현하고 호출하시오.
				// END:
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		System.out.println("이동 대상 경로: " + url);

		// 위 과정을 거쳐서 url 들이 결정되었을 때
		// TODO: 02 url이 {로 시작할 경우 ajax로, redirect로 시작할 경우 redirect로,
		// 나머지는 forward로 처리하시오.
		if (url.startsWith("{")) {
			// {....}
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(url);
		} else if (url.startsWith("redirect")) {
			// url: redirect:/login.do
			response.sendRedirect(request.getContextPath() + url.substring(url.indexOf(":") + 1));
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
		// END:
	}

	// TODO: 05-1 login을 통해 로그인 처리하시오. 주요 사항은 아래를 참조한다.
	// @@ 아이디 저장 기능을 사용할 경우 id를 이름으로 쿠키를 저장한다.
	// @@ memberService의 login을 이용해 로그인 하고 성공 시 referer가 있을 경우는 referer로,
	// 그렇지 않을 경우 index.jsp로 이동한다.
	// @@ 로그인 실패 시 msg를 키로 request에 실패 사유를 저장하고 loginform.do로 이동한다.
	public String login(HttpServletRequest req, HttpServletResponse res) {
		// 파라미터 확인
		String id = req.getParameter("id");
		String pass = req.getParameter("pw");
		String idSave = req.getParameter("idsave");
		String referer = req.getParameter("referer");

		// 아이디 쿠키에 저장 설정
		Cookie c = new Cookie("id", id);
		if (idSave != null) { // 체크되지 않으면 서버로 날아오지 않는다.
			c.setMaxAge(60 * 60 * 24 * 7);
		} else {
			c.setMaxAge(0); // 안쓸꺼면 지우기
		}
		c.setPath(req.getContextPath());
		res.addCookie(c);
		// 모델 연결 - service를 사용할 때에는 언제나 runtime exception을 염두해두자.!!
		// 뷰 결정
		try {
			boolean result = memberService.login(id, pass);
			if (result) {
				// 사용자 정보를 세션에 담고, referer가 있다면 그리로, 없다면 index.jsp
				addToSession(req, "id", id);
				if (referer != null) {
					return "redirect:" + referer;
				} else {
					return "redirect:/index.jsp";
				}
			} else {
				throw new RuntimeException("지정된 사용자가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			return "/loginform.do";
		}
	}

	// END:

	// TODO: 06-1 logout()을 통해 로그아웃 처리하시오.
	// @@ 세션에서 사용자 정보(id)를 제거하고 loginform.do로 이동한다.
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();

		return "redirect:/loginform.do";
	}
	// END:

	// TODO: 08-1 insertMember()를 통해 회원가입을 처리하시오.
	// @@ 가입 성공 시 loginform.do로 이동해서 로그인을 유도하고
	// 실패 시 오류 메시지를 설정하고 다시 현재 페이지를 호출한다.
	public String insertMember(HttpServletRequest req, HttpServletResponse res) {
		// 파라미터 확인
		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		Member member = new Member(id, pass, name, email, null, address);
		// 모델연결 // 뷰 결정
		try {
			memberService.add(member);
			addToSession(req, "msg", "회원 가입 되었습니다.");
			return "redirect:/loginform.do";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			return "/insertMemberForm.do";
		}

	}
	// END:

	// TODO: 09-1 memberUpdateForm()을 통해 회원 정보 수정 페이지를 보이시오.
	// @@ 이때 현재 login 되어있는 사용자 정보를 화면 /member/updateMember.jsp에 전달한다.
	public String memberUpdateForm(HttpServletRequest req, HttpServletResponse res) {
		// 사용자 아이디 확인
		String id = getId(req);
		// 모델을 통해 정보 확인
		Member member = memberService.search(id);
		// JSP에 전달
		req.setAttribute("member", member);

		return "/member/updateMember.jsp";
	}
	// END:

	// TODO: 10-1 updateMember()를 통해 회원 정보를 수정하시오.
	// @@ 수정 성공 시 index.jsp로 이동하고 실패 시 오류 메시지를 설정하고
	// 다시 현재 페이지를 호출한다.
	public String updateMember(HttpServletRequest req, HttpServletResponse res) {
		// 파라미터 확인
		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		Member member = new Member(id, pass, name, email, null, address);

		// 모델 연결 --> 페이지 결정 후 리턴
		try {
			memberService.update(member);
			addToSession(req, "msg", "수정되었습니다.");
			return "redirect:/index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			return "/memberUpdateForm.log";
		}
	}
	// END:

	// TODO: 12-2 listBoard()를 통해 게시글 목록을 JSON 문자열 형태로 반환한다.
	// @@ boardService.searchAll()을 호출하기 위해서 파라미터로 PageBean을 만들어
	// 전달하고 리턴 타입의 내용을 확인하자.
	public String listBoard(HttpServletRequest req, HttpServletResponse res) {
		// 파라미터 추출
		String key = req.getParameter("key");
		String word = req.getParameter("word");
		String pageNo = req.getParameter("pageNumber");
		System.out.println("page no: "+ pageNo);
		PageBean bean = new PageBean(key, word, pageNo);
		// 모델 연결
		Map<String, Object> result = boardService.searchAll(bean);
		// JSON 문자열 형태로 변환 후 전달
		Gson gson = new Gson();
		return gson.toJson(result); // {......}
	}
	// END:

	// TODO: 13-1 searchBoard()를 구현해서 게시물 상세 내용을 출력하시오.
	public String searchBoard(HttpServletRequest req, HttpServletResponse res) {
		String no = req.getParameter("no");
		req.setAttribute("board", boardService.search(no));
		return "/board/searchBoard.jsp";
	}
	// END:

	// TODO: 14-1 deleteBoard()를 구현해서 게시물을 삭제 처리하시오.
	public String deleteBoard(HttpServletRequest req, HttpServletResponse res) {
		String no = req.getParameter("no");
		boardService.deleteBoard(no);
		return "redirect:/listBoard.do";
	}
	// END:

	// TODO: 15-1 boardUpdateForm() 을 구현해서 게시물 수정 화면인 
	//       /board/updateBoard.jsp를 리턴한다.
	// @@ no에 해당하는 게시물을 검색해서 board라는 이름으로 저장한다.
	public String boardUpdateForm(HttpServletRequest req, HttpServletResponse res) {
		String no = req.getParameter("no");
		req.setAttribute("board", boardService.search(no));
		return "/board/updateBoard.jsp";//
	}
	// END:

	// TODO: 16-1 updateBoard() 구현해서 게시물을 수정 처리하시오.
	// @@ 수정 성공 시 listBoard.do로 이동하고 실패 시 updateBoardForm.do로 이동하시오.
	public String updateBoard(HttpServletRequest req, HttpServletResponse res) {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		Board board = new Board(Integer.parseInt(no), null, title, null, contents);
		try {
			boardService.updateBoard(board);
			addToSession(req, "msg", "수정되었습니다.");
			return "redirect:/listBoard.do";
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			return "/updateBoardForm.do";
		}
	}
	
	// END:

	// TODO: 18-1 insertBoard()를 구현해서 게시글 정보를 저장하시오.
	// END:

	public void addToSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	public String getId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}
}
