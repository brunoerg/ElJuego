package whacamole;


import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno Garcia
 */
public class EvolutionaryAlgorithm {
    
    public int sizePopulation;
    public int mutation;
    
    private int Kt = 2;
    private int Kd = 4;
    private int Ke = 4;
    
    public int numberGenerations;
    
    
    public float[][] population;
    
    public float[] fitPopulation;
    
    public ArrayList<Double> bPontuation = new ArrayList<Double>();
    
    Random generator = new Random();
    
    
    public EvolutionaryAlgorithm(int sizePopulation, int mutation, int numberGenerations)
    {
        this.sizePopulation = sizePopulation;
        this.mutation = mutation;
        this.numberGenerations = numberGenerations;
        
        population = new float[sizePopulation][3];
        fitPopulation = new float[sizePopulation];
        
        firstPopulation();
    }

    private void firstPopulation()
    {
        int i, j;
        for(i=0; i<sizePopulation; i++)
        {
            for(j=0; j<3; j++)
            {
                switch (j) {
                    case 0:
                        population[i][j] = (float) (generator.nextFloat() * 3);
                        break;
                    case 1:
                        population[i][j] = generator.nextInt(500);
                        break;
                    default:
                        population[i][j] = generator.nextInt(400);
                        break;
                }
            } 
        }
    }
    
    public void calculateFitness(int cod, float distanceBefore, float distanceAfter)
    {
        float fit;
        fitPopulation[cod] = (Kt * (1-population[cod][0])) + (Kd * distanceBefore) - (Ke * distanceAfter);
        System.out.println("Fitness:  " + fitPopulation[cod]);
    }
    
    public void bestChromosome()
    {
        int i;
        
        int fitIndex;
        float fitValue;
        fitIndex=-1;
        fitValue=-1;
        
        for (i=0; i<fitPopulation.length; i++)
        {
            if (fitPopulation[i] > fitValue)
            {
                fitValue = fitPopulation[i];
                fitIndex = i;
            }
        }
        
        bPontuation.add((double)fitValue);
        mutation(fitIndex);
    }
    
    private void mutation(int best)
    {
        int i,k;
        for (i=1; i<population.length; i++)
        {
            if (i==best)
                continue;
            for (k=0; k<2; k++)
            {
                switch(k)
                {
                    case 0:
                        population[i][k] = (float) (generator.nextFloat() * 3);
                        break;
                    case 1:
                        population[i][k] = generator.nextInt(500);
                        break;
                    case 2:
                        population[i][k] = generator.nextInt(400);
                        break;
                    default:
                        break;
                }  
            }
        }
    }
    
    public static float distancePoint(float x1, float y1, float x2, float y2)
    {
        return (float) Math.sqrt((Math.pow(x2-x1,2) + Math.pow(y2-y1,2)));  
    }
    
    
    public void printPontuation()
    {
        int i, k, pontuation;
        pontuation = 0;
        for (double pont : bPontuation)
        {
            pontuation += pont;
        }
        System.out.println("Final pontuation:  " + (pontuation / numberGenerations));
    }
    
}
