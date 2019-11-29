package com.ssafy.safefood.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Eat;
import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.dto.FoodPageBean;
import com.ssafy.safefood.dto.Jjim;
import com.ssafy.safefood.dto.Member;
import com.ssafy.safefood.dto.PageMaker;
import com.ssafy.safefood.dto.SearchCriteria;
import com.ssafy.safefood.service.BoardService;
import com.ssafy.safefood.service.EatService;
import com.ssafy.safefood.service.FoodService;
import com.ssafy.safefood.service.JjimService;
import com.ssafy.safefood.service.MemberService;

@Controller
@CrossOrigin("*")
public class FoodWebController {

	private static final Logger log = LoggerFactory.getLogger(FoodWebController.class);

	@Autowired
	MemberService ms;

	@Autowired
	FoodService fs;

	@Autowired
	BoardService bs;

	@Autowired
	EatService es;

	@Autowired
	JjimService js;

	private List<Food> foodrr = new ArrayList<Food>();

	/*
	 * redirect
	 */
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/foodinfo")
	public String foodinfo() {
		return "foodinfo";
	}

	@GetMapping("/login")
	public String redLogin() {
		return "login";
	}

	@GetMapping("/register.do")
	public String reboard() {
		return "registerboard";
	}

//	@GetMapping("registerboard.do")
//	public String rboard() {
//		return "registerboard";
//	}

	@GetMapping("/qna")
	public String page(Model model) {
		// model.addAttribute("pageName", name);
		log.trace("page html 호출");
		return "qna";
	}

	@PostMapping("registerboard.do")
	public String registerboard(Board board, HttpServletRequest req, HttpSession session) {
		try {
			int result = bs.regist(board);
			List<Board> boards = bs.listAll();
			if (boards != null) {
				req.setAttribute("boards", boards);
				session.setAttribute("boards", boards);
			}
			return "redirect:board.do";
		} catch (Exception e) {
			return "notify";
		}

	}

	@GetMapping("modify.do")
	public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest req, HttpSession session) throws Exception {
		System.out.println(bno);
		bs.updateViewCnt(bno);
		model.addAttribute(bs.read(bno));
		List<Board> boards = bs.listAll();
		if (boards != null) {
			req.setAttribute("boards", boards);
			session.setAttribute("boards", boards);
		}
	}

	@GetMapping("readboard.do")
	public void readboardGET(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest req, HttpSession session) throws Exception {
		System.out.println(bno);
		model.addAttribute(bs.read(bno));
		List<Board> boards = bs.listAll();
		if (boards != null) {
			req.setAttribute("boards", boards);
			session.setAttribute("boards", boards);
		}
	}

