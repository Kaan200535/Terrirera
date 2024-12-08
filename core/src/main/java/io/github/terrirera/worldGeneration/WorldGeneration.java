package io.github.terrirera.worldGeneration;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class WorldGeneration {

        static int worldHeight = 80;
        static int worldWidth = 120;
        static int blockSize = 10;
        static double[][] noise = new double[worldHeight][worldWidth];
        float frequency = 0.01f;
        Random random;
        PerlinNoise perlinNoise;

        public void CreateWorld(){
            random = new Random();
            perlinNoise = new PerlinNoise();
            int height,width;

            for(height = 0;height < worldHeight;height++){
                for(width = 0;width < worldWidth;width++){

                    noise[height][width] = convertTo255(perlinNoise.noise(width,height));
                    System.out.println(noise[height][width]);
                }
            }


        }

        public void RenderWorld(ShapeRenderer shape){
           int height,width;

            for(height = 0;height < worldHeight; height++){
                for(width = 0; width < worldWidth; width++){


                    shape.setColor((float)noise[height][width],(float)noise[height][width],(float)noise[height][width],1f);

                    shape.rect(width * blockSize, height * blockSize, blockSize , blockSize);

                }
            }
        }

    public float convertTo255(double value) {
        return (float) ((value + 1) / 2 );
    }
}
