
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        int inputNum=100;
        menu.setMenu();
        product.setProduct();
        Loop:
        while (true) {
            menu.menuScreen();
            do {
                if(inputNum!=100)Menu.numError();
                inputNum = sc.nextInt();
            }while (inputNum<-2 || inputNum > Menu.menuMapSize);
            switch (inputNum){
                case 0 : order.showTotalSale(); break;
                case -1: break Loop;
                case -2 : menu.createMenu(menu,product); break;
                default: menu.selectMenu(inputNum,Menu.menuMapSize,menu,product,order);
            }
        }
    }


}
