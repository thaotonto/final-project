package gamemain;

import gamemain.gamescene.SceneType;

import java.util.Vector;

/**
 * Created by EDGY on 3/19/2017.
 */
public class NotificationCenter {
    private Vector<Subcriber> subcriberVector;

    public NotificationCenter() {
        subcriberVector = new Vector<>();
    }

    private static NotificationCenter instance;

    public static NotificationCenter getInstance(){
        if(instance == null){
            instance = new NotificationCenter();
        }
        return instance;
    }

    public void onChange(SceneType sceneType, boolean addToBackStack){
        for (Subcriber subcriber : subcriberVector){
            subcriber.onChange(sceneType,addToBackStack);
        }
    }

    public void register(Subcriber subcriber){
        subcriberVector.add(subcriber);
    }

    public void unRegister(Subcriber subcriber){
        subcriberVector.remove(subcriber);
    }
}
