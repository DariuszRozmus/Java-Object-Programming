package agh.ics.oop.model;

import java.util.*;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final List<Vector2d> positions;
    private int size;
    private final Random random = new Random();

    public RandomPositionGenerator(int width, int height) {
        positions = new ArrayList<>();
        for (int x = 0; x <= width; x++) {
            for (int y = 0; y <= height; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        size = positions.size();
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Vector2d next() {
                int i = random.nextInt(size);
                Vector2d pos = positions.get(i);
                Collections.swap(positions, i, size - 1);
                size--;
                return pos;
            }
        };
    }
}
