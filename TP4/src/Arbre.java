import java.util.ArrayList;

public class Arbre {
    private Noeud racine;
    private long size;

    public Arbre() {
        this.racine = new Noeud();
    }

    public Arbre(Noeud racine) {
        this.racine = racine;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }

    public void addEnfant(Noeud parent, Noeud enfant) {
        parent.addEnfant(enfant);
    }

    public void removeEnfant(Noeud parent, Noeud enfant) {
        parent.getEnfants().remove(enfant);
    }

    private static String prefixe(Noeud noeud) {
        if (noeud == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(noeud.getEl());
        for (Noeud enfant : noeud.getEnfants()) {
            sb.append(" ").append(prefixe(enfant));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Arbre{" + racine.toString() +'}';
    }

    private static class Noeud{
        private int el;
        private ArrayList<Noeud> enfants;

        public Noeud(int el) {
            this.el = el;
            this.enfants = new ArrayList<Noeud>();
        }

        public Noeud() {
            this.el = 0;
            this.enfants = new ArrayList<Noeud>();
        }

        public int getEl() {
            return el;
        }

        public void setEl(int el) {
            this.el = el;
        }

        public ArrayList<Noeud> getEnfants() {
            return enfants;
        }

        public void setEnfants(ArrayList<Noeud> enfants) {
            this.enfants = enfants;
        }

        public void addEnfant(Noeud enfant) {
            this.enfants.add(enfant);
        }

        @Override
        public String toString() {
            return "{"+ el + "} /n" + enfants.toString();
        }
    }
}