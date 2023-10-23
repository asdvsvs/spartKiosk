import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Order extends Product {
    float totalOrderPrice;
    float totalSalePrice;
    static int orderNum=1;
    ArrayList<String> orders = new ArrayList<>();
    ArrayList<String> tempOrders = new ArrayList<>();
    ArrayList<String> totalOrders = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> menuCnt = new HashMap<String, Integer>();
    public Order(String menuName, float price, String explanation) {
        super(menuName, price, explanation);
    }

    public void addOrder(String menuName, float price, String explanation){
        if(menuCnt.get(menuName)==null) {
            menuCnt.put(menuName,1);
            orders.add(menuName+ " | " +price+ " |  "+menuCnt.get(menuName)+ "개 |  " +explanation);
            totalOrderPrice += price;
        }
        else {
            int cnt = menuCnt.get(menuName);
            menuCnt.put(menuName,++cnt);
            for (String s : orders){
                if(s.contains(menuName)){
                    orders.set(orders.indexOf(s),menuName+ " | " +price+ " |  "+menuCnt.get(menuName)+ "개 |  " +explanation);
                    totalOrderPrice += price;
                }
            }
        }
//        tempOrders.add(" - %5s   |   W %.1f ",menuName,price);
        tempOrders.add(" - "+menuName+" | W "+price);
    }

    public void showOrders(){
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

    public void orderComplete(){
        int second=3;
        if(sc.nextInt()==1){
            System.out.println("주문이 완료되었습니다!");
            System.out.printf("대기번호는 [ %d ] 번입니다.\n", Order.orderNum++);
            try {
                System.out.printf("(%d 초 후 메뉴판으로 돌아갑니다.)\n",second);
                System.out.print(second+", ");
                Thread.sleep(second*1000/3);
                System.out.print(second-1+", ");
                Thread.sleep(second*1000/3);
                System.out.println(second-2+" ");
                Thread.sleep(second*1000/3);

            }catch (Exception e){
                System.out.println("에러"+e);
            }
            orders.clear();
            totalOrders.addAll(tempOrders);
            totalSalePrice +=totalOrderPrice;
            totalOrderPrice = 0;
            menuCnt.clear();
            tempOrders.clear();
        }
    }

    public void orderCancel(){
        int num;
        System.out.println("---------------------------------------------------");
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        num = sc.nextInt();
        if(num ==1) {
            orders.clear();
            totalOrderPrice = 0;
            menuCnt.clear();
            tempOrders.clear();
        }
    }

    public void showTotalSale(){
        System.out.println("---------------------------------------------------");
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은[ W %.1f ] 입니다.\n\n",totalSalePrice);
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for (String s : totalOrders){
            System.out.println(s);
        }
        System.out.println("1.돌아가기");
        sc.nextInt();
    }


}
