
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
            while (inputNum<-2 || inputNum>menu.getMenus("Main").size()){
                    Menu.numError();
                    inputNum = sc.nextInt();
            }
            switch (inputNum){
                case 0 : order.showTotalSale(); break;
                case -1: break Loop;
                case  -2 :
                    String menuName = setMenuName(menu, product);
                    System.out.println(menuName + "or Null");
                    Product newProduct = manager.createProduct();
                    product.addProduct(menuName, newProduct);
                    break;
                default: product.productScreen(menu.getMenus("Main"), inputNum);
            }


            if (1 <= inputNum && inputNum <= menu.getMenus("Main").size()) {
//                System.out.println("menu.getMenus(Main).size() :  " + menu.getMenus("Main").size());
                product.productScreen(menu.getMenus("Main"), inputNum);
            } else if (inputNum == menu.getMenus("Main").size() + 1) {
                order.showOrders();
                order.orderComplete();
            } else if (inputNum == menu.getMenus("Main").size() + 2) {
                order.orderCancel();
            } else if (inputNum == 0) {
                order.showTotalSale();
            } else if (inputNum == -1) {
                break Loop;
            } else if (inputNum == -2) {
                String menuName = setMenuName(menu, product);
                System.out.println(menuName + "or Null");
                Product newProduct = manager.createProduct();
                product.addProduct(menuName, newProduct);
            } else {
                Menu.numError();
            }
        }
    }

    private static String setMenuName(Menu menu, Product product) {
        System.out.println("[ 메뉴 목록 ]");
        List<Menu> mainMenus = menu.getMenus("Main");
        int num = 1;
        for (int i = 0; i < mainMenus.size(); i++) {
            System.out.println(num++ + ". " + mainMenus.get(i).menuName + "   | " + mainMenus.get(i).explanation);
        }
        System.out.println(mainMenus.size() + 1 + ". 신규 메뉴");
        System.out.print("메뉴 ID: ");
        Scanner scanner = new Scanner(System.in);
        int menuId = scanner.nextInt();
        if (menuId <= mainMenus.size()) {
            return menu.getMainMenuName(menuId);
        } else {
            System.out.print("신규 메뉴이름: ");
            String newMenuName = scanner.next();
            System.out.print("신규 메뉴설명: ");
            String newMenuDescription = scanner.next();
            menu.addMenu(newMenuName, newMenuDescription);
            product.putMenu(newMenuName);
            return newMenuName;
        }
    }
}
