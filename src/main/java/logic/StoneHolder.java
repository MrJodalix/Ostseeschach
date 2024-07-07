package logic;

public class StoneHolder {
    private Stone stone;
    private boolean tower;

    public StoneHolder(Stone stone) {
        this.stone = stone;
    }

    public Stone getStone() {
        return stone;
    }

    public StoneHolder setStone(Stone stone) {
        StoneHolder stoneHolder = new StoneHolder(stone);
        this.stone = stone;
        return stoneHolder;
    }

    public boolean getTower() {
        return tower;
    }

    public void setTower(boolean tower) {
        this.tower = tower;
    }
}
