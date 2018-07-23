package com.zhuziym.char03;
/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 上午9:30:02
 *
 */
public class Client38   {

	private String name;
	private Home home;
	
	
	public static class Home{
		private String address;
		private String tel;
		public Home(String address, String tel) {
			this.address = address;
			this.tel = tel;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Home getHome() {
		return home;
	}


	public void setHome(Home home) {
		this.home = home;
	}


	public Client38(String name) {
		this.name = name;
		
	}
	public static void main(String[] args) {
		Client38  p = new Client38("李四");
		p.setHome(new Home("shangxi","1234"));
	}
}
