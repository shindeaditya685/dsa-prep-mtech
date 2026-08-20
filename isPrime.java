class Codechef
{
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int n = 49;
        boolean result = isPrime(n);
        System.out.println(result); // correctly prints false
    }
}
