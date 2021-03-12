package com.go.baum;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class BAUMDRUCKER {

    private BINBAUM baum;

    public BAUMDRUCKER(BINBAUM baum) {
        this.baum = baum;
    }

    private String baumStringVertikalZusammensetzen(BINBAUM binbaum) {

        BAUMELEMENT root = binbaum.getWurzel();

        if (root.datenGeben() == null) return "Der übergebene Baum ist leer";

        StringBuilder sb = new StringBuilder();
        sb.append(root.datenGeben().getKey());

        String pointerRight = "└──";
        String pointerLeft = (root.nachfolgerRGeben() != null) ? "├──" : "└──";

        knotenStringVertikalZusammensetzen(sb, "", pointerLeft, root.nachfolgerLGeben(), root.nachfolgerRGeben() != null);
        knotenStringVertikalZusammensetzen(sb, "", pointerRight, root.nachfolgerRGeben(), false);

        return sb.toString();
    }

    private void knotenStringVertikalZusammensetzen(StringBuilder sb, String padding, String pointer, BAUMELEMENT node, boolean hasRightSibling) {

        if (node != null && !(node instanceof ASCHLUSS)) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.datenGeben().getKey());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.nachfolgerRGeben() != null) ? "├──" : "└──";

            knotenStringVertikalZusammensetzen(sb, paddingForBoth, pointerLeft, node.nachfolgerLGeben(), node.nachfolgerRGeben() != null);
            knotenStringVertikalZusammensetzen(sb, paddingForBoth, pointerRight, node.nachfolgerRGeben(), false);

        }
    }

    public void printVertikal(BINBAUM baum) {
        System.out.println(this.baumStringVertikalZusammensetzen(baum));
    }

    private String baumStringHorizontalZusammensetzen(BINBAUM binbaum) {

        BAUMELEMENT root = binbaum.getWurzel();

        if (root.datenGeben() == null) return "Der übergebene Baum ist leer";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%"+root.resthoeheGeben() * 3 +"s", ""));
        sb.append(root.datenGeben().getKey());
        sb.append("\n");

        String pointerRight = "\\";
        String pointerLeft = "/";

        knotenStringHorizontalZusammensetzen(sb, root.nachfolgerLGeben());
        knotenStringHorizontalZusammensetzen(sb, root.nachfolgerRGeben());

        return sb.toString();
    }

    private void knotenStringHorizontalZusammensetzen(StringBuilder sb, BAUMELEMENT node) {
        String pointerRight = "\\";
        String pointerLeft = "/";
        String pointerPadding = String.format("%" + (node.resthoeheGeben() * 3 + 15) + "s", "");
        String nodePadding = String.format("%" + (node.resthoeheGeben() * 3 + 10) + "s", "");

        if (!(node.nachfolgerLGeben() instanceof ASCHLUSS) && !(node.nachfolgerRGeben() instanceof ASCHLUSS)) {
            sb.append(pointerPadding);
            sb.append(pointerLeft);
            sb.append(pointerPadding);
            sb.append(pointerPadding);
            sb.append(pointerRight);
            sb.append("\n");
            sb.append(nodePadding);
            sb.append(node.nachfolgerLGeben().datenGeben().getKey());
            sb.append(nodePadding);
            sb.append(nodePadding);
            sb.append(node.nachfolgerRGeben().datenGeben().getKey());
            sb.append("\n");

            knotenStringHorizontalZusammensetzen(sb, node.nachfolgerLGeben());
            knotenStringHorizontalZusammensetzen(sb, node.nachfolgerRGeben());

        }
    }

    public void printHorizontal(BINBAUM baum) {
        System.out.println(this.baumStringHorizontalZusammensetzen(baum));
    }
}
