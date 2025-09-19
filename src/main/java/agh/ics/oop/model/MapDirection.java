package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static final Vector2d[] unitVectors = {
        new Vector2d(0, 1),
        new Vector2d(1, 0),
        new Vector2d(0, -1),
        new Vector2d(-1, 0)
    };

    public Vector2d toUnitVector() {
        return unitVectors[this.ordinal()];
    }

    public MapDirection next(){
        int nextOrdinal = (ordinal() + 1) % values().length;
        return values()[nextOrdinal];
    }

    public MapDirection previous(){
        int nextOrdinal = (ordinal() - 1 +values().length) % values().length;
        return values()[nextOrdinal];
    }

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "Polnoc";
            case EAST -> "Wschod";
            case SOUTH -> "Poudnie";
            case WEST -> "Zachod";
        };
    }

}

