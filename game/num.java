package game;

public enum num {

    monk("Монах"), crossbowman("Арбалетчик"), peasant("Крестьянин"),
    rogue("Разбойник"), sniper("Снайпер"), wizard("Волшебник"),
    spearman("Копьеносец");


    private String name;

    num(String name) {this.name = name;}


    public String getName() {return name;}

}
