package g56212.samegame.model;

/**
 * Block component that represents a colored block in the game.
 */
public class Block {

    private Color color;

    /**
     * Constructor of the block that needs a color to be initialised.
     *
     * @param color Color to initialize the block.
     */
    public Block(Color color) {
        this.color = color;
    }

    /**
     * Getter of the block's color.
     *
     * @return Color of the block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Equals method that compares 2 different blocks, by checking their colors that exists in COLOR enum.
     * If the colors are the same true is returned, if not false.
     *
     * @param block An other block to compare with.
     * @return Boolean
     */
    public boolean equals(Block block) {
        if (block == null) {
            throw new IllegalArgumentException("Block is null");
        }
        return this.color.equals(block.color);
    }

}
