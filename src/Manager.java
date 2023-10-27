
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {

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

    public void deleteProduct(Map<String, List<Product>> productMap, int productId) {
        int removeindex = -1;
        for(Map.Entry<String,List<Product>> entry : productMap.entrySet()){
            for (int i = 0; i < entry.getValue().size(); i++) {
                if(entry.getValue().get(i).id == productId){
                    removeindex = i;
                }
            }
            if(removeindex != -1){
                entry.getValue().remove(removeindex);
            }
        }
        System.out.println("상품이 삭제되었습니다.");
    }
}
