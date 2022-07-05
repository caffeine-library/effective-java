package org.caffein.library.efj.item1;

import java.util.*;

/**
 * @author : jbinchoo
 * @since : 2022-07-05
 */
public class EnumSetBFS {

    private enum Node {
        A, B(A), C, D, E, F(A, E), G(C),
        H(E), I(B, D), J, K(F), L, M, N,
        O, P(I, H, J, K), Q(A,C), R, S, T, U,
        V(U), W(B), X, Y(S,T), Z(A,Y);

        private List<Node> adj;

        Node(Node... adj) {
            this.adj = new ArrayList<>(Arrays.asList(adj));
            for (Node v : adj) v.adj.add(this);
        }

        public List<Node> getAdj() {
            return this.adj;
        }
    }

    public static void main(String[] args) {
        for (Node u : Node.values())
            bfs(u);
    }

    private static void bfs(Node s) {
        EnumSet<Node> visit = EnumSet.noneOf(Node.class);
        LinkedList<Node> frontier = new LinkedList<>();

        frontier.add(s);
        visit.add(s);

        int step = 0;
        while (frontier.size() > 0) {
            int sz = frontier.size();
            while (sz-- > 0) {
                Node u = frontier.removeFirst();
                System.out.printf("Current(%s) %d steps from %s%n", u, step, s);
                for (Node v : u.getAdj()) {
                    if (!visit.contains(v)) {
                        visit.add(v);
                        frontier.add(v);
                    }
                }
            }
            step++;
        }
    }
}
