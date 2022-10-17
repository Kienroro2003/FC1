package frame.jlist_jcombobox.color_combobox;

import java.awt.*;

public class ItemColor {
    private Color color;
    private String name;

    public ItemColor(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public ItemColor() {
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
