package pojo;

public class Customer {
	//封装和数据库中字段同个数（对应）的属性
	private int account;
	private String password;
	private String cname;
	private double cbalance;
	
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCbalance() {
		return cbalance;
	}
	public void setCbalance(double cbalance) {
		this.cbalance = cbalance;
	}

}
