import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        int menuId;

        menu.setMenu();
        product.setProduct();
        Loop :
        while (true) {
            menu.menuScreen();
            menuId = sc.nextInt();
            if(menuId<-1 || 7<menuId) {
                Menu.numError();
                continue;
            }
            switch (menuId){
                case 1,2,3 :
                    product.selectMenu(menuId);
                    product.inputNum(menuId);
                    break;
                case 4 :
                    order.showOrders();
                    order.orderComplete();
                    break;
                case 5 : order.orderCancel();break;
                case 6 : product.createProduct();break;
                case 7 : menu.deleteMenu();break;
                case 0 : order.showTotalSale();break;
                case -1 : break Loop;
            }
        }
    }
}