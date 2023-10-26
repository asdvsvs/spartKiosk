
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int inputNum;
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        Manager manager = new Manager();

        menu.setMenu();
        product.setProduct();
        Loop:
        while (true) {
            menu.menuScreen();
            inputNum = sc.nextInt();
            while (inputNum < -3 || inputNum > Menu.menuMapSize) {
                Menu.numError();
                inputNum = sc.nextInt();
            }
            switch (inputNum) {
                case 0:
                    order.showTotalSale();
                    break;
                case -1:
                    break Loop;
                case -2:
                    menu.createMenu(menu, product);
                    break;
                case -3:
                    product.allProductScreen();
                    System.out.println("지울 id : ");
                    int removeId = sc.nextInt();
                    manager.deleteProduct(product.productMap,removeId);
                case -4:
                    break;
                default:
                    menu.selectMenu(inputNum, Menu.menuMapSize, menu, product, order);
            }
        }
    }
}
