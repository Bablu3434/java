class Sum {
    int a;
    int b;

    // Parameterized function
    void add(int x, int y) {
        a = x;
        b = y;
    }

    // Function to calculate sum
    int addTwo() {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {

        int sum1, sum2;

        Sum s1 = new Sum();
        Sum s2 = new Sum();

        s1.a = 10;
        s1.b = 40;

        s2.a = 45;
        s2.b = 30;

        sum1 = s1.a + s1.b;
        sum2 = s2.a + s2.b;

        System.out.println("a+b = " + sum1);
        System.out.println("a+b = " + sum2);
    }
}