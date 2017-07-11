package com.hanbit.lotto.controller;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoService service = new LottoServiceImpl();
		LottoBean lotto = null;
		while(true){
			switch(JOptionPane.showInputDialog("0.exit 1.create lotto")){
			case "0":
				return;
			case "1":
				lotto = new LottoBean();
				lotto.setMoney(Integer.parseInt(JOptionPane.showInputDialog("show me the money")));
				service.setLottos(lotto);
				int[][] lottos =service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
						System.out.println(lottos[i][j]);
					}
				}
				break;
			}
		}
	}
}
