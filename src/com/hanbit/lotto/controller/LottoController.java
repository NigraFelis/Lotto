package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
				StringBuffer buff=new StringBuffer();
				lotto.setMoney(Integer.parseInt(JOptionPane.showInputDialog("show me the money")));
				service.setLottos(lotto);
				int[][] lottos =service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
						//System.out.println(lottos[i][j]+"\t");
						buff.append(lottos[i][j]+"\t");
					}
					buff.append("/");
				}
				int lottoSerinalNo=(int)(Math.random()*99999+1000);
				File output = new File("C:\\Users\\1027\\JavaProgect\\workspace\\Lotto\\"+lottoSerinalNo+".txt");
											//C:\Users\1027\JavaProgect\workspace\Lotto
				FileWriter fw=null;
				BufferedWriter bw = null;
				String [] lottoPrint=buff.toString().split("/");
				try {
					bw=new BufferedWriter(new FileWriter(output));
					for(String s:lottoPrint){
						s+=System.getProperty("line.separator");
						bw.write(s);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				break;
				
				default:
					break;
			}
		}
	}
}
