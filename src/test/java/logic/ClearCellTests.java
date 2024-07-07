package logic;

import org.junit.Test;

import static logic.TestStone.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ClearCellTests {
    private void testTwoFields (Game expected, Game actual){
        for (int x = 0; x < actual.getFIELDWIDTHLENGTH(); x++) {
            for (int y = 0; y < actual.getFIELDWIDTHLENGTH(); y++) {
                assertEquals(expected.getGameField()[x][y].getStone(), actual.getGameField()[x][y].getStone());
            }
        }
    }
    @Test
    public void getEmptyFieldByEdgeOnRival () {
        TestStone[][] field1 = {
                {M,M,M,M,S2T,M,M},
                {M,M,M,M,M1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] { 0, 0 };
        int[] points2 = new int[] { 1, 0 };
        Game game1 = new Game(field1, points1, new FakeGUI());
        Game game2 = new Game(field2, points1, new FakeGUI());

        game1.turn(new Position(4,1), new Position(4,0));
        testTwoFields(game2, game1);
        assertArrayEquals(points2, game1.getPoints());
    }

    @Test
    public void getEmptyFieldByEdge () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] { 0, 0 };
        int[] points2 = new int[] { 1, 0 };
        Game game1 = new Game(field1, points1, new FakeGUI());
        Game game2 = new Game(field2, points1, new FakeGUI());

        game1.turn(new Position(4,1), new Position(4,0));
        testTwoFields(game2, game1);
        assertArrayEquals(points2, game1.getPoints());
    }

    @Test
    public void getEmptyFieldByEdgeAI () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M2,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] { 0, 0 };
        int[] points2 = new int[] { 1, 0 };
        Game game1 = new Game(field1, points1, new FakeGUI());
        Game game2 = new Game(field2, points1, new FakeGUI());
        game1.setCurrentPlayer(1);
        game1.turn(new Position(5,5), new Position(5,6));
        testTwoFields(game2, game1);
        assertArrayEquals(points2, game1.getPoints());
    }

    @Test
    public void getEmptyFieldByBuild () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,M,M1T,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };

        int[] points1 = new int[] { 0, 0 };
        int[] points2 = new int[] { 1, 0 };
        Game game1 = new Game(field1, points1, new FakeGUI());
        Game game2 = new Game(field2, points1, new FakeGUI());

        game1.turn(new Position(3,3), new Position(3,2));
        testTwoFields(game2, game1);
        assertArrayEquals(points2, game1.getPoints());
    }

    @Test
    public void getEmptyFieldByBuildAi () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,M,M1T,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points1 = new int[] { 0, 0 };
        int[] points2 = new int[] { 1, 0 };
        Game game1 = new Game(field1, points1, new FakeGUI());
        Game game2 = new Game(field2, points1, new FakeGUI());
        game1.setCurrentPlayer(1);
        game1.turn(new Position(3,2), new Position(3,3));
        testTwoFields(game2, game1);
        assertArrayEquals(points2, game1.getPoints());
    }
}
