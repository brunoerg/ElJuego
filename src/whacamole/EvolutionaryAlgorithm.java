package whacamole;


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
    private int Ke = 8;
    
    public float[][] population;
    
    public float[] fitPopulation;
    
    Random generator = new Random();
    
    
    public EvolutionaryAlgorithm(int sizePopulation, int mutation)
    {
        this.sizePopulation = sizePopulation;
        this.mutation = mutation;
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
    
    
    
   
    
    
}
