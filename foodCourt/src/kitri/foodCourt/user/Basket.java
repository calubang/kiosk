package kitri.foodCourt.user;

import java.util.Iterator;
import java.util.List;

public interface Basket {
	
	//���� �޼ҵ�
	//�߰� : list�߰��� �ƴ϶� totalPrice�� savePoint ���� ���� ����
	public int add(BasketDetail detail);
	//����(index�� ����) : list������ �ƴ϶� totalPrice�� savePoint ���� ���� ����
	public BasketDetail remove(int index);
	//����(���ؼ� ����)
	//������ null ������ ������ ��ü
	public BasketDetail remove(BasketDetail detailRemove);
	//��� ���� : ��� 0����
	public int removeAll();
	
	public String getRequestNumber();
	public void setRequestNumber(String requestNumber);
	public String getPaymentDate();
	public void setPaymentDate(String paymentDate);
	public int getTotalPrice();
	public void setTotalPrice(int totalPrice);
	public int getSavePoint();
	public void setSavePoint(int savePoint);
	public List<BasketDetail> getDetailList();
	public void setDetailList(List<BasketDetail> detailList);
	
}