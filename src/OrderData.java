import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderData extends Order{

    public OrderData (int orderDateNum, List<String> orderData, float totalOrderPrice, String orderRequest, LocalDateTime orderDateTime) {
        this.orderDateNum = orderDateNum;
        this.orderDatas = new ArrayList<>(orderData);
        this.totalPrices = totalOrderPrice;
        this.orderRequest = orderRequest;
        this.orderDateTime = orderDateTime;
    }
    public void showData(){
        System.out.println("주문 번호: " + orderDateNum);
        System.out.println("주문 항목: " + orderDatas);
        System.out.printf("총 가격: W %.1f\n" , totalPrices);
        System.out.println("주문 요청 사항: " + orderRequest);
        System.out.println("주문 날짜와 시간: " + orderDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }




}
