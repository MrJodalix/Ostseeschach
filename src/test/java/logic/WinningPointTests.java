package logic;

import org.junit.Test;

import static logic.TestStone.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class WinningPointTests {
    @Test
    public void getPointByStapleOnTower () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2T,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] {0,0};
        int[] points2 = new int[] {1,0};
        Game game = new Game(field1, points1, new FakeGUI());

        Position pos = new Position(2,1);

        assertTrue(game.possiblePoint(new StoneHolder(Stone.ROBBE1), pos));
        game.turn(new Position(3,3), pos);
        assertArrayEquals(points2, game.getPoints());
    }

    @Test
    public void getPointByStapleFromTower () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1T,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] {0,0};
        int[] points2 = new int[] {1,0};
        Game game = new Game(field1, points1, new FakeGUI());

        Position pos = new Position(2,1);
        StoneHolder stone = new StoneHolder(Stone.ROBBE1);
        stone.setTower(true);

        assertTrue(game.possiblePoint(stone, pos));
        game.turn(new Position(3,3), pos);
        assertArrayEquals(points2, game.getPoints());
    }

    @Test
    public void getPointByEdge () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] {0,0};
        int[] points2 = new int[] {1,0};
        Game game = new Game(field1, points1, new FakeGUI());

        Position pos = new Position(2,0);

        assertTrue(game.possiblePoint(new StoneHolder(Stone.ROBBE1), pos));
        game.turn(new Position(3,2), pos);
        assertArrayEquals(points2, game.getPoints());
    }

    @Test
    public void getPointByEdgeOnRival () {
        TestStone[][] field1 = {
                {M,M,M,M,S2,M,M},
                {M,M,M,M,M1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] {0,0};
        int[] points2 = new int[] {1,0};
        Game game = new Game(field1, points1, new FakeGUI());
        Position pos = new Position(4,0);

        assertTrue(game.possiblePoint(new StoneHolder(Stone.MOEWE1), pos));
        game.turn(new Position(4,1), pos);
        assertArrayEquals(points2, game.getPoints());
    }

    @Test
    public void rivalWinning () {
        TestStone[][] field1 = {
                {M,M,M,M,S2,M,M},
                {M,M,M,M,M1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S1,M,M,M2,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M2,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[]{0, 2};
        int[] points2 = new int[]{0, 3};
        Game game = new Game(field1, points1, new FakeGUI());
        game.setCurrentPlayer(1);
        Position pos = new Position(5,6);

        assertTrue(game.possiblePoint(new StoneHolder(Stone.MOEWE1), pos));
        game.turn(new Position(5,5), pos);
        assertArrayEquals(points2, game.getPoints());
    }
}
