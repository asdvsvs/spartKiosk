import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu("", "");
        Product product = new Product("",0,"");
        Order order = new Order("", 0, "");
        int inputNum;
        Loop :
        while (true) {
            menu.setMenu();
            menu.menuScreen();

            inputNum = sc.nextInt();
            if(inputNum<-1 || 5<inputNum) {
                Menu.numError();
                continue;
            }
            switch (inputNum){
                case 1,2,3 :
                    product.setProduct(inputNum);
                    product.productScreen();
                    break;
                case 4 :
                    order.showOrders();
                    order.orderComplete();
                    break;
                case 5 : order.orderCancel();break;
                case 0 : order.showTotalSale();break;
                case -1 : break Loop;


            }

        }

    }
}