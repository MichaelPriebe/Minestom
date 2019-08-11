package fr.themode.minestom.instance;

public class Block {

    private short typeAndDamage;

    public Block(int type) {
        this.typeAndDamage = (short) (type & 0x0FFF);
        this.typeAndDamage |= (0 << 12) & 0xF000;
    }

    public Block(int type, int damage) {
        this.typeAndDamage = (short) (type & 0x0FFF);
        this.typeAndDamage |= (damage << 12) & 0xF000;
    }

    public int getType() {
        return typeAndDamage & 0x0FFF;
    }

    public void setType(int type) {
        this.typeAndDamage |= type & 0x0FFF;
    }

    public int getDamage() {
        return (typeAndDamage & 0xF000) >>> 12;
    }

    public void setDamage(int damage) {
        this.typeAndDamage |= (damage << 12) & 0xF000;
    }

    @Override
    public String toString() {
        return String.format("CustomBlock{type=%s, damage=%s}", getType(), getDamage());
    }
}