package jp.co.rakus.stockmanagement.web;

import org.hibernate.validator.constraints.NotBlank;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * 
 * @author igamasayuki
 *
 */
public class MemberForm {
	
	/** 名前 */
	@NotBlank(message="名前の入力は必須です")
	private String name;
	
	/** メールアドレス */
	@NotBlank(message="メールアドレスを入力してください")
	//@Email(message="メールアドレスの形式が不正です")
	private String mailAddress;
	
	/** パスワード */
	@NotBlank(message="パスワードを入力してください")
	//@Size(min=4,max=12,message="パスワードは4文字以上12文字以内で入力してください")
	private String password;

	/** 確認用パスワード */
	private String checkPassword;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


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


	public String getCheckPassword() {
		return checkPassword;
	}


	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	
	
	
}
