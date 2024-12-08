package io.github.terrirera.worldGeneration;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class WorldGeneration {

        static int worldHeight = 30;
        static int worldWidth = 42;
        static int blockSize = 25;
        static float[][] noise = new float[worldHeight][worldWidth];
        float frequency = 0.01f;
        Random random;
        PerlinNoise perlinNoise;

        public void CreateWorld(){
            random = new Random();
            perlinNoise = new PerlinNoise();
            int height,width;
            System.out.println("Noise " + noise.length + "Noise [0] " + noise[0].length);

            noise = perlinNoise.GenerateWhiteNoise(worldHeight ,worldWidth);
            noise = perlinNoise.GeneratePerlinNoise(noise,4);



            for(height = 0;height < worldHeight;height++){
                for(width = 0;width < worldWidth;width++){
                    System.out.println(noise[height][width]);
                }
            }
        }

        public void RenderWorld(ShapeRenderer shape){
           int height,width;

            for(height = 0;height < worldHeight; height++){
                for(width = 0; width < worldWidth; width++){


                    shape.setColor(noise[height][width],noise[height][width],noise[height][width],1f);

                    shape.rect(width * blockSize, height * blockSize, blockSize , blockSize);

                }
            }




        }


}
