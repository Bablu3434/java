class Parameterized  {
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

        Parameterized  s1 = new Parameterized ();
        Parameterized  s2 = new Parameterized ();

        s1.add(10, 40);
        s2.add(45, 30);

        sum1 = s1.addTwo();
        sum2 = s2.addTwo();

        System.out.println("a+b = " + sum1);
        System.out.println("a+b = " + sum2);
    }
}