import java.time.LocalDateTime;
import java.util.*;

public class Order extends Product {
    LocalDateTime orderDateTime;
    LocalDateTime completedDateTime =  LocalDateTime.now(); //완료 처리 시간
    static float totalOrderPrice;
    static float totalSalePrice;
    float totalPrices; // 주문의 총 금액을 저장하여 저장데이터로 옮겨주는 정적 변수
    static float completedTotalPrices; // 주문데이터 총금액을 저장하여 완료데이터로 옮겨주는 정적 변수
    static int orderNum = 1;
    int orderDateNum;
    static int completedNum;

    static ArrayList<String> orders = new ArrayList<>();
    static ArrayList<String> tempOrders = new ArrayList<>();
    static ArrayList<String> totalOrders = new ArrayList<>();
    ArrayList<String> orderDatas = new ArrayList<>(); //주문데이터 목록을 저장하는 동적 배열
    static ArrayList<String> completedDatas = new ArrayList<>();//완료데이터 목록을 저장하는 동적 배열

    Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> menuCnt = new HashMap<>();
    String orderRequest; // 주문 요청 사항을 저장하는 변수
    List<OrderData> orderData = new ArrayList<>();
    List<OrderData> completedOrder = new ArrayList<>();
    public Order() {
    }

    public Order(String menuName, float price, String explanation) {
        super(menuName, price, explanation);
    }

    public void addOrder(String menuName, float price, String explanation) {
        if (menuCnt.get(menuName) == null) {
            menuCnt.put(menuName, 1);
            orders.add(menuName + " | " + price + " |  " + menuCnt.get(menuName) + "개 |  " + explanation);
            totalOrderPrice += price;
        } else {
            int cnt = menuCnt.get(menuName);
            menuCnt.put(menuName, ++cnt);
            for (String s : orders) {
                if (s.contains(menuName)) {
                    orders.set(orders.indexOf(s), menuName + " | " + price + " |  " + menuCnt.get(menuName) + "개 |  " + explanation);
                    totalOrderPrice += price;
                }
            }
        }
        tempOrders.add(" - " + menuName + " | W " + price);
    }

    public void showOrders() {
        System.out.println("---------------------------------------------------");
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ 장바구니 ]");
        for (String s : orders) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.1f \n ", totalOrderPrice);
        System.out.println();
        System.out.println("1. 주문       2. 메뉴판");
    }

    public void orderComplete() {
        int second = 3;
        if (sc.nextInt() == 1) {
            System.out.println("주문 요청사항을 입력해주세요.");
            sc.nextLine();
            orderRequest = sc.nextLine(); // 주문 요청사항 입력 받음
            System.out.println("주문 요청사항: " + orderRequest);
            System.out.println("주문이 완료되었습니다!");
            System.out.printf("대기번호는 [ %d ] 번입니다.\n", Order.orderNum);
            try {
                System.out.printf("(%d 초 후 메뉴판으로 돌아갑니다.)\n", second);
                System.out.print(second + ", ");
                Thread.sleep(second * 1000 / 3);
                System.out.print(second - 1 + ", ");
                Thread.sleep(second * 1000 / 3);
                System.out.println(second - 2 + " ");
                Thread.sleep(second * 1000 / 3);

            } catch (Exception e) {
                System.out.println("에러" + e);
            }
            orderDateTime = LocalDateTime.now();
            orderData.add(new OrderData(orderNum, tempOrders, totalOrderPrice, orderRequest, orderDateTime));
            orders.clear();
            orderNum++;
            totalOrders.addAll(tempOrders);
            totalSalePrice += totalOrderPrice;
            totalOrderPrice = 0;
            menuCnt.clear();
            tempOrders.clear();
        }
    }

    public void orderCancel() {
        int num;
        System.out.println("---------------------------------------------------");
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        num = sc.nextInt();
        if (num == 1) {
            orders.clear();
            totalOrderPrice = 0;
            menuCnt.clear();
            tempOrders.clear();
        }
    }

    public void showTotalSale() {
        System.out.println("---------------------------------------------------");
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은[ W %.1f ] 입니다.\n\n", totalSalePrice);
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for (String s : totalOrders) {
            System.out.println(s);
        }
        System.out.println("1.돌아가기");
        sc.nextInt();
    }

    public void orderData() {
        for (int i=0; i<orderData.size();i++){
            System.out.println("---------------------------------------------------");
            System.out.println("[ 대기 주문 목록 ]");
            orderData.get(i).showData();
        }
        System.out.println("\n0.돌아가기");
        System.out.println("1.맨위에 주문 완료처리 ");
        if (sc.nextInt() == 1) {
            completedOrder.add(orderData.get(0));
            orderData.remove(0);
        }
    }

    public void completedData() {
        System.out.println("---------------------------------------------------");
        System.out.println("[ 완료 주문 목록 ]");
        for (int i=0; i<completedOrder.size();i++){
            System.out.println("*******        *******");
            completedOrder.get(i).showData();
        }
        System.out.println("\n1.돌아가기");
        sc.nextInt();
    }

    public void showOrderStatus() {
        System.out.println("---------------------------------------------------");
        System.out.println("[ 최근 완료 주문 ]");
        if(completedOrder.isEmpty()) System.out.println("완료된 주문이 없습니다\n");
        for (int i = completedOrder.size()-1; i>=0 &&i >completedOrder.size()-4; i--) {
            completedOrder.get(i).showData();
            System.out.println("---------------------------------------------------");
        }
        System.out.println("---------------------------------------------------");
        System.out.println("[ 대기 중인 모든 주문 ]");
        for (int i=0; i<orderData.size();i++){
            orderData.get(i).showData();
            System.out.println("---------------------------------------------------");
        }
        System.out.println("\n1.돌아가기");
        sc.nextInt();
    }
}