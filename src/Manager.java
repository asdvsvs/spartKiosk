
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    Menu menu = new Menu();
    Product product = new Product();


    public void managerScreen() {
        int inputNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("[ 관리자 메뉴 ]");
        System.out.println("어떤 작업을 수행하시겠습니까?");
        System.out.println("1. 대기주문 목록");
        System.out.println("2. 완료주문 목록");
        System.out.println("3. 상품 생성");
        System.out.println("4. 상품 삭제");
        System.out.println("0. 돌아가기");

    }

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 설정 : ");
        String menuName = sc.nextLine();

        System.out.println("설명 설정 : ");
        String explanation = sc.nextLine();

        System.out.println("가격 설정 : ");
        float price = sc.nextFloat();

        return new Product(menuName, price, explanation);
    }

    public static String setMenuName(Menu menu, Product product) {
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

    public void deleteProductById(Menu menu, Product product) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("상품 id로 삭제하기");
        for (List<Product> p : product.productMap.values()) {
            for (int i = 0; i < p.size(); i++) System.out.println(p.get(i).menuName + p.get(i).id);
        }
        System.out.print("삭제할 id 입력: ");
        int inputId = sc.nextInt();
        for (List<Product> p : product.productMap.values())
            for (int i = 0; i < p.size(); i++) {
                if (inputId == p.get(i).id) p.remove(i);
                break;
            }
        System.out.println("삭제완료");
        menu.deleteMenu(product);
    }

}
