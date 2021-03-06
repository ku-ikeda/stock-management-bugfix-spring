package jp.co.rakus.stockmanagement.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.repository.MemberRepository;
import jp.co.rakus.stockmanagement.service.MemberService;

/**
 * メンバー関連処理を行うコントローラー.
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/member")
@Transactional
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository repository;
	
	
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public MemberForm setUpForm() {
		return new MemberForm();
	}

	/**
	 * メンバー情報登録画面を表示します.
	 * @return メンバー情報登録画面
	 */
	@RequestMapping(value = "form")
	public String form() {
		
		return "/member/form";
	}
	
	/**
	 * メンバー情報を登録します.
	 * @param form フォーム
	 * @param result リザルト
	 * @param model モデル
	 * @return ログイン画面
	 */
	@RequestMapping(value = "create")
	public String create(@Validated MemberForm form, 
			BindingResult result,
			Model model) {
		
		
		String mailAddres =form.getMailAddress();
		Member member = repository.findByEmail(mailAddres);
		if(member != null) {
			result.rejectValue("mailAddress", null,"このメールアドレスは既に使われております。");
			return form();
		}
		
		String password = form.getPassword();
		String checkPassword = form.getCheckPassword();
		if(!(password.equals(checkPassword))) {
			result.rejectValue("password", null,"同じパスワードを入力してください。");
			return form();
		}
		
		if (result.hasErrors()){
			return form();
		}
		
		Member member1 = new Member();
		BeanUtils.copyProperties(form, member1);
		memberService.save(member1);
		return "redirect:/";
	}
	
}
