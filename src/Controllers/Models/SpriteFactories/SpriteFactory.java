package Controllers.Models.SpriteFactories;

import Controllers.Models.GameFactories.GameType;

public class SpriteFactory {

    public Character createCharacter(CharacterType type){
        return new Character(type);
    }

    public Background createBackground(GameType type){
        return new Background(type);
    }

}
