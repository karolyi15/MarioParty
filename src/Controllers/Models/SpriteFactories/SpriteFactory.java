package Controllers.Models.SpriteFactories;

import Controllers.Models.GameFactories.GameType;
import Controllers.Models.SpriteFactories.Backgrounds.Background;
import Controllers.Models.SpriteFactories.Characters.Character;
import Controllers.Models.SpriteFactories.Characters.CharacterType;

public class SpriteFactory {

    public iSprite createCharacter(CharacterType type){
        return new Character(type);
    }

    public iSprite createBackground(GameType type){
        return new Background(type);
    }

}
