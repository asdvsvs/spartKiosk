import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderData extends Order{

    public OrderData (int orderDateNum, List<String> orderDatas, float totalOrderPrice, String orderRequest, LocalDateTime orderDateTime) {
        Order.orderDateNum = orderDateNum;
            System.out.println("주문 번호: " +orderDateNum);

        Order.orderDatas = new ArrayList<>(orderDatas);
            System.out.println("주문 항목: " +orderDatas);

        Order.totalOrderPrice = totalOrderPrice;
            System.out.println("총 가격: W" +totalOrderPrice);

        this.orderRequest = orderRequest;
            System.out.println("주문 요청 사항: " +orderRequest);

        this.orderDateTime = orderDateTime;
            System.out.println("주문 날짜와 시간: " +orderDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));


    }




}
