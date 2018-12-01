public class Recursia {

    public static void main(String[] args) {
        System.out.println(facto(5));
    }

    public static int facto(int n){
        if (n==0){
            return 1;
        }
        System.out.println(n);
        return n*facto(n-1);
    }
}
