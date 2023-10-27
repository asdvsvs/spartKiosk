import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderData extends Order{

    public OrderData(int orderNum, List<String> orderItems, float totalOrderPrice, String orderRequest, LocalDateTime orderDateTime) {
        Order.orderNum = orderNum;
        this.orderItems = new ArrayList<>(orderItems);
        Order.totalOrderPrice = totalOrderPrice;
        this.orderRequest = orderRequest;
        this.orderDateTime = orderDateTime;

    }



}
