package Controllers.Models.SpriteFactory;

import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.*;
import Controllers.Models.SpriteFactory.Products.Character;

public class SpriteFactory {

    public Sprite createCharacter(CharacterType type){
        return new Character(type);
    }

    public Sprite createBackground(SceneType type){
        return new Background(type);
    }

    public Sprite createButton(double positionX, double positionY){
        return new Button(positionX,positionY);
    }

    public Sprite createNode(double positionX, double positionY){
        return new Node(positionX,positionY);
    }



}
