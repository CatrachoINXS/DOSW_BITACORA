package main.dosw.semana_4.ejercicio_4;

public class WarriorBuilder {

    private String armor;
    private String skill;
    private String weapon;

    public void reset() {
        this.armor = "ninguna";
        this.skill = "ninguna";
        this.weapon = "ninguna";
    }

    public WarriorBuilder setArmor(String armor) {
        this.armor = armor;
        return this;
    }

    public WarriorBuilder setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public WarriorBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public Character build() {
        return new BaseCharacter(armor, skill, weapon);
    }
}