//	@PostMapping("readboard.do")
//	public String readboardPOST(Board board, SearchCriteria cri, RedirectAttributes rttr,HttpServletRequest req, HttpSession session) throws Exception {
//		//bs.updateViewCnt(board.getBno());
//		bs.modify(board);
//		rttr.addAttribute("page", cri.getPage());
//		rttr.addAttribute("perPageNum", cri.getPerPageNum());
//		rttr.addAttribute("searchType", cri.getSearchType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		rttr.addFlashAttribute("msg", "SUCCESS");
//		List<Board> boards = bs.listAll();
//		if (boards != null) {
//			req.setAttribute("boards", boards);
//			session.setAttribute("boards", boards);
//		} 
//		return "redirect:board.do";
//	}

	@GetMapping("/remove.do")
	public String Deleteboard(@RequestParam("bno") int bno, Model model) throws Exception {
		int result = bs.remove(bno);
		return "redirect:board.do";
	}

	@PostMapping("modify.do")
	public String modifyPagingPOST(Board board, SearchCriteria cri, RedirectAttributes rttr, HttpServletRequest req,
			HttpSession session) throws Exception {
		// bs.updateViewCnt(board.getBno());
		bs.modify(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		List<Board> boards = bs.listAll();
		if (boards != null) {
			req.setAttribute("boards", boards);
			session.setAttribute("boards", boards);
		}
		return "redirect:board.do";
	}

	@GetMapping("/boardlist.do")
	public String listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute("boards", bs.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bs.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "notify";
	}

	@GetMapping("/board.do")
	public String postboard(@ModelAttribute("cri") SearchCriteria cri, HttpServletRequest request, Model model,
			HttpSession session) {

		try {
			List<Board> boards = bs.listAll();
			if (boards != null) {
				request.setAttribute("boards", boards);
				session.setAttribute("boards", boards);

				model.addAttribute("boards", bs.listSearchCriteria(cri));

				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(bs.listSearchCount(cri));
				model.addAttribute("pageMaker", pageMaker);

				return "notify";
			} else {
				return "index";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/login.do")
	public String getLogin(String id, String pw, HttpSession session) {
		Member result = ms.login(id, pw);

		if (result != null) {
			System.out.println("로그인 정보 받아오기 성공");
			session.setAttribute("member", result);
			return "redirect:index";
		} else {
			System.out.println("로그인 실패");
			return "login";
		}
	}

	@GetMapping("/logout.do")
	public String getLogout(HttpSession session) {
		session.invalidate();

		return "index";
	}

	@RequestMapping("/foodlist.do")
	public String getFoodList(String stype, String word, HttpSession session, HttpServletRequest request) {
		String sort = (String) session.getAttribute("sort");

		log.trace("foodlist");

		if (stype == null) {
			stype = "all";
		}
		if (word == null) {
			word = "";
		}

		List<Food> f = fs.searchAll(new FoodPageBean(stype, word, null, 0));
		foodrr = f;

		System.out.println("FoodList 호출");
		request.setAttribute("foods", f);

//		HttpSession session = request.getSession();
		session.setAttribute("foods", f);
		session.setAttribute("data", "true");
		Member loginuser = (Member) session.getAttribute("member");

		if (loginuser != null) {
			String mall = loginuser.getAllergy();
			session.setAttribute("mallergy", mall);
		}

		return "foodlist";
	}

	@GetMapping("/foodsortlist.do")
	public String FoodSortList(String stype, String word, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> foods = fs.searchview();
		session.setAttribute("foods", foods);
		System.out.println(foods);

		return "foodlist";
	}

	@GetMapping("/foodview.do")
	public String FoodView(String code, HttpServletRequest request, HttpSession session) {
		// 가져오기

		Food f = fs.search(Integer.parseInt(code));
		System.out.println("view" + f);

		try {
			f.setFrequency(f.getFrequency() + 1);
			fs.updateClick(f);
		} catch (RuntimeException e) {
			log.error("조회수 업데이트 실패", e);
		}

		System.out.println("FoodView 호출");

		System.out.println(f.getFrequency());

		// HttpSession session = request.getSession();
		session.setAttribute("foodview", f);

//		request.setAttribute("foodview", f);
		return "redirect:foodinfo";
	}

	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	@GetMapping("/best.do")
	public String best(HttpServletRequest request, HttpSession session) {
		// 가져오기

		List<Food> foodlist = fs.eatBest();
		request.setAttribute("foodlist", foodlist);
//		request.setAttribute("foodview", f);
		return "best";
	}

	@PostMapping("/signup.do")
	public String Signup(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String[] allergy = request.getParameterValues("allergy");

		System.out.println(Arrays.toString(allergy));
		String allergySum = "";

		if (allergy != null) {
			for (String a : allergy) {
				allergySum = allergySum.concat("/" + allergys[Integer.parseInt(a)]);
			}
		}

		if (!allergySum.equals("")) {
			allergySum = allergySum.substring(1);
		}

		System.out.println("/SignUp " + id + " / " + pw);
		Member member = new Member(id, pw, name, phone, email, allergySum);

		ms.signup(member);
		return "redirect:index";
	}

	@PostMapping("/update.do")
	public String UpdateController(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String[] allergy = request.getParameterValues("allergy");

		System.out.println(Arrays.toString(allergy));
		String allergySum = "";

		if (allergy != null) {
			for (String a : allergy) {
				allergySum = allergySum.concat("/" + allergys[Integer.parseInt(a)]);
			}
		}

		if (!allergySum.equals("")) {
			allergySum = allergySum.substring(1);
		}

		Member member = new Member(id, pw, name, phone, email, allergySum);

		int num = ms.update(member);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		System.out.println("/UpdateMember " + num + "개 수정");
		return "redirect:index";
	}

	@PostMapping("/delete.do")
	public String DeleteController(String id) {
		int result = ms.delete(id);
		if (result != 0) {
			return "redirect:login";
		} else
			return "memberinfo";
	}

	@GetMapping("/memberlist.do")
	public String MemberListController(HttpSession session) {
		List<Member> list = ms.searchAll();
		session.setAttribute("memberlist", list);
		return "memberlist";
	}

	@GetMapping("deleteeat.do")
	public String Deleteeat(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("idx"));
		int idx = Integer.parseInt(req.getParameter("idx"));
		System.out.println(idx);
		int result = es.delete(idx);
		if (result > 0) {
			System.out.println("삭제 완료");
			Member temp = (Member) session.getAttribute("member");
			List<Eat> myNutri = es.select(temp.getId());
			System.out.println(myNutri);
			req.setAttribute("nutri", myNutri);
			return "redirect:membereat.do";
		} else {
			System.out.println("삭제 오류");
			return "redirect:membereat.do";
		}

	}

	@GetMapping("deletejjim.do")
	public String deletejjim(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		// System.out.println(req.getParameter("idx"));
		int idx = Integer.parseInt(req.getParameter("idx"));
		// System.out.println(idx);
		int result = js.delete(idx);
		if (result > 0) {
			System.out.println("삭제 완료");
			Member temp = (Member) session.getAttribute("member");
			List<Jjim> myNutri = js.select(temp.getId());
			// System.out.println(myNutri);
			req.setAttribute("jjnutri", myNutri);
			return "redirect:jjim.do";
		} else {
			System.out.println("삭제 오류");
			return "redirect:jjim.do";
		}

	}

	@PostMapping("/foodsimilar.do")
	@ResponseBody
	public String FoodsimilarController(HttpServletRequest request, HttpSession sessionm,
			HttpServletResponse response) {
		int code = Integer.parseInt(request.getParameter("fname"));

		Food food = fs.search(code); // 현재

		List<Food> list = null;

		try {
			list = fs.searchAll(new FoodPageBean());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 유클리디언 거리
		double[] u = new double[20];
		double[] idx = new double[20];
		int cnt = 0;
		for (Food f : list) {
			double dis = Math.floor(Math.pow(food.getCalory() - f.getCalory(), 2)
					+ Math.pow(food.getCarbo() - f.getCarbo(), 2) + Math.pow(food.getProtein() - f.getProtein(), 2)
					+ Math.pow(food.getFat() - f.getFat(), 2) + Math.pow(food.getSugar() - f.getSugar(), 2)
					+ Math.pow(food.getNatrium() - f.getNatrium(), 2));
			idx[cnt] = u[cnt] = dis;
			cnt++;
		}
		Arrays.sort(idx);
		List<Food> f = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < u.length; j++) {
				if (idx[i] == u[j]) {
					f.add(fs.search(j + 1));
				}
			}
		}
		Gson gson = new Gson();
		String jString = gson.toJson(f);

		return jString;
	}

	@GetMapping("/jjim.do")
	public String MemberjjimFoodController(String code, HttpSession session, HttpServletRequest request) {
		// 유저 이름하고 먹은 음식 가져오기
		Member loginuser = (Member) session.getAttribute("member");
		if (loginuser != null) {
			List<Jjim> myNutri = js.select(loginuser.getId());
			System.out.println(myNutri);
			String myall = loginuser.getAllergy();
			String[] myalls = myall.split("/");
			for (int i = 0; i < myNutri.size(); i++) {
				String foodallery = foodrr.get(myNutri.get(i).getCode() - 1).getAllergy();
				String[] alls = foodallery.split(",");
				String myresult = "";
				outer: for (int j = 0; j < myalls.length; j++) {
					for (int k = 0; k < alls.length; k++) {
						if (myalls[j].equals(alls[k])) {
							myNutri.get(i).setCheck("주의");
							myresult = myresult + " " + myalls[j];
						} else if (myalls[j].equals("없음"))
							continue outer;
					}
				}
				// System.out.println(myresult);
				myNutri.get(i).setAllergy(myresult);
			}
			Food sum = new Food(-1, "", 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, "", "", "", "", 0, 0);

			for (Jjim j : myNutri) {
				Food temp = fs.search(j.getCode());
				int count = j.getAmount();
//				System.out.println(temp);

				sum.setSupportpereat(Math.round(sum.getSupportpereat() + (temp.getSupportpereat() * count)));
				sum.setCalory(Math.round(sum.getCalory() + (temp.getCalory() * count)));
				sum.setCarbo(Math.round(sum.getCarbo() + (temp.getCarbo() * count)));
				sum.setProtein(Math.round(sum.getProtein() + (temp.getProtein() * count)));
				sum.setFat(Math.round(sum.getFat() + (temp.getFat() * count)));
				sum.setSugar(Math.round(sum.getSugar() + (temp.getSugar() * count)));
				sum.setNatrium(Math.round(sum.getNatrium() + (temp.getNatrium() * count)));
				sum.setChole(Math.round(sum.getChole() + (temp.getChole() * count)));
				sum.setFattyacid(Math.round(sum.getFattyacid() + (temp.getFattyacid() * count)));
				sum.setTransfat(Math.round(sum.getTransfat() + (temp.getTransfat() * count)));
			}

			request.setAttribute("jjnutri", myNutri);
			session.setAttribute("jjsummary", sum);

			return "jjim";
		} else {
			return "index";
		}
	}

	@GetMapping("/membereat.do")
	public String MemberEatFoodController(String code, HttpSession session, HttpServletRequest request) {
		// 유저 이름하고 먹은 음식 가져오기
		Member loginuser = (Member) session.getAttribute("member");

		// System.out.println(loginuser);
		// System.out.println(code);

		if (loginuser != null) {
			Member result = ms.eatMember(loginuser.getId());
			// System.out.println(result.getEatlist());

			// List<Eat> myNutri = result.getEatlist();
			List<Eat> myNutri = es.select(loginuser.getId());
			String myall = loginuser.getAllergy();
			String[] myalls = myall.split("/");
			for (int i = 0; i < myNutri.size(); i++) {
				String foodallery = foodrr.get(myNutri.get(i).getCode() - 1).getAllergy();
				String[] alls = foodallery.split(",");
				String myresult = "";
				outer: for (int j = 0; j < myalls.length; j++) {
					for (int k = 0; k < alls.length; k++) {
						if (myalls[j].equals(alls[k])) {
							myNutri.get(i).setCheck("주의");
							myresult = myresult + " " + myalls[j];
						} else if (myalls[j].equals("없음"))
							continue outer;
					}
				}
				System.out.println(myresult);
				myNutri.get(i).setAllergy(myresult);
			}
			// System.out.println(myNutri);
			Food sum = new Food(-1, "", 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, "", "", "", "", 0, 0);

			for (Eat e : myNutri) {
				Food temp = fs.search(e.getCode());
				int count = e.getAmount();
//				System.out.println(temp);

				sum.setSupportpereat(Math.round(sum.getSupportpereat() + (temp.getSupportpereat() * count)));
				sum.setCalory(Math.round(sum.getCalory() + (temp.getCalory() * count)));
				sum.setCarbo(Math.round(sum.getCarbo() + (temp.getCarbo() * count)));
				sum.setProtein(Math.round(sum.getProtein() + (temp.getProtein() * count)));
				sum.setFat(Math.round(sum.getFat() + (temp.getFat() * count)));
				sum.setSugar(Math.round(sum.getSugar() + (temp.getSugar() * count)));
				sum.setNatrium(Math.round(sum.getNatrium() + (temp.getNatrium() * count)));
				sum.setChole(Math.round(sum.getChole() + (temp.getChole() * count)));
				sum.setFattyacid(Math.round(sum.getFattyacid() + (temp.getFattyacid() * count)));
				sum.setTransfat(Math.round(sum.getTransfat() + (temp.getTransfat() * count)));
			}

			request.setAttribute("nutri", myNutri);
			session.setAttribute("summary", sum);

			return "myeat";
		} else {
			return "index";
		}
	}

	@PostMapping("/addcount.do")
	public String AddEatFoodController(HttpSession session, HttpServletRequest request) {
		// 유저 이름하고 먹은 음식 가져오기

		Member loginuser = (Member) session.getAttribute("member");

		int code = Integer.parseInt(request.getParameter("code"));
		int amount = Integer.parseInt(request.getParameter("count"));
		String foodname = request.getParameter("foodname");
		String id = request.getParameter("idx");

		if (loginuser != null) {
			Eat temp = new Eat(0, id, code, amount, foodname, null, "");

			Member result = ms.eatMember(loginuser.getId());
			// System.out.println(result.getEatlist());
			es.insert(temp);

			return "redirect:foodinfo";
		} else {
			return "fail";
		}
	}

	@PostMapping("/updatefreq.do")
	public String updatefreq(HttpSession session, HttpServletRequest request) {
		// 유저 이름하고 먹은 음식 가져오기
		int code = Integer.parseInt(request.getParameter("code"));
		int amount = Integer.parseInt(request.getParameter("count"));
		Food f = fs.search(code);
		f.setSfreq(f.getSfreq() + amount);
		fs.updatesfrq(f);
		return "redirect:foodinfo";
	}

	@PostMapping("/addjjim.do")
	public String AddJjimFoodController(HttpSession session, HttpServletRequest request) {
		// 유저 이름하고 먹은 음식 가져오기

		Member loginuser = (Member) session.getAttribute("member");

		int code = Integer.parseInt(request.getParameter("code"));
		int amount = Integer.parseInt(request.getParameter("count"));
		String foodname = request.getParameter("foodname");
		String id = request.getParameter("idx");

		if (loginuser != null) {
			Jjim temp = new Jjim(0, id, code, amount, foodname, "", "");

			// Member result = ms.eatMember(loginuser.getId());
			// System.out.println(result.getEatlist());
			js.insert(temp);

			return "redirect:foodinfo";
		} else {
			return "fail";
		}
	}

	// 알고리즘
	public static void quickSort(List<Food> a, int left, int right) {
		if (left >= right) { // 종료파트 원소가 두개 이상일 때만 작업하겠다.
			return;
		}
		// 재귀 파트
		int pivot = lomutoPartition(a, left, right);

		quickSort(a, left, pivot - 1);
		quickSort(a, pivot + 1, right);
	}

	public static int lomutoPartition(List<Food> a, int left, int right) {
		int pivot = a.get(right).getFrequency();
		int i = left - 1;

		for (int j = left; j < right; j++) {
			if (a.get(j).getFrequency() > pivot) {
				i++;
				Food temp = a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
			}
		}

		Food temp = a.get(i + 1);
		a.set(i + 1, a.get(right));
		a.set(right, temp);

		return i + 1;
	}
}
