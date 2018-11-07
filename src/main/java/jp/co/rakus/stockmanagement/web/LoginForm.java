package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * ログイン関連のリクエストパラメータが入るフォーム.
 * 
 * @author igamasayuki
 *
 */
public class LoginForm {
	
	/** メールアドレス */
	@NotBlank(message = "メールアドレスを入力してください")
	//@Email(message="メールアドレスの形式が不正です")
	private String mailAddress;
	
	/** パスワード */
	@NotBlank(message = "パスワードを入力してください")
	//@Size(min=4,max=12,message="パスワードは4文字以上12文字以内で入力してください")
	private String password;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
