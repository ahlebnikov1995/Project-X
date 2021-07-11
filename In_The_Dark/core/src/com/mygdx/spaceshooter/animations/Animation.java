package com.mygdx.spaceshooter.animations;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private float frameCount;
    private int frame;
    private boolean isStart;

    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth()/frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount =  frameCount;
        maxFrameTime = cycleTime / this.frameCount;
        frame = 0;
    }


    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount)
            frame = 0;

    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }


    public void setCurrentFrameTime(float currentFrameTime) {
        this.currentFrameTime = currentFrameTime;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }
}
