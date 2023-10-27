
import java.util.*;

public class Product extends Menu {
    float price;

    public Map<String, List<Product>> productMap = new HashMap<>();

    public Product() {
    }

    public Product(String menuName, float price, String explanation) {
        super(menuName, explanation);
        this.price = price;
    }

    public void selectProduct(String productName, float price, String explanation) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order("", 0, "");
        Product product = new Product(productName, price, explanation);
        if (product.getMenuName().contains("피자")) {    /* <--이렇게도 가능--> if(productName.contains("피자"))*/
            Loop:
            while (true) {
                System.out.println("---------------------------------------------------");
                System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum, product.menuName, product.price, explanation);
                System.out.println("    위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                System.out.printf("\t1.기본(W %.1f)\t2.치즈 추가(+W 2.0)\t3.토핑 추가(+W 3.0)\n", price);
                int inputNum = sc.nextInt();
                if (inputNum < 1 || 3 < inputNum) {
                    numError();
                    continue;
                }
                switch (inputNum) {
                    case 1:
                        product.menuName = productName + "(기본)     ";
                        product.price = price;
                        break Loop;
                    case 2:
                        product.menuName = productName + "(치즈 추가)";
                        product.price = price + 2;
                        break Loop;
                    case 3:
                        product.menuName = productName + "(토핑 추가)";
                        product.price = price + 3;
                        break Loop;
                }
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum, product.menuName, product.price, explanation);
        System.out.println("\t위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("\t1.확인        2.취소");
        if (sc.nextInt() == 1) {
            order.addOrder(product.menuName, product.price, product.explanation);
            System.out.println("장바구니에 추가 되었습니다.");
        }
    }

    public float getPrice() {
        return price;
    }

    public void setProduct() { //입출력 값 바꾸기
        List<Product> pizzaProductList = new ArrayList<>();
        pizzaProductList.add(new Product("햄피자    ", 10.9f, "햄이 들어간 피자"));
        pizzaProductList.add(new Product("치즈피자  ", 9.9f, "치즈가 들어간 피자"));
        pizzaProductList.add(new Product("감자피자  ", 12.9f, "감자가 들어간 피자"));
        pizzaProductList.add(new Product("고구마피자 ", 13.9f, "고구마가 들어간 피자"));
        productMap.put("피자", pizzaProductList);

        List<Product> sideProductList = new ArrayList<>();
        sideProductList.add(new Product("감자튀김            ", 4.9f, "구운 감자튀김"));
        sideProductList.add(new Product("크림스파게티         ", 8.9f, "크림소스가 들어간 스파게티"));
        sideProductList.add(new Product("너겟                ", 2.9f, "구운 너겟"));
        sideProductList.add(new Product("토마토스파게티        ", 7.9f, "토마토소스가 들어간 스파게티"));
        productMap.put("사이드", sideProductList);

        List<Product> beverageProductList = new ArrayList<>();
        beverageProductList.add(new Product("콜라                ", 2.9f, "코카콜라"));
        beverageProductList.add(new Product("사이다              ", 2.9f, "스프라이트"));
        beverageProductList.add(new Product("환타                ", 2.9f, "오렌지 환타"));
        beverageProductList.add(new Product("제로콜라            ", 2.9f, "제로 코카콜라"));
        productMap.put("음료", beverageProductList);
    }

    public void productScreen(List<Menu> menuList, int inputNum) {
        Scanner sc = new Scanner(System.in);
        Menu.menuNum = 1;
        String type = menuList.get(inputNum - 1).getMenuName();
        System.out.println("---------------------------------------------------");
        System.out.println("[ " + type + " 메뉴 ]");
        if (productMap.get(type).isEmpty()) {
            System.out.println(" 준비된 메뉴가 없습니다. ");
//            ???
        }
        for (int i = 0; i < productMap.get(type).size(); i++) {
            System.out.printf("%d %-10s \t  \t| W %.1f \t|\t%s\n", menuNum++, productMap.get(type).get(i).menuName, productMap.get(type).get(i).price, productMap.get(type).get(i).explanation);
        }
        System.out.println();
        System.out.print("메뉴 번호 입력 : ");

        int productNum;
        while (true) {
            productNum = sc.nextInt();
            if (0 < productNum && productNum <= productMap.get(type).size()) break;
            else numError();
        }
        Menu.menuNum = productNum;
        selectProduct(productMap.get(type).get(productNum - 1).menuName, productMap.get(type).get(productNum - 1).price, productMap.get(type).get(productNum - 1).explanation);
    }

    public void addProduct(String key, Product newProduct) {
        productMap.get(key).add(newProduct);
    }

    public void putMenu(String key) {
        productMap.put(key, new ArrayList<>());
    }

    public void allProductScreen() {
        System.out.println("[ 전체 상품 ]");
        for (String key : productMap.keySet()) {
            System.out.println("[ " + key + " 메뉴 ]");
            for (Product products : productMap.get(key)) {
                System.out.printf("%d. %-10s | %.1f | %s\n", products.id, products.menuName, products.getPrice(), products.getExplanation());
            }
        }
    }
}
