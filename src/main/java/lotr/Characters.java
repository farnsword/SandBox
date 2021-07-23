package lotr;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Characters {

    @Getter
    private static final List<Character> characters = new ArrayList<>();
    static {
        characters.add(new Character("Фродо",	1	, "KRT3S"));
        characters.add(new Character("Гендальф",	2	, "KDS8Q"));
        characters.add(new Character("Мэри",	3	, "SIE84"));
        characters.add(new Character("Арагорн",	4	, "HDKS2"));
        characters.add(new Character("Галадриель",	5	, "FFL5S"));
        characters.add(new Character("Саруман",	6	, "NCBD2"));
        characters.add(new Character("Элронд",	7	, "PS28S"));
        characters.add(new Character("Саурон",	8	, "FXP3K"));
        characters.add(new Character("Гимли",	9	, "PDK39"));
        characters.add(new Character("Боромир",	10	, "NSV2D"));
        characters.add(new Character("Сэм",	11	, "CDS98"));
        characters.add(new Character("Король-чародей",	12	, "DH3PR"));
        characters.add(new Character("Радагаст",	13	, "F83MD"));
        characters.add(new Character("Балрог",	14	, "LSHF3"));
        characters.add(new Character("Эовин",	15	, "MXN4A"));
        characters.add(new Character("Голлум",	16	, "SDSZ8"));
        characters.add(new Character("Леголас",	17	, "FPW72"));
        characters.add(new Character("Арвен",	18	, "MS92K"));
        characters.add(new Character("Древобород",	19	, "NC712"));
        characters.add(new Character("Шелоб",	20	, "BCX8R"));
        characters.add(new Character("Врата Дурина",	21	, "NC84H"));
        characters.add(new Character("Орлы",	22	, "MAE81"));
        characters.add(new Character("Пиппин",	23	, "KDP91"));
        characters.add(new Character("Кольцо",	24	, "DRK12"));
    }

    public static Character get(String name) {
        for (Character character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }
        return null;
    }
}
