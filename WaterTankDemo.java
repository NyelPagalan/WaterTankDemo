
package waterTank;

    class WaterTank {

    private String name;
    private int[] bucket;
    private int top;

    // =========================================
    // NO-ARGUMENT CONSTRUCTOR
    // =========================================
    public WaterTank() {
        this.name = "Standard Tank";
        this.bucket = new int[5];
        this.top = -1;

        System.out.println(name + " created no-argument constructor");
    }

    // =========================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================
    public WaterTank(String name, int capacity) {
        this.name = name;
        this.bucket = new int[capacity];
        this.top = -1;

        System.out.println(name + ": Holds " + capacity + " buckets.");
    }

    // =========================================
    // POUR WATER
    // =========================================
    public void pour(int liters) {
        if (top == bucket.length - 1) {
            System.out.println("OVERFLOW! " + name
                    + " is full. " + liters
                    + "L spilled on the floor!");
            return;
        }

        top++;
        bucket[top] = liters;

        System.out.println("Poured " + liters + "L into " + name);
    }

    // =========================================
    // DRAIN WATER
    // =========================================
    public int drain() {
        if (isEmpty()) {
            System.out.println("UNDERFLOW! " + name + " is empty.");
            return 0;
        }

        int liters = bucket[top];
        bucket[top] = 0;
        top--;

        System.out.println("Drained " + liters + "L from " + name);
        return liters;
    }

    // =========================================
    // CHECK TOP BUCKET
    // =========================================
    public int checkTop() {
        if (isEmpty()) {
            System.out.println(name + " is empty.");
            return 0;
        }

        return bucket[top];
    }

    // =========================================
    // CHECK IF EMPTY
    // =========================================
    public boolean isEmpty() {
        return top == -1;
    }

    // =========================================
    // COUNT BUCKETS
    // =========================================
    public int bucketCount() {
        return top + 1;
    }

    // =========================================
    // CALCULATE TOTAL LITERS
    // =========================================
    public int totalLiters() {
        int total = 0;

        for (int i = 0; i <= top; i++) {
            total += bucket[i];
        }

        return total;
    }

    // =========================================
    // MAIN DEMO
    // =========================================
    public static class WaterTankDemo {

        public static void main(String[] args) {

            System.out.println("========================================");
            System.out.println("           WATER TANK SYSTEM");
            System.out.println("========================================");

            // -------------------------------------
            // STANDARD TANK
            // -------------------------------------
            System.out.println("\n========== STANDARD TANK ================");

            WaterTank tank1 = new WaterTank();

            tank1.pour(10);
            tank1.pour(20);
            tank1.pour(15);

            System.out.println("----------------------------------------");
            System.out.println("Top bucket: " + tank1.checkTop() + "L");

            tank1.drain();

            System.out.println("Buckets left: " + tank1.bucketCount());
            System.out.println("Total water: " + tank1.totalLiters() + "L");

            // -------------------------------------
            // MINI TANK
            // -------------------------------------
            System.out.println("\n============== MINI TANK ===============");

            WaterTank tank2 = new WaterTank("Mini Tank", 3);

            tank2.pour(5);
            tank2.pour(10);
            tank2.pour(15);
            tank2.pour(20);

            System.out.println("----------------------------------------");
            System.out.println("Top bucket: " + tank2.checkTop() + "L");
            System.out.println("Buckets: " + tank2.bucketCount());
            System.out.println("Total water: " + tank2.totalLiters() + "L");

            // Drain all buckets
            System.out.println("\n----------- DRAINING MINI TANK ----------");

            tank2.drain();
            tank2.drain();
            tank2.drain();
            tank2.drain();

            System.out.println("----------------------------------------");
            System.out.println("Is the tank empty? " + tank2.isEmpty());
            System.out.println("Buckets left: " + tank2.bucketCount());
            System.out.println("Total water: " + tank2.totalLiters() + "L");

            System.out.println("========================================");
            System.out.println("             PROGRAM END");
            System.out.println("========================================");
        }
    }
}
