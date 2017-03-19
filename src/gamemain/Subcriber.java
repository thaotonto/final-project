package gamemain;

import gamemain.gamescene.SceneType;

/**
 * Created by EDGY on 3/20/2017.
 */
public interface Subcriber {
    void onChange(SceneType sceneType, boolean addToBackStack);
}
