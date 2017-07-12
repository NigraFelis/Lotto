package com.hanbit.lotto.serviceImpl;


import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService{
	int[][] lottos;
	int[] lotto; //돈과 상관없이 생성되는 한 줄 숫자6 로또
	private int count;

	
	@Override
	public void setcount(LottoBean bean) {
		//몇 줄을 출력할것인가
		this.count=(bean.getMoney()/1000>=5)?5:bean.getMoney()/1000;
	}

	@Override
	public int getCount() {
		//해당 로또수만큼 출력
		return count;
	}
	
	@Override
	public void setLottos(LottoBean bean) {
		
		setcount(bean);
		lottos = new int[count][6];
		for(count=0; count<lottos.length; count++){
			for(int j=0; j<lottos[count].length; j++){
				int num=bean.getNumber();
				if(!isDuplication(count, num)){
					lottos[count][j]=num;
				}else{
					j--;
				}
			}
			sort(lottos[count]);
		}
	}

	@Override
	public int[][] getLottos() {
		// 만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		//중복된 번호인지 체크(중복이면 true 리턴)
		boolean flag = false;
		
		for(int i=0; i<lottos[count].length; i++){
			if(num==lottos[count][i]){
				flag = true;
				
			}
		}
		return flag;
	}

	@Override
	public void sort(int[] arr) {
		// 오름차순으로 정렬
		int temp = 0;
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	
}