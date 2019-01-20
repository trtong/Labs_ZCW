package com.zipcodeconway;

import java.util.Random;

public class ConwayGameOfLife {

    private SimpleWindow sw;
    private int[][] nextGen;
    private int[][] currentGen;
    private int dimension;

    public ConwayGameOfLife(Integer dimension) {
        this.sw = new SimpleWindow(dimension);
        currentGen = createRandomStart(dimension);
        nextGen = new int[dimension][dimension];
        this.dimension = dimension;
     }

    public ConwayGameOfLife(Integer dimension, int[][] startmatrix) {
        this.sw = new SimpleWindow(dimension);
        currentGen = startmatrix;
        nextGen = new int[dimension][dimension];
        this.dimension = dimension;
    }

    public static void main(String[] args) {
        ConwayGameOfLife sim = new ConwayGameOfLife(50);
        sim.simulate(50);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] aCurrentGen : currentGen) {
            for (int j = 0; j < currentGen.length; j++) {
                sb.append(aCurrentGen[j]);
            }
        }

        return sb.toString();
    }

    // Contains the logic for the starting scenario.
    // Which cells are alive or dead in currentGen 0.
    // allocates and returns the starting matrix of size 'dimension'
    private int[][] createRandomStart(Integer dimension) {
        int[][] randomStart = new int[dimension][dimension];
        Random rand = new Random();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                randomStart[i][j] = rand.nextInt(2);
            }
        }
        return randomStart;
    }

    public int[][] simulate(Integer maxGenerations) {
        for (int gen = 0; gen <= maxGenerations; gen++) {
            this.sw.display(currentGen, gen);
            for (int i = 0; i < currentGen.length ; i++) {
                for (int j = 0; j < currentGen.length; j++) {
                    nextGen[i][j] = isAlive(i, j, currentGen);
                }
            }
            copyAndZeroOut(nextGen, currentGen);
            this.sw.sleep(125);
        }
        return nextGen;
    }

    // copy the values of 'next' matrix to 'current' matrix,
    // and then zero out the contents of 'next' matrix
    private void copyAndZeroOut(int [][] next, int[][] current) {
        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current.length; j++) {
                current[i][j] = next[i][j];
                next[i][j] = 0;
            }
        }
    }

// Calculate if an individual cell should be alive in the next currentGen.
// Based on the game logic:
	/*
		Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
		Any live cell with more than three live neighbours dies, as if by overcrowding.
		Any live cell with two or three live neighbours lives, unchanged, to the next currentGen.
		Any dead cell with exactly three live neighbours cells will come to life.
	*/

    private int isAlive(int row , int col, int[][] world) {
        int count = neighbors(row, col, world);
        int returnValue = 0;

        if (count == 3 || (world[row][col] == 1 && count == 2)) {
            returnValue = 1;
        }
        return returnValue;
    }

    private int neighbors(int row , int col, int[][] world) {
        int x, y, count = 0;

        for (int i = row - 1; i <= row + 1; i++) {

            for (int j = col - 1; j <= col + 1; j++) {
                x = i;
                y = j;

                if (i == -1) {
                    i = dimension - 1;
                } else if (i == dimension) {
                    i = 0;
                }

                if (j == -1) {
                    j = dimension - 1;
                } else if (j == dimension) {
                    j = 0;
                }

                if (world[i][j] == 1 && (!(i == row && j == col))) {
                    count++;
                }

                i = x;
                j = y;
            }
        }
        return count;
    }
}

