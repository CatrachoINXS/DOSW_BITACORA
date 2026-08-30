package main.dosw.semana_4.ejercicio_4;

public class Main {

    public static void main(String[] args) {

        WarriorBuilder builder = new WarriorBuilder();
        Character warrior = builder.setArmor("steel")
                                   .setWeapon("sword")
                                   .setSkill("rage")
                                   .build();

        Character powered = new ShieldDecorator(
            new SpeedDecorator(warrior));

        powered.attack();
    }
}
