public class MathUtilsTest {
    @BeforeSuite
    public void init() {
        System.out.println("Инициализация тестовой среды...");
    }

    @Test(order = 1)
    public void testAddition() {
        int result = MathUtils.add(5, 3);
        assertResult(result, 8, "testAddition");
    }

    @Test(order = 2)
    public void testSubtraction() {
        int result = MathUtils.subtract(10, 4);
        assertResult(result, 6, "testSubtraction");
    }

    @Test // order по умолчанию = Integer.MAX_VALUE
    public void testMultiplication() {
        int result = MathUtils.multiply(2, 5);
        assertResult(result, 10, "testMultiplication");
    }

    @AfterSuite
    public void cleanup() {
        System.out.println("Очистка тестовой среды...");
    }

    private void assertResult(int actual, int expected, String testName) {
        if (actual == expected) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed. Expected: " + expected + ", Actual: " + actual);
        }
    }
}
