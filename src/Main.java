
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        Manager manager = new Manager();
        int inputNum;
        menu.setMenu();
        product.setProduct();
        Loop:
        while (true) {
            menu.menuScreen();
            inputNum = sc.nextInt();
            if (inputNum == menu.getMenus("Main").size() + 1) {
                order.showOrders();
                order.orderComplete();
            } else if (inputNum == menu.getMenus("Main").size() + 2) {
                order.orderCancel();
            }
            switch (inputNum) {
                case 0:
                    order.showTotalSale();
                    break;
                case -1:
                    break Loop;
                case -2:
                    String menuName = Manager.setMenuName(menu, product);
                    Product newProduct = manager.createProduct();
                    product.addProduct(menuName, newProduct);
                    break;
                default:
                    product.productScreen(menu.getMenus("Main"), inputNum);
            }

//            if (1 <= inputNum && inputNum <= menu.getMenus("Main").size()) {
//                product.productScreen(menu.getMenus("Main"), inputNum);
//            } else if (inputNum == menu.getMenus("Main").size() + 1) {
//                order.showOrders();
//                order.orderComplete();
//            } else if (inputNum == menu.getMenus("Main").size() + 2) {
//                order.orderCancel();
//            } else if (inputNum == 0) {
//                order.showTotalSale();
//            } else if (inputNum == -1) {
//                break Loop;
//            } else if (inputNum == -2) {
//                String menuName = Manager.setMenuName(menu, product);
//                Product newProduct = manager.createProduct();
//                product.addProduct(menuName, newProduct);
//            } else {
//                Menu.numError();
//            }
//        }
        }
    }
}

