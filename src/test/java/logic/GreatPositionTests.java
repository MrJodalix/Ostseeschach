package logic;

import org.junit.Test;

import static logic.TestStone.*;
import static org.junit.Assert.*;

public class GreatPositionTests {

    private void testTwoFields (Game expected, Game actual){
        for (int x = 0; x < actual.getFIELDWIDTHLENGTH(); x++) {
            for (int y = 0; y < actual.getFIELDWIDTHLENGTH(); y++) {
                assertEquals(expected.getGameField()[x][y].getStone(), actual.getGameField()[x][y].getStone());
            }
        }
    }

    @Test
    public void MuschelMovementNorthWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,H1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,H1,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void MuschelMovementNorthEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,H1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void SternMovementNorth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(3,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void SternMovementNorthEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,S1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void SternMovementNorthWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S1,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void SternMovementSouthWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S1,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2,4));
        testTwoFields(game2, game1);
    }

    @Test
    public void SternMovementSouthEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,S1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4,4));
        testTwoFields(game2, game1);
    }

    @Test
    public void MoeweMovementNorth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(3,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void MoeweMovementEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4,3));
        testTwoFields(game2, game1);
    }

    @Test
    public void MoeweMovementSouth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(3,4));
        testTwoFields(game2, game1);
    }

    @Test
    public void MoeweMovementWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2,3));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementNorthEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,R1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4,1));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementEastNorth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,R1,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(5,2));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementEastSouth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,R1,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(5, 4));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementSouthEast () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
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
                {M,M,M,M,R1,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(4, 5));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementSouthWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
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
                {M,M,R1,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2, 5));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementWestSouth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,R1,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(1, 4));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementWestNorth () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,R1,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(1, 2));
        testTwoFields(game2, game1);
    }

    @Test
    public void RobbeMovementNorthWest () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        TestStone[][] field2 = {
                {M,M,M,M,M,M,M},
                {M,M,R1,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game1 = new Game(field1, points, new FakeGUI());
        Game game2 = new Game(field2, points, new FakeGUI());
        game1.turn(new Position(3,3), new Position(2, 1));
        testTwoFields(game2, game1);
    }








    @Test
    public void MuschelYouPossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,H1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);
        Position[] positions = new Position[]{new Position(4,2),
                new Position(2,2) };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,H2,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);
        Position[] positions = new Position[]{new Position(4,4),
                new Position(2,4) };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoewePossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(3,2),
                new Position(4,3),
                new Position(3,4),
                new Position(2,3) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(3,2),
                new Position(4,2),
                new Position(4,4),
                new Position(2,4),
                new Position(2,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAIPossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,2),
                new Position(4,4),
                new Position(3,4),
                new Position(2,4),
                new Position(2,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbePossibleMovement () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,R1,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,1),
                new Position(5,2),
                new Position(5,4),
                new Position(4,5),
                new Position(2,5),
                new Position(1,4),
                new Position(1,2),
                new Position(2,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelYouPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,H1},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(6,6);
        Position[] positions = new Position[]{
                new Position(5,5) };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelYouPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {H1,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(0,6);
        Position[] positions = new Position[]{
                new Position(1,5) };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,H2},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(6,0);
        Position[] positions = new Position[]{
                new Position(5,1)
        };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {H2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);
        Position[] positions = new Position[]{
                new Position(1,1)
        };
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweYouPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M1,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(0,6);

        Position[] positions = new Position[]{
                new Position(0,5),
                new Position(1,6) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweYouPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M1},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(6,6);

        Position[] positions = new Position[]{
                new Position(6,5),
                new Position(5,6) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweAIPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {M2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(1,0),
                new Position(0,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweAIPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M2},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(6,0);

        Position[] positions = new Position[]{
                new Position(6,1),
                new Position(5,0) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {S1,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(0,6);

        Position[] positions = new Position[]{
                new Position(0,5),
                new Position(1,5) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,S1},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(6,6);

        Position[] positions = new Position[]{
                new Position(6,5),
                new Position(5,5)
        };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAIPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {S2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(1,1),
                new Position(0,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAIPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,S2},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(6,0);

        Position[] positions = new Position[]{
                new Position(6,1),
                new Position(5,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerLeft () {
        TestStone[][] field1 = {
                {R2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(2,1),
                new Position(1,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerRight () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,R2},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(6,0);

        Position[] positions = new Position[]{
                new Position(5,2),
                new Position(4,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelYouPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S2,M,S1,M,M},
                {M,M,M,H1,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,6);
        Position[] positions = new Position[]{new Position(2,5)};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelYouPossibleMovementCornerLeftBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S1,M,S2,M,M},
                {M,M,M,H1,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,6);
        Position[] positions = new Position[]{new Position(4,5)};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelYouPossibleMovementCornerAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,S1,M,S1,M,M},
                {M,M,M,H1,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,6);
        Position[] positions = new Position[]{};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M,M,M,H2,M,M,M},
                {M,M,S1,M,S2,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,0);
        Position[] positions = new Position[]{new Position(2,1)};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovementCornerLeftBlocked () {
        TestStone[][] field1 = {
                {M,M,M,H2,M,M,M},
                {M,M,S2,M,S1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,0);
        Position[] positions = new Position[]{new Position(4,1)};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MuschelAIPossibleMovementCornerAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,H2,M,M,M},
                {M,M,S2,M,S2,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,0);
        Position[] positions = new Position[]{};
        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweYouPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {S2,M,M,M,M,M,M},
                {M1,R1,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(0,6);

        Position[] positions = new Position[]{
                new Position(0,5)};

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweYouPossibleMovementCornerTopBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {S1,M,M,M,M,M,M},
                {M1,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(0,6);

        Position[] positions = new Position[]{
                new Position(1,6)};

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweYouPossibleMovementCornerAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,S1},
                {M,M,M,M,M,R1,M1},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(6,6);

        Position[] positions = new Position[]{ };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweAIPossibleMovementCornerDownBlocked () {
        TestStone[][] field1 = {
                {M2,M,M,M,M,M,M},
                {S2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(1,0) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweAIPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M2,S2,M,M,M,M,M},
                {S1,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(0,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void MoeweAIPossibleMovementAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,H2,M,M,M},
                {M,M,R2,M2,S2,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        game.setCurrentPlayer(1);
        Position[] positions = new Position[]{ };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementLeftTopNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M2,S1,R1,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H1,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(2,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementTopNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,S2,R1,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H1,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(3,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementRightTopNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,S1,R2,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H1,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementRightDownNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,S1,R1,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H1,M,H2,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementLeftDownNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,S1,R1,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H2,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(2,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementLeftDownNotBlockedTowers () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M2T,S2T,R2T,M,M},
                {M,M,M,S1T,M,M,M},
                {M,M,H2,M,H2T,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(2,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M1,S1,R1,M,M},
                {M,M,M,S1,M,M,M},
                {M,M,H1,M,H1,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);

        Position[] positions = new Position[]{ };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAiPossibleMovementDownNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M2,M,R2,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,H2,M1,H2,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(3,3);
        game.setCurrentPlayer(1);

        Position[] positions = new Position[]{
                new Position(3,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAiPossibleMovementAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M2,M,R2,M,M},
                {M,M,M,S2,M,M,M},
                {M,M,H2,M2,H2,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{ };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternYouPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,S1},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        Position pos = new Position(6,6);

        Position[] positions = new Position[]{
                new Position(6,5),
                new Position(5,5)
        };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAIPossibleMovementCornerLeftBlocked () {
        TestStone[][] field1 = {
                {S2,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(0,0);

        Position[] positions = new Position[]{
                new Position(1,1),
                new Position(0,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void SternAIPossibleMovementCornerRightBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,S2},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(6,0);

        Position[] positions = new Position[]{
                new Position(6,1),
                new Position(5,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerTopLeftNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R1,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(2,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerTopRightNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R1,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,1) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerRightTopNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S1,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(5,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerRightDownNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H1,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(5,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerDownRightNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M1,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(4,5) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerDownLeftNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M1,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(2,5) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerLeftDownNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H1,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());
        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(1,4) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerLeftTopNotBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S1,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{
                new Position(1,2) };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }

    @Test
    public void RobbeAIPossibleMovementCornerAllBlocked () {
        TestStone[][] field1 = {
                {M,M,M,M,M,M,M},
                {M,M,R2,M ,R2,M,M},
                {M,S2,M,M ,M ,S2,M},
                {M,M ,M,R2,M ,M,M},
                {M,H2,M,M ,M ,H2,M},
                {M,M,M2,M ,M2,M,M},
                {M,M,M,M,M,M,M},
        };
        int[] points = new int[]{0,0};
        Game game = new Game(field1, points, new FakeGUI());

        game.setCurrentPlayer(1);
        Position pos = new Position(3,3);

        Position[] positions = new Position[]{ };

        Position[] allPos = game.allMoves(pos);

        assertArrayEquals(positions, allPos);
    }
}
