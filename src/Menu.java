
import java.util.*;


public class Menu {
    String menuName;
    String explanation;
    static int menuNum;
    static int idSeq = 1;
    int id;

    static int menuMapSize;


    private Map<String, List<Menu>> menus = new HashMap<>();

    public Menu() {}

    public Menu(String menuName, String explanation) {
        this.id = idSeq++;
        this.menuName = menuName;
        this.explanation = explanation;
    }

    public static void numError() {
        try {
            System.out.println("##번호 입력 오류!##");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMenu() {
        List<Menu> categoryMenu = new ArrayList<>();

        categoryMenu.add(new Menu("피자", "스파르타식 피자 (옵션 선택)"));
        categoryMenu.add(new Menu("사이드", "스파르타식 사이드"));
        categoryMenu.add(new Menu("음료", "스파르타식 음료"));

        menus.put("Main", categoryMenu);

        List<Menu> orderMenu = new ArrayList<>();

        orderMenu.add(new Menu("주문   ", "장바구니를 확인 후 주문합니다."));
        orderMenu.add(new Menu("취소   ", "진행중인 주문을 취소합니다."));

        menus.put("Order", orderMenu);

        Menu.menuMapSize=(int)getMenus("Main").size()+(int)getMenus("Order").size();
    }

    public void menuScreen() {
        Menu.menuNum = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("\"스파르타 피자 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ 스파르타 메뉴 ]");
        for (int i = 0; i < menus.get("Main").size(); i++) {
            System.out.printf("%d %s  |  %s\n", menuNum++, menus.get("Main").get(i).getMenuName(), menus.get("Main").get(i).getExplanation());
        }
        System.out.println("\n[ 오더 메뉴 ]");
        for (int i = 0; i < menus.get("Order").size(); i++) {
            System.out.printf("%d %s  |  %s\n", menuNum++, menus.get("Order").get(i).getMenuName(), menus.get("Order").get(i).getExplanation());
        }
        System.out.println();
        System.out.println("(0.총 판매), (-1. 키오스크 끄기), (-2. 상품생성 ), (-3. 상품삭제), (-4. id로 상품삭제)");
        System.out.print("메뉴 번호 입력 : ");
    }


    public String getMenuName() {
        return menuName;
    }

    public String getExplanation() {
        return explanation;
    }

    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    public String getMainMenuName(int id) {
        List<Menu> mainMenus = menus.get("Main");
        for (Menu mainMenu : mainMenus) {
            if (mainMenu.id == id) {
                return mainMenu.menuName;
            }
        }
        return "";
    }

    public void addMenu(String key, String explanation) {
        menus.get("Main").add(new Menu(key, explanation));
    }

    public String setMenuName(Menu menu, Product product) {
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
    public void createMenu(Menu menu, Product product){
        Manager manager = new Manager();
        String menuName = menu.setMenuName(menu, product);
        System.out.println(menuName+" 가 추가 되었습니다");
        Product newProduct = manager.createProduct();
        product.addProduct(menuName, newProduct);
        Menu.menuMapSize=(int)getMenus("Main").size()+(int)getMenus("Order").size();
    }

    public void deleteMenu(Product product){
        for (String s : product.productMap.keySet()){
            if(product.productMap.get(s).isEmpty())
                for (int i=0;i<menus.get("Main").size();i++)
                {
                    if(menus.get("Main").get(i).menuName.equals(s)){
                        menus.get("Main").remove(i);
                        break;
                    }
                }
        }
        Menu.menuMapSize=(int)getMenus("Main").size()+(int)getMenus("Order").size();
    }

    public void selectMenu(int inputNum, int menuMapSize,Menu menu,Product product,Order order){
        if(inputNum==menuMapSize-1){
            order.showOrders();
            order.orderComplete();
        }
        else if(inputNum==menuMapSize){
            order.orderCancel();
        }
        else product.productScreen(menu.getMenus("Main"), inputNum);
    }
}
