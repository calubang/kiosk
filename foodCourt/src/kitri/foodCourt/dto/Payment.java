package kitri.foodCourt.dto;

import java.util.Iterator;

public interface Payment {
	
	//구현 메소드
	//추가 : list추가뿐 아니라 totalPrice와 savePoint 값도 같이 더함
	public int add(PaymentDetailDto detail);
	//삭제(index로 삭제) : list삭제뿐 아니라 totalPrice와 savePoint 값도 같이 삭제
	public PaymentDetailDto remove(int index);
	//삭제(비교해서 삭제)
	//없으면 null 있으면 삭제한 객체
	public PaymentDetailDto remove(PaymentDetailDto detailRemove);
	//모두 삭제 : 모두 0으로
	public int removeAll();
	
	
}
