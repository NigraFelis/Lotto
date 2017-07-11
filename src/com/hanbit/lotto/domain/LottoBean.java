package com.hanbit.lotto.domain;

public class LottoBean {
	private int money, number;

	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}

	
	public void setNumber() {
		this.number = (int)(Math.random()*45+1);
	}
	public int getNumber() {
		setNumber();
		return number;
	}
	
}
