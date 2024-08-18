public interface I1 {
    void fun1();
    void fun();
}

public interface I2 {
    void fun2();
    void fun();
}

public interface I extends I1, I2 {
}

public class C implements I {
    @Override
    public void fun1() {

    }

    @Override
    public void fun2() {

    }

    @Override
    public void fun() {

    }
}

/**------------------------------------------------------------------------------------------- */

public class Car implements Comparable<Car> {
    int Price;
    int Speed;

    @Override
    public int compareTo(Car car){
        return this.Price - car.Price;
    }
}

/**------------------------------------------------------------------------------------------- */
