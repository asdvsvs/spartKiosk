import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum;

        Loop :
        while (true) {
            Menu.setMenu();
            Menu.menuScreen();

            inputNum = sc.nextInt();
            if(inputNum<-1 || 5<inputNum) {
                Menu.numError();
                continue;
            }
            switch (inputNum){
                case 1,2,3 :
                    Product.setProduct(inputNum);
                    Product.productScreen();
                    break;
                case 4 :
                    Order.showOrders();
                    Order.orderComplete();
                    break;
                case 5 : Order.orderCancel();break;
                case 0 : Order.showTotalSale();break;
                case -1 : break Loop;
            }

        }

    }
}