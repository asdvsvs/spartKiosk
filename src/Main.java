import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        Manager manager = new Manager();

        int inputNum=100;
        menu.setMenu();
        product.setProduct();
        Loop:
        while (true) {
            menu.menuScreen();
            inputNum = sc.nextInt();
            while (inputNum<-6 || inputNum > Menu.menuMapSize){
                Menu.numError();
                inputNum = sc.nextInt();
            }
            switch (inputNum){
                case 0 : order.showTotalSale(); break;
                case -1: break Loop;
                case -2 : menu.createMenu(menu,product); break;
                case -3:  manager.deleteProduct(menu,product); break ;
                case -4: manager.deleteProductById(menu,product); break ;
                case -5: order.orderData(); break ;
                case -6: order.completedData(); break ;
                default: menu.selectMenu(inputNum,Menu.menuMapSize,menu,product,order);
            }
        }
    }


}
