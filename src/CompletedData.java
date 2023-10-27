import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompletedData extends Order{
    public CompletedData(int orderNum, List<String> orderItems, float totalOrderPrice, String orderRequest, LocalDateTime orderDateTime, LocalDateTime completedDateTime) {
        Order.orderNum = orderNum;
        this.orderItems = new ArrayList<>(orderItems);
        Order.totalOrderPrice = totalOrderPrice;
        this.orderRequest = orderRequest;
        this.orderDateTime = orderDateTime;
        this.completedDateTime = completedDateTime;
    }

    public CompletedData(int orderNum) {
    }
}
