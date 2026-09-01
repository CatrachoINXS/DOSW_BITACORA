package main.dosw.semana_4.ejercicio_4;

public class BaseCharacter implements Character {

    private String armor;
    private String skill;
    private String weapon;

    public BaseCharacter(String armor, String skill, String weapon) {
        this.armor = armor;
        this.skill = skill;
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        System.out.println("ataque base");
    }

    public String getArmor() {
        return armor;
    }

    public String getSkill() {
        return skill;
    }

    public String getWeapon() {
        return weapon;
    }
}