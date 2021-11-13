package g56212.samegame.model;

public class Block {
    private Color color;

    public Block(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean equals(Block block) {
        if (block == null) {
            throw new IllegalArgumentException("Block is null");
        }
        return this.color.equals(block.color);
    }

}
