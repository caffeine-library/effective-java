package org.caffein.library.efj.item1;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

/**
 * @author : jbinchoo
 * @since : 2022-07-05
 */
public class EnumSetDemo {
    public static void main(String[] args) {
        EnumSet<Game> fullSet = EnumSet.allOf(Game.class);
        assert Arrays.stream(Game.values())
                .filter(fullSet::contains)
                .count() == Game.values().length;

        EnumSet<Game> emptySet = EnumSet.complementOf(fullSet);
        assert emptySet.isEmpty();
    }

    private enum Game {
        A, B, C, D, E, F, G,
        H, I, J, K, L, M, N,
        O, P, Q, R, S, T, U,
        V, W, X, Y, Z;
    }
}
