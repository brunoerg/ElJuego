package whacamole;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    private int Kt = 8;
    private int Kd = 8;
    private int Ke = 2;
    
    public int numberGenerations;
    
    
    public float[][] population;
    
    public float[] fitPopulation;
    
    ArrayList <Float> allFitness;
    
    Random generator = new Random();
    
    Log log;
    
    public EvolutionaryAlgorithm(int sizePopulation, int mutation, int numberGenerations) throws IOException
    {
        this.sizePopulation = sizePopulation;
        this.mutation = mutation;
        this.numberGenerations = numberGenerations;
        
        population = new float[sizePopulation][3];
        fitPopulation = new float[sizePopulation];
        allFitness = new ArrayList<>();
        
        log = new Log();
        firstPopulation();
    }
    
    public void calculateFinalPontuation()
    {
        float allPont = 0;
        int i;
        
        allPont = allFitness.stream().map((c) -> c).reduce(allPont, (accumulator, _item) -> accumulator + _item);
        ElJuegoDAO dao = new ElJuegoDAO();
        dao.cadastroPontuacao(allPont);
        log.write("Final pontuation");
        log.write("\r\n");
        log.write(Float.toString(allPont));
        log.write("\r\n");
        System.out.println(allPont);
       
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
        log.write("Fitness - ind: " + Integer.toString(cod));
        log.write("\r\n");
        log.write(Float.toString(fitPopulation[cod]));
        log.write("\r\n");
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
            allFitness.add(fitPopulation[i]);
            if (fitPopulation[i] > fitValue)
            {
                fitValue = fitPopulation[i];
                fitIndex = i;
            }
        }
        
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
        System.out.println("New population realeased!");
    }
    
    public static float distancePoint(float x1, float y1, float x2, float y2)
    {
        return (float) Math.sqrt((Math.pow(x2-x1,2) + Math.pow(y2-y1,2)));  
    }
    
}
