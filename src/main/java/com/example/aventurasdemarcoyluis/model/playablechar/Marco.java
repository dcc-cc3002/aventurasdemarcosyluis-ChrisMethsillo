package com.example.aventurasdemarcoyluis.model.playablechar;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.npc.*;

/**
 * One of the playable characters is Marco. He has different methods for the combat system of the game
 * @author Christian Jesus Parra Cofre
 * @see MarcoCombat
 */
public class Marco extends AbstractPlayers implements MarcoCombat {
    /**
     * Creates a new Marco
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param maxHP Max heal points
     * @param FP  fight points
     * @param maxFP Max fight points
     * @param LVL level of the Unit
     */
    public Marco(int ATK, int DEF, double HP, double maxHP, int FP, int maxFP, int LVL) {
        super(ATK, DEF, HP, maxHP, FP, maxFP, LVL, PlayerType.MARCO);
    }

    /**
     * This method is to take damage done by the enemy Goomba.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Goomba
     */
    @Override
    public void getAtkByGoomba(double dmg) {
        this.dealDamage(dmg);
    }

    /**
     * This method is to take damage done by the enemy Spiny.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Spiny
     */
    @Override
    public void getAtkBySpiny(double dmg) {
        this.dealDamage(dmg);
    }


    /**
     * This method make a Normal attack to an enemy.
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackNormal(GoombaCombat enemy) {
        if(!isDeath() & hasEnoughFp(1)){
            double dmg=this.getAtk()*this.getLvl()/ enemy.getDef();
            enemy.getAtkByMarcoNormal(dmg);
            reduceFp(1);
        }
    }
    /**
     * This method make a Normal attack to an enemy.
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackNormal(SpinyCombat enemy) {
        if(!isDeath() & hasEnoughFp(1)){
            double dmg=this.getAtk()*this.getLvl()/ enemy.getDef();
            enemy.getAtkByMarcoNormal(dmg);
            getAtkBySpiny(0.1*MAXHP());
            reduceFp(1);
        }
    }

    /**
     * This method make a Normal attack to an enemy.
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackNormal(BooCombat enemy) {
        if(!isDeath() & hasEnoughFp(1)) {
            double dmg = this.getAtk() * this.getLvl()/enemy.getDef();
            enemy.getAtkByMarcoNormal(dmg);
            reduceFp(1);
        }
    }

    /**
     * This method make a Hammer attack to an enemy
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackHammer(GoombaCombat enemy) {
        boolean probability=Math.random()>=0.25;
        if(!isDeath() & probability & hasEnoughFp(2)){
            double dmg=1.5*this.getAtk()*this.getLvl()/ enemy.getDef();
            enemy.getAtkByMarcoHammer(dmg);
            reduceFp(2);
        }
    }

    /**
     * This method make a Hammer attack to an enemy
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackHammer(SpinyCombat enemy) {
        boolean probability=Math.random()>=0.25;
        if(!isDeath() & probability & hasEnoughFp(2)){
            double dmg=1.5*this.getAtk()*this.getLvl()/ enemy.getDef();
            enemy.getAtkByMarcoHammer(dmg);
            reduceFp(2);
        }
    }
}
