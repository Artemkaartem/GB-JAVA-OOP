package game;

public class monk extends units {

    public monk() {
        super(100, 5, 30, 0, 30, "monk", 7);
        
    }
    public monk(String name) {
        super(100, 5, 30, 70, 30, name, 7);
    }

    @Override
    String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step() {
        super.step();
    }
}
