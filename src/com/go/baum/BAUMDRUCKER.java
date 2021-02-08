package com.go.baum;

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


}
