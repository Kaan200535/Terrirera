package io.github.terrirera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.terrirera.worldGeneration.WorldGeneration;

import java.util.Objects;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class core extends ApplicationAdapter {

    private ShapeRenderer shape;
    private  WorldGeneration worldGeneration;


    @Override
    public void create() {

        shape = new ShapeRenderer();
        worldGeneration = new WorldGeneration();

        worldGeneration.CreateWorld();

    }

    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        worldGeneration.RenderWorld(shape);
        shape.end();
    }

    @Override
    public void dispose() {

        shape.dispose();
    }
}
