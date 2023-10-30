import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompletedData extends Order{
    public CompletedData(int completedNum, List<String> completedDatas, float completedTotalPrices, String orderRequest, LocalDateTime orderDateTime, LocalDateTime completedDateTime) {
        Order.completedNum = completedNum;
            System.out.println("주문 번호: " +completedNum);

        Order.completedDatas = new ArrayList<>(completedDatas);
            System.out.println("주문 항목: " +completedDatas);

        Order.completedTotalPrices = completedTotalPrices;
            System.out.println("총 가격: W" +completedTotalPrices);

        this.orderRequest = orderRequest;
            System.out.println("주문 요청 사항: " +orderRequest);

        this.orderDateTime = orderDateTime;
            System.out.println("주문 날짜와 시간: " +orderDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        this.completedDateTime = completedDateTime;
            System.out.println("완료 날짜와 시간: " +completedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }

}
