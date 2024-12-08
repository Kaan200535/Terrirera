package io.github.terrirera.worldGeneration;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class WorldGeneration {

        static int worldHeight = 30;
        static int worldWidth = 35;
        static int blockSize = 25;
        static int[][] noise = new int[worldHeight][worldWidth];
        Random random;

        public void CreateWorld(){
            random = new Random();
            int height,width;

            for(height = 0;height < worldHeight;height++){
                for(width = 0;width < worldWidth;width++){
                       int randInt = random.nextInt(256);
                      noise[height][width] =randInt;

                }
            }
        }

        public void RenderWorld(ShapeRenderer shape){
           int height,width;

            for(height = 0;height < worldHeight; height++){
                for(width = 0; width < worldWidth; width++){
                    shape.setColor(noise[height][width]/255f,noise[height][width]/255f,noise[height][width]/255f,1f);

                    shape.rect(width * blockSize, height * blockSize, blockSize , blockSize);

                }
            }




        }


}
