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
            if (inputNum == -2) {
                int managerInputNum = manager.managerScreen();
                while(!(0<= managerInputNum && managerInputNum <= 4)){
                    Menu.numError();
                    managerInputNum = manager.managerScreen();
                }
                switch (managerInputNum) {
                    case 0: break;
                    case 1: order.orderData(); break ;
                    case 2 : order.completedData(); break ;
                    case 3: menu.createMenu(menu, product);break;
                    case 4: manager.deleteProductById(menu, product);break;
                }
            }
            else {
                switch (inputNum) {
                    case 0: order.showTotalSale();break;
                    case -1: break Loop;
                    case -3 : order.showOrderStatus();break;
                    default: menu.selectMenu(inputNum, Menu.menuMapSize, menu, product, order);
                }
            }
        }
    }
}