package net.com.springmvc.entity;

import java.io.Serializable;

//@Entity
//@Table(name="login")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6078553903710596913L;

	// @Column(name="username")
	String username;
	// @Column(name="password")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

}
